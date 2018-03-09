package com.example.vinguyen.exandroid2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textName) TextView tvResult;
    @BindView(R.id.background)
    ImageView background;
    @BindView(R.id.btnChangeTitle) Button btnChangeText;
    @BindView(R.id.btnChangeBackground) Button btnChangeBackground;
    private static final int REQUEST_CODE_COLOR = 2809;
    private static final int REQUEST_CODE_BACKGROUND = 1106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnChangeBackground)
    public void startActivityBackground(){
        Intent i = new Intent(this,ChangeBackgroundActivity.class);
        startActivityForResult(i,REQUEST_CODE_BACKGROUND);

    }

    @OnClick(R.id.btnChangeTitle)
    public void startActivityColor(){
        Intent i = new Intent(this,ChangeTitleActivity.class);
        startActivityForResult(i,REQUEST_CODE_COLOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_COLOR){
            if (resultCode == RESULT_OK){
                String txt = data.getStringExtra("TEXT");
                int color = data.getIntExtra("COLOR",R.color.blue);
                Log.d("TEXT", txt);
                Log.d("COLOR", String.valueOf(color));
                changeText(txt,color);
            }
        }
        else if (requestCode == REQUEST_CODE_BACKGROUND){
            if (resultCode == RESULT_OK){
                String code = data.getStringExtra("PICTURE_CODE");
                Log.d("PICTURE_CODE",code);
                changeBackground(code);
            }
        }

    }

    private void changeBackground(String code) {
        switch (code){
            case "1":
                Picasso.with(this).load(R.drawable.shutterstock_130125752_huge).into(background);
                break;
            case "2":
                Picasso.with(this).load(R.drawable.shutterstock_248651677_supersize).into(background);
                break;
            case "3":
                Picasso.with(this).load(R.drawable.shutterstock_280897220_huge).into(background);
                break;
            case "4":
                Picasso.with(this).load(R.drawable.shutterstock_316465280_huge).into(background);
                break;
            case "5":
                Picasso.with(this).load(R.drawable.shutterstock_333376544_huge).into(background);
                break;
            case "6":
                Picasso.with(this).load(R.drawable.shutterstock_390660301_huge).into(background);
                break;
        }

    }

    private void changeText(String txt, int color) {
        tvResult.setText(txt);
        tvResult.setTextColor(ContextCompat.getColor(this, color));
    }
}
