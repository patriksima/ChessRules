package com.scheema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RookRuleTest {
    @Test
    void rankUp() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3R4/8/8/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.D), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.D), board));
    }

    @Test
    void rankDown() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3R4/8/8/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.D), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.D), board));
    }

    @Test
    void fileLeft() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3R4/8/8/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.A), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.C), board));
    }

    @Test
    void fileRight() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3R4/8/8/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.E), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.H), board));
    }

    @Test
    void rankUpCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/3b4/8/1r1R1r2/8/3n4/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.D), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.D), board));

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R7, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.D), board));
    }

    @Test
    void rankDownCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/3b4/8/1r1R1r2/8/3n4/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R2, File.D), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R3, File.D), board));

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.D), board));
    }

    @Test
    void fileLeftCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/3b4/8/1r1R1r2/8/3n4/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.C), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.B), board));

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.A), board));
    }

    @Test
    void fileRightCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/3b4/8/1r1R1r2/8/3n4/4K3 w KQkq -");

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R5, File.E), board));

        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.E), board));
        assertTrue(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.F), board));

        assertFalse(RookRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.G), board));
    }
}