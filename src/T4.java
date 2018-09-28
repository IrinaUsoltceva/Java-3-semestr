import java.io.*;

public class T4 {
    public static void main(String[] args) {
        String text = "Четыре чёрненьких чумазеньких чертёнка чертили чёрными чернилами чертёж чрезвычайно чётко";
        task4_2(text);
    }

    private static void task4_2(String text) {
        /*Врайтер - символы
        файлОутпустрим - байты
        следовательно, нужно завести врайтер, загнать туда текст и перевести
        при помощи кодировки в оутпут

        OutputStreamWriter превратит ОС в врайтера

        try (Reader in =
            new InputStreamReader(
            new FileInputStream("a.txt"), "utf-8"
            ))
        */

        try {
            new FileOutputStream("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
