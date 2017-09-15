package com.example.nicolo.tfquiz;

/**
 * Created by per6 on 9/15/17.
 */

public class Question {



    private String questionText;
    private boolean answer;

    public Question(String text, boolean answer)
    {
        questionText=text;
        this.answer=answer;
    }

    public boolean CheckAnswer(boolean userAns)
    {
        if (userAns=answer)
        {
            return true;
        }
        return false;

    }

    public String getQuestionText() {
        return questionText;
    }


}
