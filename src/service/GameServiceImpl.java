package service;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dto.GameDto;

public class GameServiceImpl implements GameService{
	
	private List<GameDto> gameDtos = new ArrayList<>();

	@Override
	public void createGame(GameDto gameDto) {
		gameDtos.add(gameDto);
		saveGameData();
	}

	@Override
	public List<GameDto> getGameList() {
		return gameDtos;
	}
	
	private void saveGameData() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("game_data.txt"))) {
			for(GameDto gameDto : gameDtos) {
				writer.println(gameDto.getGameNumber() + "," +gameDto.getGameName()+ "," +gameDto.getConsole()+ "," +gameDto.getPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	   public void updateGame(int gameNumber, String gameName, String console, int price) {
        GameDto gameToUpdate = null;
        for (GameDto game : gameDtos) {
            if (game.getGameNumber() == gameNumber) {
                gameToUpdate = game;
                break;
            }
        }
        if (gameToUpdate != null) {
            gameToUpdate.setGameName(gameName);
            gameToUpdate.setConsole(console);
            gameToUpdate.setPrice(price);
            saveGameData();
            System.out.println("게임 정보가 성공적으로 업데이트되었습니다.");
        } else {
            System.out.println("게임 번호에 해당하는 게임을 찾을 수 없습니다.");
        }
    }

	@Override
	public void deleteGame(int index) {
		gameDtos.remove(index);
		
	}
}
	
	

