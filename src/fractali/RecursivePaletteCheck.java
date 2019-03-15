package fractali;

public class RecursivePaletteCheck {
    public static void main(String[] args) {
        test(0, 0);
        test(1.0/2048, 0);
        //test(2.0/2048, 0);
        //test(3.0/2048, 1.0/2);
        //test(4.0/2048, 0);
        //test(3.0/4, 1.0/2);
        test(1, 1);
    }

    public static double getColor (double ind){
        double recursiveInd = -1;

        int degree = 0;
        int N = 1024;

        while (N > 1) {
            //System.out.println("\t" + N);
            if (Math.pow(1.0/2, degree + 1) <= ind && ind < Math.pow(1.0/2, degree)) {
                System.out.println(ind + " " + Math.pow(1.0/2, degree + 1));
                recursiveInd = ind * Math.pow(2, degree + 1) - 1;
                System.out.println("\t" + "returned: " + recursiveInd);
                return recursiveInd;
            }
            else {
                degree++;
                N = N / 2;
                System.out.println(Math.pow(1.0/2, degree + 1) + " " + ind + " " + Math.pow(1.0/2, degree));
                System.out.println("\t" + "new degree = " + degree + ", new N = " + N);
            }
        }
        System.out.println("\t" + "final returned: 1");

        if (ind == 1)
            return 1;

        return 0;
    }

    private static void test(double ind, double recursiveIndWaited) {
        System.out.println("ind = " + ind);
        double recursiveIndReal = getColor(ind);
        System.out.println("надо: " + recursiveIndWaited + ", получили: " + recursiveIndReal);
        if (recursiveIndReal == recursiveIndWaited) {
            System.out.println("\t верно");
            System.out.println();
        }
        else {
            System.out.println("не то");
            System.out.println();
        }
    }
}
