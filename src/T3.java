import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class T3 {
    public static void main(String[] args) {
        task3();
    }

    private static void task3() {
        List<String> fileNames = Arrays.asList("a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt");
        String catalogName = "t3_katalog";

        try {
            for (String fileName : fileNames) {
                Path old = Paths.get(catalogName + "\\\\" + fileName);
                String newFileName = String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName;
                Path updated = Paths.get(catalogName  + "\\\\" + newFileName);

                //для возвращения без номеров
                //Path old = Paths.get("t3_katalog\\\\" + String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName);
                //Path updated = Paths.get("t3_katalog\\\\" + fileName);

                Files.move(old, updated, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(fileName + " Успешно переименован в " + newFileName);
            }
        } catch (IOException e) {
            System.out.println("Не удалось переименовать Файл, ошибка");
            System.out.println("Что-то не так с " + e.getMessage());
        }

        /*
            "UnsupportedOperationException – if the array contains a copy option that is not supported, - что-то не то в массиве" +
            "java.nio.file.DirectoryNotEmptyException – the REPLACE_EXISTING option is specified but the file
                                        cannot be replaced because it is a non-empty directory (optional specific exception)" +
                                        " - папка не пуста, поэтому нельзя переместить файл?" +
            "java.io.IOException – if an I/O error occurs - ошибка в вводе/выводе");


            Для каждого файла выведите, удалось ли его переименовать, а если нет, то

            что именно пошло не так.
            Проследите, чтобы не выводилось лишней информации об ошибках наподобие содержимого стека.

         */
    }
}
