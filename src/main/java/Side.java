package com.scheema;

enum Side {
    BLACK,
    WHITE,
    NONE;

    Side opposite() {
        return (this == WHITE) ? BLACK : WHITE;
    }
}
