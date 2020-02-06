package Computer;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeIt {

    static class Test1 extends Thread{
        Test1(String name){
            super(name);
        }
        public void run(){
            System.out.println(getName());

            for(int i=0;i<100000;i+=500){
                System.out.println(i);
            }

        }
    }
    static class Test2 extends Thread{
        Test2(String name){
            super(name);
        }
        public void run(){
            System.out.println(getName());

            for(int i=0;i<100000;i+=500){
                System.out.println(i);
            }

        }
    }

    public static void main(String[] args) {

        new Test1("name1").start();
        new Test1("name2").start();
        new Test2("name3").start();
        new Test2("name4").start();


        String keyboardName="";
        String keyboardManufacturer="";
        int keyboardPrice=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{


            System.out.println("Давайте соберем вам новый компьютер!");
            System.out.println("Введите название вашей клавиатуры");

            keyboardName = reader.readLine();
            System.out.println("Введите производителя вашей клавиатуры");

            keyboardManufacturer = reader.readLine();
            System.out.println("Введите стоимость вашей клавиатуры");

            while (true) {
                try {
                    keyboardPrice = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Цена должна быть числом");
                }
            }

            System.out.println("Отлично, с клавитурой разобрались");
            System.out.println("Готовы отдать 250 долларов за мышь?");
            while(true) {
                String answer = reader.readLine();
                if(answer.toLowerCase().equals("да")){

                    int money = (int) (Math.random()*50000);
                    System.out.println("Мы готовы собрать вам компьютер за " + money + " USD");
                    break;}
                if(answer.toLowerCase().equals("нет"))
                    break;
                System.out.println("Отвечайте нормально, пожалуйста");
            }




        Computer computer = new Computer(new Keyboard(keyboardName,keyboardManufacturer,keyboardPrice), new Mouse("M170", "Logitech",250),
                new Monitor("AGON", "AOC",500));
        System.out.println("Вот что у нас получилось:");
        System.out.println(computer);

        System.out.println("А теперь поиграем с числами");
        System.out.println("Введите через пробел несколько чисел: ");
        int minValue = Integer.MAX_VALUE;

            while (true) {
                    String numbers = reader.readLine();
                    while (numbers.contains("  ")){
                        numbers = numbers.replace("  "," ");
                    }
                    numbers = numbers.trim();

                    ArrayList<Integer> list = new ArrayList<Integer>();
                        try {
                            for (String item : numbers.split(" ", 0)){
                                list.add(Integer.parseInt(item));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Вводите только числа");
                        }
                        int mesto = 0;
                        for(int i=0;i<list.size();i++){
                            for(int j=i;j<list.size();j++){
                                if(minValue>list.get(j)){
                                    minValue=list.get(j);
                                    mesto = j;
                                }
                            }
                            int temp = list.get(i);
                            list.set(i,minValue);
                            list.set(mesto,temp);
                        }
                if(minValue!=Integer.MAX_VALUE){
                    break;
                }
            }
            System.out.println("Минимальное число: "+ minValue);
        }
        catch (IOException e){
            System.out.println("Не могу это прочитать!");
            System.out.println("На этом наши полномочия всё");
        }
            finally {
            // Закрывать тут нечего
        }

    }





}
