package example.service;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;

import java.util.List;

public interface TaskManager<T extends Task> {

    void add(T task);

    void remove(int id);

    public List<Task> getAllTasks();

    public List<Epic> getAllEpics();

    public List<Subtask> getAllSubtasks();

    public List<Subtask> getSubtasksOfEpic(int epicId);

}

