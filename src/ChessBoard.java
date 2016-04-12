import java.util.ArrayList;

public class ChessBoard {

	public static char[][] board = new char[8][8];

	public static void createNewBoard() {
		ArrayList<PlayingFigure> figures = new ArrayList<PlayingFigure>();
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!flag) {
					board[i][j] = '\u25A0';
					flag = true;
				} else {
					board[i][j] = '\u25A1';
					flag = false;
				}
				// System.out.print(board[i][j] + " ");
			}
			if (flag == false) {
				flag = true;
			} else {
				flag = false;
			}
			// System.out.println();
		}
		putFigures(figures);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				for (int k = 0; k < figures.size(); k++) {
					if (i == figures.get(k).coordinateX && j == figures.get(k).coordinateY) {
						board[i][j] = figures.get(k).icon;
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void putFigures(ArrayList<PlayingFigure> figures) {
		Rook rookBlack1 = new Rook( 0, 0, false);
		figures.add(rookBlack1);
		Rook rookBlack2 = new Rook( 0,  7, false);
		figures.add(rookBlack2);
		Knight knightBlack1 = new Knight( 0,  1, false);
		figures.add(knightBlack1);
		Knight knightBlack2 = new Knight( 0,  6, false);
		figures.add(knightBlack2);
		Bishop bishopBlack1 = new Bishop( 0,  5, false);
		figures.add(bishopBlack1);
		Bishop bishopBlack2 = new Bishop( 0, 2, false);
		figures.add(bishopBlack2);
		Queen queenBlack = new Queen( 0,  3, false);
		figures.add(queenBlack);
		King kingBlack = new King( 0,  4, false);
		figures.add(kingBlack);
		// Pawn[] pawnBlack = new Pawn[8];
		// for (int i = 0; i < board.length; i++) {
		// pawnBlack[i] = new Pawn((byte) 1, (byte) i, false);
		// figures.add(pawnBlack[i]);
		// }
		Pawn pawn1 = new Pawn( 1, 0, false);
		figures.add(pawn1);
		Rook rookWhite1 = new Rook( 7,  0, true);
		figures.add(rookWhite1);
		Rook rookWhite2 = new Rook( 7, 7, true);
		figures.add(rookWhite2);
		Knight knightWhite1 = new Knight( 7,  1, true);
		figures.add(knightWhite1);
		Knight knightWhite2 = new Knight( 7,  6, true);
		figures.add(knightWhite2);
		Bishop bishopWhite1 = new Bishop( 7, 5, true);
		figures.add(bishopWhite1);
		Bishop bishopWhite2 = new Bishop( 7,  2, true);
		figures.add(bishopWhite2);
		Queen queenWhite = new Queen( 7,  4, true);
		figures.add(queenWhite);
		King kingWhite = new King( 7,  3, true);
		figures.add(kingWhite);
//		Pawn[] pawnWhite = new Pawn[8];
//		for (int i = 0; i < board.length; i++) {
//			pawnWhite[i] = new Pawn((byte) 6, (byte) i, true);
//			figures.add(pawnWhite[i]);
//		}

	}

}
