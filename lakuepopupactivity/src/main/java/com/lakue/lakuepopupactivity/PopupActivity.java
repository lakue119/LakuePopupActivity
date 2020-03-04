package com.lakue.lakuepopupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;
import static android.os.FileUtils.copy;

public class PopupActivity extends Activity {
    TextView tv_title;
    TextView tv_content;
    Button btn_ok;
    Button btn_left;
    Button btn_right;
    ImageView iv_popup_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //데이터 가져오기
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);

        String title = "";
        String content = "";
        String buttonCenter = "";
        String buttonLeft = "";
        String buttonRight = "";

        if (type == 1) {
            setContentView(R.layout.activity_popup);
            title = intent.getStringExtra("title");
            content = intent.getStringExtra("content");
            buttonCenter = intent.getStringExtra("buttonCenter");

            //UI 객체생성
            tv_title = (TextView) findViewById(R.id.tv_title);
            tv_content = (TextView) findViewById(R.id.tv_content);
            btn_ok = (Button) findViewById(R.id.btn_ok);


            tv_title.setText(title);
            tv_content.setText(content);
            btn_ok.setText(buttonCenter);

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Popup1 Close");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });
        } else if (type == 2) {
            setContentView(R.layout.activity_popup_select);
            title = intent.getStringExtra("title");
            content = intent.getStringExtra("content");
            buttonLeft = intent.getStringExtra("buttonLeft");
            buttonRight = intent.getStringExtra("buttonRight");

            //UI 객체생성
            tv_title = (TextView) findViewById(R.id.tv_title);
            tv_content = (TextView) findViewById(R.id.tv_content);
            btn_left = (Button) findViewById(R.id.btn_left);
            btn_right = (Button) findViewById(R.id.btn_right);

            tv_title.setText(title);
            tv_content.setText(content);
            btn_left.setText(buttonLeft);
            btn_right.setText(buttonRight);

            btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Right Popup Click");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });

            btn_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Left Popup Click");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });
        } else if (type == 3) {
            setContentView(R.layout.activity_popup_error);
            title = intent.getStringExtra("title");
            content = intent.getStringExtra("content");
            buttonRight = intent.getStringExtra("buttonRight");

            //UI 객체생성
            tv_title = (TextView) findViewById(R.id.tv_title);
            tv_content = (TextView) findViewById(R.id.tv_content);
            btn_ok = (Button) findViewById(R.id.btn_ok);


            tv_title.setText(title);
            tv_content.setText(content);
            btn_ok.setText(buttonRight);

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Popup3 Close");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });
        } else if (type == 4) {
            setContentView(R.layout.activity_popup_image);
            title = intent.getStringExtra("title");
            buttonLeft = intent.getStringExtra("buttonLeft");
            buttonRight = intent.getStringExtra("buttonRight");

            //UI 객체생성
            btn_left = (Button) findViewById(R.id.btn_left);
            btn_right = (Button) findViewById(R.id.btn_right);
            iv_popup_image = (ImageView) findViewById(R.id.iv_popup_image);

            btn_left.setText(buttonLeft);
            btn_right.setText(buttonRight);
            new DownloadFilesTask().execute(title);
            //DownloadFullFromUrl(title, iv_popup_image);
            //Glide.with(this).load(title).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(iv_popup_image);

            iv_popup_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Go");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });

            btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Go");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });

            btn_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //데이터 전달하기
                    Intent intent = new Intent();
                    intent.putExtra("result", "Cancel");
                    setResult(RESULT_OK, intent);

                    //액티비티(팝업) 닫기
                    finish();
                }
            });
        }
    }

    private class DownloadFilesTask extends AsyncTask<String,Void,Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            iv_popup_image.setImageBitmap(result);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
