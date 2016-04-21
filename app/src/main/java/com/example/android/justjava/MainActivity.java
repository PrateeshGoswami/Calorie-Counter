package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // variable quantity initilization

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Calorie Counter");
    }


    int calorie = 0;
    int number;


    public int calculateCalorie(int number) {
       int bal = 1500 - number;
        return bal;

    }



    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (calorie == 1500) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more calories", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        calorie = calorie + 10;
        display(calculateCalorie(calorie));
        displayCalorie(calorie);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {

        calorie = calorie - 10;
        display(calculateCalorie(calorie));
        displayCalorie(calorie);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayCalorie(int number){
        TextView calorieText = (TextView) findViewById(R.id.calorie);
        calorieText.setText("" + number);
    }


}
