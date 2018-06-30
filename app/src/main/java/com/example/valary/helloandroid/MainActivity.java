package com.example.valary.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showScore(View view) {

        Button next = findViewById(R.id.score_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(nextScreen);
            }
        });
        EditText answer_one = findViewById(R.id.answer_one);
        String firstAnswerText = String.valueOf(answer_one.getText());
        boolean firstAnswer = false;
        if (firstAnswerText.equals("adenine, thymine, cytosine")){
            firstAnswer = true;}

        //checks the answer for question two.
        EditText answer_two = findViewById(R.id.answer_two);
        String secondAnswerText = String.valueOf(answer_two.getText());
        boolean secondAnswer = false;
        if (secondAnswerText.equals("Where cellular respiration occurs, found in muscle cells, cardiac cells, root cells")){
            secondAnswer = true;
        }

         // checks if the answer given by the user matches with thirdAnswer
        EditText answer_three = findViewById(R.id.answer_three);
        String thirdAnswerText = String.valueOf(answer_three.getText());
        boolean thirdAnswer = false;
        if (thirdAnswerText.equals("Vincent Van Gogh")) {
            thirdAnswer = true;
        }

        //Ensures only one radio button is checked
        RadioButton transpiration = findViewById(R.id.transpiration);
        boolean fourthAnswer = transpiration.isChecked();


         // Checks if the user has check the first box

        CheckBox Cooling = findViewById(R.id.cool);
        boolean fifthAnswerCool = Cooling.isChecked();


         //Checks if the user has checked the second box
        CheckBox MineralSalts = findViewById(R.id.mineral);
        boolean fifthAnswerSalts = MineralSalts.isChecked();


         // Checks if the use has clicked on the third box
        CheckBox water = findViewById(R.id.water);
        boolean fifthAnswerWater = water.isChecked();




        //Remaining for the six answer right question  the method to check the answer should be here

        int score = calculateScore(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, fifthAnswerCool, fifthAnswerSalts, fifthAnswerWater);
        displayScore(score);

    }

    /**
     *
     * @param firstAnswer whether the user has answered the first question
     * @param secondAnswer if user has answered the second question
     * @param thirdAnswer if user has answered the third question
     * @param fourthAnswer if user has answered the fourth question
     * @param fifthAnswerCool if user has answered the fifth question
     * @param fifthAnswerSalts if user has answered the fifth question
     * @param  fifthAnswerWater if user has answered the fifth question
     * @return total score
     */

    public int calculateScore(boolean firstAnswer, boolean secondAnswer, boolean thirdAnswer, boolean fourthAnswer, boolean fifthAnswerCool, boolean fifthAnswerSalts, boolean fifthAnswerWater ){
        int score = 0;
        if (firstAnswer){
            score = score + 2;
        }
        if (secondAnswer){
            score = score + 2;
        }
        if (thirdAnswer){
            score = score + 2;
        }
        if (fourthAnswer){
            score = score + 2;
        }
        if (fifthAnswerCool && fifthAnswerSalts && fifthAnswerWater){
            score = score + 2;
        }
        return score;

    }
    public void  displayScore(int score){
        if (score == 0){
            Toast.makeText(this, "You scored 0 points, you can do better than this! try again", Toast.LENGTH_LONG).show();
        }
        else if (score < 6){
            Toast.makeText(this, "Not bad, your score is " + score + " you can do better try again!", Toast.LENGTH_LONG).show();
        }
        else if (score == 8){
            Toast.makeText(this, "Nice work your score is" + score + " keep up", Toast.LENGTH_LONG).show();
        }
        else  if (score == 12){
            Toast.makeText(this, "WOW! congrats, your score is" + score + " you've gotten everything right", Toast.LENGTH_LONG).show();
        }
        else if (score >= 6){
            Toast.makeText(this, "Good your score is" + score + " you've answered more tha half the questions", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "You need to answer at least one question to submit", Toast.LENGTH_LONG).show();
        }

    }

}

