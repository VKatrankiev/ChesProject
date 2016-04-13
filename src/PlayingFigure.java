
public class PlayingFigure {

	public static final String BLACK_PAWN = "black pawn";
	public static final String BLACK_ROOK = "black rook";
	public static final String BLACK_KNIGHT = "black knight";
	public static final String BLACK_BISHOP = "black bishop";
	public static final String BLACK_QUEEN = "black queen";
	public static final String BLACK_KING = "black king";
	public static final String WHITE_PAWN = "white pawn";
	public static final String WHITE_ROOK = "white rook";
	public static final String WHITE_KNIGHT = "white knight";
	public static final String WHITE_BISHOP = "white bishop";
	public static final String WHITE_QUEEN = "white queen";
	public static final String WHITE_KING = "white king";

	static byte deadX = -2;
	int coordinateX;
	int coordinateY;
	boolean isDead;
	boolean isWhite;
	String icon;

	public PlayingFigure(int i, int j, boolean isWhite) {
		if (isMovePossible(i, j)) {
			this.coordinateX = i;
			this.coordinateY = j;
			this.isWhite = isWhite;
		}
	}

	public void move(int x, int y) {
		if (isMovePossible(x, y) && !this.isDead) {
			this.coordinateX = x;
			this.coordinateY = y;
		} else {
			System.out.println("Incorrect move!");
		}
	}

	protected boolean isMovePossible(int x, int y) {
		return (x >= 0 || x < 8) && (y >= 0 || y < 8);
	}

	protected boolean isSomethingInTheWay(int x, int y) {
		if (this.coordinateX == x) {
			int tempY;
			int tempYMin;
			if (this.coordinateY > y) {
				tempY = this.coordinateY;
				tempYMin = y;
			} else {
				tempY = y;
				tempYMin = this.coordinateY;
			}
			for (int i = tempYMin; i <= tempY; i++) {
				if (!Board.board[x][i].getIcon().equals(null)) {
					return false;
				} else {
					return true;
				}
			}
		}
		if (this.coordinateY == y) {
			int tempX;
			int tempXMin;
			if (this.coordinateX > x) {
				tempX = this.coordinateX;
				tempXMin = x;
			} else {
				tempX = x;
				tempXMin = this.coordinateX;
			}
			for (int i = tempXMin; i <= tempX; i++) {
				if (!Board.board[i][y].getIcon().equals(null)) {
					return false;
				} else {
					return true;
				}
			}
		}
		return checkDiagonals(x,y);
	}

	private boolean checkDiagonals(int x, int y) {

		for (int i = 0; i < Math.abs(x - this.coordinateX); i++) {
			if (x + y == this.coordinateX + this.coordinateY) {
				if (i <= x + y) {
					if (this.coordinateX + i < 8 && this.coordinateY - i > -1) {
						if (!Board.board[this.coordinateX + i][this.coordinateY - i].getIcon().equals(null)) {
							return false;
						}
					}
					if (this.coordinateX - i > -1 && this.coordinateY + i < 8) {
						if (!Board.board[this.coordinateX - i][this.coordinateY + i].getIcon().equals(null)) {
							return false;
						}
					}
				}
			}
			if (x - y == this.coordinateX - this.coordinateY) {
				if(this.coordinateX+i < 8 && this.coordinateY+i<8){
					if(!Board.board[this.coordinateX + i][this.coordinateY + i].getIcon().equals(null)){
						return false;
					}
				}
				if(this.coordinateX-i >-1 && this.coordinateY-i>-1){
					if (!Board.board[this.coordinateX - i][this.coordinateY + i].getIcon().equals(null)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected void destroy(PlayingFigure figure) {
		if (this.isMovePossible(figure.coordinateX, figure.coordinateY) && !this.isDead && !figure.isDead) {
			this.move(figure.coordinateX, figure.coordinateY);
			figure.isDead = true;
			figure.coordinateX = deadX;
			deadX--;
			figure.coordinateY = -2;
		}
	}

}
