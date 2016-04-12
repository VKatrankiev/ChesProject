
public class Rook extends PlayingFigure {

	public Rook(int i, int j, boolean isWhite) {
		super(i, j, isWhite);
		if(this.isWhite){
			this.icon = '\u2657';
		} else {
			this.icon = '\u265D';
		}
	}

	@Override
	protected boolean isMovePossible(int x, int y) {
		return super.isMovePossible(x, y) && (x == this.coordinateX || y == this.coordinateY);
	}
}
