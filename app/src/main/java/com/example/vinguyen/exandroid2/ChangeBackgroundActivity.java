package com.example.vinguyen.exandroid2;

/**
 * Created by ViNguyen on 3/9/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeBackgroundActivity extends AppCompatActivity {
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.img6)
    ImageView img6;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.sampleImg)
    ImageView sampleImg;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chagebackground);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btnSave)
    public void saveBackground(){
        Intent i = new Intent();
        i.putExtra("PICTURE_CODE",code);
        setResult(RESULT_OK,i);
        finish();
    }
    @OnClick({R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6})
    public void setPicture(View v){
        switch (v.getId()){
            case R.id.img1:
                Picasso.with(this).load(R.drawable.shutterstock_130125752_huge).resize(130,130).into(sampleImg);
                code = "1";
                break;
            case R.id.img2:
                Picasso.with(this).load(R.drawable.shutterstock_248651677_supersize).resize(130,130).into(sampleImg);
                code = "2";
                break;
            case R.id.img3:
                Picasso.with(this).load(R.drawable.shutterstock_280897220_huge).resize(130,130).into(sampleImg);
                code = "3";
                break;
            case R.id.img4:
                Picasso.with(this).load(R.drawable.shutterstock_316465280_huge).resize(130,130).into(sampleImg);
                code = "4";
                break;
            case R.id.img5:
                Picasso.with(this).load(R.drawable.shutterstock_333376544_huge).resize(130,130).into(sampleImg);
                code = "5";
                break;
            case R.id.img6:
                Picasso.with(this).load(R.drawable.shutterstock_390660301_huge).resize(130,130).into(sampleImg);
                code = "6";
                break;
        }
    }

}
