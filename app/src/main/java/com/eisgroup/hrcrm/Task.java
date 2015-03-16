package com.eisgroup.hrcrm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 10/03/15.
 */
public class Task {
    private int id;
    private String summary, type, priority, complexity, dueDate, description;

    public Task(String summary) {
        this.summary = summary;
    }

    public Task(int id, String summary, String type, String priority, String complexity, String dueDate, String description) {
        this.id = id;
        this.summary = summary;
        this.type = type;
        this.priority = priority;
        this.complexity = complexity;
        this.dueDate = dueDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
