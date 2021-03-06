package semestr_3.ljavafx;

public class L5_Pane {
}

/*
#Pane
    панели позволяют располагать на себе другие элементы интерфейса.
    Например, кнопки, поля ввода текста, другие панельки.
    Разные виды панелей (HBox, VBox, GridPane и т.п.) отличаются тем, что по-разному
    описывают, как на них располагаются элементы

    Например, HBox располагает по горизонтали, Vbox по вертикали, GridPane - в виде сетки

    Pane - базовый класс для всех панелей, он не располагает элементы сам, в нем можно указать
    произвольные координаты элементов, но пользоваться этим нужно только при крайней необходимости


##Constrains
    Ограничения. Они позволяют указать параметры расположения элементов внутри панели
    Т.е. панель при расположении элементов руководствуется дополнительными пожлеаниями в расположении, з
    взятыми из Constraints

    Пример Constraints -Insets, соответствует margin, padding в CSS

    Другой пример, в HBox элементы располагаются по горизонтали друг за другом, а с помощью constraint можно
    указать выравнивание по вертикали

    У каждого вида панели свой набор constraint

##Preferred size

    Предпочитаемый размер компонента.
    Каждый Region знает размер, который ему хочется иметь. Это размер, который позволяет отобразить
    все содержимое. НАпример, для кнопки предпочитаемый размер соответствует тексту и шрифту
    кнопки.


    У панелей предпочитаемый размер вычисляется на осонве предпочитаемых размеров содержимого.
    В этом размере помещается все содержимое панели, и не остается лишнего пространства.

    Компонент не обязательно имеет размер, соответствующий Preferred sixe

    Еще бывает размеры MinimalSize и MaximalSize, компонент никогда не будет меньше или больше
    этих размеров


##Разные Pane

### HBox
    смотри пример в коде

### VBox
    аналогично HBox, но элементы по вертикали

### BorderPane
    позволяет расположить пять узлов. Сверху, снизу, слева, справа, по центру.

*Constraints:*

    'alignment' - где расположен элемент, если он не растянут на всю область.
                Снизу слева, снизу справа, по центру и т..п.

    'margin' - отступы.
            Какпой их пяти - этот constraint указывается кодом

            '''
            BorderPane.setLeft(...)
            BorderPane.setCenter(...)
            ...
            '''

### FlowPane
    элементы располагаются друг за другом, слева направо, а если место по горизонтали
    кончается, элемент переносится на слежующую "строку"

    Можно устанавливать промежутки между элементами hgap, vgap
    Можно выкладывать элементы не по горизонтали, а по вертикали, свойство 'Orientation'

###GridPane
    в соед.раз. Это удобный Pane, часто будем использовать

###TilePane
    Как FlowPane, но все элементы приводятся к одному размеру


 */
