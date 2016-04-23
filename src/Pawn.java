
public class Pawn extends PlayingFigure {

	private boolean isMoved;

	public Pawn(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if (this.isWhite) {
			this.icon = WHITE_PAWN;
		} else {
			this.icon = BLACK_PAWN;
		}
		if ((this.isWhite && this.coordinateX == 6) || (!this.isWhite && this.coordinateX == 1)) {
			this.isMoved = false;
		} else {
			this.isMoved = true;
		}

	}

	@Override
	protected boolean isMovePossible(int x, int y) {
		return super.isMovePossible(x, y) && colorMove(this.isWhite, x, y);
	}

	private boolean colorMove(boolean isWhite, int x, int y) {
		int dist;
		if (isWhite) {
			dist = -1;
		} else {
			dist = 1;
		}

		if (!this.isMoved) {
			if (((x - this.coordinateX == dist
					|| x - this.coordinateX == 2 * dist) && !Board.board[x][y].getFigure().isAFigure)
					&& y == this.coordinateY && super.isMovePossible(x, y)) {
				return true;
			}
		} else {
			if (x - this.coordinateX == dist && y == this.coordinateY && super.isMovePossible(x, y)
					&& !Board.board[x][y].getFigure().isAFigure) {
				return true;
			}
		}
		return canDestroy(x, y, dist);

	}

	@Override
	public void move(int x, int y) {
		super.move(x, y);
		this.isMoved = true;
	}

	private boolean canDestroy(int x, int y, int dist) {
		if (x < 8 && x > -1 && y < 8 && y > -1) {
			if (Board.board[x][y].getFigure().isAFigure && Board.board[x][y].getFigure().isWhite != this.isWhite) {
				if (x - this.coordinateX == dist && Math.abs(y - this.coordinateY) == 1) {
					return true;
				}
			}
		}
		return false;

	}

}
