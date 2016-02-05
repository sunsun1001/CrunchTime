package com.example.sunsun1001.crunchtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
import android.view.*;

public class CalorieCrunch extends AppCompatActivity {

    int[] exercise = {350, 200, 10, 12};

    int[] boolMins = {0, 1, 0, 1};

    Button btnSubmit;
    RadioButton jogging, jumping, pushups, situps;
    RadioGroup group;
    EditText input;
    TextView output;
    Double inputNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_crunch);

        input = (EditText) findViewById(R.id.repsMins);
        output = (TextView) findViewById(R.id.outputText);
        jogging = (RadioButton) findViewById(R.id.joggingRadio);
        jumping = (RadioButton) findViewById(R.id.jumpingJacksRadio);
        pushups = (RadioButton) findViewById(R.id.pushupsRadio);
        situps = (RadioButton) findViewById(R.id.situpsRadio);
        btnSubmit = (Button) findViewById(R.id.calcCalories);
        group = (RadioGroup) findViewById(R.id.exerciseGroup);
        String strUserName = input.getText().toString();

        if(TextUtils.isEmpty(strUserName)) {
            input.setError("Your message");
            return;
        }

        inputNum = Double.parseDouble(strUserName);
    }

    public void onCalorieClick(View v) {
        String strUserName = input.getText().toString();

        inputNum = Double.parseDouble(strUserName);

        if (pushups.isChecked()) {
            output.setText(Double.toString((inputNum / exercise[0]) * 100));
        } else if (situps.isChecked()) {
            output.setText(Double.toString((inputNum / exercise[1]) * 100));
        } else if (jumping.isChecked()) {
            output.setText(Double.toString((inputNum / exercise[2]) * 100));
        } else  {
            output.setText(Double.toString((inputNum / exercise[3]) * 100));
        }


    }
    public void onClickJogging(View v) {
        Toast.makeText(this, "Enter Minutes of Activity", Toast.LENGTH_SHORT).show();
    }

    public void onClickJumping(View v) {
        Toast.makeText(this, "Enter Minutes of Activity", Toast.LENGTH_SHORT).show();
    }

    public void onClickSitups(View v) {
        Toast.makeText(this, "Enter Reps of Activity", Toast.LENGTH_SHORT).show();
    }

    public void onClickPushups(View v) {
        Toast.makeText(this, "Enter Reps of Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calorie_crunch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


