package com.example.nicolo.tfquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private Button trueButton, falseButton, nextButton;
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

//        trueButton=(Button)(findViewById(R.id.true_button));
//        falseButton=(Button)(findViewById(R.id.false_button));
//        nextButton=(Button)findViewById(R.id.next_button);

        setText();

    }
    public void onNextButtonClick()
    {
        theQuiz.nextQuestion();
        setText();
    }
    public void onTrueButtonClick()
    {
        theQuiz.checkAnswer(true);
    }
    public void onFalseButtonClick()
    {
        theQuiz.checkAnswer(false);
    }
    public void setText()
    {
        questionText.setText(theQuiz.getCurrentQuestionText());

    }


}
