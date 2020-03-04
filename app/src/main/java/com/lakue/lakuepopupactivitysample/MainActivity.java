package com.lakue.lakuepopupactivitysample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lakue.lakuepopupactivity.PopupActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_show_popup1;
    Button btn_show_popup2;
    Button btn_show_popup3;
    Button btn_show_popup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show_popup1 = findViewById(R.id.btn_show_popup1);
        btn_show_popup2 = findViewById(R.id.btn_show_popup2);
        btn_show_popup3 = findViewById(R.id.btn_show_popup3);
        btn_show_popup4 = findViewById(R.id.btn_show_popup4);

        btn_show_popup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra("title", "공지사항");
                intent.putExtra("content", "Popup Activity was made by Lakue");
                intent.putExtra("buttonCenter", "종료");
                startActivityForResult(intent, 1);
            }
        });

        btn_show_popup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", 2);
                intent.putExtra("title", "공지사항");
                intent.putExtra("content", "Did Lakue make a Popup Activity?");
                intent.putExtra("buttonLeft", "예");
                intent.putExtra("buttonRight", "아니오");
                startActivityForResult(intent, 1);
            }
        });

        btn_show_popup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", 3);
                intent.putExtra("title", "Error");
                intent.putExtra("content", "Error Message");
                intent.putExtra("buttonRight", "닫기");
                startActivityForResult(intent, 1);
            }
        });

        btn_show_popup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", 4);
                intent.putExtra("title", "https://taegon.kim/wp-content/uploads/2018/05/image-5.png");
                intent.putExtra("buttonLeft", "종료");
                intent.putExtra("buttonRight", "바로가기");
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //데이터 받기
            if(requestCode == 1){
                String result = data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
            if(requestCode == 2){
                String result = data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
            if(requestCode == 3){
                String result = data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
            if(requestCode == 3){
                String result = data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
