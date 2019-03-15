package semestr_3;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class T3_File_renaming {

    private static final String CATALOG_NAME = "t3_katalog";

    public static void main(String[] args) {
        task3();
    }

    private static void task3() {
        List<String> fileNames = Arrays.asList("a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt");
        for (String fileName : fileNames) {
            try {
                Path old = Paths.get(CATALOG_NAME, fileName);
                String newFileName = String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName;
                Path updated = Paths.get(CATALOG_NAME, newFileName);

                Files.move(old, updated, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(fileName + " Успешно переименован в " + newFileName);
            } catch (DirectoryNotEmptyException e) {
                System.out.println("Не удалось переименовать Файл " + fileName + ", ошибка");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Не удалось переименовать Файл, ошибка");
                System.out.println("Что-то не так с " + fileName);
                System.out.println(e.getMessage());
            }
        }
    }
}
