package l;

public class Monkeys10 {

    public static void main(String[] args) {
        new Monkeys10(); //создаем одну программу про обезьянок
    }

    private int bananas = 1_000_000;
    private int total = 0;

    private Monkeys10() {
        Object monitor = new Object();

        Runnable monkeyAction = () -> {
            int eaten = 0;
            while (bananas > 0) {
                synchronized (monitor) {
                    if (bananas > 0) {
                        bananas--;
                        eaten++;
                    }
                }
            }
            //используем глобальную переменную, необходима синхронизация
            synchronized (monitor) {
                total += eaten;
            }
            System.out.println(String.format("A monkey ate %d bananas, total: %d", eaten, total));
        };
        for (int i = 0; i < 10; i++) {
            Thread monkey = new Thread(monkeyAction);
            monkey.start();
        }
    }
}
