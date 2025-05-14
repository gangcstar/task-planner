package example;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;
import example.service.TaskManagerImpl;
import example.util.Status;

public class Main {
    public static void main(String[] args) {

        TaskManagerImpl taskmanager = new TaskManagerImpl();

        Task task = new Task("Первая задача", "Описание первой задачи");
        Epic epic = new Epic("Тестовый Эпик", "Описание тестового эпика");
        Subtask subtask = new Subtask("Подзадача", "Описание подзадачи", epic.getId());
        Subtask subtask2 = new Subtask("Вторая подзадача", "для эпика", epic.getId());
        Epic epic2 = new Epic("второй тестовый", "в нем будет одна подзадача");
        Subtask subtask3 = new Subtask("обычная подзадача", "и ее описание", epic2.getId());


        //добавили задачи в менеждер
        taskmanager.add(task);
        taskmanager.add(epic);
        taskmanager.add(subtask);
        taskmanager.add(subtask2);

        System.out.println(taskmanager.getAllSubtasks());

        subtask2.setStatus(Status.DONE);
        subtask.setStatus(Status.DONE);


        System.out.println(taskmanager.getAllSubtasks());


    }

}
