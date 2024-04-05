package main;

import controller.GameController;
import service.GameServiceImpl;

public class GameApp {

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.runStartApp();

	}

}
