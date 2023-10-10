package ru.gb.exceptions;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args){
        //String name = null;
        //System.out.println(name.length());
        //Object object = new String("123");          //NullPointerException
        //File file = (File) object;
        //System.out.println(file);                   // ClassCastException
        //String number = "123fq";
        //int result = Integer.parseInt(number);
        //System.out.println(result);                 //NumberFormatException
        //List<Object> emptyList = Collections.emptyList();
        //emptyList.add(new Object());                //UnsupportedOperationException
        // int number = 1;
        // try {                                      // какой первый упадет, тот и будет
        //     number = 10 / 1;
        //     String test = null;
        //     Collections.emptyList().add(new Object());
        //     System.out.println(test.length());
        // } catch (ArithmeticException e) {
        //     System.out.println("На ноль делить нельзя!");
        // } catch (NullPointerException e) {
        //     System.out.println("Нуль поинтер экс");
        // } catch (Exception e){
        //     System.out.println("Exception");
        // }
        // System.out.println(number);
        FileReader text = null;
        try {
            text = new FileReader("C://Users//Почечуевы//OneDrive//Desktop//Учеба//Тестирование//Обработка ошибок Семинары//Lection2//.idea//.gitignore");
            //text.read();
        } catch (RuntimeException | IOException e){
            System.out.println("Catch exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Finally start");
            if (text != null){
                try {
                    text.close();
                } catch (IOException e) {
                    System.out.println("Exception while close");
                }
            }
            System.out.println("Finaly end");
        }


    }
}
