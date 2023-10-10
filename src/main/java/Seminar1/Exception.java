package Seminar1;

public class Exception {
    public static void main(String[] args) {
        System.out.printf("Длинна массива: %d", task1(new int [] {4, 3, -1}));
    }
        /**
         Задача 1
         ********
         Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
         Если длинна массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки
         Иначе - длинну массива.
         */
        static int task1(int[] arr){
            if (arr == null){
                return -2;
            }
            if (arr.length == 0){
                return -1;
            }
            return arr.length;
        }

}
