package com.scheema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenRuleTest {
    @Test
    void herMajesty() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/3Q4/8/8/4K3 w KQkq -");

        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.A), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R7, File.A), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.D), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.H), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.H), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.G), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.D), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.A), board));

        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.E), board));
    }

    @Test
    void herMajestyCapturing() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/1r6/8/3Q2n1/8/8/4K3 w KQkq -");

        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.A), board));
        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R7, File.A), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.D), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R8, File.H), board));
        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.H), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.G), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.D), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R1, File.A), board));

        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.B), board));
        assertTrue(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.G), board));

        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R4, File.D), board));
        assertFalse(QueenRule.isLegalMove(new Square(Rank.R4, File.D), new Square(Rank.R6, File.E), board));
    }
}