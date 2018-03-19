package com.multiplication.mccullough.multiplicationlearningthefacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.String.valueOf;

public class PracticeActivity extends AppCompatActivity {

    private Button mDelete, mEqual, m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, mStart;
    private TextView prac_fact1, prac_fact2, prac_ans, prac_sym;
    private Chronometer prac_timer;

    /////////////testing texts
    private TextView h1, h2, h3, h4, h5, h6, h7, h8;

    ArrayList<Integer> p1 = new ArrayList<>();
    ArrayList<Integer> p2 = new ArrayList<>();
    ArrayList<Integer> correct_ans = new ArrayList<>();
    ArrayList<Integer> problem_shuffler = new ArrayList<>();
    ArrayList<Integer> randomsetter = new ArrayList<>();
    ArrayList<String> missed = new ArrayList<>();


    int[] prac_multiple = {7};//}
    int[] prac_multiplicand = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    int prac_qty = 20;
    String user_ans;
    //char[] prac_ch =new char[3];
    int prac_counter =0;
    int prac_correct_counter=0;



    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        practice_main();
    }

    private void practice_main(){
        //user_ans.setLength(3);
        practice_setup();
        practice_start_view();
        //practice_main_view();
        practice_problem_builder();
        practice_problem_constructor();
  //      }
       // h3.setText(valueOf(prac_ans.length()));

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prac_ans.length()>0) {
                    user_ans = prac_ans.getText().toString();
                    user_ans = user_ans.substring(0, user_ans.length() - 1);
                    prac_ans.setText(user_ans);

                }
            }
        });
         mEqual.setOnClickListener(new View.OnClickListener() { //////////////start small
            @Override
            public void onClick(View v) {

                if(prac_ans.length()>=0){//was greater than changed to include 0
                //if(prac_ans.getText() == "") {
                   // prac_ans.setText(-1);
                    practice_ans_check();//should delete user_ans
                }
                //if(prac_ans.length()==0){
                //    prac_miss();
                //}
               //}
                practice_problem_constructor();
                prac_ans.setText("");
            }
        });
 /*  */    mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practice_main_view();
            }
        });
        m0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m0.getText().toString();
                    prac_ans.append(user_ans);
                }

            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans=m1.getText().toString();
                    prac_ans.append(user_ans);
            }}
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m2.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m3.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m4.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m5.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m6.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m7.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m8.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prac_ans.length()< 3) {
                    user_ans = m9.getText().toString();
                    prac_ans.append(user_ans);
                }
            }
        });
  /*  */ }
    private void practice_setup(){
        mDelete=findViewById(R.id.button_practice_delete);
        mEqual=findViewById(R.id.button_practice_equal);
        m0=findViewById(R.id.button_practice_0);
        m1=findViewById(R.id.button_practice_1);
        m2=findViewById(R.id.button_practice_2);
        m3=findViewById(R.id.button_practice_3);
        m4=findViewById(R.id.button_practice_4);
        m5=findViewById(R.id.button_practice_5);
        m6=findViewById(R.id.button_practice_6);
        m7=findViewById(R.id.button_practice_7);
        m8=findViewById(R.id.button_practice_8);
        m9=findViewById(R.id.button_practice_9);
        mStart=findViewById(R.id.button_practice_start);
        prac_fact1=findViewById(R.id.practice_text_1);
        prac_fact2=findViewById(R.id.practice_text_2);
        prac_ans=findViewById(R.id.practice_text_answer);
        prac_sym=findViewById(R.id.practice_text_multiplication_symbol);
        prac_timer=findViewById(R.id.practice_chronometer2);

        //testing text

        h1=findViewById(R.id.pt1);/* block out*/
        h2=findViewById(R.id.pt2);
        h3=findViewById(R.id.pt3);
        h4=findViewById(R.id.pt4);
        h5=findViewById(R.id.pt5);
        h6=findViewById(R.id.pt6);
        h7=findViewById(R.id.pt7);
        h8=findViewById(R.id.pt8);


    }

    private void practice_start_view(){
        mDelete.setVisibility(View.INVISIBLE);
        mEqual.setVisibility(View.INVISIBLE);
        m0.setVisibility(View.INVISIBLE);
        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
        m5.setVisibility(View.INVISIBLE);
        m6.setVisibility(View.INVISIBLE);
        m7.setVisibility(View.INVISIBLE);
        m8.setVisibility(View.INVISIBLE);
        m9.setVisibility(View.INVISIBLE);
        prac_timer.setVisibility(View.INVISIBLE);
        prac_ans.setVisibility(View.INVISIBLE);
        prac_fact1.setVisibility(View.INVISIBLE);
        prac_fact2.setVisibility(View.INVISIBLE);
        prac_sym.setVisibility(View.INVISIBLE);
        mStart.setVisibility(View.VISIBLE);

        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);
        h6.setVisibility(View.INVISIBLE);
        h7.setVisibility(View.INVISIBLE);
        h8.setVisibility(View.INVISIBLE);
    }

    private void practice_main_view(){
        mDelete.setVisibility(View.VISIBLE);
        mEqual.setVisibility(View.VISIBLE);
        m0.setVisibility(View.VISIBLE);
        m1.setVisibility(View.VISIBLE);
        m2.setVisibility(View.VISIBLE);
        m3.setVisibility(View.VISIBLE);
        m4.setVisibility(View.VISIBLE);
        m5.setVisibility(View.VISIBLE);
        m6.setVisibility(View.VISIBLE);
        m7.setVisibility(View.VISIBLE);
        m8.setVisibility(View.VISIBLE);
        m9.setVisibility(View.VISIBLE);
        prac_timer.setVisibility(View.VISIBLE);
        prac_ans.setVisibility(View.VISIBLE);
        prac_fact1.setVisibility(View.VISIBLE);
        //prac_ans.setVisibility(View.VISIBLE);
        //prac_fact1.setVisibility(View.VISIBLE);
        prac_fact2.setVisibility(View.VISIBLE);
        prac_sym.setVisibility(View.VISIBLE);
       // prac_fact2.setVisibility(View.VISIBLE);
       // prac_sym.setVisibility(View.VISIBLE);
        mStart.setVisibility(View.GONE);

        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);
        h6.setVisibility(View.INVISIBLE);
        h7.setVisibility(View.INVISIBLE);
        h8.setVisibility(View.INVISIBLE);
    }

    private void practice_clear_view(){
        mDelete.setVisibility(View.INVISIBLE);
        mEqual.setVisibility(View.INVISIBLE);
        m0.setVisibility(View.INVISIBLE);
        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
        m5.setVisibility(View.INVISIBLE);
        m6.setVisibility(View.INVISIBLE);
        m7.setVisibility(View.INVISIBLE);
        m8.setVisibility(View.INVISIBLE);
        m9.setVisibility(View.INVISIBLE);
        prac_timer.setVisibility(View.INVISIBLE);
        prac_ans.setVisibility(View.INVISIBLE);
        prac_fact1.setVisibility(View.INVISIBLE);
        prac_fact2.setVisibility(View.INVISIBLE);
        prac_sym.setVisibility(View.INVISIBLE);
        mStart.setVisibility(View.INVISIBLE);

        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);
        h6.setVisibility(View.INVISIBLE);
        h7.setVisibility(View.INVISIBLE);
        h8.setVisibility(View.INVISIBLE);

    }


    private void practice_problem_builder(){///////////if more than 1 multiple then what
        if(p1.size()<prac_qty){
            while(p1.size()<prac_qty){
                for(int i =0; i<prac_multiple.length; i++){
                    int temp = prac_multiple[i];
                    p1.add(temp);
                }
            }

        }
        for(int i = 0; i<prac_multiplicand.length; i++){
            int temp = prac_multiplicand[i];
            p2.add(temp);
        }

        if(p2.size()< prac_qty){
            int temp = prac_qty-p2.size();
            for(int i = 0; i<temp; i++){
                p2.add(rand.nextInt(13));
            }
        }

        for (int i = 0; i<prac_qty;i++){
            Integer val1 = p1.get(i);
            Integer val2 = p2.get(i);
            Integer product = val1 * val2;
            correct_ans.add(product);
        }

        for(int i =0; i<prac_qty;i++){
            problem_shuffler.add(i);
        }
        Collections.shuffle(problem_shuffler);
    }
    private void practice_problem_constructor(){
        ///////////////////using counter
        int n = prac_counter;
        int q = problem_shuffler.get(n);
        int x = p1.get(q);
        int y = p2.get(q);

        randomsetter.add(x);
        randomsetter.add(y);
        Collections.shuffle(randomsetter);

        prac_fact1.setText(valueOf(randomsetter.get(0)));
        prac_fact2.setText(valueOf(randomsetter.get(1)));

        //test section
     //   h1.setText(valueOf(prac_counter));
     //   h2.setText(valueOf(problem_shuffler.get(n)));
     //   h3.setText(valueOf(q));
     //   h4.setText(valueOf(x));
     //   h5.setText(valueOf(y));
     //   h6.setText(valueOf(randomsetter.get(0)));
     //   h7.setText(valueOf(randomsetter.get(1)));
        //////////////////////////////end of testing text

        randomsetter.clear();

        ++prac_counter;
    }


    private void practice_ans_check() {
/* not called but blocked*/
        Integer num1 = Integer.valueOf(prac_fact1.getText().toString());
        Integer num2 = Integer.valueOf(prac_fact2.getText().toString());
        Integer num3;
        if(prac_ans.length()>0){
            num3 = Integer.valueOf(prac_ans.getText().toString());//.get())
        }else{
            num3 = 0;
        }

        //if(num3==null){
        //    num3 = -1;
        //}
        int prac_temp_ans = num1 * num2;

     //   h3.setText(valueOf(num2));
     //   h4.setText(valueOf(num3));
     //   h5.setText(valueOf(prac_temp_ans));


        if (prac_temp_ans == num3) {
            ++prac_correct_counter;

       }
        else {missed.add(num1 + " x " + num2 + " = " + prac_temp_ans + '\n');
        }
        if (prac_counter == prac_qty) {
            exit_practice();
        }
     //   h2.setText(valueOf(prac_correct_counter));
    }

    private void score_practice(){

        double mScore;
        double pcorrectCounter = prac_correct_counter;
        double pcounter = prac_counter;

        if(pcorrectCounter==0){
            mScore = 0;
        }else{
            mScore = (pcorrectCounter/pcounter/*prac_qty*/)*100;
        }

        String pScore = valueOf(mScore);
        Intent intent = new Intent(PracticeActivity.this, DialogActivity.class);
        intent.putExtra("score", pScore);

        intent.putExtra("testing the pass", "this is a pass test");

        String mybadstr= missed.toString();/////////////////////never used
        String newmybad = mybadstr.replace("[", " ").replaceAll(",", "")
                .replace("]", "");//.replaceAll(",", "");
        intent.putExtra("sending", newmybad);//.toString());
        startActivity(intent);

        //finish();
    }

    private void exit_practice(){
        practice_clear_view();
        score_practice();
        finish();
    }

    private void prac_miss(){
        int n = prac_counter;
        int num1 = p1.get(n);
        int num2 = p2.get(n);
        int prac_temp_ans = correct_ans.get(n);

        missed.add(num1 + " x " + num2 + " = " + prac_temp_ans + '\n');

        if (prac_counter == prac_qty) {
            exit_practice();
        }
    }
}
