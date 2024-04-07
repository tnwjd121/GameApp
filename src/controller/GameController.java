package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import dto.GameDto;
import service.GameService;
import service.GameServiceImpl;
import view.GameView;

public class GameController {
	
	private GameView gameView;
	private GameService gameService = new GameServiceImpl();
	private int nextGameNumber = 1;
	
	public GameController() {
		this.gameView = new GameView(gameService);
	}
	
	public void runStartApp() {
		loadGameData();
		int selectNumber;
		while(true) {
			selectNumber = gameView.getMenu();
			switch (selectNumber) {
			case 0:
				saveGameData();
				return;
			case 1:
				//게임정보 등록 함수
				createGame();
				break;
			case 2:
				// 게임정보 확인 함수
				getGameList();
				break;
			case 3:
				updateGame();
				break;
			case 4:
				// 게임정보 삭제 함수
				deleteGame();
				break;
			default:
				System.out.println("없는 메뉴를 선택하셨습니다. 다른 메뉴를 선택 부탁드립니다.");
				break;
			}
		}	
	}
	
	
	public void createGame() {
		GameDto gameDto = gameView.createGame(nextGameNumber);
		gameService.createGame(gameDto);
		nextGameNumber++;
	}
	
	public void getGameList() {
		gameView.getGameList(gameService.getGameList());
	}
	
	public void updateGame() {
		gameView.updateGame();
	}
	
    private void saveGameData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("game_data.txt"))) {
            for (GameDto gameDto : gameService.getGameList()) {
                writer.println(gameDto.getGameNumber() + "," + gameDto.getGameName() + "," + gameDto.getConsole() + "," + gameDto.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	private void loadGameData() {
		try (Scanner scanner = new Scanner(new File("game_data.txt"))){
			int maxGameNumber = 0;
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				int gameNumber = Integer.parseInt(data[0]);
	            if (gameNumber > maxGameNumber) {
	                maxGameNumber = gameNumber;
	            }
				String gameName = data[1];
				String console = data[2];
				int price = Integer.parseInt(data[3]);
				gameService.createGame(new GameDto(gameNumber, gameName, console, price));
			}
			nextGameNumber = maxGameNumber + 1;
		} catch (Exception e) {
			System.out.println("게임 데이터 파일이 없습니다. 새로운 파일을 생성합니다.");
		}
	}
	private void deleteGame() {
		int index = gameView.deleteGame();
		gameService.deleteGame(index);
	}

}
