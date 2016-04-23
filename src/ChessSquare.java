import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ChessSquare extends JButton {

	private PlayingFigure figure;

	private static boolean clicked = false;
	private static int xA;
	private static int yA;
	private static int xB;
	private static int yB;
	private static PlayingFigure figureA;
	private static PlayingFigure figureB;

	static boolean turnWhite = true;

	public ChessSquare(int a, int b) {

		this.figure = new EmptyFigure(a, b, false);

	}

	public ChessSquare(PlayingFigure pF) {
		this.figure = pF;

	}

	public boolean isFigWhite() {
		return figure.isWhite;
	}

	public void clickListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<8; i++){
					for (int j=0; j<8;j++){
						Board.board[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
					}
				}
				if (turnWhite) {
					getNextTurn(true);
				} else {
					getNextTurn(false);
				}
			}

			private void getNextTurn(boolean isWhite) {
				if (figure.isAFigure) {
					figure.possibleMoves();
					System.out.println(figure.icon);
					if (getFigure().isWhite == isWhite) {
						System.out.println("it is white");
						clicked = true;
						xA = getFigure().coordinateX;
						yA = getFigure().coordinateY;
						figureA = getFigure();
						System.out.println(xA + " " + yA + " " + figure.icon);
					} else {
						moveFigure();
						figure.possibleMoves();
					}
				} else {
					System.out.println(figure.coordinateX + " " + figure.coordinateY + " " + figure.icon);
					moveFigure();
					clicked = false;
				}

			}

			private void moveFigure() {
				if (clicked) {
					int a = turnWhite ? -1 : 1;
					System.out.println("clicked");
					xB = getFigure().coordinateX;
					yB = getFigure().coordinateY;
					figureB = getFigure();
					if (Board.getPlayingFigure(xA, yA).isMovePossible(xB, yB)) {
						System.out.println("move is possible");
						clicked = false;
						Board.board[xA][yA].getFigure().move(xB, yB);
						Board.board[xB][yB].setFigure(Board.board[xA][yA].getFigure());
						Board.board[xB][yB].setIcon(new ImageIcon(Board.board[xB][yB].getFigure().icon));
						Board.board[xA][yA].setFigure(new EmptyFigure(xA, yA, false));
						Board.board[xA][yA].setIcon(new ImageIcon(PlayingFigure.EMPTY));

						System.out.println(Board.isCheckActive()[0] + "*" + a);
						if (Board.isCheckActive()[0] == a) {
							reverseMove();
						}
						if (Board.isCheckActive()[0] == 1 || Board.isCheckActive()[0] == -1) {
//							System.out.println("CHECK!");
							Board.lblNewLabel.setText("CHECK!");
							Board.lblNewLabel.setVisible(true);
							Board.contentPane.add(Board.lblNewLabel);
						}else{
							Board.lblNewLabel.setVisible(false);
						}
						turnWhite = !turnWhite;
					}
				}
			}

		});
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
	
	private static boolean someMethod(boolean flag) {
		for (int i = 0; i < Board.board.length; i++) {
			for (int j = 0; j < Board.board.length; j++) {
				if (Board.board[i][j].getFigure().isAFigure && !Board.board[i][j].getFigure().isDead
						&& Board.board[i][j].getFigure().isWhite == flag) {
					for (int k = 0; k < Board.board.length; k++) {
						for (int l = 0; l < Board.board.length; l++) {
							if (Board.board[i][j].getFigure().isMovePossible(k, l)) {
								int xA = i;
								int yA = j;
								int xB = k;
								int yB = l;
								PlayingFigure figureA = Board.board[i][j].getFigure();
								PlayingFigure figureB = Board.board[k][l].getFigure();

								Board.board[i][j].getFigure().move(k, l);
								Board.board[k][l].setFigure(Board.board[i][j].getFigure());
								Board.board[k][l].setIcon(new ImageIcon(Board.board[k][l].getFigure().icon));
								Board.board[i][j].setFigure(new EmptyFigure(i, j, false));
								Board.board[i][j].setIcon(new ImageIcon(PlayingFigure.EMPTY));
								if (Board.isCheckActive()[0] == 0) {
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
									return true;
								}
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
							}
						}
					}
				}
			}
		}
		return false;
	}

}
