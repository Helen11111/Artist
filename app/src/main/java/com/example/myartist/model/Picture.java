package com.example.myartist.model;

public class Picture {
    int pictureId;
    boolean boolButtonNext;

    Question question1;
    Question question2;
    Question question3;
    Question question4;

    Piece piece;

    public Picture(int pictureId, boolean boolButtonNext, Question question1, Question question2, Question question3, Question question4, Piece piece) {
        this.pictureId = pictureId;
        this.boolButtonNext = boolButtonNext;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.piece = piece;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public boolean isBoolButtonNext() {
        return boolButtonNext;
    }

    public void setBoolButtonNext(boolean boolButtonNext) {
        this.boolButtonNext = boolButtonNext;
    }

    public Question getQuestion1() {
        return question1;
    }

    public void setQuestion1(Question question1) {
        this.question1 = question1;
    }

    public Question getQuestion2() {
        return question2;
    }

    public void setQuestion2(Question question2) {
        this.question2 = question2;
    }

    public Question getQuestion3() {
        return question3;
    }

    public void setQuestion3(Question question3) {
        this.question3 = question3;
    }

    public Question getQuestion4() {
        return question4;
    }

    public void setQuestion4(Question question4) {
        this.question4 = question4;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
