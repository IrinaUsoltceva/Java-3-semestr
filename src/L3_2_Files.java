public class L3_2_Files {
    public static void main(String[] args) {
        String text = "1234.txt";
        System.out.print(text.substring(0, text.length() - 4));
    }
    /*
    В java.io
    Класс File - путь на диске

    В java.nio
    Класс Path - путь

    можно превращать друг в друга
        new File("a.txt").toPath()

        сразу Path
                    Path.set("..")
                    Path.set("c:/windows")
                    Path.set("c:/windows", "a.txt")


    Класс Files - вспомогательный файл для работы с файлами
        Примеры
        Files.move(source, dest, ...)    удобнее, чем File.move
                    :Path  :Path ещо опции
                                StandartCopyOption.REPLACE_EXISTING

    byte[] Files.readAllBytes(Path)
    String[] Files.readAllLines(Path)

    Files.write(Path, byte[]), ...(опции))
    Files.write(Path,_____(коллекция строк)____, Charset(опции))

    хотим прочитать файл, как одну строку
    byte[] allBytes = Files.readAllBytes(..)

    (byte[])  -> newString(byte[], кодировка -> (String)
    (byte[])  <- String.getBytes(кодировка) <- (byte[], кодировка <- (String)


    //для возвращения без номеров
    //Path old = Paths.get("t3_katalog\\\\" + String.valueOf(fileNames.indexOf(fileName) + 1) + " " + fileName);
    //Path updated = Paths.get("t3_katalog\\\\" + fileName);

     */

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
