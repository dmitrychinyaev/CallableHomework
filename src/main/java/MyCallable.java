import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final String name;
    private int count = 0;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Я поток "  + getName() + ". Всем привет!");
            count ++;
        }
        System.out.printf("%s завершен. Кол-во вызовов %d\n", getName(), count);
        return count;
    }
}