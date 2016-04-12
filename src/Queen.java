
public class Queen extends PlayingFigure {

	public Queen(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if(this.isWhite){
			this.icon = '\u2655';
		} else {
			this.icon = '\u265B';
		}
	}

	@Override
	protected boolean isMovePossible(int x, int y) {
		return super.isMovePossible(x, y) && ((Math.abs(this.coordinateX - x) == Math.abs(this.coordinateY - y))
				|| (x == this.coordinateX || y == this.coordinateY));
	}

}
