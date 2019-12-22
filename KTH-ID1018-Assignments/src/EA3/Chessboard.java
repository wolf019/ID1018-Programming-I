package EA3;

public class Chessboard {

	/**
	 * This class Chessboard will create a board with fields and markings on the board.
	 * This class is to put a piece on the board and to show where on the board the piece 
	 * can go to. It´s not playable at this point. 
	 * @author tomaxberg
	 *
	 */
	
	/**
	 * This class is to create a field with the ability to have a row character and column
	 * number. The field will also include the information if a piece is present or if 
	 * it's marked by an other piece.
	 *
	 */
	public static class Field {
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;

		/**
		 * Constructor for class Field that builds a specific field specified by
		 * the parameters.
		 * 
		 * @param row
		 * @param column
		 */
		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}

		/**
		 * Placing @param Chesspiece as piece.
		 * 
		 * @param piece
		 */
		public void put(Chesspiece piece) {
			this.piece = piece;

		}

		/**
		 * Creates a Chesspiece returnPiece and sets it to null. The piece is set
		 * to returnPiece and the method @returns it.
		 * 
		 * @return returnPiece
		 */
		public Chesspiece take() {
			Chesspiece returnPiece = null;
			this.piece = null;
			return returnPiece;

		}
		
		/**
		 * 
		 */
		public void mark() {
			marked = true;
		}

		public void unmark() {
			marked = false;
		}

		public String toString() {

			String s = (marked) ? "xx" : "--";

			return (piece == null) ? s : piece.toString();
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;

	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;

	/**
	 * A two dimensional array of type Field is created that correspond to the 
	 * fields on the Chessboard.
	 */
	private Field[][] fields;

	/**
	 * Constructor for class Chessboeard witch creates a two dimensional array of
	 * type Field. Field type is defined above.
	 */
	public Chessboard() {

		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

		char row = 0;
		byte column = 0;

		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;

			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	/**
	 * Returns a Chessboard to print.
	 */
	public String toString() {

		StringBuilder boardPrint = new StringBuilder();
		char sideChar = 65;

		boardPrint.append("    1   2   3   4   5   6   7   8 \n\n");

		int i = 0;
		while (i < NUMBER_OF_ROWS) {
			boardPrint.append((char) (sideChar + i));
			boardPrint.append("   ");
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				boardPrint.append(fields[i][j] + "  ");
			}
			boardPrint.append("\n\n");
			i++;
		}
			boardPrint.append("\n------------------------------------\n");
		return boardPrint.toString();

	}

	/**
	 * Checks if @param row and column is a field on the board and returns a boolean
	 * value.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isValidField(char row, byte column) {
		return 'a' <= row && row <= 'h' && 1 <= column && column <= 8;

	}

	public abstract class Chesspiece {

		private char color; // w - white, b - black
		private char name; // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn

		protected char row = 0;
		protected byte column = -1;

		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
		}

		public String toString() {

			return "" + color + name;
		}

		public boolean isOnBoard() {

			return Chessboard.this.isValidField(row, column);
		}

		/**
		 * This method is for placing a piece in a desired field.
		 * 
		 * If the piece want to moveTO a field where a piece stands it takes it and
		 * replace it's spot.
		 * 
		 * Försök att baka in att ta pjäser genom att anropa [code]take()[/code] i
		 * metoden om du flyttar pjäsen dit det redan finns en pjäs av annan färg
		 * 
		 * @param row    is the row where we want to move a piece to.
		 * @param column is the column where we want to move the piece to.
		 * @throws NotValidFieldException is thrown if the row and column defines a non
		 *                                valid field. I.e the field is not defined on
		 *                                the board.?
		 */

		public void moveTo(char row, byte column) throws NotValidFieldException {
			if (!Chessboard.this.isValidField(row, column))
				throw new NotValidFieldException("The field " + row + column + " is not valid!");
			this.row = row;
			this.column = column;
			int r = row - FIRST_ROW; // The row index of the chessboard is 0-7
			int c = column - FIRST_COLUMN; // The column index of the chessboard is 0-7
			Chessboard.this.fields[r][c].put(this);
		}

		// Gives a NotValidFieldException with a message.
		public class NotValidFieldException extends Exception {
			public NotValidFieldException(String message) {
				super(message);
			}
		}

		public void moveOut() {
			Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();

		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();

	}

	public class Pawn extends Chesspiece {

		public Pawn(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {

			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Rook extends Chesspiece {

		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {

			for (byte col = 1; col <= 8; col++) {
				if (Chessboard.this.isValidField(row, col) && col != column) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}

			for (char ro = 'a'; ro <= 'h'; ro++) {
				if (Chessboard.this.isValidField(ro, column) && ro != row) {
					int r = ro - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
		}

		public void unmarkReachableFields() {

			for (byte col = 1; col <= 8; col++) {
				if (Chessboard.this.isValidField(row, col)) {
					int r = row - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for (char ro = 'a'; ro <= 'h'; ro++) {
				if (Chessboard.this.isValidField(ro, column)) {
					int r = ro - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
		}
	}

	public class Knight extends Chesspiece {

		char i = 0;

		public Knight(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			int[] psblMvs = {-2, 1, 2, 1, -2, -1, 2, -1, -2};
			int j = 0;

			while (j <= 7) {
				char ro = (char) (row + psblMvs[j]);
				byte col = (byte) (column + psblMvs[j + 1]);
				if (Chessboard.this.isValidField(ro, col)) {
					int r = ro - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
				j++;
			}
		}

		public void unmarkReachableFields() {
			int[] psblMvs = {-2, 1, 2, 1, -2, -1, 2, -1, -2};
			int j = 0;

			while (j <= 7) {
				char ro = (char) (row + psblMvs[j]);
				byte col = (byte) (column + psblMvs[j + 1]);
				if (Chessboard.this.isValidField(ro, col)) {
					int r = ro - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
				j++;
			}
		}
	}

	public class Bishop extends Chesspiece {


		public Bishop(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {

			char ro = 0;
			byte co = 0;
			
			while (ro <= 7 && co <= 7) {
				char roNE = (char) (row - ro);
				byte colNE = (byte) (column + co);
				char roNW = (char) (row - ro);
				byte colNW = (byte) (column - co);
				char roSE = (char) (row + ro);
				byte colSE = (byte) (column + co);
				char roSW = (char) (row + ro);
				byte colSW = (byte) (column - co);
				if (Chessboard.this.isValidField(roNE, colNE)) {
					int r = roNE - FIRST_ROW;
					int c = colNE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roNW, colNW)) {
					int r = roNW - FIRST_ROW;
					int c = colNW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roSE, colSE)) {
					int r = roSE - FIRST_ROW;
					int c = colSE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roSW, colSW)) {
					int r = roSW - FIRST_ROW;
					int c = colSW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				ro++;
				co++;
			}
		}

		public void unmarkReachableFields() {
			
			int ro = 0;
			int co = 0;
			
			while (ro <= 7 && co <= 7) {
				char roNE = (char) (row - ro);
				byte colNE = (byte) (column + co);
				char roNW = (char) (row - ro);
				byte colNW = (byte) (column - co);
				char roSE = (char) (row + ro);
				byte colSE = (byte) (column + co);
				char roSW = (char) (row + ro);
				byte colSW = (byte) (column - co);
				if (Chessboard.this.isValidField(roNE, colNE)) {
					int r = roNE - FIRST_ROW;
					int c = colNE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roNW, colNW)) {
					int r = roNW - FIRST_ROW;
					int c = colNW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roSE, colSE)) {
					int r = roSE - FIRST_ROW;
					int c = colSE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roSW, colSW)) {
					int r = roSW - FIRST_ROW;
					int c = colSW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				ro++;
				co++;
			}
		}
	}

	public class Queen extends Chesspiece {

		public Queen(char color, char name) {
			super(color, name);
		}
		public void markReachableFields() {

			char ro = 0;
			byte co = 0;
			
			while (ro <= 7 && co <= 7) {
				char roNE = (char) (row - ro);
				byte colNE = (byte) (column + co);
				char roNW = (char) (row - ro);
				byte colNW = (byte) (column - co);
				char roSE = (char) (row + ro);
				byte colSE = (byte) (column + co);
				char roSW = (char) (row + ro);
				byte colSW = (byte) (column - co);
				if (Chessboard.this.isValidField(roNE, colNE)) {
					int r = roNE - FIRST_ROW;
					int c = colNE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roNW, colNW)) {
					int r = roNW - FIRST_ROW;
					int c = colNW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roSE, colSE)) {
					int r = roSE - FIRST_ROW;
					int c = colSE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				if (Chessboard.this.isValidField(roSW, colSW)) {
					int r = roSW - FIRST_ROW;
					int c = colSW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();}
				ro++;
				co++;
			}
			
			for ( co = 1; co <= 8; co++) {
				if (Chessboard.this.isValidField(row, co)) {
					int r = row - FIRST_ROW;
					int c = co - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
			for ( ro = 'a'; ro <= 'h'; ro++) {
				if (Chessboard.this.isValidField(ro, column)) {
					int r = ro - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
		}

		public void unmarkReachableFields() {
			
			char ro = 0;
			byte co = 0;
			
			while (ro <= 7 && co <= 7) {
				char roNE = (char) (row - ro);
				byte colNE = (byte) (column + co);
				char roNW = (char) (row - ro);
				byte colNW = (byte) (column - co);
				char roSE = (char) (row + ro);
				byte colSE = (byte) (column + co);
				char roSW = (char) (row + ro);
				byte colSW = (byte) (column - co);
				if (Chessboard.this.isValidField(roNE, colNE)) {
					int r = roNE - FIRST_ROW;
					int c = colNE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roNW, colNW)) {
					int r = roNW - FIRST_ROW;
					int c = colNW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roSE, colSE)) {
					int r = roSE - FIRST_ROW;
					int c = colSE - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				if (Chessboard.this.isValidField(roSW, colSW)) {
					int r = roSW - FIRST_ROW;
					int c = colSW - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();}
				ro++;
				co++;
			}
			
			for ( co = 1; co <= 8; co++) {
				if (Chessboard.this.isValidField(row, co)) {
					int r = row - FIRST_ROW;
					int c = co - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for ( ro = 'a'; ro <= 'h'; ro++) {
				if (Chessboard.this.isValidField(ro, column)) {
					int r = ro - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
		}
	}

	public class King extends Chesspiece {

		public King(char color, char name) {
			super(color, name);
		}
		
		public void markReachableFields() {
			
			int[] psblMvs = {0 , 1,  0 , -1, 0};
			int j = 0;

			while (j <= 3) {
				char ro = (char) (row + psblMvs[j]);
				byte col = (byte) (column + psblMvs[j + 1]);
				if (Chessboard.this.isValidField(ro, col)) {
					int r = ro - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
				j++;
			}
		}

		public void unmarkReachableFields() {
			int[] psblMvs = {0 , 1,  0 , -1, 0};
			int j = 0;

			while (j <= 3) {
				char ro = (char) (row + psblMvs[j]);
				byte col = (byte) (column + psblMvs[j + 1]);
				if (Chessboard.this.isValidField(ro, col)) {
					int r = ro - FIRST_ROW;
					int c = col - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
				j++;
			}
		}
	}

}
