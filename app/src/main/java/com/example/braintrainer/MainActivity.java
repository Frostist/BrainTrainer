package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Defining UI Elements
    Button goButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumText;
    //Definding my array list fo potential answers
    ArrayList<Integer> answers = new ArrayList<Integer>();







    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);

    }

    public void chooseAnswer(View view) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find views
        sumText = findViewById(R.id.sumText);
        goButton = findViewById(R.id.goButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        //Creates new random number
        Random rand = new Random();
        //setting up the sum
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        //setting up the display text view
        sumText.setText(Integer.toString(a) + " + " + Integer.toString(b));

        int locationOfAnswer = rand.nextInt(4);

        for (int i=0; i<4; i++) {
            if (i == locationOfAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                //This makes sure that any of the random 3 numbers arent the same as the ansewer button
                while (wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
}
