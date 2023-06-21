package com.example.myartist.model;

public class Piece {
    int pieceId1;
    int pieceId2;
    int pieceId3;
    int pieceId4;
    int pieceId5;

    boolean b1;
    boolean b2;
    boolean b3;
    boolean b4;
    boolean b5;

    public Piece(int pieceId1, int pieceId2, int pieceId3, int pieceId4, int pieceId5) {
        this.pieceId1 = pieceId1;
        this.pieceId2 = pieceId2;
        this.pieceId3 = pieceId3;
        this.pieceId4 = pieceId4;
        this.pieceId5 = pieceId5;
        this.b1 = false;
        this.b2 = false;
        this.b3 = false;
        this.b4 = false;
        this.b5 = false;
    }

    public int getPieceId1() {
        return pieceId1;
    }

    public void setPieceId1(int pieceId1) {
        this.pieceId1 = pieceId1;
    }

    public int getPieceId2() {
        return pieceId2;
    }

    public void setPieceId2(int pieceId2) {
        this.pieceId2 = pieceId2;
    }

    public int getPieceId3() {
        return pieceId3;
    }

    public void setPieceId3(int pieceId3) {
        this.pieceId3 = pieceId3;
    }

    public int getPieceId4() {
        return pieceId4;
    }

    public void setPieceId4(int pieceId4) {
        this.pieceId4 = pieceId4;
    }

    public int getPieceId5() {
        return pieceId5;
    }

    public void setPieceId5(int pieceId5) {
        this.pieceId5 = pieceId5;
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public boolean isB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    public boolean isB4() {
        return b4;
    }

    public void setB4(boolean b4) {
        this.b4 = b4;
    }

    public boolean isB5() {
        return b5;
    }

    public void setB5(boolean b5) {
        this.b5 = b5;
    }
}
