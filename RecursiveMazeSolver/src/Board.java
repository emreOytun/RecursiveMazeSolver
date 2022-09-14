package src;

public class Board {
	private Square[][] board;
	private WhiteStamp whiteStamp;
	
	public Board() {
		whiteStamp = new WhiteStamp(0, 0);
		
		board = new Square[8][8];
		
		char[] horizantalNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		for (int i = 8; i >= 1; --i) {
			for (int j = 0; j < 8; ++j) {
				board[(int)(i-1)][j] = new Square();
				board[(int)(i-1)][j].setVerticalName((char)(i + '0'));
				board[(int)(i-1)][j].setHorizantalName(horizantalNames[j]);
			}
		}
	}
	
	public Square get(int y, int x) {
		return board[y][x];
	}
	
	public WhiteStamp getWhiteStamp() {
		return whiteStamp;
	}
	
	public void print() {
		
		for (int i = 8; i >= 1 ;--i) {
			for (int j = 0; j < 8; ++j) {
				if (j == 0) System.out.print((char)(i + '0') + " ");
				
				if (board[i-1][j].hasStamp()) System.out.print("-");
				else if (whiteStamp.getyPos() == i-1 && whiteStamp.getxPos() == j) System.out.print("+");
				else System.out.print("#");
			
				System.out.print(" ");
			}
			System.out.println("\n");
		}
	
		System.out.print(" ");
		for (int i = 0; i < 8; ++i) {
			System.out.print((char)(i + 'A') + " ");
		}
		
		System.out.println();
	}
	
}
