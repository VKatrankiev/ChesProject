import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.omg.Messaging.SyncScopeHelper;

public class Board extends JFrame {

	private JPanel contentPane;

	public static ChessSquare[][] board = new ChessSquare[8][8];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static void createNewBoard() {
		Board board = new Board();
	}

	public Board() {
		init();
	}

	private void init() {
		getGeneralDetails();
		boolean flag = false;
		int bound1 = 35;
		int bound2 = 25;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				generateFigures(i, j);
				board[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
				board[i][j].setContentAreaFilled(false);
				flag = paintSquares(flag, i, j);
				board[i][j].setOpaque(true);
				board[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				board[i][j].setBounds(bound1, bound2, 35, 35);
				board[i][j].setIcon(new ImageIcon(board[i][j].getFigure().icon));
				contentPane.add(board[i][j]);
				board[i][j].clickListener();
				bound1 += 34;
			}
			bound2 += 34;
			bound1 = 35;
		}
	}

	private void getGeneralDetails() {
		setTitle("CHESS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private boolean paintSquares(boolean flag, int i, int j) {
		if (flag) {
			flag = false;
			board[i][j].setBackground(Color.WHITE);
		} else {
			flag = true;
			board[i][j].setBackground(Color.GRAY);
		}
		if (j == board.length - 1) {
			if (flag) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	private void generateFigures(int i, int j) {
		if (i == 0) {
			getNextFigure(i, j, false);
		} else if (i == 1) {
			board[i][j] = new ChessSquare(new Pawn(i, j, false));
		} else if (i == 6) {
			board[i][j] = new ChessSquare(new Pawn(i, j, true));
		} else if (i == 7) {
			getNextFigure(i,j,true);
		} else {
			board[i][j] = new ChessSquare(i, j);
		}
	}

	private void getNextFigure(int i, int j, boolean flag) {
		switch (j) {
		case 0:
		case 7:
			board[i][j] = new ChessSquare(new Rook(i, j, flag));
			break;
		case 1:
		case 6:
			board[i][j] = new ChessSquare(new Knight(i, j, flag));
			break;
		case 2:
		case 5:
			board[i][j] = new ChessSquare(new Bishop(i, j, flag));
			break;
		case 3:
			board[i][j] = new ChessSquare(new Queen(i, j, flag));
			break;
		case 4:
			board[i][j] = new ChessSquare(new King(i, j, flag));
			break;
		default:
			board[i][j] = new ChessSquare(i, j);
		}
	}

	public static PlayingFigure getPlayingFigure(int x, int y) {
		if (x < 8 && x >= 0 && y < 8 && y >= 0) {
			return board[x][y].getFigure();
		}
		return null;
	}

	public static int[] isCheckActive() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (getPlayingFigure(i, j).icon.equals(PlayingFigure.BLACK_KING)) {
					if (isKingThreatened(i, j, false)) {
						return new int[] { 1, i, j };
					}
				}
				if (getPlayingFigure(i, j).icon.equals(PlayingFigure.WHITE_KING)) {
					if (isKingThreatened(i, j, true)) {
						return new int[] { -1, i, j };
					}
				}

			}
		}
		return new int[] { 0, -1, -1 };
	}

	private static boolean isKingThreatened(int x, int y, boolean isWhite) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (getPlayingFigure(i, j).isAFigure && !getPlayingFigure(i, j).isDead
						&& getPlayingFigure(i, j).isWhite != isWhite) {
					if (getPlayingFigure(i, j).isMovePossible(x, y)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean notMate() {
		boolean flag = false;
		if (isCheckActive()[0] == -1) {
			flag = true;
		}
		if (isCheckActive()[0] == 1) {
			flag = false;
		}

		int x = isCheckActive()[1];
		int y = isCheckActive()[2];
		return areThereMoves(x, y, flag) || areThereDefenders(x, y, flag);

	}


	private static boolean areThereDefenders(int x, int y, boolean isWhite) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].getFigure().isAFigure && !board[i][j].getFigure().isDead
						&& board[i][j].getFigure().isWhite == isWhite
						&& !board[i][j].getFigure().icon.equals(PlayingFigure.BLACK_KING)
						&& !board[i][j].getFigure().icon.equals(PlayingFigure.WHITE_KING)) {

					boolean flag = areTherePossibleMoves(board[i][j].getFigure(), x, y, isWhite);
					if (flag) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean areTherePossibleMoves(PlayingFigure figure, int x, int y, boolean isWhite) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (figure.isMovePossible(i, j)) {
					count++;
					System.out.println(count);
					int a = figure.coordinateX;
					int b = figure.coordinateY;
					String icon = board[i][j].getFigure().icon;
					PlayingFigure oldFigure = board[i][j].getFigure();
					boolean flag = false;
					if (board[i][j].getFigure().isAFigure && !board[i][j].getFigure().isDead) {
						System.out.println("have found a figure " + figure.icon);
						flag = true;
					}
					board[i][j].getFigure().isAFigure = true;
					board[i][j].getFigure().isDead = false;
					board[a][b].setIcon(new ImageIcon(PlayingFigure.EMPTY));
					board[i][j].setIcon(new ImageIcon(figure.icon));
					figure.coordinateX = i;
					figure.coordinateY = j;
					board[i][j].setFigure(figure);

					if (!isKingThreatened(x, y, isWhite)) {
						if (flag) {
							board[i][j].getFigure().isAFigure = true;
							board[i][j].getFigure().isDead = false;
						}
						figure.coordinateX = a;
						figure.coordinateY = b;
						board[i][j].setIcon(new ImageIcon(icon));
						board[a][b].setFigure(figure);
						board[a][b].setIcon(new ImageIcon(figure.icon));
						board[i][j].setFigure(oldFigure);

						System.out.println(a + " " + b);
						return true;
					}
					if (flag) {
						board[i][j].getFigure().isAFigure = true;
						board[i][j].getFigure().isDead = false;
					}
					figure.coordinateX = a;
					figure.coordinateY = b;
					board[i][j].setIcon(new ImageIcon(icon));
					board[a][b].setFigure(figure);
					board[i][j].setFigure(oldFigure);

				}
			}
		}
		return false;
	}

	private static boolean areThereMoves(int x, int y, boolean isWhite) {
		boolean[] moves = { true, true, true, true, true, true, true, true };
		boolean flag = false;
		if (getPlayingFigure(x, y).isMovePossible(x + 1, y)) {
			moves[0] = isKingThreatened(x + 1, y, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x + 1, y + 1)) {
			moves[1] = isKingThreatened(x + 1, y + 1, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x, y + 1)) {
			moves[2] = isKingThreatened(x, y + 1, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x - 1, y)) {
			moves[3] = isKingThreatened(x - 1, y, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x - 1, y - 1)) {
			moves[4] = isKingThreatened(x - 1, y - 1, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x, y - 1)) {
			moves[5] = isKingThreatened(x, y - 1, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x + 1, y - 1)) {
			moves[6] = isKingThreatened(x + 1, y - 1, isWhite);
		}
		if (getPlayingFigure(x, y).isMovePossible(x - 1, y + 1)) {
			moves[7] = isKingThreatened(x - 1, y + 1, isWhite);
		}
		for (boolean b : moves) {
			if (b == false) {
				return !b;
			}
		}
		return flag;
	}


}
