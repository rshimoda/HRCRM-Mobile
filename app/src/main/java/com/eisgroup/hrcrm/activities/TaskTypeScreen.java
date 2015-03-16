package com.eisgroup.hrcrm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.eisgroup.hrcrm.R;
import com.eisgroup.hrcrm.Task;
import com.eisgroup.hrcrm.TaskList;


public class TaskTypeScreen extends Activity {

    String taskName, taskType, taskDescription ,taskDueDate, taskPrior, taskCompl;
    Spinner spinner, spinnerP, spinnerC;
    EditText summary, description, date;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_type_screen);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerC = (Spinner) findViewById(R.id.complexitySpinner);
        spinnerP = (Spinner) findViewById(R.id.prioritySpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskCompl = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskPrior = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tasks_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterC = ArrayAdapter.createFromResource(this, R.array.complexity_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterP = ArrayAdapter.createFromResource(this, R.array.priority_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinnerP.setAdapter(adapterP);
        spinnerC.setAdapter(adapterC);

        summary = (EditText) findViewById(R.id.summary);
        date = (EditText) findViewById(R.id.dateInput);
        description = (EditText) findViewById(R.id.description);

        imageButton = (ImageButton) findViewById(R.id.nextButton);

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
        TaskList.wasCreated = true;

        taskName = summary.getText().toString();

        TaskList.tasks.add(0, new Task(TaskList.tasks.size(), summary.getText().toString(), taskType, taskPrior, taskCompl, date.getText().toString(), description.getText().toString()));

        Intent intent = new Intent(TaskTypeScreen.this, MainScreen.class);
        startActivity(intent);
    }

    public void setNextVisible() {
            imageButton.setVisibility(View.VISIBLE);
    }


}
