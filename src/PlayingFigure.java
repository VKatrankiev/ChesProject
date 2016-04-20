import javax.swing.JButton;

public class PlayingFigure {

	
	public static final String BLACK_PAWN = "src\\resources\\pawn_black.png";
	public static final String BLACK_ROOK = "src\\resources\\rook_black.png";
	public static final String BLACK_KNIGHT = "src\\resources\\knight_black.png";
	public static final String BLACK_BISHOP = "src\\resources\\bishop_black.png";
	public static final String BLACK_QUEEN = "src\\resources\\queen_black.png";
	public static final String BLACK_KING = "src\\resources\\king_black.png";
	public static final String WHITE_PAWN = "src\\resources\\pawn_white.png";
	public static final String WHITE_ROOK = "src\\resources\\rook_white.png";
	public static final String WHITE_KNIGHT = "src\\resources\\knight_white.png";
	public static final String WHITE_BISHOP = "src\\resources\\bishop_white.png";
	public static final String WHITE_QUEEN = "src\\resources\\queen_white.png";
	public static final String WHITE_KING = "src\\resources\\king_white.png";
	public static final String EMPTY = "empty";

	static byte deadX = -2;
	int coordinateX;
	int coordinateY;
	boolean isDead;
	boolean isWhite;
	boolean isAFigure;
	String icon;

	public PlayingFigure(int i, int j, boolean isWhite) {
		if ((i >= 0 || i < 8) && (j >= 0 || j < 8)) {
			this.coordinateX = i;
			this.coordinateY = j;
			this.isWhite = isWhite;
			this.icon = EMPTY;
			this.isAFigure = true;
		}
	}

	public void move(int x, int y) {
		if (isMovePossible(x, y) && !this.isDead) {
			if(!Board.board[x][y].getIcon().equals(EMPTY)){
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
					if (!Board.board[i][y].getIcon().equals(EMPTY)) {
						return true;
					} else {
						return true;
					}
				}
			} else {
				for (int i = this.coordinateX; i < x; i++) {
					if (!Board.board[i][y].getIcon().equals(EMPTY)) {
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
					if (!Board.board[x][i].getIcon().equals(EMPTY)) {
						flag = true;
					} else {
						flag = true;
					}
				}
			} else {
				for (int i = this.coordinateY; i < y; i++) {
					if (!Board.board[x][i].getIcon().equals(EMPTY)) {
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
		if (!Board.board[x][y].getIcon().equals(EMPTY)) {
			if (this.isWhite) {
				return (!Board.getPlayingFigure(x, y).isWhite);
			} else {
				return Board.getPlayingFigure(x, y).isWhite;
			}
		}
		return false;

	}

	private boolean checkDiagonals(int x, int y) {

		for (int i = 0; i < Math.abs(x - this.coordinateX); i++) {
			if (x + y == this.coordinateX + this.coordinateY) {
				if (i <= x + y) {
					if (this.coordinateX + i < 8 && this.coordinateY - i > -1) {
						if (!Board.board[this.coordinateX + i][this.coordinateY - i].getIcon().equals(EMPTY)) {
							return false;
						}
					}
					if (this.coordinateX - i > -1 && this.coordinateY + i < 8) {
						if (!Board.board[this.coordinateX - i][this.coordinateY + i].getIcon().equals(EMPTY)) {
							return false;
						}
					}
				}
			}
			if (x - y == this.coordinateX - this.coordinateY) {
				if (this.coordinateX + i < 8 && this.coordinateY + i < 8) {
					if (!Board.board[this.coordinateX + i][this.coordinateY + i].getIcon().equals(EMPTY)) {
						return false;
					}
				}
				if (this.coordinateX - i > -1 && this.coordinateY - i > -1) {
					if (!Board.board[this.coordinateX - i][this.coordinateY + i].getIcon().equals(EMPTY)) {
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
