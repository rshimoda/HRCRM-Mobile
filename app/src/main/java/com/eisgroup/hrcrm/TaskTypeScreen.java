package com.eisgroup.hrcrm;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class TaskTypeScreen extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    String taskSelected = "ODS Internal";
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_type_screen);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tasks_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_type_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent;
        switch (taskSelected) {
            case "Candidates":
                intent = new Intent(TaskTypeScreen.this, CandidatesScreen.class);
                break;
            case"Marketing":
                intent = new Intent(TaskTypeScreen.this, MarketingScreen.class);
                break;
            case "ODS Internal":
                intent = new Intent(TaskTypeScreen.this, ODSInternalScreen.class);
                break;
            case "Performance":
                intent = new Intent(TaskTypeScreen.this, PerformanceScreen.class);
                break;
            case "Recruiting":
                intent = new Intent(TaskTypeScreen.this, RecruitmentScreen.class);
                break;
            default:
                intent = new Intent(TaskTypeScreen.this, TaskTypeScreen.class);
        }
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        taskSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
