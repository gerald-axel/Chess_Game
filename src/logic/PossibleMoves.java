package logic;

import graphics.Board;
import pieces.Piece;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author gerald
 */
public class PossibleMoves {
	public static ArrayList<JPanel> possibleMoves = new ArrayList<JPanel>();

	public PossibleMoves() {
	}

	public static void reviewPiece(Piece piece) {
		String pieceType = piece.getType();
		int[] coordenates = piece.getCoordenates();
		int x = coordenates[0];
		int y = coordenates[1];

		switch (pieceType) {
		case "Pawn":
			pawnMoves(x, y, piece);
			break;

		case "Knight":
			knightMoves(x, y, piece);
			break;

		case "King":
			kingMoves(x, y, piece);
			break;

		case "Bishop":
			bishopMoves(x, y, piece);
			break;

		case "Rook":
			rookMoves(x, y, piece);
			break;

		case "Queen":
			queenMoves(x, y, piece);
			break;
		}
	}

	public static ArrayList pawnMoves(int x, int y, Piece piece) {
		int numberOfIterations = piece.getMovesCounter() == 0 ? 2 : 1;
		int direction = piece.getTeam().equals("white") ? -1 : 1;

		if (reviewBoardLimits(x + direction, y)) {
			for (int i = 0, aux = direction; i < numberOfIterations; i++, aux += aux) {
				int squarePiece = Board.squares[x + aux][y].getAccessibleContext().getAccessibleChildrenCount();

				if (squarePiece == 0) {
					possibleMoves.add(Board.squares[x + aux][y]);
					Board.setBorders(x + aux, y);
				} else {
					break;
				}
			}
		}

		pawnTrajectory(x + direction, y - 1, piece);
		pawnTrajectory(x + direction, y + 1, piece);

		return possibleMoves;
	}

	public static ArrayList kingMoves(int x, int y, Piece piece) {

		for (int i = 0, directionX = 1; i < 3; i++, directionX += -1) {

			for (int j = 0, directionY = 1; j < 3; j++, directionY += -1) {

				if (reviewBoardLimits(x + directionX, y + directionY)) {
					pieces.Piece squarePiece = (pieces.Piece) Board.squares[x + directionX][y + directionY]
							.getAccessibleContext().getAccessibleChild(0);

					if (squarePiece == null) {
						possibleMoves.add(Board.squares[x + directionX][y + directionY]);
						Board.setBorders(x + directionX, y + directionY);
					} else {
						if (piece.getTeam() != squarePiece.getTeam()) {
							possibleMoves.add(Board.squares[x + directionX][y + directionY]);
							Board.setBorders(x + directionX, y + directionY);
						}
					}
				}
			}

		}

		return possibleMoves;
	}

	public static ArrayList bishopMoves(int x, int y, Piece piece) {

		for (int j = 1; j <= 8 && bishopTrajectory(x + j, y + j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x - j, y - j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x + j, y - j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x - j, y + j, piece); j++) {
		}

		return possibleMoves;
	}

	public static ArrayList rookMoves(int x, int y, Piece piece) {
		for (int j = 1; j <= 8 && rookTrajectory(x + j, y, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x - j, y, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x, y + j, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x, y - j, piece); j++) {
		}

		return possibleMoves;
	}

	public static ArrayList queenMoves(int x, int y, Piece piece) {

		for (int j = 1; j <= 8 && bishopTrajectory(x + j, y + j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x - j, y - j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x + j, y - j, piece); j++) {
		}

		for (int j = 1; j <= 8 && bishopTrajectory(x - j, y + j, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x + j, y, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x - j, y, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x, y + j, piece); j++) {
		}

		for (int j = 1; j <= 8 && rookTrajectory(x, y - j, piece); j++) {
		}

		return possibleMoves;
	}

	public static ArrayList knightMoves(int x, int y, Piece piece) {

		knightTrajectory(x - 2, y - 1, piece);
		knightTrajectory(x - 2, y + 1, piece);
		knightTrajectory(x - 1, y - 2, piece);
		knightTrajectory(x - 1, y + 2, piece);

		knightTrajectory(x + 2, y + 1, piece);
		knightTrajectory(x + 2, y - 1, piece);
		knightTrajectory(x + 1, y - 2, piece);
		knightTrajectory(x + 1, y + 2, piece);

		return possibleMoves;
	}

	public static void pawnTrajectory(int x, int y, pieces.Piece piece) {
		if (reviewBoardLimits(x, y)) {
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y].getAccessibleContext().getAccessibleChild(0);
			if (squarePiece != null && !piece.getTeam().equals(squarePiece.getTeam())) {
				possibleMoves.add(Board.squares[x][y]);
				Board.setBorders(x, y);
			}
		}
	}

	public static boolean bishopTrajectory(int x, int y, pieces.Piece piece) {

		if (reviewBoardLimits(x, y)) {
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y].getAccessibleContext().getAccessibleChild(0);

			if (squarePiece == null) {
				possibleMoves.add(Board.squares[x][y]);
				Board.setBorders(x, y);
			} else {
				if (piece.getTeam() != squarePiece.getTeam()) {
					possibleMoves.add(Board.squares[x][y]);
					Board.setBorders(x, y);
					return false;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean rookTrajectory(int x, int y, pieces.Piece piece) {
		if (reviewBoardLimits(x, y)) {
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y].getAccessibleContext().getAccessibleChild(0);

			if (squarePiece == null) {
				possibleMoves.add(Board.squares[x][y]);
				Board.setBorders(x, y);
			} else {
				if (piece.getTeam() != squarePiece.getTeam()) {
					possibleMoves.add(Board.squares[x][y]);
					Board.setBorders(x, y);
					return false;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static void knightTrajectory(int x, int y, pieces.Piece piece) {
		if (reviewBoardLimits(x, y)) {
			pieces.Piece squarePiece = (pieces.Piece) Board.squares[x][y].getAccessibleContext().getAccessibleChild(0);
			if (squarePiece == null) {
				possibleMoves.add(Board.squares[x][y]);
				Board.setBorders(x, y);
			} else {
				if (piece.getTeam() != squarePiece.getTeam()) {
					possibleMoves.add(Board.squares[x][y]);
					Board.setBorders(x, y);
				}
			}
		}
	}

	public static boolean reviewBoardLimits(int x, int y) {
		return (x < 8 && y < 8) && (x >= 0 && y >= 0) ? true : false;
	}
}
