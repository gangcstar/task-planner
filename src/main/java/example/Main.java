package example;

import example.model.Epic;
import example.model.Subtask;
import example.model.Task;
import example.service.HistoryManager;
import example.service.InMemoryHistoryManager;
import example.service.InMemoryTaskManager;
import example.service.TaskManager;
import example.util.Managers;
import example.util.Status;

public class Main {
    public static void main(String[] args) {
        //создали менеджер
        InMemoryTaskManager taskmanager = new InMemoryTaskManager();


        //создаем задачи
        Task task = new Task("Первая задача", "Описание первой задачи");
        Task task2 = new Task("вторая задача", "второе описание");
        Epic epic = new Epic("Тестовый Эпик", "Описание тестового эпика");
        Subtask subtask = new Subtask("Подзадача", "Описание подзадачи", epic.getId());
        Subtask subtask2 = new Subtask("Вторая подзадача", "для эпика", epic.getId());
        Epic epic2 = new Epic("второй тестовый", "в нем будет одна подзадача");
        Subtask subtask3 = new Subtask("обычная подзадача", "и ее описание", epic2.getId());


        //добавили задачи в менеждер
        taskmanager.add(task);
        taskmanager.add(task2);
        taskmanager.add(epic);
        taskmanager.add(epic2);
        taskmanager.add(subtask);
        taskmanager.add(subtask2);
        taskmanager.add(subtask3);                  // хотел уточнить: задачи в менеджер лучше добавлять списком, или сразу после создания



        //печать всех созданных задач
        System.out.println(taskmanager.getAllTasks());
        System.out.println(taskmanager.getAllEpics());
        System.out.println(taskmanager.getAllSubtasks());

        //меняем статусы задач
        subtask2.setStatus(Status.DONE);
        subtask3.setStatus(Status.IN_PROGRESS);


        //вывод эпиков с новыми статусами
        System.out.println();
        System.out.println(taskmanager.getAllEpics());


        //удаление подзадачи и эпика
        taskmanager.remove(3);
        taskmanager.remove(5);


        //вывод обновленных задач и эпиков
        System.out.println();
        System.out.println(taskmanager.getAllEpics());



        // ТЕСТЫ ДЛЯ ВТОРОЙ ЧАСТИ
        System.out.println();

        //получаем задачи по ID
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(4);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(8);
        taskmanager.getTask(1);


        //выводим результат - 10 последних задач
        System.out.println(taskmanager.getHistory());

    }


}
