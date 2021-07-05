package com.example.myschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    //전역변수
    int img_no = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final ImageView img_info = findViewById(R.id.img_info);
        TextView txt_info = findViewById(R.id.txt_info);
        ImageButton btn_back = findViewById(R.id.btn_back);

        //이미지를 클릴하면 다음 이미지로 넘어가게한다.
        img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //다음그림으로 세팅
                img_no = (img_no + 1) % 5;
                switch (img_no) {
                    case 1:
                        img_info.setImageResource(R.drawable.info1); break;
                    case 2:
                        img_info.setImageResource(R.drawable.info2); break;
                    case 3:
                        img_info.setImageResource(R.drawable.info3); break;
                    case 4:
                        img_info.setImageResource(R.drawable.info4); break;
                    case 5:
                        img_info.setImageResource(R.drawable.info5); break;

                }
            }
        });
    }
}
