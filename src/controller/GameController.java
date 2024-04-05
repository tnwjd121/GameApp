package controller;

import dto.GameDto;
import service.GameService;
import service.GameServiceImpl;
import view.GameView;

public class GameController {
	
	private GameView gameView = new GameView();
	private GameService gameService = new GameServiceImpl();
	
	public void runStartApp() {
		int selectNumber;
		while(true) {
			selectNumber = gameView.getMenu();
			switch (selectNumber) {
			case 0:
				return;
			case 1:
				//게임정보 등록 함수
				createGame(null);
				break;
			case 2:
				// 게임정보 확인 함수
				break;
			case 3:
				// 게임정보 수정 함수
				break;
			case 4:
				// 게임정보 삭제 함수
				break;
			default:
				System.out.println("없는 메뉴를 선택하셨습니다. 다른 메뉴를 선택 부탁드립니다.");
				break;
			}
		}	
	}
	
	public void createGame(GameDto gameDto) {
		gameDto = gameView.createGame();
		gameService.createGame(gameDto);
	}

}
