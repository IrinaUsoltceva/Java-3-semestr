import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class T3 {
    public static void main(String[] args) {
        task3();
    }

    private static void task3() {
        List<String> fileNames = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        try {
            for (String fileName : fileNames) {
                Path old = Paths.get("t3_katalog\\\\" + fileName + ".txt");
                Path updated = Paths.get("t3_katalog\\\\" + String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName + ".txt");

                //для возвращения без номеров
                //Path old = Paths.get("t3_katalog\\\\" + String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName + ".txt");
                //Path updated = Paths.get("t3_katalog\\\\" + fileName + ".txt");

                Files.move(old, updated, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }

        /*
            Например, если был список a.txt, b.txt, то нунжо переименовать файлы в 1 a.txt и 2 b.txt.
            Для каждого файла выведите, удалось ли его переименовать, а если нет, то что именно пошло не так.
            Проследите, чтобы не выводилось лишней информации об ошибках наподобие содержимого стека.
            Используйте метод Files.move().

            Files.move(source, dest, ...)
                    :Path  :Path ещо опции
                                StandartCopyOption.REPLACE_EXISTING

         */
    }
}
