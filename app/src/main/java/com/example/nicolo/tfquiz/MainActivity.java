package com.example.nicolo.tfquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trueButton, falseButton, nextButton;
    private Quiz theQuiz;
    TextView questionText;
    public static final String TAG="Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState!=null)
        {
            theQuiz.setCurrentQuestion(savedInstanceState.getInt("question we're on"));
        }
        wireWidgets();

    }

    public void wireWidgets()
    {
        ArrayList<Question> qs=new ArrayList<Question>();
        qs.add(new Question(getString(R.string.question_one), true));
        qs.add(new Question(getString(R.string.question_two),true));
        qs.add(new Question(getString(R.string.question_three),false));
        theQuiz=new Quiz(qs);
        questionText=(TextView)(findViewById(R.id.text_question));

        trueButton=(Button)(findViewById(R.id.true_button));
        falseButton=(Button)(findViewById(R.id.false_button));
        nextButton=(Button)findViewById(R.id.next_button);
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        setText();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.true_button:
                theQuiz.checkAnswer(true);
                break;
            case R.id.false_button:
                theQuiz.checkAnswer(false);
                break;
            case R.id.next_button:
                if(!theQuiz.onLastQuestion()) {
                    theQuiz.nextQuestion();
                    setText();
                }
                else{
                    Intent i =new Intent(MainActivity.this, EndScreen.class);
                    i.putExtra("score",theQuiz.getScore());
                    startActivity(i);
                }
                break;


        }
    }



    public void setText()
    {
        questionText.setText(theQuiz.getCurrentQuestionText());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: method fired");
        
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: method fired");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: method fired");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: method fired");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: method fired");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("question we're on", theQuiz.getCurrentQuestion());
    }
}
