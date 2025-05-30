package example.service;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;

import java.util.List;

public interface TaskManager<T extends Task> {

    void add(T task);

    void remove(int id);

    void update(int id, T task);

    void removeAllTasks();

    List<Task> getAllTasks();

    List<Epic> getAllEpics();

    List<Subtask> getAllSubtasks();

    List<Subtask> getSubtasksOfEpic(int epicId);

    List<Task> getHistory();
}

