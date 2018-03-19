package com.multiplication.mccullough.multiplicationlearningthefacts;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.lang.String.valueOf;

//this.setFinishOnTouchOutside(false);
public class FlashCardActivity extends AppCompatActivity {

    private Button answer, next, prev;

    private ImageView back, cover, front;

    private TextView tv1, tv2, tv3, tv4, tv5;

    private TextView m1;
    private TextView m2;
    private TextView m3, m4;


    ArrayList<Integer> factor1_arr = new ArrayList<>();//future based on settings,future array based on settings
    ArrayList<Integer> factor2_arr = new ArrayList<>();//
    ArrayList<Integer> answer_arr = new ArrayList<>();

    Random rand = new Random();

    int[] factor1_nums = {7};//}
    int[] factor2_nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    int qty = 20;

    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);
        flashCard_interface();
    }

    private void flashCard_interface() {
        flashcard_set();
        flashcard_cover();
        flashcard_factors();
        flashcards(0);

        cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcard_problem();
            }
        });
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcard_solution();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcard_problem();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcard_problem(); // reset to card front
                int nextFac = n;
                if(++nextFac<qty){
                    flashcards(++n);
                }

              //  }
              //  m4.setText(valueOf(n));
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcard_problem();//resets to card front
                int prevFac = n;
                if(--prevFac>-1){
                    flashcards(--n);
                }
            }
        });

    }

    private void flashcard_set() {
        answer = findViewById(R.id.flashcard_button_answer);
        next = findViewById(R.id.flashcard_button_next);
        prev = findViewById(R.id.flashcard_button_previous);

        cover = findViewById(R.id.flashcard_image_cover);
        back = findViewById(R.id.flashcard_image_back);
        front = findViewById(R.id.flashcard_image_front);

        tv1 = findViewById(R.id.flashcard_text_factor1);
        tv2 = findViewById(R.id.flashcard_text_factor2);
        tv3 = findViewById(R.id.flashcard_text_answer);
        tv4 = findViewById(R.id.flashcard_text_multiplication_symbol);
        tv5 = findViewById(R.id.flashcard_text_equal_symbol);

        m1 = findViewById(R.id.test1);
        m2= findViewById(R.id.test2);
        m3 = findViewById(R.id.test3);
        m4 = findViewById(R.id.test4);
    }

    private void flashcard_cover() {
        answer.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        prev.setVisibility(View.INVISIBLE);

        back.setVisibility(View.INVISIBLE);
        cover.setVisibility(View.VISIBLE);/////////////only time visible
        front.setVisibility(View.INVISIBLE);

        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);

        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
    }

    private void flashcard_problem() {                        //front is visible
        answer.setVisibility(View.VISIBLE);//all buttons visible
        next.setVisibility(View.VISIBLE);
        prev.setVisibility(View.VISIBLE);

        back.setVisibility(View.INVISIBLE);//
        cover.setVisibility(View.INVISIBLE);//no longer to be visible
        front.setVisibility(View.VISIBLE);// only visible during proble

        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.INVISIBLE);//only visible on flashcard_solution call
        tv4.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.VISIBLE);

        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
    }

    private void flashcard_solution() {                       //back is visible
        answer.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        prev.setVisibility(View.VISIBLE);

        back.setVisibility(View.VISIBLE);
        cover.setVisibility(View.INVISIBLE);/////////////only time visible
        front.setVisibility(View.INVISIBLE);

        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);

        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
    }

    private void flashcard_factors() {

        if(factor1_arr.size()<qty){
            while(factor1_arr.size()<qty){
                for(int i =0; i<factor1_nums.length; i++){
                int temp = factor1_nums[i];
                factor1_arr.add(temp);
                }
            }

        }
        for(int i = 0; i<factor2_nums.length; i++){
            int temp = factor2_nums[i];
            factor2_arr.add(temp);
        }

        if(factor2_arr.size()< qty){
            int temp = qty-factor2_arr.size();
            for(int i = 0; i<temp; i++){
                factor2_arr.add(rand.nextInt(13));
            }
        }

  //      m1.setText(valueOf(factor1_arr));
  //      m2.setText(valueOf(factor2_arr));
  //      m3.setText(valueOf(factor1_arr.size()));


        ////////////////////////////////////////////////////////////////////////////////////////////

        for(int i=0;i<qty;i++){
            Integer t1 = factor1_arr.get(i);
            Integer t2 = factor2_arr.get(i);
            Integer t3 = t1 * t2;
            answer_arr.add(t3);

        //m4.setText(valueOf(n));
        }
    }

    private void flashcards(int n) {

        tv1.setText(valueOf(factor1_arr.get(n)));
        tv2.setText(valueOf(factor2_arr.get(n)));
        tv3.setText(valueOf(answer_arr.get(n)));

    }

 //   private void prevFlashCard(){

 //   }

}
