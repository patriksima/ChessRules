package cz.patriksima.mychess;

class PawnRule {
    private Board board;

    private PawnRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        PawnRule rule = new PawnRule(board);
        Piece piece = board.getPiece(from);

        // same square?
        if (from.equals(to)) {
            return false;
        }

        if (board.getPiece(from).getType() != Type.PAWN) {
            return false;
        }

        if (rule.isOneSpaceMove(from, to, piece.getSide())) {
            return true;
        }

        if (rule.isTwoSpaceMove(from, to, piece.getSide())) {
            return true;
        }

        if (rule.isEnPassant(from, to, piece.getSide())) {
            return true;
        }

        if (rule.isTryingCapture(from, to, piece.getSide())
                && rule.isCapturable(board.getPiece(to))
                && board.getPiece(to).getSide() != piece.getSide()) {
            return true;
        }

        return false;
    }

    private boolean isOneSpaceMove(Square from, Square to, Side side) {
        boolean b;
        if (side == Side.WHITE) {
            b = from.getRank() + 1 == to.getRank()
                    && from.getFile() == to.getFile()
                    && isEmpty(to);
        } else {
            b = from.getRank() - 1 == to.getRank()
                    && from.getFile() == to.getFile()
                    && isEmpty(to);
        }
        return b;
    }

    private boolean isTwoSpaceMove(Square from, Square to, Side side) throws CloneNotSupportedException {
        boolean b;
        if (side == Side.WHITE) {
            b = isBaseRank(from, side)
                    && from.getRank() + 2 == to.getRank()
                    && from.getFile() == to.getFile()
                    && isEmpty(to)
                    && isEmpty(to.clone().rankDown());
        } else {
            b = isBaseRank(from, side)
                    && from.getRank() - 2 == to.getRank()
                    && from.getFile() == to.getFile()
                    && isEmpty(to)
                    && isEmpty(to.clone().rankUp());
        }
        return b;
    }

    private boolean isEnPassant(Square from, Square to, Side side) throws CloneNotSupportedException {
        if (!isTryingCapture(from, to, side)) {
            return false;
        }

        if (!isEnPassantCondition(side)) {
            return false;
        }

        if (!isEmpty(to)) {
            return false;
        }

        boolean b;

        if (side == Side.WHITE) {
            b = from.getRank() == 4
                    && to.getRank() == 5;
        } else {
            b = from.getRank() == 3
                    && to.getRank() == 2;
        }
        return b;
    }

    private boolean isEnPassantCondition(Side attacker) throws CloneNotSupportedException {
        Square square = board.getLastMove();
        Piece piece = board.getPiece(square);
        Side defender = attacker.opposite();

        boolean b;

        if (attacker == Side.WHITE) {
            b = isPawn(piece)
                    && piece.getSide() == defender
                    && square.getRank() == 4;
        } else {
            b = isPawn(piece)
                    && piece.getSide() == defender
                    && square.getRank() == 3;
        }

        return b;
    }

    private boolean isTryingCapture(Square from, Square to, Side side) {
        boolean b;
        if (side == Side.WHITE) {
            b = from.getRank() + 1 == to.getRank()
                    && (from.getFile() - 1 == to.getFile() || from.getFile() + 1 == to.getFile());
        } else {
            b = from.getRank() - 1 == to.getRank()
                    && (from.getFile() - 1 == to.getFile() || from.getFile() + 1 == to.getFile());
        }
        return b;
    }

    private boolean isEmpty(Square square) {
        return board.getPiece(square).getType() == Type.NONE;
    }

    private boolean isPawn(Piece piece) {
        return piece.getType() == Type.PAWN;
    }

    private boolean isCapturable(Piece piece) {
        return (piece.getType() != Type.NONE) && (piece.getType() != Type.KING);
    }

    private boolean isBaseRank(Square square, Side side) {
        return (side == Side.WHITE && square.getRank() == 1) || (side == Side.BLACK && square.getRank() == 6);
    }
}
