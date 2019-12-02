package gachon.ac.kr.android_project_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class indexActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        //4개의 이미지
        final Integer imageFileID[] = {R.drawable.puppeyfeed,R.drawable.puppeyhaircut,R.drawable.puppeycushion,R.drawable.puppeyshampoo};

        //4개의 이미지버튼 ID 배열
        Integer imageId[] = {R.id.recommand1,R.id.recommand2,R.id.recommand3,R.id.recommand4};

        final String imgName[]={"맛있개! 애견사료 소형 1kg","무섭개! 꽃보다 강아지 이발기","푹신하개! 물방울 꿀잠 방석","깨끗하개! 룰루 뽀송 샴푸 500ml"};

        final String imgPrice[]={"₩10,000","₩16,900","₩68,000","₩5,000"};

        //raw폴더에 txt파일 배열
        final Integer rawExplain[]={R.raw.feedexplain,R.raw.haircutexplain,R.raw.cushionexplain,R.raw.shampooexplain};
        final Integer rawSummary[]={R.raw.feedsummary,R.raw.haircutsummary,R.raw.cushionsummary,R.raw.shampoosummary};

        ImageView imageView1 = (ImageView)findViewById(R.id.recommand1);
        ImageView imageView2 = (ImageView)findViewById(R.id.recommand2);
        ImageView imageView3 = (ImageView)findViewById(R.id.recommand3);
        ImageView imageView4 = (ImageView)findViewById(R.id.recommand4);


        //첫번째 이미지뷰 적용
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //사진, 상품이름, 가격, 상품설명, 상품특징 보냄
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("ImageFile",imageFileID[0]);
                intent.putExtra("ImageName",imgName[0]);
                intent.putExtra("ImagePrice",imgPrice[0]);
                intent.putExtra("rawExplain",rawExplain[0]);
                intent.putExtra("rawSummary",rawSummary[0]);

                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("ImageFile",imageFileID[1]);
                intent.putExtra("ImageName",imgName[1]);
                intent.putExtra("ImagePrice",imgPrice[1]);
                intent.putExtra("rawExplain",rawExplain[1]);
                intent.putExtra("rawSummary",rawSummary[1]);

                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("ImageFile",imageFileID[2]);
                intent.putExtra("ImageName",imgName[2]);
                intent.putExtra("ImagePrice",imgPrice[2]);
                intent.putExtra("rawExplain",rawExplain[2]);
                intent.putExtra("rawSummary",rawSummary[2]);

                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("ImageFile",imageFileID[3]);
                intent.putExtra("ImageName",imgName[3]);
                intent.putExtra("ImagePrice",imgPrice[3]);
                intent.putExtra("rawExplain",rawExplain[3]);
                intent.putExtra("rawSummary",rawSummary[3]);

                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1,menu);


        return true;
    }
}
