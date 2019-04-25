package cz.patriksima.mychess;

class Piece {
    private Type type;
    private Side side;

    Piece() {
        this(Type.NONE, Side.NONE);
    }

    Piece(Type type, Side side) {
        this.type = type;
        this.side = side;
    }

    public Type getType() {
        return type;
    }

    public Side getSide() {
        return side;
    }

    @Override
    public boolean equals(Object obj) {
        Piece o = (Piece) obj;
        return (side == o.side) && (type == o.type);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + side.hashCode();
        hash = 29 * hash + type.hashCode();
        return hash;
    }
}
