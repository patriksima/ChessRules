package cz.patriksima.mychess;

class RookRule {
    private Board board;

    private RookRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        RookRule rule = new RookRule(board);

        if (from.equals(to)) {
            return false;
        }

        /*
        if (board.getPiece(from).getType() != Type.ROOK) {
            return false;
        }
        */

        if (to.getRank() - from.getRank() > 0
                && to.getFile() == from.getFile()) {
            return rule.checkUp(from, to);
        }

        if (to.getRank() - from.getRank() < 0
                && to.getFile() == from.getFile()) {
            return rule.checkDown(from, to);
        }

        if (to.getFile() - from.getFile() < 0
                && to.getRank() == from.getRank()) {
            return rule.checkLeft(from, to);
        }

        if (to.getFile() - from.getFile() > 0
                && to.getRank() == from.getRank()) {
            return rule.checkRight(from, to);
        }

        return false;
    }

    private boolean checkUp(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().rankUp();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.rankUp();
        }

        return false;
    }

    private boolean checkDown(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().rankDown();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.rankDown();
        }

        return false;
    }

    private boolean checkLeft(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().fileLeft();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.fileLeft();
        }

        return false;
    }

    private boolean checkRight(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().fileRight();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.fileRight();
        }

        return false;
    }

    private boolean isEmpty(Square square) {
        return board.getPiece(square).getType() == Type.NONE;
    }

    private boolean isCapturable(Piece piece) {
        return (piece.getType() != Type.NONE) && (piece.getType() != Type.KING);
    }
}
