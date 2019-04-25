package com.scheema;

class KingRule {
    private Board board;

    private KingRule(Board board) {
        this.board = board;
    }

    public static boolean isLegalMove(Square from, Square to, Board board) throws CloneNotSupportedException {
        KingRule rule = new KingRule(board);
        Piece king = board.getPiece(from);

        if (from.equals(to)) {
            return false;
        }

        Square next = from.clone().fileLeft();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().fileRight();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().rankUp();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().rankDown();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().upLeft();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().upRight();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().downLeft();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        next = from.clone().downRight();
        if (rule.isLegalSquare(next, to, king.getSide().opposite())) {
            return true;
        }

        CastleRight cr = board.getCastleRight(king.getSide());
        if (cr == CastleRight.KING_SIDE || cr == CastleRight.BOTH_SIDES) {
            //
            if (king.getSide() == Side.WHITE) {
                if (from.equals(new Square(Rank.R1, File.E))
                        && to.equals(new Square(Rank.R1, File.G))
                        && !KingRule.isChecked(from, king.getSide().opposite(), board)
                        && rule.isLegalSquare(new Square(Rank.R1, File.F), new Square(Rank.R1, File.F), king.getSide().opposite())
                        && rule.isLegalSquare(new Square(Rank.R1, File.G), new Square(Rank.R1, File.G), king.getSide().opposite())) {
                    return true;
                }
            } else {
                if (from.equals(new Square(Rank.R8, File.E))
                        && to.equals(new Square(Rank.R8, File.G))
                        && !KingRule.isChecked(from, king.getSide().opposite(), board)
                        && rule.isLegalSquare(new Square(Rank.R8, File.F), new Square(Rank.R8, File.F), king.getSide().opposite())
                        && rule.isLegalSquare(new Square(Rank.R8, File.G), new Square(Rank.R8, File.G), king.getSide().opposite())) {
                    return true;
                }
            }
        }

        if (cr == CastleRight.QUEEN_SIDE || cr == CastleRight.BOTH_SIDES) {
            //
            if (king.getSide() == Side.WHITE) {
                if (from.equals(new Square(Rank.R1, File.E))
                        && to.equals(new Square(Rank.R1, File.C))
                        && !KingRule.isChecked(from, king.getSide().opposite(), board)
                        && rule.isLegalSquare(new Square(Rank.R1, File.D), new Square(Rank.R1, File.D), king.getSide().opposite())
                        && rule.isLegalSquare(new Square(Rank.R1, File.C), new Square(Rank.R1, File.C), king.getSide().opposite())) {
                    return true;
                }
            } else {
                if (from.equals(new Square(Rank.R8, File.E))
                        && to.equals(new Square(Rank.R8, File.C))
                        && !KingRule.isChecked(from, king.getSide().opposite(), board)
                        && rule.isLegalSquare(new Square(Rank.R8, File.D), new Square(Rank.R8, File.D), king.getSide().opposite())
                        && rule.isLegalSquare(new Square(Rank.R8, File.C), new Square(Rank.R8, File.C), king.getSide().opposite())) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isLegalSquare(Square next, Square to, Side attacker) throws CloneNotSupportedException {
        return !next.isEmpty()
                && !to.isEmpty()
                && isEmpty(to)
                && next.equals(to)
                && !KingRule.isChecked(to, attacker, board);
    }

    public static boolean isChecked(Square square, Side attacker, Board board) throws CloneNotSupportedException {
        KingRule rule = new KingRule(board);

        Square next = square.clone().fileLeft();

        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);
            if (!rule.isEmpty(next)) {
                // queen, rook
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.ROOK)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.fileLeft();
        }

        next = square.clone().fileRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, rook
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.ROOK)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.fileRight();
        }

        next = square.clone().rankUp();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, rook
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.ROOK)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.rankUp();
        }

        next = square.clone().rankDown();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, rook
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.ROOK)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.rankDown();
        }

        // diagonal
        next = square.clone().upLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, bishop
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.BISHOP)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.upLeft();
        }

        next = square.clone().upRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, bishop
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.BISHOP)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.upRight();
        }

        next = square.clone().downLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, bishop
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.BISHOP)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.downLeft();
        }

        next = square.clone().downRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KING
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }
        while (!next.isEmpty()) {
            Piece piece = board.getPiece(next);

            if (!rule.isEmpty(next)) {
                // queen, bishop
                if (attacker == piece.getSide()
                        && (piece.getType() == Type.QUEEN || piece.getType() == Type.BISHOP)) {
                    return true;
                }
                // our king is invisible now
                if (piece.getType() != Type.KING || piece.getSide() == attacker) {
                    break;
                }
            }
            next = next.downRight();
        }

        // knight
        next = square.clone().rankUp().fileLeft().fileLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankUp().rankUp().fileLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankUp().fileRight().fileRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankUp().rankUp().fileRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankDown().fileLeft().fileLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankDown().rankDown().fileLeft();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankDown().fileRight().fileRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        next = square.clone().rankDown().rankDown().fileRight();
        if (!next.isEmpty()
                && board.getPiece(next).getType() == Type.KNIGHT
                && board.getPiece(next).getSide() == attacker) {
            return true;
        }

        // pawn
        if (attacker == Side.BLACK) {
            next = square.clone().upLeft();
            if (!next.isEmpty()
                    && board.getPiece(next).getType() == Type.PAWN
                    && board.getPiece(next).getSide() == attacker) {
                return true;
            }

            next = square.clone().upRight();
            if (!next.isEmpty()
                    && board.getPiece(next).getType() == Type.PAWN
                    && board.getPiece(next).getSide() == attacker) {
                return true;
            }
        } else {
            next = square.clone().downLeft();
            if (!next.isEmpty()
                    && board.getPiece(next).getType() == Type.PAWN
                    && board.getPiece(next).getSide() == attacker) {
                return true;
            }

            next = square.clone().downRight();
            if (!next.isEmpty()
                    && board.getPiece(next).getType() == Type.PAWN
                    && board.getPiece(next).getSide() == attacker) {
                return true;
            }
        }

        return false;
    }

    private boolean isEmpty(Square square) {
        return board.getPiece(square).getType() == Type.NONE;
    }
}
