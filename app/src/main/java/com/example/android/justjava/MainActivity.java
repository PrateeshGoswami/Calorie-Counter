package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.jar.Attributes;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // variable quantity initilization

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    /**
     * Create summary
     *
     * @param name            of the customer
     * @param price
     * @param addWhippedCream w if the whipped cream is added or not
     * @param haschoco        if it has chocolate
     * @return text summary
     */
    private String createSummary(String name, double price, boolean addWhippedCream, boolean haschoco) {

        String priceMessage = "Name :-- " + name;
        priceMessage += " \nHas whipped cream  =" + addWhippedCream;
        priceMessage += " \nHas chocolate  =" + haschoco;
        priceMessage += "\n Quantity = " + quantity;
        priceMessage += "\n After adding tax @6.5% ";
        priceMessage += "\n Total =  $ " + price;
        priceMessage += "\n Thank You!!!";
        return priceMessage;

    }

    /**
     * Calculate price
     *
     * @param haswhipped w if the whipped cream is added or not
     * @param haschoco   if it has chocolate
     * @return price
     */
    public double calculatePrice(boolean haswhipped, boolean haschoco) {

        double basePrice = 5;
        if (haswhipped) {
            basePrice = basePrice + 1;
        }
        if (haschoco) {
            basePrice = basePrice + 2;
        }
        basePrice = basePrice * quantity;
        double tax = .065;
       double total = basePrice + (basePrice * tax);
        return total;

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.editText);
        String name = text.getText().toString();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox_whip);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox_choco);
        boolean haswhipped = whippedCream.isChecked();
        boolean haschoco = chocolate.isChecked();
        double price = calculatePrice(haswhipped, haschoco);
        String message = createSummary(name, price, haswhipped, haschoco);
        displayPrice(message);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 99 ){
            quantity =99;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if(quantity <= 0){
            quantity = 1;
        }
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