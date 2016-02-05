package com.example.sunsun1001.crunchtime;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
import android.view.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
<<<<<<< HEAD

public class CalorieCrunch extends AppCompatActivity {

=======

public class CalorieCrunch extends AppCompatActivity {
    
>>>>>>> origin/master
    Map<String, Pair<Integer, Integer>> exercises = new HashMap<String, Pair<Integer, Integer>>() {{
        put("Pushups", Pair.create(350, 0)); // 0 represents reps
        put("Situps", Pair.create(200, 0));
        put("Jumping Jacks", Pair.create(10, 1));
        put("Jogging", Pair.create(12, 1));
    }};

    Button btnSubmit;
    RadioButton jogging, jumping, pushups, situps;
    RadioGroup group;
    EditText input;
    TextView output;
    Double inputNum;
    TableLayout conversionTable;
    Pair<Integer, Integer> valueCurrentExercise;
    TextView conversionHint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_crunch);

        conversionTable = (TableLayout) findViewById(R.id.conversionTable);
        input = (EditText) findViewById(R.id.repsMins);
        output = (TextView) findViewById(R.id.outputText);
        conversionHint = (TextView) findViewById(R.id.conversionHint);
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
        String currentChecked = getCurrentChecked();
        valueCurrentExercise = exercises.get(currentChecked);
        Double caloriesBurnt = (inputNum / valueCurrentExercise.first) * 100;
        output.setText(Double.toString(Math.round(caloriesBurnt * 10)/10) + " calories burnt");
        setConversions(currentChecked, caloriesBurnt);
    }

    private String getCurrentChecked() {
        int selected = group.getCheckedRadioButtonId();
        RadioButton b = (RadioButton) findViewById(selected);

        return b.getText().toString();
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

    private void setConversions(String checked, Double caloriesBurnt) {
        conversionTable.removeAllViews();
        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        row.setGravity(Gravity.CENTER_HORIZONTAL);

        TableRow headerRow = new TableRow(this);
        headerRow.setLayoutParams(lp);
        headerRow.setGravity(Gravity.CENTER_HORIZONTAL);

        conversionHint.setVisibility(View.VISIBLE);

        for (Map.Entry<String, Pair<Integer, Integer>> entry : exercises.entrySet()) {
            if (!entry.getKey().equals(checked)) {
                TextView tv = new TextView(this);
                Integer forHundredCals = entry.getValue().first;
                Integer isMinutes = entry.getValue().second;
                Double otherRequired = caloriesBurnt / 100 * forHundredCals;
                String neededRepsOrMinutes = Double.toString(Math.round(otherRequired * 10) / 10) + (isMinutes == 1 ? " minutes" : " reps");
                tv.setText(neededRepsOrMinutes);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                row.addView(tv);

                TextView headerView = new TextView(this);
                headerView.setTypeface(null, Typeface.BOLD);
                headerView.setText(entry.getKey());
                headerView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                headerRow.addView(headerView);
            }

        }
        conversionTable.addView(headerRow);
        conversionTable.addView(row);
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