package example.service;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;
import example.util.Managers;

import java.net.IDN;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager<T extends Task> implements TaskManager<T> {
    private final Map<Integer, T> tasks = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public void add(T task) {
        if (task instanceof Subtask) {
            Subtask subtask = (Subtask) task;
            Epic epic = getEpicById(subtask.getEpic().getId());
            subtask.setEpic(epic);
            epic.addSubtask(subtask);
        }

        tasks.put(task.getId(), task);
    }

    @Override
    public void remove(int id) {
        T task = tasks.get(id);
        if (task == null) {
            return;
        }

        if (task instanceof Epic) {
            Epic epic = (Epic) task;
            for (Subtask subtask : epic.getSubtasks()) {
                subtask.setEpic(null);
                tasks.remove(subtask.getId());
            }
        } else if (task instanceof Subtask) {
            Subtask subtask = (Subtask) task;
            Epic epic = getEpicById(subtask.getEpic().getId());
            if (epic != null) {
                epic.removeSubtask(subtask);
                subtask.setEpic(null);
            }
        }

        tasks.remove(id);
    }

    @Override
    public void update(int id, T task) {
        if (task instanceof Subtask) {
            Subtask subtask = (Subtask) task;
            Epic epic = getEpicById(subtask.getEpic().getId());
            epic.updateStatus();
        }

        task.setId(id);
        tasks.put(id, task);
    }

    public T getTask(int id) {
        if (tasks.get(id) != null) {
            historyManager.add(tasks.get(id));
        }
        return tasks.get(id);

    }

    public void removeAllTasks(){
        tasks.clear();
    }

    public List<Task> getAllTasks() {
        List<Task> result = new ArrayList<>();
        for (T task : tasks.values()) {
            if (!(task instanceof Epic) && !(task instanceof Subtask)) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Epic> getAllEpics() {
        List<Epic> result = new ArrayList<>();
        for (T task : tasks.values()) {
            if (task instanceof Epic) {
                result.add((Epic) task);
            }
        }
        return result;
    }

    public List<Subtask> getAllSubtasks() {
        List<Subtask> result = new ArrayList<>();
        for (T task : tasks.values()) {
            if (task instanceof Subtask) {
                result.add((Subtask) task);
            }
        }
        return result;
    }

    public List<Subtask> getSubtasksOfEpic(int epicId) {
        Epic epic = getEpicById(epicId);
        if (epic == null) {
            return new ArrayList<>();
        }
        return epic.getSubtasks();
    }

    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    private Epic getEpicById(int epicId) {
        T task = tasks.get(epicId);
        return (task instanceof Epic) ? (Epic) task : null;
    }
}