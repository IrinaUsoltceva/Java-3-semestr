public class T1_Exeption {
    public static void main(String[] args) {
        task1();
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
}
