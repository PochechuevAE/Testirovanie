package Seminar1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exception {

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.printf("Длина массива: %d\n", task1(new int[] {4, 3, -1}));
        //task2();
        //task3();
        //task4();
        task5();
    }

    /**
     Задача 1
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
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

    /**
     Задача 2
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     3. если вместо массива пришел null, метод вернет -3
     4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
     Напишите метод, в котором реализуйте взаимодействие с пользователем.
     То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     обработает возвращенное значение и покажет читаемый результат пользователю.
     Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    static void task2(){
        while (true){
            System.out.print("Укажите значение для поиска: ");
            int searchNumber = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(5) + 1];
            if (random.nextInt(3) == 0){
                array = null;
            }
            if (array != null){
                for (int i = 0; i < array.length; i++){
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }
            int codeResult = processArray(array, searchNumber);
            switch (codeResult){
                case -1 -> System.out.println("Кол-во элементов массива менее 3х");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массив некорректно проинициализирован");
                default -> {
                    System.out.println("Массив успешно обработан. Завершение работы приложения.");
                    System.out.printf("Элемент найден по индексу: %d", codeResult);
                    return;
                }
            }
        }

    }

    static int processArray(int[] arr, int searchElement){
        if (arr == null){
            return -3; // Массив некорректно проинициализирован
        }
        if (arr.length < 3){
            return -1; // Кол-во элементов массива менее 3х
        }
        Arrays.sort(arr);
        for (int e: arr)
            System.out.printf("%d\t", e);
        System.out.println();
        int searchResult = Arrays.binarySearch(arr, searchElement);
        if (searchResult < 0)
            return -2; // Элемент не найден
        return searchResult;
    }

    /**
     Задача 3
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     Необходимо посчитать и вернуть сумму элементов этого массива.
     При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибки.
     */

    static void task3(){
        for (int i = 0; i < 5; i++){
            processArray(generateArray());
        }
    }

    static void processArray(int[][] array){
        if (array.length != array[0].length)
            throw new RuntimeException("Некорректная размерность массива");

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j= 0; j < array[i].length; j++){
                if (array[i][j] != 0 && array[i][j] != 1)
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу: [%d][%d]",
                            i, j));
                else
                    sum += array[i][j];
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    static int[][] generateArray(){
        int[][] array = new int[random.nextInt(4, 6)][5];
        for (int i = 0; i < array.length; i++){
            for (int j= 0; j < array[i].length; j++){
                array[i][j] = random.nextInt(2);
            }
        }
        if (random.nextInt(3) == 0){
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = 2;
        }
        for (int i = 0; i < array.length; i++){
            for (int j= 0; j < array[i].length; j++){
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return array;
    }

    /**
     Задача 4
     ========
     Переработать реализацию задачи 3 с использованием кодов ошибок
     */

    static void task4(){
        for (int i = 0; i < 5; i++){
            int errCode = processArrayV2(generateArray());
            switch (errCode){
                case -1 -> System.out.println("Некорректный размер массива");
                case -2 -> System.out.println("Некорректное значение массива");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errCode);
                }
            }
        }
    }


    static int processArrayV2(int[][] array){
        if (array.length != array[0].length)
            return -1;
        //throw new RuntimeException("Некорректная размерность массива");

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j= 0; j < array[i].length; j++){
                if (array[i][j] != 0 && array[i][j] != 1)
                    return -2;
                    //hrow new RuntimeException(String.format("Некорректное значение элемента массива по индексу: [%d][%d]",
                    //        i, j));
                else
                    sum += array[i][j];
            }
        }
        //System.out.printf("Сумма элементов массива: %d\n", sum);
        return sum;
    }

    /**
     Задача 5
     ========
     Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     входящих массивов в той же ячейке.
     Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */

    static void task5(){

        try
        {
            int[] res = getSumArray(new int[] {1, -2, 3, 6}, null);
            for (int e: res)
                System.out.printf("%d\t", e);
            System.out.println();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.println("Длина первого массива: " + e.getLength1());
            System.out.println("Длина второго массива: " + e.getLength2());
        }

    }

    static int[] getSumArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.",
                    arr1.length, arr2.length);
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }}




