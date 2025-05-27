package example.util;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;
import example.service.HistoryManager;
import example.service.InMemoryHistoryManager;
import example.service.InMemoryTaskManager;
import example.service.TaskManager;

import java.util.List;

public class Managers {
    public static TaskManager getDefault() {
        TaskManager manager = new InMemoryTaskManager();
        return manager;
    }

    public static HistoryManager getDefaultHistory() {
        HistoryManager historyManager = new InMemoryHistoryManager();
        return  historyManager;
    }
}
