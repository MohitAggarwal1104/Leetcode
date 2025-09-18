import java.util.*;

class Task {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task other = (Task) o;
        return this.userId == other.userId
            && this.taskId == other.taskId
            && this.priority == other.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, taskId, priority);
    }
}

public class TaskManager {
    private Map<Integer, Task> taskMap;
    private TreeSet<Task> taskSet;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>(new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                if (a.priority != b.priority) {
                    return Integer.compare(b.priority, a.priority);
                }
                if (a.taskId != b.taskId) {
                    return Integer.compare(b.taskId, a.taskId);
                }
                return Integer.compare(a.userId, b.userId);
            }
        });
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        taskMap.put(taskId, newTask);
        taskSet.add(newTask);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null) return;
        taskSet.remove(old);
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        taskSet.add(updated);
    }

    public void rmv(int taskId) {
        Task old = taskMap.get(taskId);
        if (old == null) return;
        taskSet.remove(old);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (taskSet.isEmpty()) {
            return -1;
        }
        Task top = taskSet.first();
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
