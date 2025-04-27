package example.service;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;
import example.util.Status;

import java.util.*;

public class Taskmanager {
    private int idTask = 1;
    private Map<Integer, Task> tasks = new HashMap<>(); //Map<Integer, T>
    private Map<Integer, Epic> epics = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    private int taskId() {
        return ++idTask;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);

        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.addSubtaskId(subtask.getId());
            updateEpicStatus(epic);
        }
    }

    public void removeTask(int id) {
        tasks.remove(id);
    }

    public  void removeSubtask(int id) {
        Subtask subtask = subtasks.remove(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                epic.removeSubtasksId(id);
                updateEpicStatus(epic);
            }
        }
    }

    public void removeEpic(int id) {
        Epic epic = epics.remove(id);
        if (epic != null) {
            for (int subtaskId : epic.getSubtaskIds()) {
                subtasks.remove(subtaskId);
            }
        }
    }

    public void updateEpicStatus(Epic epic) {
        List<Integer> subtaskIds = epic.getSubtaskIds();
        if (subtaskIds.isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }

        int  newCount = 0;
        int doneCount = 0;

        for (int id : subtaskIds) {
            Status status = subtasks.get(id).getStatus();
            if (status == Status.NEW) {
                newCount++;
            }
            else if (status == Status.DONE) {
                doneCount++;
            }
        }

        if (newCount == subtaskIds.size()) {
            epic.setStatus(Status.NEW);
        } else if (doneCount == subtaskIds.size()) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }

    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public  List<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public  List<Subtask> getSubtaskOfEpic(int epicId) {
        List<Subtask> result = new ArrayList<>();
        Epic epic = epics.get(epicId);
        for (int id : epic.getSubtaskIds()) {
            result.add(subtasks.get(id));
        }
        return result;
    }
}
