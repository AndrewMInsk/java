package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {


           // File your_file_name = File.createTempFile(filename1, null);
            String filename1 = "D:\\2.txt";
            File your_file_name = new File(filename1);

            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov);
            System.out.println(somePerson);


            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
//            System.out.println(ivanov.equals(somePerson));
//            inputStream.close();
//
//            PrintStream edfg = System.out;
//            ByteArrayOutputStream ter = new ByteArrayOutputStream();
//            PrintStream test = new PrintStream(ter);
//            System.setOut(test);
//
//
//            InputStream dsf = System.in;
//            InputStream  df= new ByteArrayInputStream(somePerson.toString().getBytes());
//            System.setIn(df);



            Human cat = new Human();
            cat.name="asdad";
            //save cat to file
            FileOutputStream fileOutput = new FileOutputStream("D:\\2.txt");
            ObjectOutputStream outputStream1 = new ObjectOutputStream(fileOutput);
            outputStream1.writeObject(cat);
            fileOutput.close();
            outputStream1.close();
//cat.name="";
            //load cat from file
            FileInputStream fiStream = new FileInputStream("D:\\2.txt");
            ObjectInputStream objectStream = new ObjectInputStream(fiStream);
            Object object = objectStream.readObject();
            fiStream.close();
            objectStream.close();

            Human newCat = (Human)object;
            System.out.println(newCat);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;
            System.out.println(name);
            Human human = (Human) o;
            System.out.println(name);
            if (name == null) {
                //System.out.println("не понимаю");
            }

            if (name == null ? !name.equals(human.name) : !human.name.equals(this.name)) {
                //System.out.println("в чем прикол?");
                return false;
            }
            return this.assets != null ? this.assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", assets=" + assets +
                    '}'+hashCode();
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            //System.out.println(result);
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets)
                    printWriter.println(current.getName());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));
            reader.close();
        }
    }
}
