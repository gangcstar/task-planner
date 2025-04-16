package example;

import java.util.*;

public class Taskmanager {
    private int idTask = 0;
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer,Epic> epics = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    private int taskId() {
        return ++idTask;
    }
}
