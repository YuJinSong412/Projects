package gachon.ac.kr.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    Button btnLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin2=(Button)findViewById(R.id.btnLogin2);

        //로그인 완료 후 index 화면 버튼
        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,indexActivity.class);
                startActivity(intent);
            }
        });


    }
}
