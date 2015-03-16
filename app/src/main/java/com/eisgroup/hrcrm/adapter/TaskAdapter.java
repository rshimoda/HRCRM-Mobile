package com.eisgroup.hrcrm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eisgroup.hrcrm.R;
import com.eisgroup.hrcrm.Task;

import java.util.List;

public class TaskAdapter extends BaseAdapter {

    private List<Task> tasks;
    private LayoutInflater layoutInflater;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.tasks = tasks;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.task_layout, parent, false);
        }



        TextView textView = (TextView) view.findViewById(R.id.textView3);
        textView.setText(getTask(position).getSummary());

        return view;
    }

    private Task getTask(int position) {
        return (Task) getItem(position);
    }
}
