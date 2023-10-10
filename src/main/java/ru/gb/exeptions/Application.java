package ru.gb.exeptions;

import java.io.File;

public class Application {

    public static void main(String[] args){
    /*   c();
    }

    public static void a(){
        b();
    }

    public static void b(){
        c();
    }

    public static void c(){

        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }
    //    System.out.println(getFileSize(new File("C://Users//Почечуевы//OneDrive//Desktop//Учеба//Тестирование//Обработка ошибок Семинары//seminar1/TestFile")));
      */  System.out.println(divide(10,0));
    }
    public static int divide(int a1, int a2){
       if (a2 == 0){
            throw new RuntimeException("Divide by zero not permited");
       }
        return a1/a2;
    }

    /*public static long getFileSize(File file){
        if (!file.exists()){
            return -1;
        }
        return file.length();
    }

     */


}