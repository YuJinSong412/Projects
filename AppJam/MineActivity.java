package org.techtown.appjam;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;

public class MineActivity extends AppCompatActivity implements View.OnClickListener{
    int a[] = new int[81];
    int a1[] = new int [81];
    int b[] = new int[81];
    Button b1[] = new Button[81];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onClick(View v) {
        int msg = Integer.parseInt(v.getTag().toString());
        int tag = Integer.parseInt(v.getTag().toString());
        Button button = (Button)findViewById(v.getId());


        Random rand = new Random();
        int a = rand.nextInt(9);

        //처음에는 "" -> char 형
        String text = button.getText().toString();
        if(text.equals("")){
            button.setText("1");
        }

        else {
            button.setText(String.valueOf((Integer.parseInt(text) == 9) ? 1 : Integer.parseInt(text) + 1));
        }

        b[msg-1] = Integer.parseInt(button.getText().toString());
        b[6]=5;b[12]=1;b[16]=4;b[18]=5;b[24]=2;b[29]=1;b[30]=3;b[31]=9;b[35]=8;b[36]=3;b[40]=8;b[44]=4;b[49]=4;b[50]=1;b[51]=7;
        b[56]=8;b[62]=9;b[64]=5;b[68]=3;b[71]=1;b[74]=4;b[75]=6;
    }

    //스도쿠가 정상인지 비정상인지 판단.
    public void Result(View view) {
        //int count = 0;
        int check=0;
        int count=0;
        //가로 부분에 숫자 겹치면 ㅇㅇ
        for(int k=0; k<81;k++){
            if(k%9 == 0){
                count = 0;
            }count += b[k];
            if(k%9 == 8){
                if(count != 45){
                    check ++;
                }
            }
        }
        //세로 부분 합치면
        count = 0;
        int m=0;
        int ck=72;
        for(int k=0; k<90; k+=9){
            String msg = String.valueOf(k);
            count += b[k];
            if(k == ck){
                k = ++m - 9;
                if(count != 45){
                    check ++;
                }
                count =0;
                ck++;

            }
            if(m>8){
                break;
            }

            Log.d(" k : ",msg);

        }
        //사각형 부분 26 53 80
        int sum1=0, sum2=0, sum3=0;
        for(int k=0; k<81; k++){
            if((k%9)/3 == 0){
                sum1 += b[k];
            }else if((k%9)/3 == 1){
                sum2 += b[k];
            }else{
                sum3 += b[k];
            }
            if(k%27 == 26){
                if(sum1 != 45 || sum2 != 45 || sum3 != 45){
                    check++;
                }
                sum1 = sum2 = sum3 = 0;
            }

        }
        if(check != 0){
            Toast.makeText(getApplicationContext(),"오답입니다.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"정답입니다.",Toast.LENGTH_SHORT).show();
        }
    }

  /*  public void CreateSudoku(View v) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        arr = shuffle(arr);
        Button button;
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
        //가로로저장
        for(int k = 0 ; k<27 ; k++){

            if((k%9)/3 == 0){
                a[k]=arr[k%9];
            }else if((k%9)/3 == 1){
                a[k]=arr[k%9];
            }else{
                a[k]=arr[k%9];
            }
            if((k%9)/3 == 8){
                for(int p=0;p<3;p++){
                    arr = post(arr);
                }
            }
        }
        //세로로 저장
        int temporate[] = new int[3];
        int q=0,r=0;
        for(int k=0; k<81; k++){

            temporate[q] = a[k];
            q++;
            int tag ;
            if(k%3 == 2){
                temporate = post(temporate);
                for(int p=0; p<3; p++) {
                    String a =v.getTag().toString();
                    ll.findViewWithTag(String.valueOf(r));
                    button = (Button)findViewById(ll.getId());
                    a1[r] =temporate[p];
                    button.setText(a1[r]);
                    r++;
                }
                q = 0;
            }
        }
    }*/

   /* private static int[] post(int[] arr) {
        int temp;
        temp = arr[8];
        for(int k=8;k>0;k--){
            arr[k]=arr[k-1];
        }arr[0] = temp;

        return arr;
    }

    public static int[] shuffle(int[] arr){
        for(int x=0;x<arr.length;x++){
            int i = (int)(Math.random()*arr.length);
            int j = (int)(Math.random()*arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr;
    }*/

}