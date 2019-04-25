package com.scheema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopRuleTest {
    @Test
    void upLeft() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/8/8/4B3/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R2, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R6, File.A), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R3, File.D), board));
    }

    @Test
    void upLeftCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/2b5/8/4B3/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R2, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R4, File.C), board));
        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R6, File.A), board));
    }

    @Test
    void upRight() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/8/8/4B3/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R2, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R5, File.H), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R3, File.F), board));
    }

    @Test
    void upRightCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/6b1/8/4B3/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R2, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R4, File.G), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R3, File.F), board));
        assertFalse(BishopRule.isLegalMove(new Square(Rank.R2, File.E), new Square(Rank.R5, File.H), board));
    }

    @Test
    void downLeft() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/4B3/8/8/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R4, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R1, File.B), board));
    }

    @Test
    void downLeftCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/4B3/8/2b5/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R4, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R2, File.C), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R3, File.D), board));
        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R1, File.B), board));
    }

    @Test
    void downRight() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/4B3/8/8/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R4, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R1, File.H), board));
    }

    @Test
    void downRightCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/4B3/8/6b1/4K3 w KQkq -");

        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R4, File.E), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R3, File.F), board));
        assertTrue(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R2, File.G), board));
        assertFalse(BishopRule.isLegalMove(new Square(Rank.R4, File.E), new Square(Rank.R1, File.H), board));
    }
}