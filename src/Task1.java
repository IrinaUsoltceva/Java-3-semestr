import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //task1();
        task2();
    }

    private static void f(int x) throws Exception {
        if (x % 2 == 0)
            throw new Exception();
    }

    private static void task1() {
        for (int i = 1; i < 100; i++) {
            try {
                System.out.print(i + " - ");
                f(i);
                System.out.println("нет исключения");
            } catch (Exception e) {
                System.out.println("есть исключение");
            }
        }
    }

    private static int readInt(String str) {
        Scanner s = new Scanner(System.in);
        System.out.println(str);
        int x;
        try {
            x = (Integer.parseInt(s.nextLine()));
        } catch (Exception e) {
            System.out.println("это не число. попробуйте еще раз");
            x = readInt(str);
        }
        return x;
    }

    private static void task2() {
        int x = (readInt("введите x"));
        int y = (readInt("введите y"));
        System.out.println(x + y);
    }

    /*        Задача2
    метод
    Integer.parseInt("242") - если не число, то исключенеие генерируется
    строку в число

    надо функцию int readInt(String message)
    использование
    int x = (readInt("введите x"));
    int y = -------//-----------
            sout ("x + y = " (x + y))

    чтобы читать с клавиатуры, надо пользоваться
            s = new Scanner(System.in) - поток того, что вводим на клавиатуре
        s.nextLine();
     */
}
