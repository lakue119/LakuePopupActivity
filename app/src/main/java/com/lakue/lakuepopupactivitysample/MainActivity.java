package com.lakue.lakuepopupactivitysample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lakue.lakuepopupactivity.PopupActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_show_popup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show_popup1 = findViewById(R.id.btn_show_popup1);

        btn_show_popup1.setOnClickListener(new View.OnClickListener() {
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
}
