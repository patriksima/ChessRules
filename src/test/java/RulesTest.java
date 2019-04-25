package cz.patriksima.mychess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {


    @Test
    void pawnMovebyTwo() throws CloneNotSupportedException {
        Board board = new Board();
        Square from = new Square(1, 0);
        Square to = new Square(2, 0);

        board.setPiece(from, new Piece(Type.PAWN, Side.WHITE));

        assertTrue(PawnRule.isLegalMove(from, to, board));
    }
}