package org.techtown.appjam;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Diff3Activity extends AppCompatActivity {

    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
    }
    public void onClickButton5(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
    public void onClick1(View v){
        button2.setBackgroundColor(0xff14148c);
        button3.setBackgroundColor(0xff14148c);
    }

    public void onClick2(View v){
        button3.setBackgroundColor(0xff14148c);
        button2.setBackgroundColor(0xff14148c);
    }

    public void onClick3(View v){
        button4.setBackgroundColor(0xff14148c);
        button5.setBackgroundColor(0xff14148c);
    }

    public void onClick4(View v){
        button5.setBackgroundColor(0xff14148c);
        button4.setBackgroundColor(0xff14148c);
    }

    public void onClick5(View v){
        button6.setBackgroundColor(0xff14148c);
        button7.setBackgroundColor(0xff14148c);
    }

    public void onClick6(View v){
        button6.setBackgroundColor(0xff14148c);
        button7.setBackgroundColor(0xff14148c);
    }

    public void onClick7(View v){
        button8.setBackgroundColor(0xff14148c);
        button9.setBackgroundColor(0xff14148c);
    }

    public void onClick8(View v){
        button8.setBackgroundColor(0xff14148c);
        button9.setBackgroundColor(0xff14148c);
    }

    public void onClick9(View v){
        button10.setBackgroundColor(0xff14148c);
        button11.setBackgroundColor(0xff14148c);
    }

    public void onClick10(View v){
        button10.setBackgroundColor(0xff14148c);
        button11.setBackgroundColor(0xff14148c);
    }
}