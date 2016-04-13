
public class Knight extends PlayingFigure {

	public Knight(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if(this.isWhite){
			this.icon = WHITE_KNIGHT;
		} else {
			this.icon = BLACK_KNIGHT;
		}
	}

	@Override
	protected boolean isMovePossible(int x, int y) {
		return super.isMovePossible(x, y)
				&& ((Math.abs(this.coordinateX - x) == 1 && Math.abs(this.coordinateY - y) == 2)
						|| (Math.abs(this.coordinateX - x) == 2 && Math.abs(this.coordinateY - y) == 1));
	}

}
