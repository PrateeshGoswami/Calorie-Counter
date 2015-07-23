package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;
/**
 * Create summary
 * @param price
 * @param
 * @return text summary
 */
    private String createSummary(int price){
        String priceMessage
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream =  (CheckBox)findViewById(R.id.checkbox_whip);
        boolean haswhipped = whippedCream.isChecked();
        Log.v("MainActivity","Has whipped cream" + haswhipped);
        display(quantity);
        String message = "Total :" + quantity*5;
        displayPrice(message);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity =quantity + 1;
        display(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */

    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}