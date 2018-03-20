package com.example.android.justjava;

import android.annotation.SuppressLint;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
        displayPrice(num*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.zero);
        quantityTextView.setText("" + number);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_num);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void reset(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.zero);
        TextView priceTextView = (TextView) findViewById(R.id.price_num);
        quantityTextView.setText("" + 0);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(0));
        num = 0;
    }

    public void increment(View view) {
        num++;
        display(num);
    }

    public void decrement(View view) {
        num--;
        display(num);
    }
}