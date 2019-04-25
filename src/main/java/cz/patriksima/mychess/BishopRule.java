package cz.patriksima.mychess;

class BishopRule {
    private Board board;

    private BishopRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        BishopRule rule = new BishopRule(board);

        if (from.equals(to)) {
            return false;
        }

        /*
        if (board.getPiece(from).getType() != Type.BISHOP) {
            return false;
        }
        */

        if (to.getRank() - from.getRank() > 0
                && to.getFile() - from.getFile() < 0) {
            return rule.checkUpLeft(from, to);
        }

        if (to.getRank() - from.getRank() > 0
                && to.getFile() - from.getFile() > 0) {
            return rule.checkUpRight(from, to);
        }

        if (to.getRank() - from.getRank() < 0
                && to.getFile() - from.getFile() < 0) {
            return rule.checkDownLeft(from, to);
        }

        if (to.getRank() - from.getRank() < 0
                && to.getFile() - from.getFile() > 0) {
            return rule.checkDownRight(from, to);
        }

        return false;
    }

    private boolean checkUpLeft(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().upLeft();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.upLeft();
        }

        return false;
    }

    private boolean checkUpRight(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().upRight();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.upRight();
        }

        return false;
    }

    private boolean checkDownLeft(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().downLeft();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.downLeft();
        }

        return false;
    }

    private boolean checkDownRight(Square from, Square to) throws CloneNotSupportedException {
        Square next = from.clone().downRight();

        while (!next.isEmpty()) {
            if (isEmpty(next) && next.equals(to)) {
                return true;
            }
            if (!isEmpty(next)) {
                return next.equals(to)
                        && isCapturable(board.getPiece(next))
                        && board.getPiece(to).getSide() != board.getPiece(from).getSide();
            }
            next = next.downRight();
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
