package cz.patriksima.mychess;

enum Side {
    BLACK,
    WHITE,
    NONE;

    Side opposite() {
        return (this == WHITE) ? BLACK : WHITE;
    }
}
