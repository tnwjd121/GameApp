package view;

import java.util.List;
import java.util.Scanner;

import dto.GameDto;
import service.GameService;
import service.GameServiceImpl;

public class GameView {
	
	
	Scanner scanner = new Scanner(System.in);
	private int nextGameNumber = 0; // 다음 등록 번호
	private GameService gameService;
	
	public GameView(GameService gameService) {
        this.gameService = gameService;
    }
	

	public int getMenu() {
		System.out.println("게임정보 앱입니다.");
		System.out.println("0. 종료");
		System.out.println("1. 게임정보 등록");
		System.out.println("2. 게임정보 확인");
		System.out.println("3. 게임정보 수정");
		System.out.println("4. 게임정보 삭제");
		int selectNumber = -1;
		selectNumber = scanner.nextInt();
		scanner.nextLine();
		return selectNumber;
	}
	
	public GameDto createGame(int nextGameNumber) {
		System.out.print("게임이름: ");
		String gameName = scanner.nextLine();
		System.out.print("콘솔명: ");
		String console = scanner.nextLine();
		System.out.print("가격: ");
		int price = scanner.nextInt();
		scanner.nextLine();
		return new GameDto(nextGameNumber, gameName, console, price);
		
	}
	
	public void getGameList(List<GameDto>gameDtos) {
		System.out.println("----------게임 정보----------");
		for(GameDto gameDto : gameDtos) {
			System.out.println(gameDto.toString());
		}
	}
	
    public void updateGame() {
        System.out.println("수정할 게임번호를 입력하세요.");
        int changeGameNumber = scanner.nextInt();
        scanner.nextLine();
        GameDto gameToUpdate = null;
        for (GameDto game : gameService.getGameList()) {
            if (game.getGameNumber() == changeGameNumber) {
                gameToUpdate = game;
                break;
            }
        }
        if (gameToUpdate != null) {
            System.out.println("새로운 게임 정보를 입력하세요.");
            System.out.print("게임이름: ");
            String gameName = scanner.nextLine();
            System.out.print("콘솔명: ");
            String console = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            
            // 변경된 정보를 GameService를 통해 전달
            gameService.updateGame(changeGameNumber, gameName, console, price);
        } else {
            System.out.println("해당 번호의 게임을 찾을 수 없습니다.");
        }
    }
    public int deleteGame() {
    	System.out.println("삭제할 게임번호를 입력하세요.");
    	int index = scanner.nextInt();
    	scanner.nextLine();
    	return index;

    }
}
