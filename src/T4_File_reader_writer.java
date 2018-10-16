import java.io.*;
import java.nio.file.*;

public class T4_File_reader_writer {
    public static void main(String[] args) {
        String text = "Четыре чёрненьких чумазеньких чертёнка чертили чёрными чернилами чертёж чрезвычайно чётко";
        task4_2(text);
        task4_3();
    }

    private static void task4_2(String text) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("text_utf8.txt"), "UTF8"))) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("text_win1251.txt"), "windows-1251"))) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("text_koi8r.txt"), "KOI8_R"))) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void task4_3() {

    //utf8
        try {
            Path pathText_utf8 = Paths.get("text_utf8.txt");
            //text_utf8.
            byte[] text_utf8 = {-48, -89, -48, -75, -47, -126, -47,
                    -117,
                    -47,
                    -128,
                    -48,
                    -75,
                    32,
                            -47,
                            -121,
                            -47};
            //byte[] text_utf8 = Files.readAllBytes(pathText_utf8);
            for (int i = 0; i < text_utf8.length; i++) {
                System.out.println(text_utf8[i]);
            }

            //доп кодом
            Files.write(Paths.get("text_utf8_b.bin"), text_utf8);
            //в число

            //16ричное

        } catch (Exception e) {
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
