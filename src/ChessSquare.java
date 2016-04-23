
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChessSquare extends JButton {

	private PlayingFigure figure;
	private static boolean clicked = false;
	private static int xA;
	private static int yA;
	private static int xB;
	private static int yB;
	private static PlayingFigure figureA;
	private static PlayingFigure figureB;

	private static boolean turnWhite = true;

	public ChessSquare(int a, int b) {

		this.figure = new EmptyFigure(a, b, false);

	}

	public ChessSquare(PlayingFigure pF) {
		this.figure = pF;

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
			}
		});
	}
	private void getNextTurn(boolean isWhite) {
		if (figure.isAFigure) {
			if (getFigure().isWhite == isWhite) {
				clicked = true;
				xA = getFigure().coordinateX;
				yA = getFigure().coordinateY;
				figureA = getFigure();
			} else {
				moveFigure();
			}
		} else {
			moveFigure();
			clicked = false;
		}
	}

	private void moveFigure() {
		if (clicked) {
			xB = getFigure().coordinateX;
			yB = getFigure().coordinateY;
			figureB = getFigure();

			if (Board.getPlayingFigure(xA, yA).isMovePossible(xB, yB)) {
				clicked = false;
				Board.board[xA][yA].getFigure().move(xB, yB);
				Board.board[xB][yB].setFigure(Board.board[xA][yA].getFigure());
				Board.board[xB][yB].setIcon(new ImageIcon(Board.board[xB][yB].getFigure().icon));
				Board.board[xA][yA].setFigure(new EmptyFigure(xA, yA, false));
				Board.board[xA][yA].setIcon(new ImageIcon(PlayingFigure.EMPTY));
				if ((Board.isCheckActive()[0] == -1 && turnWhite)
						|| (Board.isCheckActive()[0] == 1 && !turnWhite)) {
					reverseMove();
				}
				if (Board.isCheckActive()[0] == 1 || Board.isCheckActive()[0] == -1) {
					if (!Board.notMate()) {
						System.out.println("CHECKMATE! Game Of Thrones!");
					} else {
						System.out.println("CHECK!");
					}

				}
				turnWhite = !turnWhite;
			}
		}
	}
	private void reverseMove() {

		Board.board[xA][yA].setFigure(new EmptyFigure(xA, yA, false));
		Board.board[xA][yA].setIcon(new ImageIcon(PlayingFigure.EMPTY));

		Board.board[xB][yB].setFigure(new EmptyFigure(xB, yB, false));
		Board.board[xB][yB].setIcon(new ImageIcon(PlayingFigure.EMPTY));

		figureA.coordinateX = xA;
		figureA.coordinateY = yA;
		Board.board[xA][yA].setFigure(figureA);
		Board.board[xA][yA].setIcon(new ImageIcon(figureA.icon));

		figureB.coordinateX = xB;
		figureB.coordinateY = yB;
		Board.board[xB][yB].setFigure(figureB);
		Board.board[xB][yB].setIcon(new ImageIcon(figureB.icon));
		turnWhite = !turnWhite;

	}

	public void setFigure(PlayingFigure figure) {
		this.figure = figure;

	}

	public PlayingFigure getFigure() {
		return this.figure;
	}

}
