package com.example.a03activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button); //버튼 생성
        text = (TextView) findViewById(R.id.text); //텍스트뷰 생성
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argO) { //버튼이 눌렀을때
                Intent in = new Intent(MainActivity.this, SubActivity.class); //서브액티비티 선언
                startActivityForResult(in, GET_STRING); //서브액티비티 실행
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int reaultCode, Intent data){ //액티비티로부터 결과를 받는다.
        if (requestCode == GET_STRING){
            if(reaultCode == RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }
}
