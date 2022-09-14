package src;

import java.util.ArrayList;
import java.util.Random;

public class BoardManager {
	
	private int getStampNumber() {
		Random rand = new Random();
		int stampNumber = rand.nextInt(7) + 3;
		return stampNumber;
	}
	
	private int[] getRandomPosition() {
		Random rand = new Random();
		return new int[] {rand.nextInt(8), rand.nextInt(8)};
	}
	
	private void placeStamps(Board board, int stampNumber) {	
		for (int i = 0; i < stampNumber; ++i) {	
			boolean isPlaced = false;
			
			do {	
				int[] position = getRandomPosition();
				if (!(position[0] == 0 && position[1] == 0)) {
					Square square = board.get(position[0], position[1]);
					if (!square.hasStamp()) {
						square.putStamp();
						isPlaced = true;
					}
				}
			}while(!isPlaced);
		}
	}
	
	private boolean checkIfGameEnded(Board board) {
		WhiteStamp whiteStamp = board.getWhiteStamp();
		if (whiteStamp.getyPos() == 7 && whiteStamp.getxPos() == 7) {
			return true;
		}
		return false;
	}
	
	private boolean move(Board board, ArrayList<Square>resultArr) {
		if (checkIfGameEnded(board)) {
			System.out.println("TESTTIR - OYUN BITIS");
			return true;
		}
		
		int whiteX = board.getWhiteStamp().getxPos();
		int whiteY = board.getWhiteStamp().getyPos();
		
		boolean rightStamp = false; 
		boolean leftStamp = false;
		if (whiteX < 7 && board.get(whiteY, whiteX + 1).hasStamp()) {
			rightStamp = true;
			resultArr.add(new Square(board.get(whiteY, whiteX + 1)));
		}
		if (whiteY < 7 && board.get(whiteY + 1, whiteX).hasStamp()) {
			leftStamp = true;
			resultArr.add(new Square(board.get(whiteY + 1, whiteX)));
		}
		
		boolean result = false;
		for (int i = 0; i < 2 && result == false; ++i) {
			
			// First try to move to the right;
			if (i == 0) {		
				if (!rightStamp && whiteX < 7) {
					board.getWhiteStamp().setxPos(whiteX + 1);
					result = move(board, resultArr);
					if (result == false) board.getWhiteStamp().setxPos(whiteX);
				}
			} 
			
			// Then try to move to the up.
			else if (!leftStamp && whiteY < 7 ) {
				board.getWhiteStamp().setyPos(whiteY + 1);
				result = move(board, resultArr);
				if (result == false) board.getWhiteStamp().setyPos(whiteY);
			}
		}
		
		if (result == false) {
			if (rightStamp) resultArr.remove(resultArr.size() - 1);
			if (leftStamp) resultArr.remove(resultArr.size() - 1);
		}
		
		return result;
	}
	
	public Board setupBoard() {
		Board board;
		int stampNumber = getStampNumber();
		
		boolean isDone = false;
		ArrayList<Square> resultArr;
		
		do {
			board = new Board();
			
			// randomly place black stamps with the given number into the board.
			placeStamps(board, stampNumber);
			
			// move the white stamp till it cannot move anymore or it is in the H8 position
			resultArr = new ArrayList<Square>();
			isDone = move(board, resultArr);
		}while (!isDone);	
		
		for (Square sq : resultArr) {
			System.out.println(sq + " ");
		}
		
		board.print();
	
		return board;
	}
}
