package com.example.nicolo.tfquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trueButton, falseButton, nextButton;
    private Quiz theQuiz;
    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();

    }

    public void wireWidgets()
    {
        theQuiz=new Quiz();
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
                theQuiz.nextQuestion();
                setText();
                break;


        }
    }



    public void setText()
    {
        questionText.setText(theQuiz.getCurrentQuestionText());

    }


}
