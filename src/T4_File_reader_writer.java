import java.io.*;

public class T4_File_reader_writer {
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

    /*4.3
        любой файл состоит из байтов - восьмибитные кусочик информации
        8 нолей/единичек
        кодировки превращат байты в буквы
        ютф8 для русских букв по два байта
        нужно вывести байты

        при чтении байт из файла получаем тип byte

        как мы будем это в файл выводить
        есть byte b
        как написать?
            - можно просто распечатать - получу дополнительный код
            - можно превратить в обычное число
                int bb = b < 0? 256 + b  : b
                шо такое ?
                это String s = x == 2 ? "два" : "не два"
                int bb = b&0xFF;

                sout (Integer.toString (bb, 16));

                печатать все три варианта b, bb, bb16
                со знаком, без знака и в шестнадцатеричной
     */

}
