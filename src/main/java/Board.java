package com.scheema;

import java.util.ArrayList;

class Board {
    private Piece[][] board = new Piece[8][8];
    private Square lastMove = Square.empty();
    private CastleRight white = CastleRight.NONE;
    private CastleRight black = CastleRight.NONE;

    Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Piece();
            }
        }
    }

    void setPiece(Square square, Piece piece) {
        board[square.getRank()][square.getFile()] = piece;
    }

    Piece getPiece(Square square) {
        return square.isEmpty() ? new Piece() : board[square.getRank()][square.getFile()];
    }

    void setLastMove(Square square) throws CloneNotSupportedException {
        lastMove = square.clone();
    }

    Square getLastMove() throws CloneNotSupportedException {
        return lastMove.clone();
    }

    CastleRight getCastleRight(Side side) {
        return (side == Side.WHITE) ? white : black;
    }

    void setCastleRight(Side side, CastleRight right) {
        if (side == Side.WHITE) {
            white = right;
        } else {
            black = right;
        }
    }

    ArrayList<Square> findPieces(Piece piece) {
        ArrayList<Square> pieces = new ArrayList<>();

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board[rank][file].equals(piece)) {
                    pieces.add(new Square(rank, file));
                }
            }
        }

        return pieces;
    }
}
