package sudoku;

import java.util.stream.IntStream;

public class sudokuSolve {


	int BOARD_START_INDEX;
	int BOARD_SIZE;
	int NO_VALUE;
	int MIN_VALUE;
	int MAX_VALUE;
	int SUBSECTION_SIZE;
	int Outboard[][] = new int[9][9];
	

	sudokuSolve(int[][] board) {
		BOARD_START_INDEX = 0;
		BOARD_SIZE = 9;
		NO_VALUE = 0;
		MIN_VALUE = 1;
		MAX_VALUE = 9;
		SUBSECTION_SIZE = 3;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				Outboard[i][j] = board[i][j];
			}
		}
	}
	
	
	public int[][] getBoard() {
		return Outboard;
	}
	public boolean solve(int[][] board) {
	    for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
	        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
	            if (board[row][column] == NO_VALUE) {
	                for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
	                    board[row][column] = k;
	                    Outboard[row][column] = k;
	                    if (isValid(board, row, column) && solve(board)) {
	                        return true;
	                    }
	                    Outboard[row][column] = NO_VALUE;
	                    board[row][column] = NO_VALUE;
	                }
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	public boolean isValid(int[][] board, int row, int column) {
	    return (rowConstraint(board, row)
	      && columnConstraint(board, column) 
	      && subsectionConstraint(board, row, column));
	}
	
	private boolean rowConstraint(int[][] board, int row) {
	    boolean[] constraint = new boolean[BOARD_SIZE];
	    return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(column -> checkConstraint(board, row, constraint, column));
	}
	
	private boolean columnConstraint(int[][] board, int column) {
	    boolean[] constraint = new boolean[BOARD_SIZE];
	    return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(row -> checkConstraint(board, row, constraint, column));
	}
	
	private boolean subsectionConstraint(int[][] board, int row, int column) {
	    boolean[] constraint = new boolean[BOARD_SIZE];
	    int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
	    int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;
	 
	    int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
	    int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;
	 
	    for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
	        for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
	            if (!checkConstraint(board, r, constraint, c)) return false;
	        }
	    }
	    return true;
	}
	
	private boolean checkConstraint(int[][] board,  int row, boolean[] constraint, int column) {
			if (board[row][column] != NO_VALUE) {
				if (!constraint[board[row][column] - 1]) {
			          constraint[board[row][column] - 1] = true;
				} 
				else {
		            return false;
		        }
		    }
			return true;
	}
	
	public void printBoard() {
	    for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
	        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
	            System.out.print(Outboard[row][column] + " ");
	        }
	        System.out.println();
	    }
	}
	
	
}
