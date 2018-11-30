package fractali;

public class FractalCircle implements Fractal {
    @Override
    public double getColor(double x, double y) {
        if (x * x + y * y < 1)
            return 1;
        else
            return 0;
    }


/*
    сами с серой палитрой?...

    в центре 0, далеко от центра - 1, в самом круге меняется
    граница круга как фон белая, а центр черная, а от центра дотуда градиентом

            1) корень из (x^2 + y^2) - равномерный градиент
            2) x^2 + y^2 - немного быстрее, на сферу похоже будет */
}
