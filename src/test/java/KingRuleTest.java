package cz.patriksima.mychess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingRuleTest {
    @Test
    void checkDefaultPosition() throws CloneNotSupportedException {
        Board board = Fen.read("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -");

        assertFalse(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void checkByBishop() throws CloneNotSupportedException {
        Board board = Fen.read("rnbqk1nr/ppp2ppp/4p3/3p4/1bPP4/5N2/PP2PPPP/RNBQKB1R w KQkq -");

        assertTrue(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void notCheckByBishop() throws CloneNotSupportedException {
        Board board = Fen.read("rnbqk1nr/ppp2ppp/4p3/3p4/1bPP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq -");

        assertFalse(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void checkByRook() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/8/8/R7/4K2r w KQkq -");

        assertTrue(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void checkByKnight() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/8/8/8/8/3n3r/1R6/4K3 w KQkq -");

        assertTrue(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void checkDouble() throws CloneNotSupportedException {
        Board board = Fen.read("4k3/4r3/8/8/8/3n4/1R6/4K3 w KQkq -");

        assertTrue(KingRule.isChecked(new Square(Rank.R1, File.E), Side.BLACK, board));
    }

    @Test
    void checkByPawn() throws CloneNotSupportedException {
        Board board = Fen.read("8/8/4k3/6p1/5pP1/4KP2/8/8 w KQkq -");

        assertTrue(KingRule.isChecked(new Square(Rank.R3, File.E), Side.BLACK, board));
    }

    @Test
    void notCheckByPawn() throws CloneNotSupportedException {
        Board board = Fen.read("8/8/4k3/6p1/4KpP1/5P2/8/8 w KQkq -");

        assertFalse(KingRule.isChecked(new Square(Rank.R4, File.E), Side.BLACK, board));
    }

    @Test
    void movingNotCheck() throws CloneNotSupportedException {
        Board board = Fen.read("8/5k2/8/6p1/2K2pP1/5P2/8/8 w - -");

        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.B), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.B), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.C), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.C), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.B), board));
    }

    @Test
    void movingCheckKing() throws CloneNotSupportedException {
        Board board = Fen.read("8/8/4k3/6p1/2K2pP1/5P2/8/8 w - -");

        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.B), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.B), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.C), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.D), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.C), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.B), board));
    }

    @Test
    void mate() throws CloneNotSupportedException {
        Board board = Fen.read("8/8/p1k1p3/P7/2K3r1/7r/8/8 w - -");

        assertTrue(KingRule.isChecked(new Square(Rank.R4, File.C), Side.BLACK, board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.C), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.C), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.D), board));

        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.D), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.D), board));
    }

    @Test
    void staleMate() throws CloneNotSupportedException {
        Board board = Fen.read("1q6/8/p1k1p3/P7/2K5/7r/8/3r4 w - -");

        assertFalse(KingRule.isChecked(new Square(Rank.R4, File.C), Side.BLACK, board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.C), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.C), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R4, File.D), board));

        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R5, File.D), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.B), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R4, File.C), new Square(Rank.R3, File.D), board));
    }

    @Test
    void castleKingSide() throws CloneNotSupportedException {
        Board board = Fen.read("r1bqk1nr/pppp1ppp/2n5/1Bb1p3/4P3/5N2/PPPP1PPP/RNBQK2R w KQkq -");

        assertTrue(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.G), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.H), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.C), board));
    }

    @Test
    void castleQueenSide() throws CloneNotSupportedException {
        Board board = Fen.read("r2qkb1r/1b3ppp/p1np1n2/1p2p3/4P3/1NN1BP2/PPPQ2PP/R3KB1R w KQkq -");

        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.G), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.H), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.B), board));
        assertTrue(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.C), board));
    }

    @Test
    void castleKingSideWrong() throws CloneNotSupportedException {
        Board board = Fen.read("rnbq1rk1/ppp2ppp/3p1n2/2b1p3/2B1P3/5P2/PPPPN1PP/RNBQK2R w KQkq -");

        assertTrue(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.F), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R2, File.F), board));
        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.G), board));
    }

    @Test
    void castleQueenSideWrong() throws CloneNotSupportedException {
        Board board = Fen.read("r2qk1nr/ppp1pp1p/2n3pb/3p1b2/2PP4/1QN3B1/PP2PPPP/R3KBNR w KQkq -");

        assertFalse(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.C), board));
    }

    @Test
    void castleQueenSideCoveredCheck() throws CloneNotSupportedException {
        Board board = Fen.read("r2qk1nr/ppp1pp1p/2n3pb/3p1b2/2PP4/1QN1P1B1/PP3PPP/R3KBNR w KQkq -");

        assertTrue(KingRule.isLegalMove(new Square(Rank.R1, File.E), new Square(Rank.R1, File.C), board));
    }
}