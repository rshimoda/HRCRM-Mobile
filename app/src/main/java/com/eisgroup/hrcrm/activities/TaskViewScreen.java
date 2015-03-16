package com.eisgroup.hrcrm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.eisgroup.hrcrm.R;
import com.eisgroup.hrcrm.Task;
import com.eisgroup.hrcrm.TaskList;


public class TaskViewScreen extends Activity {

    TextView summary, type, priority, dueDate, complexity, description;
    Task task = TaskList.tasks.get(TaskList.currentId);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view_screen);

        summary = (TextView) findViewById(R.id.TaskSummary);
        summary.setText(task.getSummary());

        type = (TextView) findViewById(R.id.taskTypeField);
        type.setText(task.getType());

        priority = (TextView) findViewById(R.id.priorityField);
        priority.setText(task.getPriority());

        dueDate = (TextView) findViewById(R.id.dueDateField);
        dueDate.setText(task.getDueDate());

        complexity = (TextView) findViewById(R.id.complexityField);
        complexity.setText(task.getComplexity());

        description = (TextView) findViewById(R.id.descriptionField);
        description.setText(task.getDescription());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_view_screen, menu);
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
}
