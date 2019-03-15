package semestr_3;

public class L1_OpenJDK {
    
    
    /*
Лекция об исключениях
    Обработка исключений, если нет трай-кэтч

    Пример, как раньше работала обработка ошибок
    Абстрактный код, так на жаве писать нельзя
    f = open ("a.txt")
    if (last.error != 0) { //0 - все хорошо
        print last.err.log(last.error (!))
        return //благодаря этому функция завершится и
                 не пойдет дальше, если все пойдет не так


    txt = read (f) { //0 - все хорошо
        print last.err.log(last.error (!))
        return
    }

    close(f) { //0 - все хорошо
        print last.err.log(last.error (!))
        return
    }

    вместо трех операций приходится делать три операции и три
    огромных кода на проверку ошибок

    может возникнуть исключение exeption
    если возникло - программа дальше не выполняется

    public void f (...) {
        появляется исключение
    }
    в джаве есть два варианта действий
    1) обработка исключения, например, сказать пользователю,
    что ошибка
    2) сказать, что мы не собираемся обрабатывать это исключение,
    явно отказываемся обработать

    как оно оформляется?
    2) если явно отказываемся, то дописываем, что оно кидает исключение
        public void f (...) throws exeption
        у всех функций в жава есть прописанные иселючения,
        которые они могут кинуть. это отображается и в помощи
        по функциям. в заголовке функциии говорится, что
        может что-то сломаться
        если мы так пищем, мы отдаем ответственность кому-тодругому
        тот, кто вызывает F, сам теперь должен решить, что делать:
        обработать исключение или отказаться и передать дальше
        ответственность
        единственное, когда не надо решать, если в main
        тоже есть throws exeption
        тогда ответственность за обработку падает на джаву
        она вызывает e.printStackTrace()

    1) как обработать исключение?
        есть функция void f() {
            //место кода, где что-то может пойти не так
            //например, вызов функции с throws
            //иногда и без нее, но чаще всего из-за нее
        }

        можно воспользоваться трай-кетч
            void f() {
                try () {
                    //место, где может случиться ошибка
                }catch(Exeption e){ - выполняется, если внутри трай
                                      был эксепшон
                                      будто заводится переменная
                                      типа эксепшн, где хранится
                                      инОрмация об ошибках
                чаще всего пишут
                }catch(Exeption e){
                    e.ptintStackTrace(!)
                    или можно
                    e.getMessage
                    или можно что-то написать
                }


    throws делятся на: 1) error - то, что вы не решите
                                  например, закончилась память
                                  если закончилась память - ничего
                                  не спасет (OutOfMemoryError)
                       2) exeption - все остальное, то, что имеет смысл
                                  обработать и проверить
                                  делятся на
                                        - возникающие сами по себе: (runtime exeption)
                                                -деление на ноль, DivideByZeroExep
                                                - выход за пределы массива ArrayOutOfBorder
                                                - NullPointer - когда присвоили Null и воспользовались
                                        -еще есть IDExeption
                                                -FileNotFoundExeption (не найден файл)

    по сути, все ошибки - это классы и их наследники
    можем создать свой класс для ошибки
    жаву критикуют, потому что нужно обязательно писать
    exeption все проверки нужно прописывать, кроме runtime exeption и throws

    Полная форма
    try {

    } catch (FileNotFound...Exeption e) {
    } catch (IO...Exeption e) {
    } catch (...Exeption e) {
    ...
    } finally {
        выполняется всегда после try
        и, возможно, catch
    }

    можно писать try (... - заводят переменные, они точно будут close())

    Оператор throw e
    throw new Exeption ("ошибка")
    throw new Exeption ()
    public class MyExeption extends Exeption{
    }
    throw new MyExeption
    catch(MyExeption e){
    }

    Задача1
        void  f(int x) throws Exepption MyExeption {
            //если x - чет, то исключ
            //если нечет - то ничего
        }

        в main
            for(i от 1 до 100)
                f(i)

        выведет
         1 - нет исключ
         2 - исключ
         3 - нет


    Задача2
        метод
        Integer.parseInt("242") - если не число, то исключенеие
                                  генерируется
            строку в число
        надо функцию int readInt(String message)

        использование
        int x = (readInt("введите x"));
        int y = -------//-----------
        sout ("x + y = " (x + y))

        чтобы читать с клавиатуры, надо пользоваться
        s = new Scanner(System.in) - поток того, что вводим на клавиатуре
        s.nextLine
     */
}