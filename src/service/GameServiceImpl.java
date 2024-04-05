package service;

import java.util.ArrayList;
import java.util.List;

import dto.GameDto;

public class GameServiceImpl implements GameService{
	
	private List<GameDto> gameDtos = new ArrayList<>();

	@Override
	public void createGame(GameDto gameDto) {
		String gameInfo = gameDto.getGameNumber() + "," + gameDto.getGameName() + "," + gameDto.getConsole() + "," + gameDto.getPrice();
		GameFileWriter.WriteGameToFile("/GameApp/src/view/GameView.java", gameInfo);
	//파일 생성하는법 찾기 경로 이상함
	}

	@Override
	public List<GameDto> getGameList() {
		return gameDtos;
	}
	


}
