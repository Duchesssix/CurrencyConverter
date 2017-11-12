package com.example.dawn.currencyconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double conversionRate =  0.857232;
    double currencyEntered = 0.0;
    double currencyConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText currency = (EditText) findViewById(R.id.txtCurrency);
        final RadioButton dolToEuro = (RadioButton) findViewById(R.id.radDollarToEuro);
        final RadioButton euroToDol = (RadioButton) findViewById(R.id.radEuroToDollar);
        final TextView result = (TextView) findViewById(R.id.txtResults);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currencyEntered = Double.parseDouble(currency.getText().toString());
                DecimalFormat dolFormat = new DecimalFormat("#.##");
                if (dolToEuro.isChecked()) {
                    if (currencyEntered <= 1000) {
                        currencyConverted = currencyEntered * conversionRate;
                        result.setText(dolFormat.format(currencyConverted));
                    } else {
                        Toast.makeText(MainActivity.this, "Dollars must be less than $1000.",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if (euroToDol.isChecked()) {
                    if (currencyEntered <= 858) {
                        currencyConverted = currencyEntered / conversionRate;
                        result.setText(dolFormat.format(currencyConverted));
                    } else {
                        Toast.makeText(MainActivity.this, "Euros must be less than 858 Euros.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
