package service;

import java.util.ArrayList;
import java.util.List;

import dto.GameDto;

public class GameServiceImpl implements GameService{
	
	private List<GameDto> gameDtos = new ArrayList<>();

	@Override
	public void createGame(GameDto gameDto) {
		gameDtos.add(gameDto);
		
	}
	


}
