public class JvmComprehension {
    // Класс JvmComprehension отдается для загрузки в систему ClassLoader'ов и перемещается в Metaspace.

    public static void main(String[] args) { // В момент вызозова метода он помещается в стэк
        int i = 1;                      // Переменная i помещается в стэк в блок метода main
        Object o = new Object();        // Создается экземпляр класса Object, ссылка на него помещается в блок метода
        // main, класс Object помещяется в кучу
        Integer ii = 2;                 // Создается экземпляр класса Integer, ссылка на него помещается в блок метода
        // main, класс Integer помещяется в кучу
        printAll(o, i, ii);             // Вызывается метод, создается новый блок в стэк, после выполнения метода
        // сборщик удаляет ненужные экземпляры
        System.out.println("finished"); // В консоль выводится запись "finished".
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // В куче создается значение типа Integer - "700" ссылочной
        // переменой "uselessAll", которая помещается во фрейм "printAll" и ссылается на это значение в куче
        System.out.println(o.toString() + i + ii);  // Класс System находится в Metaspace, у него вызывается метод
        // .out который помещается в стэк.
    }
}
