package com.scheema;

/**
 * Chess board position (rank x file)
 * Chainable. Useful for movement.
 */
class Square implements Cloneable {
    /**
     * Rank 0 - 7
     */
    private int rank;

    /**
     * File 0 - 7
     * 0 = A, 1 - B, ... , 7 = H
     */
    private int file;

    /**
     * It's empty object?
     */
    private boolean isEmpty;
    private static final Square EMPTY = new Square();

    /**
     * Private constructor for
     * avoiding null antipattern
     */
    private Square() {
        rank = -1;
        file = -1;
        isEmpty = true;
    }

    /**
     * Chessboard position
     *
     * @param rank int
     * @param file int
     */
    Square(int rank, int file) {
        this.rank = rank;
        this.file = file;
        isEmpty = false;
    }

    int getFile() {
        return file;
    }

    int getRank() {
        return rank;
    }

    /**
     * Check if we are isEmpty
     *
     * @return boolean
     */
    boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Return an isEmpty object
     *
     * @return Square
     */
    static Square empty() {
        return EMPTY;
    }

    /**
     * Move field one rank up
     *
     * @return Square
     */
    Square rankUp() {
        if (isEmpty()) {
            return empty();
        }
        if (rank > 6) {
            return empty();
        }
        rank++;
        return this;
    }

    /**
     * Move field one rank down
     *
     * @return Square
     */
    Square rankDown() {
        if (isEmpty()) {
            return empty();
        }
        if (rank < 1) {
            return empty();
        }
        rank--;
        return this;
    }

    /**
     * Move left
     *
     * @return Square
     */
    Square fileLeft() {
        if (isEmpty()) {
            return empty();
        }
        if (file < 1) {
            return empty();
        }
        file--;
        return this;
    }

    /**
     * Move right
     *
     * @return Square
     */
    Square fileRight() {
        if (isEmpty()) {
            return empty();
        }
        if (file > 6) {
            return empty();
        }
        file++;
        return this;
    }

    /**
     * Move diagonal up left
     *
     * @return Square
     */
    Square upLeft() {
        return rankUp().fileLeft();
    }

    /**
     * Move diagonal up right
     *
     * @return Square
     */
    Square upRight() {
        return rankUp().fileRight();
    }

    /**
     * Move diagonal down left
     *
     * @return Square
     */
    Square downLeft() {
        return rankDown().fileLeft();
    }

    /**
     * Move diagonal down right
     *
     * @return Square
     */
    Square downRight() {
        return rankDown().fileRight();
    }

    @Override
    public boolean equals(Object obj) {
        Square o = (Square) obj;
        return (rank == o.rank) && (file == o.file);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Integer.hashCode(rank);
        hash = 29 * hash + Integer.hashCode(file);
        return hash;
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {
        return (Square) super.clone();
    }

    @Override
    public String toString() {
        return "Square (" + Integer.toString(rank) + "," + Integer.toString(file) + ")";
    }
}
