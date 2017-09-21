package com.example.nicolo.tfquiz;

/**
 * Created by per6 on 9/15/17.
 */

class Question {



    private String questionText;
    private boolean answer;

    Question(String text, boolean answer)
    {
        questionText=text;
        this.answer=answer;
    }

    boolean CheckAnswer(boolean userAns)
    {
        return userAns == answer;

    }

    String getQuestionText() {
        return questionText;
    }


}
