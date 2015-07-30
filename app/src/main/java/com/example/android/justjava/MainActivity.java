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
 * @param price
 * @param addWhippedCream w if the whipped cream is added or not
 * @return text summary
 */
    private String createSummary(double price,boolean addWhippedCream,boolean haschoco){
        String priceMessage = "Name :-- Prateesh Goswami";
        double addTax = price * 6.5/100;
        priceMessage += " \nHas whipped cream  =" + addWhippedCream;
        priceMessage += " \nHas chocolate  =" + haschoco;

        priceMessage += "\n Quantity = " + quantity + " " + " @$10/Coffee";
               priceMessage +=  "\n Total  :=  $ " +price ;
        priceMessage += "\n Tax @ 6.5%  = $ " + addTax;

        price = price + addTax;
        priceMessage += "\n Total =  $ " + price ;
        priceMessage += "\n Thank You!!!";
        return priceMessage;

    }
    public int calculatePrice(){
        int price = 10;
        price = price*quantity;
        return price;
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whippedCream =  (CheckBox)findViewById(R.id.checkbox_whip);
        CheckBox chocolate = (CheckBox)findViewById(R.id.checkbox_choco);
        boolean haswhipped = whippedCream.isChecked();
        boolean haschoco = chocolate.isChecked();


        String message =createSummary(price,haswhipped,haschoco);
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