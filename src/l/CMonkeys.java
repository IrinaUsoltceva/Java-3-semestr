package l;

public class CMonkeys {

    //Принцип минимально пользоваться статическими методами
    //Хотя бы потому, что каждый раз приписывать надо слово статик:
    // относящийся к классу, а не объекту
//    И статический должен вызывать только статический, и в итоге всё стенет статическим
//    Но мейн обязан быть статическим, другие некоторые тоже
    public static void main(String[] args) {
        new l.CMonkeys(); //создаём одну программу про обезъянок
    }

    private int bananas = 1_000_000;
    private int total = 0;

    private CMonkeys() {
        //здесь основная логика программы будет
        //Одна обезъянка ест бананы
//        int eaten = 0;
//        while (bananas > 0) {
//            bananas--;
//            eaten++;
//        }
//        System.out.println(String.format("A monkey ate %,d bananas", eaten));
        //запятая разделила пробельчиками число

//        Нам нужно, чтобы две обезъянки ели одновременно, поэтому создаём два потока
        //Runnable - произвольный код, у него нет аргументов, не возвращает результат
        Runnable monkeyAction = () -> {
            int eaten = 0;
            while (bananas > 0) {
//                    в скобках указывается любой объект - монитор.
//                    Если первый поток взял монитор - внутри сихронайзд, и другой поток не может войти,
//                     пока монитор не вернут. Тут this это объект monkeys( НА ЭКЗАМЕНЕ СПРОСИТ)
//                    можно Object monitor new Object();
                synchronized (this) {
                    if (bananas > 0) {
                        bananas--;
                        eaten++;
                    }
                }
            }
            //eaten - локальная переменная у каждой обезъянки своя, а бананас глобальная.
//            после синхронизирования хорошо, но на один банан меньше они съели чем должно быть. самый последний банан они ели одновременно и получилось минус 1 банан в конце
//            обе обезъяны входят в вайл на псследнем банане, и уже нет выхода есть два, хотя остался один. добавим проверку
            synchronized (this) {
                //при глобальных переменных нужна синхронизация
                total = total + eaten;
            }
            System.out.println(String.format("A monkey ate %,d bananas", eaten));
            System.out.println(String.format("Total bananas is %,d", total));
        };

//        это когда две было
//        Thread monkey1 = new Thread(monkeyAction);
//        //new Thread(() -> {...}) можно было бы
//        Thread monkey2 = new Thread(monkeyAction);

//        monkey1.run();
//        monkey2.run();
//        то они будут по очереди есть, и второй ничего не достанется

//        это если десять их
        for (int i = 0; i < 10; i++) {
            Thread monkey = new Thread(monkeyAction);
            monkey.start();
        }

//        это для двух
//        monkey1.start();
//        monkey2.start();

//        одновременно будут. По идее должно быть примерно поровну, но там A monkey ate 720 239 bananas
//A monkey ate 967 559 bananas и оно ещё с каждым запуском разное
//        проблема в том, что bananas-- это взять значение бананов, уменьшить и записать обратно
// они едят один и тот же банан, но считают, что каждая по целому съела. Нужно синхронизировать
//        ПрОБЛЕМЫ

//        Участи кода,которые нельзя выполнять одновременно нескольким потокам нужны,
//        синхронизировать - ясно указывать, что только один потом может выполнять участок кода
//        Ключевое слово synchronize
//        но с ним ваще сложно, особенно если программа большая и потоков много
//        это самый низкоуровневый метод программирования


    }
}
