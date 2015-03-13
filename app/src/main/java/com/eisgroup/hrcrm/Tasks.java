package com.eisgroup.hrcrm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 10/03/15.
 */
public class Tasks {
    public static boolean isInitiated = false;
    public static List<String> tasks = new ArrayList<>();
    static {
        tasks.add("There are no tasks created :(");
    }
}
