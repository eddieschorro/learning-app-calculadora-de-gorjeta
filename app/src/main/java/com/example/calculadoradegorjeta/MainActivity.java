package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView textView_finalCost, textView_tipPercentFromSeekbar,textView_tipAmoutCalculated;
    SeekBar tipPercentSeekBar;
    EditText billPriceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_tipAmoutCalculated = findViewById(R.id.textView_tipAmoutCalculated);
        billPriceEditText = findViewById(R.id.editText_billPrice);
        textView_finalCost = findViewById(R.id.textView_finalCost);
        textView_tipPercentFromSeekbar = findViewById(R.id.textView_tipPercentFromSeekbar);
        tipPercentSeekBar = findViewById(R.id.seekBar_TipPercent);

        tipPercentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (billPriceEditText == null || billPriceEditText.equals("")) {
                    billPriceEditText.setText("100");
                } else {
                    precoGorjeta();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void precoGorjeta() {

        //get valor da conta
        double billPrice = Double.parseDouble(billPriceEditText.getText().toString());

        // calcular e mostrar o percentual da gorjeta
        String percentual = String.valueOf(tipPercentSeekBar.getProgress());
        textView_tipPercentFromSeekbar.setText(percentual + "%");
        double tip = Double.parseDouble(percentual);

        // calcular e mostrar o valor da gorjeta
        double valorGorjeta = tip * billPrice / 100;
        String showValorGorjeta = "R$ " +valorGorjeta;
        textView_tipAmoutCalculated.setText(showValorGorjeta);

        // calcular e mostrar o total da conta
        double finalCost = ( billPrice + valorGorjeta );
        textView_finalCost.setText(String.valueOf(finalCost));
    }
}