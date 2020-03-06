package com.lakue.lakuepopupactivitysample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lakue.lakuepopupactivity.PopupActivity;
import com.lakue.lakuepopupactivity.PopupGravity;
import com.lakue.lakuepopupactivity.PopupResult;
import com.lakue.lakuepopupactivity.PopupType;

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
                intent.putExtra("type", PopupType.NORMAL);
                intent.putExtra("gravity", PopupGravity.CENTER);
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
                intent.putExtra("type", PopupType.SELECT);
                intent.putExtra("gravity", PopupGravity.LEFT);
                intent.putExtra("title", "공지사항");
                intent.putExtra("content", "Did Lakue make a Popup Activity?");
                intent.putExtra("buttonLeft", "예");
                intent.putExtra("buttonRight", "아니오");
                startActivityForResult(intent, 2);
            }
        });

        btn_show_popup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.ERROR);
                intent.putExtra("gravity", PopupGravity.RIGHT);
                intent.putExtra("title", "ERROR");
                intent.putExtra("content", "ERROR Message");
                intent.putExtra("buttonRight", "닫기");
                startActivityForResult(intent, 3);
            }
        });

        btn_show_popup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.IMAGE);
                intent.putExtra("title", "https://media.istockphoto.com/photos/night-empty-road-with-modern-led-street-lights-entrance-to-a-small-picture-id1072163884?k=6&m=1072163884&s=612x612&w=0&h=rMlTtkKwKTbj36JigRzicznv98jaCvwnuZGQN4_CNZQ=");
                intent.putExtra("buttonLeft", "종료");
                intent.putExtra("buttonRight", "바로가기");
                startActivityForResult(intent, 4);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //데이터 받기
            if(requestCode == 1){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.CENTER){
                    // 작성 코드
                    Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();
                }
            }
            if(requestCode == 2){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.LEFT){
                    // 작성 코드
                    Toast.makeText(this, "LEFT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.RIGHT){
                    // 작성 코드
                    Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show();

                }
            }
            if(requestCode == 3){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.CENTER){
                    // 작성 코드
                    Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();

                }
            }
            if(requestCode == 4){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.LEFT){
                    // 작성 코드
                    Toast.makeText(this, "LEFT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.RIGHT){
                    // 작성 코드
                    Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.IMAGE){
                    // 작성 코드
                    Toast.makeText(this, "IMAGE", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}
