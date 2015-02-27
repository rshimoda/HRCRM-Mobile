package com.eisgroup.hrcrm;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class TaskTypeScreen extends ActionBarActivity {

    private StringBuffer TaskSelect = new StringBuffer("ODSInternal");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_type_screen);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    public void ODSInternalSelect() {
        TaskSelect.delete(0, TaskSelect.length()-1);
        TaskSelect.append("ODSInternal");
    }

    public void RecruitmentSelect() {
        TaskSelect.delete(0, TaskSelect.length()-1);
        TaskSelect.append("Recruitment");
    }

    public void MarketingSelect() {
        TaskSelect.delete(0, TaskSelect.length()-1);
        TaskSelect.append("Management");
    }
    public void CandidatesSelect() {
        TaskSelect.delete(0, TaskSelect.length()-1);
        TaskSelect.append("Candidates");
    }
    public void PerformanceSelect() {
        TaskSelect.delete(0, TaskSelect.length()-1);
        TaskSelect.append("Performance");
    }

    public void onClick(View view) {
        Intent intent;
        switch (TaskSelect.toString()) {
            case "ODSInternal":
                intent = new Intent(TaskTypeScreen.this, ODSInternalScreen.class);
                break;
            case "Recruitment":
                intent = new Intent(TaskTypeScreen.this, RecruitmentScreen.class);
                break;
            case "Management":
                intent = new Intent(TaskTypeScreen.this, MarketingScreen.class);
                break;
            case "Candidates":
                intent = new Intent(TaskTypeScreen.this, CandidatesScreen.class);
                break;
            case "Performance":
                intent = new Intent(TaskTypeScreen.this, PerformanceScreen.class);
                break;
            default:
                intent = new Intent(TaskTypeScreen.this, TaskTypeScreen.class);
                break;
        }
        startActivity(intent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_task_type_screen, container, false);
            return rootView;
        }
    }
}
