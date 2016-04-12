
public class Knight extends PlayingFigure {

	public Knight(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if(this.isWhite){
			this.icon = '\u2658';
		} else {
			this.icon = '\u265E';
		}
	}

	@Override
	protected boolean isMovePossible(int x, int y) {
		return super.isMovePossible(x, y)
				&& ((Math.abs(this.coordinateX - x) == 1 && Math.abs(this.coordinateY - y) == 2)
						|| (Math.abs(this.coordinateX - x) == 2 && Math.abs(this.coordinateY - y) == 1));
	}

}
