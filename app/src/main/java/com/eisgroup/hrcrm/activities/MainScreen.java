package com.eisgroup.hrcrm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.eisgroup.hrcrm.R;
import com.eisgroup.hrcrm.Task;
import com.eisgroup.hrcrm.TaskList;
import com.eisgroup.hrcrm.adapter.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class MainScreen extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    ListView listView;
    List<Task> tasks = new ArrayList<>();

    ImageButton create;

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet;

    @Override
    protected void onStart() {
        super.onStart();
        if(tasks.isEmpty()) tasks.add(new Task("There are no tasks created"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        listView = (ListView) findViewById(R.id.listView);
        TaskAdapter adapter = new TaskAdapter(this, TaskList.wasCreated ? TaskList.tasks : tasks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        create = (ImageButton) findViewById(R.id.imageButton3);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, TaskTypeScreen.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_admin) {
            Intent intent = new Intent(MainScreen.this, LoginScreen.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TaskList.currentId = position;
        Intent intent = new Intent(this, TaskViewScreen.class);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TaskList.currentId = position;
        Intent intent = new Intent(MainScreen.this, TaskViewScreen.class);
        startActivity(intent);
    }
}
