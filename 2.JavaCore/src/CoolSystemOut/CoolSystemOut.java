package CoolSystemOut;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoolSystemOut {
    static PrintStream consoleStream = System.out;

    public static void colPrint(String str){
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        //выводим ее в консоль

        System.setOut(consoleStream);
        System.out.println(result);
        System.out.println((char)27 + "[32m" + str + (char)27 +  "[0m");
    }

    public static void main(String[] args) {
        CoolSystemOut.colPrint("sdfsf");
        printSomething();

        printSomething();

    }



    public static void printSomething()
    {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}
