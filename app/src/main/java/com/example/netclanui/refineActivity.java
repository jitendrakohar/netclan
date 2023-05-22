package com.example.netclanui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class refineActivity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    SeekBar seekBar;
    TextView seekBarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekbar);
        seekBarValue = findViewById(R.id.seekBarValue);


        setSpinner();
        setSeekBar();
    }

    public void setSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[] {"Available! Hey Let us Connect", "Away! Stay Discreet And Watch ", "Busy! Do Not Disturb| Will Catch Up Later", "SOS | Emerency! Need Assistance! Help" });
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
//                textView.setText("" + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


    }

    public void setSeekBar(){

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText(String.valueOf(progress));

                // Calculate the position of the TextView based on the progress of the SeekBar
                int thumbOffset = seekBar.getThumbOffset();
                int seekBarWidth = seekBar.getWidth() - 2 * thumbOffset;
                int val = (seekBarWidth * progress) / seekBar.getMax();
                seekBarValue.setX(seekBar.getX() + val + thumbOffset - seekBarValue.getWidth() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(refineActivity.this,MainActivity.class));
    }
}