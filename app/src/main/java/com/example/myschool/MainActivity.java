package com.example.myschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_info, btn_time, btn_call;
    EditText edit_userid, edit_passwd;
    CheckBox chk_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //반드시 setContentVied 아래에서 작업
        //xml에 지정된 view의 Java 객체를 연결

        edit_userid = findViewById(R.id.edit_userid);
        edit_passwd = findViewById(R.id.edit_passwd);
        btn_login = findViewById(R.id.btn_login);
        btn_info = findViewById(R.id.btn_info);
        btn_time = findViewById(R.id.btn_time);
        btn_call = findViewById(R.id.btn_call);
        chk_agree = findViewById(R.id.chk_agree);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = edit_userid.getText().toString();
                String passwd = edit_passwd.getText().toString();

                //개인정보 동의 여부 확인

                if(chk_agree.isChecked() == false){
                    myToast("개인정보 수집에 동의해주세요");
                    return;
                }

                if(userid.length() < 5) {//id의 길이가 5이상인지
                    myToast("아이디는 5글자 이상입니다.");
                }
                else if(passwd.length() < 6) {// passwd 6자리 이상인지
                    myToast("비밀번호는 6글자 이상입니다.");
                }else{
                    if(userid.equals("30601") && passwd.equals("123456")){
                        myToast(userid + "님 환영합니다.");
                    }
                    else{
                        myToast("아이디와 패스워드를 확인해주세요");
                    }
                }
                //id는 학번 password는 123456이다 맞으면Ok, 아니면 잘못된아이다 pass라고
            }
        });

        //학과소개 버튼 클릭
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myToast("학과소개 화면이동");
                //명시적 인텐트의 예
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }

    void myToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
