package com.example.nicolo.tfquiz;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by per6 on 9/15/17.
 */

class Quiz {

    private ArrayList<Question> questions;

    private int currentQuestion;
    private int score;

    Quiz()
    {
        questions= new ArrayList<Question>();



        currentQuestion=0;
        addQuestions();
    }

    private void addQuestions() {
        questions.add(new Question("Is Bread Good?",true));
        questions.add(new Question("The answer is true",true));
        questions.add(new Question("Does life suck?",false));

    }
    void checkAnswer(boolean userAnswer)
    {
        if(questions.get(currentQuestion).CheckAnswer(userAnswer))
        {
            score++;
        }
    }
    String getCurrentQuestionText()
    {
        return questions.get(currentQuestion).getQuestionText();
    }
    void nextQuestion()
    {
        if(currentQuestion<questions.size()-1) {
            currentQuestion++;
        }
    }

}
