package com.example.nicolo.tfquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        text=(TextView)findViewById(R.id.end_screen_text);

        Intent i=getIntent();
        text.setText("Score: "+ i.getIntExtra("score",0));

    }


}
