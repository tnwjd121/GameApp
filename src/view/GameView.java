package view;

import java.util.Scanner;

import dto.GameDto;

public class GameView {
	
	
	Scanner scanner = new Scanner(System.in);
	private int nextGameNumber = 1; // 다음 등록 번호
	
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
	
	public GameDto createGame() {
		System.out.print("게임이름: ");
		String gameName = scanner.nextLine();
		System.out.println("콘솔명: ");
		String console = scanner.nextLine();
		System.out.println("가격: ");
		int price = scanner.nextInt();
		scanner.nextLine();
		
		GameDto gameDto = new GameDto(nextGameNumber, gameName, console, price);
		nextGameNumber++;
		
		return gameDto;
		
	}

}
