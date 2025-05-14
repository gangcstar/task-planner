package example.service;

import example.model.Task;

public interface TaskManager<T extends Task> {

    void add(T task);

    void remove(int id);
}
