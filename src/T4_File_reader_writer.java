import java.io.*;
import java.nio.file.*;

public class T4_File_reader_writer {
    public static void main(String[] args) {
        String text = "Четыре чёрненьких чумазеньких чертёнка чертили чёрными чернилами чертёж чрезвычайно чётко";
        task4_2(text);
        task4_3();
        task4_4();
    }

    private static void writeInKodirovka (String file, String kodirovka, String text) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), kodirovka))) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void task4_2(String text) {
        writeInKodirovka("text_utf8.txt", "UTF8", text);
        writeInKodirovka("text_win1251.txt", "windows-1251", text);
        writeInKodirovka("text_koi8r.txt", "KOI8_R", text);
    }

    private static void reWriteInThreeBin(String fileIn, String kodirovka) {
        String fileName = fileIn.substring(0, fileIn.length() - 4);
        try (
            Writer outb = new OutputStreamWriter(new FileOutputStream(fileName + "_b.bin"), kodirovka);
            Writer outbb = new OutputStreamWriter(new FileOutputStream(fileName + "_bb.bin"), kodirovka);
            Writer outbb16 = new OutputStreamWriter(new FileOutputStream(fileName + "_bb16.bin"), kodirovka)
        ) {
            Path pathText = Paths.get(fileIn);
            byte[] text = Files.readAllBytes(pathText);

            for (byte word : text) {
                String b = Byte.toString(word);
                outb.write(b + " ");

                int intbb = word < 0 ? 256 + word : word;
                String bb = Integer.toString(intbb);
                outbb.write(bb + " ");

                String bb16 = Integer.toString(intbb, 16);
                outbb16.write(bb16 + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void task4_3() {
        reWriteInThreeBin("text_utf8.txt", "UTF8");
        reWriteInThreeBin("text_win1251.txt", "windows-1251");
        reWriteInThreeBin("text_koi8r.txt", "KOI8_R");
    }

    private static void task4_4() {
        try (Writer out = new OutputStreamWriter(new FileOutputStream("text_koi7r.txt"),"KOI8_R")) {
            Path pathText = Paths.get("text_koi8r.txt");
            byte[] text = Files.readAllBytes(pathText);

            for (byte word : text) {
                word = word < 0 ? (byte) (128 + word) : word;
                out.write(word + " ");
            }
            //Files.write(Paths.get("text_koi7r.txt"), text_utf8);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
