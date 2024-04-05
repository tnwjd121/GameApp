package service;

import java.util.List;

import dto.GameDto;

public interface GameService {
	
	public void createGame(GameDto gameDto);
	public List<GameDto> getGameList();

}
