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
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.eisgroup.hrcrm.R;
import com.eisgroup.hrcrm.Task;
import com.eisgroup.hrcrm.TaskList;


public class TaskTypeScreen extends Activity {

    String taskName, taskType, taskDescription ,taskDueDate, taskPrior, taskCompl;
    Spinner spinner, spinnerP, spinnerC, spinnerPro, spinnerPos,  spinnerL;
    EditText summary, description, date;
    ImageButton imageButton;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_type_screen);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerC = (Spinner) findViewById(R.id.complexitySpinner);
        spinnerP = (Spinner) findViewById(R.id.prioritySpinner);
        spinnerPro = (Spinner) findViewById(R.id.projectSpinner);
        spinnerPos = (Spinner) findViewById(R.id.positionSpinner);
        spinnerL = (Spinner) findViewById(R.id.levelSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskType = parent.getItemAtPosition(position).toString();
                relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                if (taskType.equals("Recruitment") || taskType.equals("Candidates")) {
                    relativeLayout.setVisibility(View.VISIBLE);
                } else relativeLayout.setVisibility(View.GONE);
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

        spinnerPro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //NOP
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerPos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //NOP


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //NOP
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
        ArrayAdapter<CharSequence> adapterPro = ArrayAdapter.createFromResource(this, R.array.project_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterPos = ArrayAdapter.createFromResource(this, R.array.position_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterL = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinnerP.setAdapter(adapterP);
        spinnerC.setAdapter(adapterC);
        spinnerPro.setAdapter(adapterPro);
        spinnerPos.setAdapter(adapterPos);
        spinnerL.setAdapter(adapterL);

        summary = (EditText) findViewById(R.id.summary);
        date = (EditText) findViewById(R.id.dateInput);
        description = (EditText) findViewById(R.id.description);

        imageButton = (ImageButton) findViewById(R.id.nextButton);

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
