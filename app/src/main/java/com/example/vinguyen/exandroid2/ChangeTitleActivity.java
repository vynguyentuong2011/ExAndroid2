package com.example.vinguyen.exandroid2;

/**
 * Created by ViNguyen on 3/9/18.
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class ChangeTitleActivity extends AppCompatActivity {
    Button btnSave;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    EditText editText;
    View sampleImg;
    private int colorSend = R.color.colorPrimaryDark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changetitle);
        connectToView();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().equals("") || colorSend == R.color.colorPrimaryDark){
                    notification();
                }
                else{
                    Intent i = new Intent();
                    i.putExtra("TEXT",editText.getText().toString());
                    i.putExtra("COLOR",colorSend);
                    setResult(RESULT_OK,i);
                    finish();
                }

            }
        });

        img1.setOnClickListener(onImageClick);
        img2.setOnClickListener(onImageClick);
        img3.setOnClickListener(onImageClick);
        img4.setOnClickListener(onImageClick);
        img5.setOnClickListener(onImageClick);
        img6.setOnClickListener(onImageClick);
    }

    private void notification() {
        Toast.makeText(this,"You haven't entered any text or chosen any color! " +
                "Check again",Toast.LENGTH_SHORT).show();

    }

    private View.OnClickListener onImageClick = new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.img1:
                    sampleImg.setBackgroundResource(R.color.pink);
                    colorSend = R.color.pink;
                    break;
                case R.id.img2:
                    sampleImg.setBackgroundResource(R.color.purple);
                    colorSend = R.color.purple;
                    break;
                case R.id.img3:
                    sampleImg.setBackgroundResource(R.color.indigo);
                    colorSend = R.color.indigo;
                    break;
                case R.id.img4:
                    sampleImg.setBackgroundResource(R.color.blue);
                    colorSend = R.color.blue;
                    break;
                case R.id.img5:
                    sampleImg.setBackgroundResource(R.color.teal);
                    colorSend = R.color.teal;
                    break;
                case R.id.img6:
                    sampleImg.setBackgroundResource(R.color.green);
                    colorSend = R.color.green;
                    break;

            }
        }
    };
    private void connectToView() {
        btnSave = findViewById(R.id.btnSave);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        editText = findViewById(R.id.editText);
        sampleImg = findViewById(R.id.sampleImg);
    }
}
