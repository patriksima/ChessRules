package cz.patriksima.mychess;

import java.util.ArrayList;

class Rules {
    private final Board board;

    private Rules(Board board) {
        this.board = board;
    }

    static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        Rules rules = new Rules(board);

        Piece piece = board.getPiece(from);

        if (rules.isChecked(piece.getSide())) {
            // if pawn capture checking piece?
            System.out.println("Hey, I'm checked!");

            if (piece.getType() == Type.PAWN
                    && board.getPiece(to).getType() != Type.NONE
                    && board.getPiece(to).getType() != Type.KING
                    && rules.isAttackedByPawn(to, piece.getSide())) {
                System.out.println("OK, I'll safe you!");
                return true;
            }
        }
        return true;
    }

    private Side getOppositeSide(Side side) {
        return (side == Side.WHITE) ? Side.BLACK : Side.WHITE;
    }

    private boolean isChecked(Side defender) throws CloneNotSupportedException {
        ArrayList<Square> squares = board.findPieces(new Piece(Type.KING, defender));
        Side attacker = getOppositeSide(defender);

        if (squares.size() > 0) {
            Square square = squares.get(0);

            if (isAttackedByPawn(square, attacker)) {
                return true;
            }
        }

        return false;
    }

    private boolean isAttackedByPawn(Square square, Side attacker) throws CloneNotSupportedException {
        final Piece piece = new Piece(Type.PAWN, attacker);
        boolean b;

        if (attacker == Side.WHITE) {
            b = isPieceDownLeft(square, piece) || isPieceDownRight(square, piece);
        } else {
            b = isPieceUpLeft(square, piece) || isPieceUpRight(square, piece);
        }

        return b;
    }

    private boolean isPieceUpLeft(Square start, Piece piece) throws CloneNotSupportedException {
        return board.getPiece(start.clone().upLeft()).equals(piece);
    }

    private boolean isPieceUpRight(Square start, Piece piece) throws CloneNotSupportedException {
        return board.getPiece(start.clone().upRight()).equals(piece);
    }

    private boolean isPieceDownLeft(Square start, Piece piece) throws CloneNotSupportedException {
        return board.getPiece(start.clone().downLeft()).equals(piece);
    }

    private boolean isPieceDownRight(Square start, Piece piece) throws CloneNotSupportedException {
        return board.getPiece(start.clone().downRight()).equals(piece);
    }
}
