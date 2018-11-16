package ljavafx;

public class T8_fractali {
    /*
    фракталы - геометрические
             - аналитические

        например, треугольник, в нем по серединам сторон треугольник и тд

    у нас будет фрактал мандельброта (оч красиво)

    */

    /***
    Color в JavaFX "фабричные" методы
    Color.rgb(0,0,255) - синий

    Color.gray(0,5)
                ^<-- 1/2 между белым и черным, 0 - черный, 1 - белый
    color.hsb(270,1,1)
                ^<-- оттенок от 0 до 360, насыщенность, яркость
     ***/

    /*
    интерфейс Fractal {
        double getColor (double x, double y)
           ^
           |
           от 0 до 1 [    ]
                        ^<--- каждому числу от 0 до 1 палитра сопоставит цвет
    }

     интерфейс Palette {
        Сolor getColor (double ind)
    }
    гет колор дает номер, а палитра превращает в отдельный цвет

    class BlackwhitePalette implements Palette {
        @Override
        public Color getColor(double ind) {
            if (ind < 0,5)
                return Color.BLACK;
            else
                return Color.WHITE;
        }

        будет палитр меньше половинки - черная, больша -  белая.
        самим - градиент
        ??......
    }

    будем делать круг радиуса 1. внутри круга цвет 0, снаружи - цвет 1

    class CircleFractale implement Fractal
        @override
        public double getColor(
            double x,
            double y) {
                if (x * x + y * y < 1)
                    return 1;
                else
                    return 0;
            }

            сами с серой палитрой?...

            в центре 0, далеко от центра - 1, в самом круге меняется
            граница круга как фон белая, а центр черная, а от центра дотуда градиентом

            1) корень из (x^2 + y^2) - равномерный градиент
            2) x^2 + y^2 - немного быстрее, на сферу похоже будет

    Мандельброт
    как координаты превращаются в цвет??

    как предлагается это программировать

    чтобы нарисовать
    1. Writeable Image - это Image (подходит для ImageView)
    у которого можно менять отдельные пиксели
    WI wi - new WI (ширина, высота);

    PixelWriter pw = wi.getPixelWriter();
    pw.setColor(0,0,color.RED)
    раскрасит (0,0) в красный, то есть, левуй верхний угол


    ИДЕЯ
    у нас есть две совершенно разных системы координат

    одна - компуктерная, из левого угла
    (0,0)
    -------------------------> WI x
    |
    |       а тут круг
    |           ^  y'
    |           |
    |           |
    |      ------------> x'
    |           |
    |           |
    |
    \/ y

    у картинки есть ширина высота
    как у размеров окна, меняем окно - меняется картинка
    но это потом, начинаем с 400х400 пикселей, фиксированной
    в таком случае центр круга можно сделать 200, 200

    и нам нужно ументь превращать одну систуему координат в другую
    тогда нужно задать преобразование системы координат
    x0, y0 - координаты

     */
}
