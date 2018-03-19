package com.multiplication.mccullough.multiplicationlearningthefacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.String.valueOf;

public class BeginnerActivity extends AppCompatActivity {

    int numOfProb = 20;//should be a variable passed from settings
   // int kill=5;//?? Does this have a real function
    Random rand = new Random();//BeginnnerActivity Random number generator
    //Future factor1 based on settings if more than one selected make random
    //Future factor2 based on settings group of numbers selected at Random Default 1-12

    //testbuttons
//    private Button killDialog;//////////////////////////////////////
//    private TextView killCounts;////////////////////////////////////

    private Button an1, an2, an3, an4, next, see;//condensed Delete following and comment
   // private Button an2;
   // private Button an3;
    //private Button an4;
   // Button[] mybut = {an1, an2, an3, an4, next, see};

   //private Button see;

    //private Button next;

//    private TextView count;
//    private TextView cCount;
    private TextView tv1,tv2,tv3;//,tv4;

    int counter=0;//////////
    int correctCounter=0;////////correctCounter/numOfProb
    //   int killcount=0;

    ArrayList<String> badstr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        mainInterface();
    }
    private void mainInterface(){
        hidder();
        seethis();

        solText();

//        Intent intent = new Intent(BeginnerActivity.this, DialogActivity.class);
//        if(killcount == kill){
 //           startActivity(intent);
 //       }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ++killcount;
                solText();
            }
        });
        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //               ++killcount;
                checkAnswer(an1.getText().toString());
            }
        });
        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(an2.getText().toString());
//                ++killcount;
            }
        });
        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(an3.getText().toString());
 //               ++killcount;
            }
        });
        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //               ++killcount;
                checkAnswer(an4.getText().toString());
            }
        });
//////////////////////////////////////////////////////////////////////////////////////////
        //Kill button
 //       killDialog.setOnClickListener(new View.OnClickListener() {
 //           @Override
 //           public void onClick(View v) {
//                Intent intent = new Intent(BeginnerActivity.this, DialogActivity.class);
 //               startActivity(intent);
 //           }
 //       });
////////////////////////////////////////////////////////////////////////////////////////////
    }
    private void hidder() {
        an1 = findViewById(R.id.button_answer1);
        an1.setVisibility(View.INVISIBLE);

        an2 = findViewById(R.id.button_answer2);
        an2.setVisibility(View.INVISIBLE);

        an3 = findViewById(R.id.button_answer3);
        an3.setVisibility(View.INVISIBLE);

        an4 = findViewById(R.id.button_answer4);
        an4.setVisibility(View.INVISIBLE);

        next = findViewById(R.id.button_next);
        next.setVisibility(View.INVISIBLE);

        tv1 = findViewById(R.id.textFactor1);
        tv1.setVisibility(View.INVISIBLE);

        tv2 = findViewById(R.id.textFactor2);
        tv2.setVisibility(View.INVISIBLE);

        tv3 = findViewById(R.id.text_x);
        tv3.setVisibility(View.INVISIBLE);

        //tv4 = findViewById(R.id.textView16);
        //tv4.setVisibility(View.INVISIBLE);

        see = findViewById(R.id.button_start);
        see.setVisibility(View.VISIBLE);

//        count = findViewById(R.id.textView);
//        cCount= findViewById(R.id.textView17);
 //       cCount.setVisibility(View.INVISIBLE);

//        killDialog=findViewById(R.id.button7);
//        killCounts=findViewById(R.id.textView18);
    }

    private void seethis(){
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                an1.setVisibility(View.VISIBLE);
                an2.setVisibility(View.VISIBLE);
                an3.setVisibility(View.VISIBLE);
                an4.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
               // tv4.setVisibility(View.VISIBLE);//may need for equal sign
 //               cCount.setVisibility(View.VISIBLE);
                see.setVisibility(View.GONE);
            }
        });
    }

    private void clearScreen(){
        an1.setVisibility(View.INVISIBLE);
        an2.setVisibility(View.INVISIBLE);
        an3.setVisibility(View.INVISIBLE);
        an4.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        //tv4.setVisibility(View.INVISIBLE);
//        count.setVisibility(View.INVISIBLE);
//        cCount.setVisibility(View.INVISIBLE);
        see.setVisibility(View.INVISIBLE);
//        killDialog.setVisibility(View.INVISIBLE);
//        killCounts.setVisibility(View.INVISIBLE);
    }

    private void solText(){
        int val1 = 5;  /////////////////////  changing variable
        int val2 = rand.nextInt(13);//random variable

        int sel1, sel2, sel3, sel4;  //

        sel1 = val1 * val2;
        sel2 = val1 * val2 + 1;
        sel3 = val1 - 1;
        sel4 = val1 + val2;

        ArrayList<String> choice = new ArrayList<>();
        ArrayList<Integer> factors = new ArrayList<>();

        choice.add(valueOf(sel1));
        choice.add(valueOf(sel2));
        choice.add(valueOf(sel3));
        choice.add(valueOf(sel4));

        Collections.shuffle(choice);

        String bud1 = choice.get(0);
        String bud2 = choice.get(1);
        String bud3 = choice.get(2);
        String bud4 = choice.get(3);

        an1.setText(bud1);
        an2.setText(bud2);
        an3.setText(bud3);
        an4.setText(bud4);

        factors.add(val1);
        factors.add(val2);
        Collections.shuffle(factors);

        tv1.setText(valueOf(factors.get(0)));
        tv2.setText(valueOf(factors.get(1)));

        ++counter;
//        count.setText(valueOf(counter));
 //       killCounts.setText(valueOf(killcount));
    }

    private void checkAnswer(String answer){
        Integer num1 = Integer.valueOf(tv1.getText().toString());
        int num2 = Integer.parseInt(tv2.getText().toString());

        int mAnswer = num1*num2;
        int Ranswer = Integer.parseInt(answer);

        if(Ranswer==mAnswer){
            ++correctCounter;
  //          cCount.setText(valueOf(correctCounter));
        }else{
            //incorrect.add(num1);//worked
            //incorrect.add(num2);//worked
            badstr.add(num1+" x "+ num2+ " = "+ mAnswer +'\n');
        }

        if(counter == numOfProb){       ////////change 5 to integer variable
            ////////call kill
            exitActivity();
        }
        solText();
    }

    private void exitActivity(){
        clearScreen();
        score();
        finish();
    }

    private void score(){
        double mScore;
        double pcorrectCounter = correctCounter;
        double pcounter = counter;

        if(correctCounter==0){
            mScore = 0;
        }else{
            mScore = (pcorrectCounter/pcounter)*100;
        }

     //   String score = getResources().getString(R.string.score);

        String pScore = valueOf(mScore);
        Intent intent = new Intent(BeginnerActivity.this, DialogActivity.class);
        intent.putExtra("score", pScore);

        intent.putExtra("testing the pass", "this is a pass test");

        String mybadstr= badstr.toString();/////////////////////never used
        String newmybad = mybadstr.replace("[", " ").replaceAll(",", "")
                .replace("]", "");//.replaceAll(",", "");
        intent.putExtra("sending", newmybad);//.toString());
        startActivity(intent);
    }

   // private void missed() {

   // }
}
