package com.scheema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FenTest {
    @Test
    void readFen() {
        Board board = Fen.read("7K/1p2n2P/P3Pk1p/2b4r/4BPq1/4p3/5p2/N7 w - - 0 1");
    }
}