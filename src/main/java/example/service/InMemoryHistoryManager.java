package example.service;

import example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    private static final List<Task> history = new ArrayList<>(10);

    public void add(Task task) {
        if(task == null) {

        }
        else {
            history.add(task);
        }
    }

    public void remove(int id) {
        history.remove(id);
    }

    public void removeAll() {
        history.clear();
    }

    @Override
    public List<Task> getHistory() {
            List<Task> result = new ArrayList<>();
            for (Task task : history) {
                result.add(task);
            }
            return result;
        }

}
