package com.example.myapplication;

public class QuestionModel {

    public QuestionModel (String questionString, String answer,String hints) {
        QuestionString = questionString;
        Answer = answer;
        Hints = hints;
    }
    public String getQuestionString() { return QuestionString; }
    public void setQuestion(String questionString) { QuestionString = questionString; }
    public String getAnswer() { return  Answer; }
    public void setAnswer(String answer) { Answer = answer;}
    public String getHints() { return Hints; }
    public void setHints(String hints) { Hints = hints; }

    private String QuestionString;
    private String Answer;
    private String Hints;
}
