public class L3_1_Files {
    /*
    В жава существует две библиотеки для IO

    пакет java.io   - старый    (синхронный: если отправили читать программу -
                                она зависла, пока не принесет информацию)
    пакет java.nio  - новый     (асинхронный: можем что-то сделать, пока прога
                                несет информацию из файла)

    если что-то делаем с файлами, стараемся пользоваться новым

    Старый
        входной поток байтов - то, что можем читать
        InputStream
        Reader - аналогично, но не байт, а символов

        выходной поток байтов - байты, которые мы сами пишем
        OutputStream
        Writer - тоже аналогично, но не байт, а символов

        в чем разница?
        байты - универсальное, символы - менее универсальное
        один символ может занимать разное количество байт

        байт 0..255 (в жаве (-127..127)) - 256 различных чисел
        для джавы символ - элемент таблицы юникод
        (буквы, цифры, знаки препинания, пробелы, переводы строки, мат.символы
        интегралы, волшебные символы - диакритических знаков? а, умлауты
        огромное количество графики - смайлики всех видов, символы "с этого
        символа текст пишется справа налево"
        псевдографики оч много)
        эта таблица сопоставляет какой-то символ с каким-то числом
        ридер - это потоки двехбайтовых кодов
        кодировка - это таблица соответствия символа и чслового представления,
        т.е. кода этого символа

        какие еще есть кодировки?
            сз866           (DOS)
            windows 1251    (win)
            koi 8-r
            utf-8
            ACII
        это что есть для русского языка, а если мы в другой стране, то кодировки тож другие


        ASCII 7бит - байт без олного бита
            сопоставляет элементы для первых 127 чисел
            кодировка для половины всего из байта
            32 - пробел
            10 - перевод строки
            13 - возврат каретки
            48 - "0"
            57 - "9"
            практически все занимает латинский алфавит

        cp866 - ASCII и вторая половина
            128-255 - русские буквы
            остальное - символы псевдографики и кириллические символы
                        других алфавитов других языков

        win1251 - тоже русские буквы, идут с конца (я - самый последний символ)

        coi8 - скажем позже

        utf8 - ASCII - овместное представление UNICODE
            в предыдущих 1 байт для 1 символа
            тут от 0 до 127 байт - это ASCII символ
            байт от 128 до 255 - считается еще несколько байт вперед
            юникод имеет разное количество байт на символ
            пишем по англицки - 1 байт на 1 символ
            пишем по-русски - может быть больше, займет больше места
            сложно раскодировать

            зато может закодировать любой символ из UNICODA,
            поэтому ей рекомендуют пользоваться всегда

        Советы:
            1)
            InputStream <-> Reader
            OutputStream <-> Writer
            <-> - кодировка, ее указывать явно!

            2)
            хранить все в utf-8, преобразовывать другие кодировки в utf-8

            есть два мира - символы и байты, а между ними - кодировки

        что умеет InputStream
            - int read () - читает 1 байт (-1, если конец)
            - out read (byte[] buf - читает несколько байт в буфер)
            - close() - не вызывать самим, делать через трай-кэтч

        что умет Output Stream?
            - write (byte b)
            - write (byte[] buf)
            - close()
            - flush() - протолкнуть, чтобы все, что написали, заставили протолкнуть на устройство
                    [прог] -> [OS](тут все копится, а потом отправляется дальше) -> [диск]

        Reader, Writer - аналогично

        FileInputStream <- IS, связанный с файлом
        FileOutputStream <- OS, связанный с файлом
        FileReader <- R, связанный с файлом
        FileWriter <- W, связанный с файлом - не рекомендуется, тк нельзя указать кодировку

        OutputStreamWriter
        InputStreanReader <- превращают OS в Writer, IS в Reader

        прочитать текст из файла
        try (Reader in = new InputStreamReader(new FileInputStream("a.txt"), "utf-8"))

        Buffered -> InpStream       обертка - сохранит данные в промежуточном буфере
                 -> OutputStream    и будет читать оттуда. для производительности
                 -> Reader          + есть доп. возможности, например в Buffered Writer
                 -> Writer          есть метод перевод строки
        try(BufferedReader in = new BR(new ISR(new FIS("a.txt")"utf-8")))
            in.readerline()



     */
}
