package com.example.myartist.model;

public class Question {
    int questionId;
    Answer answer;

    public Question(int questionId, Answer answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
