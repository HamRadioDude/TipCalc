package com.example.klechak.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    double billTotal = 0.00;
    int numPpl;
    double totalTip;
    String tipChoice;
    double tipPerc;
    String fmt_totalTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText amount = (EditText) findViewById(R.id.txtCharges);
        final EditText people = (EditText) findViewById(R.id.txtPpl);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);


        Button calc = (Button) findViewById(R.id.btnCalc);
        calc.setOnClickListener(new View.OnClickListener() {


                                    final TextView result = ((TextView) findViewById(R.id.txtTotal));

                                    public void onClick(View View) {

                                        // billTotal = Double.parseDouble(amount.getText().toString());
//                            numPpl = Integer.parseInt(people.getText().toString());
                                        float num = 0;

                                        try {
                                            billTotal = Double.parseDouble(amount.getText().toString());
                                            numPpl = Integer.parseInt(people.getText().toString());

                                            DecimalFormat currency = new DecimalFormat("$###,###.##");


                                            tipChoice = group.getSelectedItem().toString();
                                            tipPerc = Double.parseDouble(tipChoice.replaceAll("[^0-9]", ""));


                                            totalTip = ((billTotal) * (tipPerc / 100)) / numPpl;

                                            fmt_totalTip = currency.format(totalTip);

                                            result.setText("Tip Amount Between " + numPpl + " people equals " + fmt_totalTip + " Each.");


                                        } catch (NumberFormatException e) {
                                            billTotal = 0;
                                            numPpl = 0;
                                            result.setText("THERE WAS A PROBLEM WITH YOUR INPUT");
                                        }


//  -------------- Klechak Note - I moved this into a try catch to prevent that horrible error from occuring (when someone forgets to put in input, program crashes.
//                            DecimalFormat currency = new DecimalFormat("$###,###.##");
//
//
//                        tipChoice = group.getSelectedItem().toString();
//                        tipPerc = Double.parseDouble(tipChoice.replaceAll("[^0-9]",""));
//
//
//
//                        totalTip = ((billTotal) *(tipPerc/100)) / numPpl ;
//
//                        fmt_totalTip = currency.format(totalTip);
//
//                        result.setText("Tip Amount Between " + numPpl + " people equals " + fmt_totalTip + " Each.");

                                    }


                                }


        );
    }
}
