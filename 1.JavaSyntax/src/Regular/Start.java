package Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {
    public static void main(String[] args) {

        String text = "Иванов Иван Иванович 31 12 1950";
        //Pattern pattern = Pattern.compile("^.+?\\s{1}");
        Pattern pattern = Pattern.compile(".+?\\s{1}");


       String[] test = pattern.split(text); //в массив
        for (String item: test) {
            System.out.println(item);
        }
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int start=matcher.start();
                int end=matcher.end();
                System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
            }

        String text2 = "Егор Алла Анна";
        Pattern pattern2 = Pattern.compile("А.+?а");

        Matcher matcher2 = pattern2.matcher(text2);
        while (matcher2.find()) {
            int start2=matcher2.start();
            int end2=matcher2.end();
            System.out.println("Найдено совпадение " + text2.substring(start2,end2)
                    + " с "+ start2 + " по " + (end2-1) + " позицию");
        }
    }
}
