package dto;

public class GameDto {
	
	private int gameNumber;
	private String gameName;
	private String console;
	private int price;
	
	public int getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public GameDto(int gameNumber, String gameName, String console, int price) {
		this.gameNumber = gameNumber;
		this.gameName = gameName;
		this.console = console;
		this.price = price;
	}
	@Override
	public String toString() {
		return "게임 번호: " + gameNumber + ", 게임명: " + gameName + ", 콘솔명: " + console + ", 가격 : "
				+ price + "]";
	}
	
	
	
	
	
	
	

}
