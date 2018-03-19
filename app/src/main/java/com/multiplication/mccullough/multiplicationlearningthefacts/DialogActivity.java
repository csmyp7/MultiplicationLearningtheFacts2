package com.multiplication.mccullough.multiplicationlearningthefacts;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.valueOf;
//this.setFinishOnTouchOutside(false);
public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);


        TextView tv20 = findViewById(R.id.textView20);
        TextView tv21 = findViewById(R.id.textView21);
        TextView tv22 = findViewById(R.id.textView22);

       Bundle extras = getIntent().getExtras();
       Resources res = getResources();
       String mScore = res.getString(R.string.score);
       String mPer = res.getString(R.string.per);


       //int[] fast = res.getIntArray(R.array.answerKey);

        tv20.setText(mScore + (extras.getString("score", ".000") + mPer));

        tv21.setText(extras.getString("sending", "sorry"));

        tv22.setText(extras.getString("testing the pass", "pass failed"));


    }
}
