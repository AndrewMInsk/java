package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            //yourFile = new File("D:\\1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User firstUser = new User();
            firstUser.setFirstName("Jim");
            firstUser.setLastName("Beam");
            firstUser.setBirthDate(new Date(1508944516168L));
            firstUser.setMale(true);
            firstUser.setCountry(User.Country.OTHER);

            User secondUser = new User();
            secondUser.setFirstName("Jack");
            secondUser.setLastName("Daniels");
            secondUser.setBirthDate(new Date(1508944511163L));
            secondUser.setMale(true);
            secondUser.setCountry(User.Country.UKRAINE);
            javaRush.users.add(firstUser);
            javaRush.users.add(secondUser);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush);
            System.out.println(loadedObject);

            System.out.println(loadedObject.equals(javaRush));



            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        @Override
        public String toString() {
            return "JavaRush{" +
                    "users=" + users +
                    '}';
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User item: users){
                writer.println(item.getFirstName());
                writer.println(item.getLastName());

                String pattern = "SSS EEE MMM dd HH:mm:ss zzz yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
                String date1 = simpleDateFormat.format(item.getBirthDate());

                //System.out.println(date1);
                writer.println(date1);

                writer.println(item.isMale());
                writer.println(item.getCountry());
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            String line2="";
            String line3="";
            String line4="";
            String line5="";
            while(reader.ready()){
                line = reader.readLine();
                line2 = reader.readLine();
                line3 = reader.readLine();
                line4 = reader.readLine();
                line5 = reader.readLine();
                User user = new User();

                //String sDate1="Wed Oct 25 18:15:16 MSK 2017";
                Date date1=new SimpleDateFormat("SSS EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(line3);

                user.setBirthDate(date1);


                user.setFirstName(line);
                user.setLastName(line2);
                user.setMale(Boolean.parseBoolean(line4));

                if(line5.equals("OTHER"))user.setCountry(User.Country.OTHER);
                if(line5.equals("UKRAINE"))user.setCountry(User.Country.UKRAINE);
                if(line5.equals("RUSSIA"))user.setCountry(User.Country.RUSSIA);
                this.users.add(user);

            }



            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
