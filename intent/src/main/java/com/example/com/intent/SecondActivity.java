package com.example.com.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    int resultvalue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        int num1 = inIntent.getIntExtra("Num1", 0);
        int num2 = inIntent.getIntExtra("Num2", 0);

        switch(inIntent.getStringExtra("Sign")){
            case "더하기" :
                resultvalue = num1 + num2;
                break;
            case "빼기" :
                resultvalue = num1 - num2;
                break;
            case "곱하기" :
                resultvalue = num1 * num2;
                break;
            case "나누기" :
                resultvalue = num1 / num2;
                break;
        }

        Button btnReturn = (Button) findViewById(R.id.button);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result", resultvalue);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
