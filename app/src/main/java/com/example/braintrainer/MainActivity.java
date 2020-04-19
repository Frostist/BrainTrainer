package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = "Project";
    //Defining UI Elements
    //Buttons
    Button goButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    //TextViews
    TextView sumText;
    TextView timeText;
    TextView resultText;
    TextView scoreText;
    //Layouts
    ConstraintLayout gameLayout;
    //Defining Ints
    int locationOfAnswer;
    int wrongAnswer;
    int a;
    int b;
    int score = 0;
    int numberOfQ = 0;
    //Definding my array list fo potential answers
    ArrayList<Integer> answers = new ArrayList<Integer>();


    //starts the
    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        score = 0;
        numberOfQ = 0;
        scoreText.setText(score + "/" + numberOfQ);
        newQuestion();
        timeText.setText("30s");
        new CountDownTimer(5100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultText.setText("Done!");
                goButton.setVisibility(View.VISIBLE);
                gameLayout.setVisibility(View.INVISIBLE);
            }
        }.start();

    }

    public void chooseAnswer(View view) {
        Log.w(TAG,"Button Pushed:" + view.getTag().toString());
        //this is comparing the tag of the button to the value of the button to the value of the correct answer.
        if (Integer.toString(locationOfAnswer).equals(view.getTag().toString())) {
            Log.w(TAG, "Correct Answer");
            resultText.setText("Correct!");
            score++;
        } else {
            Log.w(TAG, "Incorrect Answer");
            resultText.setText("Wrong! :(");
        }
        numberOfQ++;
        scoreText.setText(score + "/" + numberOfQ);
        newQuestion();
    }

    public void newQuestion() {

        //Creates new random number
        Random rand = new Random();
        //setting up the sum
        a = rand.nextInt(21);
        b = rand.nextInt(21);
        //setting up the display text view
        sumText.setText(a + " + " + b);
        //is defining that the answer is going to be set to one fo the 4 buttons
        locationOfAnswer = rand.nextInt(4);
        //clears the answers arry list to make sure that the tags don't break
        answers.clear();

        for (int i=0; i<4; i++) {
            if (i == locationOfAnswer) {
                answers.add(a + b);
            } else {
                wrongAnswer = rand.nextInt(41);

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find views
        //Texts Defined
        sumText = findViewById(R.id.sumText);
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        resultText = findViewById(R.id.resultText);
        //Buttons Defined
        goButton = findViewById(R.id.goButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        //Constraint
        gameLayout = findViewById(R.id.gameLayout);
        gameLayout.setVisibility(View.INVISIBLE);

       newQuestion();
    }
}
