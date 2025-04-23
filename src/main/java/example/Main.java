package example;

public class Main {
    public static void main(String[] args) {
        Taskmanager taskmanager = new Taskmanager();

        Task task = new Task("Первая задача", "Описание первой задачи");
        Epic epic = new Epic("Тестовый Эпик", "Описание тестового эпика");
        Subtask subtask = new Subtask("Подзадача", "Описание подзадачи", epic.getId());
        Subtask subtask2 = new Subtask("Вторая подзадача", "для эпика", epic.getId());
        Epic epic2 = new Epic("второй тестовый", "в нем будет одна подзадача");
        Subtask subtask3 = new Subtask("обычная подзадача", "и ее описание", epic2.getId());


        taskmanager.addTask(task);
        taskmanager.addEpic(epic);
        taskmanager.addSubtask(subtask);
        taskmanager.addSubtask(subtask2);
        taskmanager.addEpic(epic2);
        taskmanager.addSubtask(subtask3);

        System.out.println("Все задачи:");
        taskmanager.getAllTasks().forEach(System.out::println);

        System.out.println("Все эпики:");
        taskmanager.getAllEpics().forEach(System.out::println);

        System.out.println("Все подзадачи:");
        taskmanager.getAllSubtasks().forEach(System.out::println);

        task.setStatus(Status.IN_PROGRESS);
        System.out.println(task);

        subtask.setStatus(Status.DONE);
        taskmanager.updateEpicStatus(epic);
        System.out.println(epic);

        subtask2.setStatus(Status.DONE);
        taskmanager.updateEpicStatus(epic);
        System.out.println(subtask);
        System.out.println(subtask2);
        System.out.println(epic);

        taskmanager.removeEpic(epic.getId());
        System.out.println("Все эпики:");
        taskmanager.getAllEpics().forEach(System.out::println);

        taskmanager.removeTask(task.getId());
        System.out.println("Все задачи:");
        taskmanager.getAllTasks().forEach(System.out::println);


    }

}
