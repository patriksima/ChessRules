package cz.patriksima.mychess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightRuleTest {
    @Test
    void jumping() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3N4/8/8/4K3 w KQkq -");

        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.B), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.C), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.E), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.F), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.F), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.E), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.C), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.B), board));

        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.D), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.B), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.E), board));
    }

    @Test
    void jumpAndCapture() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/2r5/8/3N4/5q2/8/4K3 w KQkq -");

        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.B), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.C), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.E), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.F), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.F), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.E), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.C), board));
        assertTrue(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.B), board));

        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.D), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.B), board));
        assertFalse(KnightRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.E), board));
    }
}