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

    Quiz(ArrayList<Question> impQuestions)
    {
        questions= new ArrayList<Question>();
        score=0;

        currentQuestion=0;
        questions.addAll(impQuestions);
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
    boolean onLastQuestion()
    {
        return (currentQuestion == questions.size() - 1);
    }

     int getCurrentQuestion() {
        return currentQuestion;
    }

    void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getScore() {
        return score;
    }
}
