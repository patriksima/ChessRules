package com.scheema;

class Fen {
    static String write(Board board) {
        return "";
    }

    static Board read(String fen) {
        Board board = new Board();

        String[] fields = fen.split(" ");

        String ranks[] = fields[0].split("/");

        int file;
        int rank = 7;
        for (String r : ranks) {
            file = 0;
            for (int i = 0; i < r.length(); i++) {
                char c = r.charAt(i);
                if (Character.isDigit(c)) {
                    file += Integer.parseInt(c + "");
                } else {
                    Piece piece;
                    switch (c) {
                        case 'K':
                            piece = new Piece(Type.KING, Side.WHITE);
                            break;
                        case 'Q':
                            piece = new Piece(Type.QUEEN, Side.WHITE);
                            break;
                        case 'R':
                            piece = new Piece(Type.ROOK, Side.WHITE);
                            break;
                        case 'N':
                            piece = new Piece(Type.KNIGHT, Side.WHITE);
                            break;
                        case 'B':
                            piece = new Piece(Type.BISHOP, Side.WHITE);
                            break;
                        case 'P':
                            piece = new Piece(Type.PAWN, Side.WHITE);
                            break;
                        case 'k':
                            piece = new Piece(Type.KING, Side.BLACK);
                            break;
                        case 'q':
                            piece = new Piece(Type.QUEEN, Side.BLACK);
                            break;
                        case 'r':
                            piece = new Piece(Type.ROOK, Side.BLACK);
                            break;
                        case 'n':
                            piece = new Piece(Type.KNIGHT, Side.BLACK);
                            break;
                        case 'b':
                            piece = new Piece(Type.BISHOP, Side.BLACK);
                            break;
                        case 'p':
                            piece = new Piece(Type.PAWN, Side.BLACK);
                            break;
                        default:
                            throw new IllegalArgumentException("Illegal piece.");
                    }

                    //System.out.println("Rank:" + rank + ", File:" + file + ", Piece:" + c + " (" + piece.getType() + ")");

                    board.setPiece(new Square(rank, file), piece);
                    file++;
                }
            }
            rank--;
        }

        if (fields[2].contains("KQ")) {
            board.setCastleRight(Side.WHITE, CastleRight.BOTH_SIDES);
        } else if (fields[2].contains("K")) {
            board.setCastleRight(Side.WHITE, CastleRight.KING_SIDE);
        } else if (fields[2].contains("Q")) {
            board.setCastleRight(Side.WHITE, CastleRight.QUEEN_SIDE);
        } else {
            board.setCastleRight(Side.WHITE, CastleRight.NONE);
        }

        if (fields[2].contains("kq")) {
            board.setCastleRight(Side.BLACK, CastleRight.BOTH_SIDES);
        } else if (fields[2].contains("k")) {
            board.setCastleRight(Side.BLACK, CastleRight.KING_SIDE);
        } else if (fields[2].contains("q")) {
            board.setCastleRight(Side.BLACK, CastleRight.QUEEN_SIDE);
        } else {
            board.setCastleRight(Side.BLACK, CastleRight.NONE);
        }
/*
        sideToMove = state.toLowerCase().charAt(0) == 'w' ? Side.WHITE : Side.BLACK;

        if (state.contains("KQ")) {
            castleRight.put(Side.WHITE, CastleRight.KING_AND_QUEEN_SIDE);
        } else if (state.contains("K")) {
            castleRight.put(Side.WHITE, CastleRight.KING_SIDE);
        } else if (state.contains("Q")) {
            castleRight.put(Side.WHITE, CastleRight.QUEEN_SIDE);
        } else {
            castleRight.put(Side.WHITE, CastleRight.NONE);
        }

        if (state.contains("kq")) {
            castleRight.put(Side.BLACK, CastleRight.KING_AND_QUEEN_SIDE);
        } else if (state.contains("k")) {
            castleRight.put(Side.BLACK, CastleRight.KING_SIDE);
        } else if (state.contains("q")) {
            castleRight.put(Side.BLACK, CastleRight.QUEEN_SIDE);
        } else {
            castleRight.put(Side.BLACK, CastleRight.NONE);
        }

        String flags[] = state.split(" ");

        if (flags.length >= 3) {
            String s = flags[2].toUpperCase().trim();
            if (!s.equals("-")) {
                Square ep = Square.valueOf(s);
                setEnPassant(ep);
                setEnPassantTarget(findEnPassantTarget(ep, sideToMove));
            } else {
                setEnPassant(Square.NONE);
                setEnPassantTarget(Square.NONE);
            }
            if (flags.length >= 4) {
                halfMoveCounter = Integer.parseInt(flags[3]);
                if (flags.length >= 5) {
                    moveCounter = Integer.parseInt(flags[4]);
                }
            }
        }

        //call listeners
        if (isEnableEvents() &&
                eventListener.get(BoardEventType.ON_LOAD).size() > 0) {
            for (BoardEventListener evl :
                    eventListener.get(BoardEventType.ON_LOAD)) {
                evl.onEvent(Board.this);
            }
        }*/
        return board;
    }
}
