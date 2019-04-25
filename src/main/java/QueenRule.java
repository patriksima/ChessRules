package com.scheema;

class QueenRule {
    private Board board;

    private QueenRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        if (from.equals(to)) {
            return false;
        }

        if (board.getPiece(from).getType() != Type.QUEEN) {
            return false;
        }

        return BishopRule.isLegalMove(from, to, board) || RookRule.isLegalMove(from, to, board);
    }
}
