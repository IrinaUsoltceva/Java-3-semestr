public class L3_2_Files {
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

     */
}
