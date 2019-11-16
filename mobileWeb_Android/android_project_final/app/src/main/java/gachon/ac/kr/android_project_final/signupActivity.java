package gachon.ac.kr.android_project_final;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtName,edtEmail,edtPassword;
    Button btnAgreeGo,soso;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        edtName=(EditText)findViewById(R.id.edtName1);
        edtEmail=(EditText)findViewById(R.id.edtEmail1);
        edtPassword=(EditText)findViewById(R.id.edtPassword1);
        btnAgreeGo =(Button)findViewById(R.id.btnAgreeGo);

        soso=(Button)findViewById(R.id.soso1);


        //디비 초기화
        myHelper = new myDBHelper(this);
        soso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close();
            }
        });

        //회원가입 완료 후 index 화면 버튼
        btnAgreeGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO memberTBL VALUES ( '"
                        + edtName.getText().toString() + "' , '"
                        + edtEmail.getText().toString() + "' , '"
                        + edtPassword.getText().toString() + "' );");
                sqlDB.close();

                Toast.makeText(getApplicationContext(), edtName.getText().toString()+"님♥ 회원가입이 되었습니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //SQLiteOpenHelper 클래스에서 상속
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "memberDB", null, 1);
        }

        @Override  //테이블을 생성하는 기능
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE memberTBL ( mName CHAR(20), email CHAR(15), password CHAR(15));");
        }

        @Override   //테이블을 삭제한 후 다시 생성
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS memberTBL");
            onCreate(db);
        }
    }


}
