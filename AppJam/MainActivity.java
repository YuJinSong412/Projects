package org.techtown.appjam;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        Button b1;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        }

@Override
public void onClick(View v) {
        if(v.getId() == R.id.imageButton1){
        Intent intent = new Intent(this,MineActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);

        }else {
        Intent intent = new Intent(this, Diff3Activity.class);
        startActivity(intent);
        }
        }
        }

