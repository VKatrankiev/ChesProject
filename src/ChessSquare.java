import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChessSquare extends JButton {

	private boolean hasFigure;
	private PlayingFigure figure;

	private static boolean clicked = false;
	private static int x;
	private static int y;
	private static boolean turnWhite = true;

	public ChessSquare(int a, int b) {
		this.hasFigure = false;
		this.figure = new EmptyFigure(a, b, false);
		
	}
	public ChessSquare(PlayingFigure pF) {
		this.figure = pF;
		this.hasFigure = true;
		
	}
	
	public void putIcon(int x, int y){
		String icon;
		Board.board[x][y].setIcon(new ImageIcon());
	}

	public void clickListener() {
		this.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if (turnWhite) {
					getNextTurn(true);
				} else {
					getNextTurn(false);
				}
				
				
				// if (!icon.equals(PlayingFigure.EMPTY)){
				// Board.getPlayingFigure(0, 0).move(getFigure().coordinateX,
				// getFigure().coordinateY);
				// Board.board[getFigure().coordinateX][getFigure().coordinateY]
				// = Board.board[0][0];
				// Board.board[getFigure().coordinateX][getFigure().coordinateY]
				// .setIcon(new ImageIcon(Board.board[0][0].getIcone()));
				// Board.board[0][0].setFigure(new EmptyFigure(0, 0, false));
				// Board.board[0][0].setIcon(new
				// ImageIcon(PlayingFigure.EMPTY));
				// }

			}
			private void getNextTurn (boolean isWhite) {
				if (figure.isAFigure) {
					System.out.println(figure.icon);
					if (getFigure().isWhite == isWhite) {
						System.out.println("it is white");
						clicked = true;
						x = getFigure().coordinateX;
						y = getFigure().coordinateY;
						System.out.println(x + " " + y + " " + figure.icon);
					} else {
						moveFigure();
					}
				} else {
					System.out.println(figure.coordinateX+" "+figure.coordinateY + " " + figure.icon);
					moveFigure();
					clicked = false;
				}
			
			}
			private void moveFigure() {
				if (clicked) {
					System.out.println("clicked");
					int thisX = getFigure().coordinateX;
					int thisY = getFigure().coordinateY;
					if (Board.getPlayingFigure(x, y).isMovePossible(thisX,
							thisY)) {
						System.out.println("move is possible");
						clicked = false;
						Board.board[x][y].getFigure().move(thisX, thisY);
						Board.board[thisX][thisY].setFigure(Board.board[x][y].getFigure());
						Board.board[thisX][thisY].setIcon(new ImageIcon(Board.board[thisX][thisY].getFigure().icon));
						Board.board[x][y].setFigure(new EmptyFigure(x,y,false));
						Board.board[x][y].setIcon(new ImageIcon(PlayingFigure.EMPTY));
						
						turnWhite = !turnWhite;
					}
				}
			}

		});
	}

	

	public void setFigure(PlayingFigure figure) {
		this.figure = figure;

	}

	public boolean isHasFigure() {
		return hasFigure;
	}

	public void setHasFigure(boolean hasFigure) {
		this.hasFigure = hasFigure;
	}

	

	public void setFigure(boolean isTrue) {
		this.hasFigure = isTrue;
	}

	public PlayingFigure getFigure() {
		return this.figure;
	}

}
