package cz.patriksima.mychess;

class KnightRule {
    private Board board;

    private KnightRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        KnightRule rule = new KnightRule(board);

        if (from.equals(to)) {
            return false;
        }

        if (board.getPiece(from).getType() != Type.KNIGHT) {
            return false;
        }

        return rule.isLegalJump(from, to) && (rule.isEmpty(to) || rule.isCapturable(from, to));
    }

    private boolean isLegalJump(Square from, Square to) throws CloneNotSupportedException {
        return from.clone().rankUp().fileLeft().fileLeft().equals(to)
                || from.clone().rankUp().rankUp().fileLeft().equals(to)
                || from.clone().rankUp().fileRight().fileRight().equals(to)
                || from.clone().rankUp().rankUp().fileRight().equals(to)
                || from.clone().rankDown().fileLeft().fileLeft().equals(to)
                || from.clone().rankDown().rankDown().fileLeft().equals(to)
                || from.clone().rankDown().fileRight().fileRight().equals(to)
                || from.clone().rankDown().rankDown().fileRight().equals(to);
    }

    private boolean isEmpty(Square square) {
        return board.getPiece(square).getType() == Type.NONE;
    }

    private boolean isCapturable(Square from, Square to) {
        Piece attacker = board.getPiece(from);
        Piece defender = board.getPiece(to);
        return (defender.getType() != Type.NONE)
                && (defender.getType() != Type.KING)
                && (attacker.getSide() != defender.getSide());
    }
}
