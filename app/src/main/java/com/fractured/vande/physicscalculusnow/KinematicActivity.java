package com.fractured.vande.physicscalculusnow;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class KinematicActivity extends AppCompatActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinematic);
    }

    //".."Switch is used to control the edit text next to the switch itself.
    //because each box and switch is unique, each one needed to be unique.
    public void intitialVelocitySwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchVel1);
        EditText theText = (EditText) findViewById(R.id.editInitialVelocity);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_initialVel);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void finalVelocitySwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchVel2);
        EditText theText = (EditText) findViewById(R.id.editFinalVelocity);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_finalVel);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void intitialPositionSwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchPos1);
        EditText theText = (EditText) findViewById(R.id.editInitialPos);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_intialPos);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void finalPositionSwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchPos2);
        EditText theText = (EditText) findViewById(R.id.editFinalPos);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_finalPos);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void initialTimeSwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchTime1);
        EditText theText = (EditText) findViewById(R.id.editInitialTime);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_initialTime);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void finalTimeSwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchTime2);
        EditText theText = (EditText) findViewById(R.id.editFinalTime);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_finalTime);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void accelerationSwitch(View view){
        Switch theSwitch = (Switch) findViewById(R.id.switchAccel);
        EditText theText = (EditText) findViewById(R.id.editAcceleration);
        if (theSwitch.isChecked()){
            theText.setText(R.string.text_acceleration);
            theText.setEnabled(false);
        }
        else{
            theText.setText("");
            theText.setEnabled(true);
        }
    }

    public void onCalculate(View view){
        int maxMissing = 2;
        int switchCount = 0; //how many switches are 'on' at the time of pressing the Calculate button
        int variableCount = 0;
        //Create a stitch to be able to observe our users switch inputs, then determine if there is more than 2 switches active
        EditText edText = (EditText) findViewById(R.id.editInitialVelocity);
        Switch stitch = (Switch) findViewById(R.id.switchVel1);
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        if (stitch.isChecked()){
            ++switchCount;
        }
        edText = (EditText) findViewById(R.id.editFinalVelocity);
        stitch = (Switch) findViewById(R.id.switchVel2);
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        if (stitch.isChecked()){
            ++switchCount;
        }
        edText = (EditText) findViewById(R.id.editInitialPos);
        stitch = (Switch) findViewById(R.id.switchPos1);
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        if (stitch.isChecked()){
            ++switchCount;
        }
        edText = (EditText) findViewById(R.id.editFinalPos);
        stitch = (Switch) findViewById(R.id.switchPos2);
        if (stitch.isChecked()){
            ++switchCount;
        }
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        edText = (EditText) findViewById(R.id.editInitialTime);
        stitch = (Switch) findViewById(R.id.switchTime1);
        if (stitch.isChecked()){
            ++switchCount;
        }
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        edText = (EditText) findViewById(R.id.editFinalTime);
        stitch = (Switch) findViewById(R.id.switchTime2);
        if (stitch.isChecked()){
            ++switchCount;
        }
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }
        edText = (EditText) findViewById(R.id.editAcceleration);
        stitch = (Switch) findViewById(R.id.switchAccel);
        if (stitch.isChecked()){
            ++switchCount;
        }
        if (!(edText.getText().toString().isEmpty())){
            ++variableCount;
        }



/*
        String tempString = Integer.toString(switchCount);
        //Temp logs for testing
        Log.d(TAG, "onCalculate SwitchCount: ");
        Log.d(TAG, tempString);
*/
        //After determining which ones have been switched, check our count to make sure it is more less than or equal to 2 (maxMissing)
        //If the value is not less than or equal to 2, then create a floating box expressing to the user to only select to, and a okay button
        if (!(switchCount <= maxMissing)){
            DialogFragment aFrag = new KineticDialogFragment();
            aFrag.show(getFragmentManager(), "badSwitch");
           // Log.d(TAG, "TOO MANY SWITCHES");
        }
        else if (true){
           // Log.d(TAG, "<=2");
        }
    }

}
