
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
			if(!Board.board[x][y].getIcon().equals(null)){
				this.destroy(Board.getPlayingFigure(x,y));
			}
			this.coordinateX = x;
			this.coordinateY = y;
		} else {
			System.out.println("Incorrect move!");
		}
	}

	protected boolean isMovePossible(int x, int y) {
		return (x >= 0 || x < 8) && (y >= 0 || y < 8) && !isSomethingInTheWay(x, y);
	}

	private boolean isSomethingInTheWay(int x, int y) {
		return checkDiagonals(x, y) || checkHorizontal(x, y) || checkVertical(x, y) || checkForOppFigure(x, y);
	}

	private boolean checkHorizontal(int x, int y) {	
		if (this.coordinateY == y) {

			if (this.coordinateX > x) {
				for (int i = this.coordinateX; i > x; i--) {
					if (!Board.board[i][y].getIcon().equals(null)) {
						return true;
					} else {
						return true;
					}
				}
			} else {
				for (int i = this.coordinateX; i < x; i++) {
					if (!Board.board[i][y].getIcon().equals(null)) {
						return  true;
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean checkVertical(int x, int y) {
		boolean flag = false;
		if (this.coordinateX == x) {
			if (this.coordinateY > y) {
				for (int i = this.coordinateY; i > y; i--) {
					if (!Board.board[x][i].getIcon().equals(null)) {
						flag = true;
					} else {
						flag = true;
					}
				}
			} else {
				for (int i = this.coordinateY; i < y; i++) {
					if (!Board.board[x][i].getIcon().equals(null)) {
						flag = true;
					} else {
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	private boolean checkForOppFigure(int x, int y) {
		if (!Board.board[x][y].getIcon().equals(null)) {
			if (this.isWhite) {
				return (!Board.getPlayingFigure(x, y).isWhite);
			} else {
				return Board.getPlayingFigure(x, y).isWhite;
			}
		}

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
				if (this.coordinateX + i < 8 && this.coordinateY + i < 8) {
					if (!Board.board[this.coordinateX + i][this.coordinateY + i].getIcon().equals(null)) {
						return false;
					}
				}
				if (this.coordinateX - i > -1 && this.coordinateY - i > -1) {
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
			figure.isDead = true;
			Board.board[figure.coordinateX][figure.coordinateY]
					.setIcon(Board.board[this.coordinateX][this.coordinateY].getIcon());
		}
	}

}
