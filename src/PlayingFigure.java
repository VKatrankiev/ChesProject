
public class PlayingFigure {

	static byte deadX = -2;
	int coordinateX;
	int coordinateY;
	boolean isDead;
	boolean isWhite;
	char icon;

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

	protected boolean isMovePossible (int x, int y) {
		return (x >= 0 || x < 16) && (y >= 0 || y < 16);
	}
	
	protected void destroy (PlayingFigure figure){
		if(this.isMovePossible(figure.coordinateX, figure.coordinateY) && !this.isDead && !figure.isDead){
			this.move(figure.coordinateX, figure.coordinateY);
			figure.isDead = true;
			figure.coordinateX = deadX;
			deadX--;
			figure.coordinateY = -2;
		}
	}

}
