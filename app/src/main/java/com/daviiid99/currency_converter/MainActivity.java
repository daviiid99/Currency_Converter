package com.daviiid99.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Declarations of all UI elements
    protected ImageView banner;
    protected TextView currencyTitle;
    protected EditText userInput;
    protected Button dolarToEuro;
    protected Button euroToDolar;
    protected TextView currencyResultTitle;
    protected TextView currentResult;
    protected String type;
    protected double resultAmount;
    protected boolean isNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize of all UI elements
        // Not everything will be used
        banner = (ImageView) findViewById(R.id.banner);
        currencyTitle = (TextView) findViewById(R.id.enterCurrency);
        userInput = (EditText) findViewById(R.id.userInput);
        dolarToEuro = (Button) findViewById(R.id.dolarToEuro);
        euroToDolar = (Button) findViewById(R.id.euroToDolar);
        currencyResultTitle = (TextView) findViewById(R.id.currencyResultTitle);
        currentResult = (TextView) findViewById(R.id.currencyResult);

        // Lets check buttons events

        dolarToEuro.setOnClickListener((new View.OnClickListener() {
                    public void onClick(View v) {
                        
                        if (userInput.getText().length() > 0){
                            try {
                                Double.parseDouble(userInput.getText().toString());
                                isNumber = true;
                            } catch (java.lang.NumberFormatException e){
                                Toast.makeText(MainActivity.this, "Valor erróneo, introduzca un valor numérico", Toast.LENGTH_SHORT).show();
                                userInput.setText("");
                            }

                            if (isNumber){
                                // Conversion is from dolar to euro
                                // Create an instance of currency class
                                type = "€";
                                Currency currencyConverter = new Currency(Double.parseDouble(userInput.getText().toString()), type);

                                // Get the convertedAmount
                                resultAmount = currencyConverter.dolarToEuro();

                                // Show result
                                currentResult.setText(userInput.getText().toString() + "$" + " = " + String.valueOf(resultAmount) + type);

                                // Notify user
                                Toast.makeText(MainActivity.this, "Operación realizada corectamente", Toast.LENGTH_SHORT).show();
                                isNumber = false;
                                userInput.setText("");

                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Debe introducir una cantidad válida", Toast.LENGTH_SHORT).show();
                        }
                        }
                        
                    }));

        euroToDolar.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {

                if (userInput.getText().length() > 0){
                    try {
                        Double.parseDouble(userInput.getText().toString());
                        isNumber = true;
                    } catch (java.lang.NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Valor erróneo, introduzca un valor numérico", Toast.LENGTH_SHORT).show();
                        userInput.setText("");

                    }

                    if (isNumber){
                        // Conversion is from euro to dolar
                        // Create an instance of currency class
                        type = "$";
                        Currency currencyConverter = new Currency(Double.parseDouble(userInput.getText().toString()), type);

                        // Get the convertedAmount
                        resultAmount = currencyConverter.euroToDolar();

                        // Show result
                        currentResult.setText(userInput.getText().toString() + "€" + " = " +  String.valueOf(resultAmount) + type);

                        // Notify user
                        Toast.makeText(MainActivity.this, "Operación realizada corectamente", Toast.LENGTH_SHORT).show();
                        isNumber = false;
                        userInput.setText("");


                    }

            } else {
                    Toast.makeText(MainActivity.this, "Debe introducir una cantidad válida", Toast.LENGTH_SHORT).show();

                }
        }
        }));
        }
    }