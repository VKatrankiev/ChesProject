
public class Pawn extends PlayingFigure {

	private boolean isMoved;

	public Pawn(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if(this.isWhite){
			this.icon = '\u2659';
		} else {
			this.icon = '\u265F';
		}
	}

	@Override
	protected boolean isMovePossible(int x, int y) {

		if (!isMoved) {
			if ((Math.abs(y - this.coordinateY) == 1 || Math.abs(y - this.coordinateY) == 2) && x == this.coordinateX
					&& super.isMovePossible(x, y)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (Math.abs(y - this.coordinateY) == 1 && x == this.coordinateX && super.isMovePossible(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void destroy(PlayingFigure figure) {
		if (!figure.isDead && !this.isDead && Math.abs(figure.coordinateX - this.coordinateX) == 1
				&& Math.abs(figure.coordinateY - this.coordinateY) == 1) {
			this.coordinateX = figure.coordinateX;
			this.coordinateY = figure.coordinateY;
			figure.isDead = true;
			figure.coordinateX = deadX;
			deadX--;
			figure.coordinateY = -2;
		}
	}

}
