package com.example.a03activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub); //서브 레이아웃

        edit = (EditText) findViewById(R.id.edit); //edit 정보를 가져온다.
        Button button_ok = (Button) findViewById(R.id.button_ok); //button_ok 값을 받아 버튼 생성
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //메인 액티비티로 결과를 보낸다.
                Intent intent = new Intent(); //인텐트 객체 생성
                intent.putExtra("INPUT_TEXT", edit.getText().toString());
                //INPUT_TEXT에 text 값을 받아와 값을 저장한다.
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel); //button_cancel 값을 받아 버튼 생성
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭하면
                setResult(RESULT_CANCELED); //종료한다.
                finish();
            }
        });
    }
}
