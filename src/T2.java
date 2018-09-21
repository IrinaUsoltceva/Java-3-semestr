import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        //task2_1();
        task2_2();
    }

    /*private static int readInt1(String str) {
        Scanner s = new Scanner(System.in);
        System.out.println(str);
        try {
            return Integer.parseInt(s.nextLine());
        } catch (Exception e) {
            System.out.println("это не число. попробуйте еще раз");
            return readInt1(str);
        }
    }

    private static void task2_1() {
        int x = readInt1("введите x");
        int y = readInt1("введите y");
        System.out.println(x + y);
    }*/

    private static int readInt2(String str) {
        Scanner s = new Scanner(System.in);
        System.out.println(str);
        while (true) {
            try {
                return Integer.parseInt(s.nextLine());
            } catch (Exception e) {
                System.out.println("это не число. попробуйте еще раз");
            }
        }
    }

    private static void task2_2() {
        int x = readInt2("введите x");
        int y = readInt2("введите y");
        System.out.println(x + y);
    }
}
