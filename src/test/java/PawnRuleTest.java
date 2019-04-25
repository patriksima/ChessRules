package cz.patriksima.mychess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnRuleTest {
    @Test
    void moveByOne() throws CloneNotSupportedException {
        Board board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(1, 4), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(1, 7), new Piece(Type.PAWN, Side.WHITE));

        assertTrue(PawnRule.isLegalMove(new Square(1, 0), new Square(2, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(1, 4), new Square(2, 4), board));
        assertTrue(PawnRule.isLegalMove(new Square(1, 7), new Square(2, 7), board));

        board = new Board();
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(2, 4), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(2, 7), new Piece(Type.PAWN, Side.WHITE));

        assertTrue(PawnRule.isLegalMove(new Square(2, 0), new Square(3, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(2, 4), new Square(3, 4), board));
        assertTrue(PawnRule.isLegalMove(new Square(2, 7), new Square(3, 7), board));

        board = new Board();
        board.setPiece(new Square(6, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(6, 4), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(6, 7), new Piece(Type.PAWN, Side.WHITE));

        assertTrue(PawnRule.isLegalMove(new Square(6, 0), new Square(7, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(6, 4), new Square(7, 4), board));
        assertTrue(PawnRule.isLegalMove(new Square(6, 7), new Square(7, 7), board));

        board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(1, 0), new Square(1, 0), board));

        board = new Board();
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(2, 0), new Square(1, 0), board));

        board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(1, 0), new Square(2, 0), board));

        board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(2, 0), new Piece(Type.BISHOP, Side.BLACK));

        assertFalse(PawnRule.isLegalMove(new Square(1, 0), new Square(2, 0), board));
    }

    @Test
    void moveByTwo() throws CloneNotSupportedException {
        Board board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(1, 4), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(1, 7), new Piece(Type.PAWN, Side.WHITE));

        assertTrue(PawnRule.isLegalMove(new Square(1, 0), new Square(3, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(1, 4), new Square(3, 4), board));
        assertTrue(PawnRule.isLegalMove(new Square(1, 7), new Square(3, 7), board));

        board = new Board();
        board.setPiece(new Square(6, 0), new Piece(Type.PAWN, Side.BLACK));
        board.setPiece(new Square(6, 4), new Piece(Type.PAWN, Side.BLACK));
        board.setPiece(new Square(6, 7), new Piece(Type.PAWN, Side.BLACK));

        assertTrue(PawnRule.isLegalMove(new Square(6, 0), new Square(4, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(6, 4), new Square(4, 4), board));
        assertTrue(PawnRule.isLegalMove(new Square(6, 7), new Square(4, 7), board));

        board = new Board();
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(2, 0), new Square(4, 0), board));

        board = new Board();
        board.setPiece(new Square(5, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(5, 0), new Square(7, 0), board));

        board = new Board();
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(1, 0), new Square(3, 0), board));
        assertFalse(PawnRule.isLegalMove(new Square(2, 0), new Square(0, 0), board));

        board = new Board();
        board.setPiece(new Square(1, 0), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(2, 0), new Piece(Type.PAWN, Side.BLACK));

        assertFalse(PawnRule.isLegalMove(new Square(1, 0), new Square(3, 0), board));
    }

    @Test
    void enPassant() throws CloneNotSupportedException {
        Board board = new Board();
        board.setPiece(new Square(4, 0), new Piece(Type.PAWN, Side.BLACK));
        board.setPiece(new Square(4, 1), new Piece(Type.PAWN, Side.WHITE));

        assertFalse(PawnRule.isLegalMove(new Square(4, 1), new Square(5, 0), board));

        board.setLastMove(new Square(4, 0));

        assertTrue(PawnRule.isLegalMove(new Square(4, 1), new Square(5, 0), board));
    }

    @Test
    void capturing() throws CloneNotSupportedException {
        Board board = new Board();
        board.setPiece(new Square(Rank.R2, File.B), new Piece(Type.PAWN, Side.WHITE));
        board.setPiece(new Square(Rank.R3, File.C), new Piece(Type.PAWN, Side.BLACK));

        assertFalse(PawnRule.isLegalMove(new Square(1, 1), new Square(2, 0), board));
        assertTrue(PawnRule.isLegalMove(new Square(1, 1), new Square(2, 2), board));
        assertFalse(PawnRule.isLegalMove(new Square(1, 1), new Square(3, 3), board));

        board.setPiece(new Square(2, 2), new Piece(Type.KING, Side.BLACK));
        assertFalse(PawnRule.isLegalMove(new Square(1, 1), new Square(2, 2), board));

        board.setPiece(new Square(2, 2), new Piece(Type.NONE, Side.BLACK));
        assertFalse(PawnRule.isLegalMove(new Square(1, 1), new Square(2, 2), board));
    }
}