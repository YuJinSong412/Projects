package gachon.ac.kr.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //사진, 상품이름, 가격, 상품설명, 상품특징 받음
        Intent intent = getIntent();

        int imageResult = intent.getIntExtra("ImageFile",0);
        String nameResult = intent.getStringExtra("ImageName");
        String namePrice = intent.getStringExtra("ImagePrice");
        int rawExplain = intent.getIntExtra("rawExplain",0);
        int rawSummary = intent.getIntExtra("rawSummary",0);

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);

        img1.setImageResource(imageResult);
        textView1.setText(nameResult);
        textView2.setText(namePrice);


        //raw폴더에서 파일 읽어오기
        final TextView productDS = (TextView)findViewById(R.id.productDS);
        try{
            InputStream inputS = getResources().openRawResource(rawExplain);
            byte[] txt = new byte[inputS.available()];
            inputS.read(txt);
            productDS.setText(new String(txt));
            inputS.close();
        }catch(IOException e){}


        //raw폴더에서 파일 읽어오기
        final TextView productSM = (TextView)findViewById(R.id.productSM);
        try{
            InputStream inputS = getResources().openRawResource(rawSummary);
            byte[] txt = new byte[inputS.available()];
            inputS.read(txt);
            productSM.setText(new String(txt));
            inputS.close();
        }catch(IOException e){}

    }
}
