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
    private static TaskManager taskManager;
    private static HistoryManager historyManager;

    public static TaskManager getDefault() {
        if(taskManager == null) {
        taskManager = new InMemoryTaskManager();
        }
        return taskManager;

    }

    public static HistoryManager getDefaultHistory() {
        if(historyManager == null) {
            historyManager = new InMemoryHistoryManager();
        }
        return  historyManager;
    }
}
