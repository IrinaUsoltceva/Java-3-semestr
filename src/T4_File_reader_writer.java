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
        try (Writer out = new OutputStreamWriter(new FileOutputStream("text_utf8.bin"),"UTF8")) {
            Path pathText_utf8 = Paths.get("text_utf8.txt");
            byte[] text_utf8 = Files.readAllBytes(pathText_utf8);

            for (byte aText_utf8 : text_utf8) {
                int bb = aText_utf8 < 0 ? 256 + aText_utf8 : aText_utf8;
                String bb16 = Integer.toString(bb, 16);
                out.write(bb16 + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    //1251
        try (Writer out = new OutputStreamWriter(new FileOutputStream("text_win1251.bin"),"windows-1251")) {
            Path pathText_utf8 = Paths.get("text_win1251.txt");
            byte[] text_utf8 = Files.readAllBytes(pathText_utf8);

            for (byte aText_utf8 : text_utf8) {
                int bb = aText_utf8 < 0 ? 256 + aText_utf8 : aText_utf8;
                String bb16 = Integer.toString(bb, 16);
                out.write(bb16 + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    //koir
        try (Writer out = new OutputStreamWriter(new FileOutputStream("text_koi8r.bin"),"KOI8_R")) {
            Path pathText_utf8 = Paths.get("text_koi8r.txt");
            byte[] text_utf8 = Files.readAllBytes(pathText_utf8);

            for (byte aText_utf8 : text_utf8) {
                int bb = aText_utf8 < 0 ? 256 + aText_utf8 : aText_utf8;
                String bb16 = Integer.toString(bb, 16);
                out.write(bb16 + " ");
            }

            for (byte aText_utf8 : text_utf8)
                aText_utf8 = aText_utf8 < 0 ? (byte) (128 + aText_utf8) : aText_utf8;
            Files.write(Paths.get("text_koi7r.txt"), text_utf8);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
