import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable task1 = new MyCallable("task1");
        MyCallable task2 = new MyCallable("task2");
        MyCallable task3 = new MyCallable("task3");
        List<MyCallable> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int result = threadPool.invokeAny(taskList);
        System.out.println("Результат = " + result);
        threadPool.shutdown();
    }
}
