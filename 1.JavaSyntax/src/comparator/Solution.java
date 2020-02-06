package comparator;

import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {

        List<Message> messages = new ArrayList();
        MessageComparator pcomp = new MessageComparator();

        Solution test = new Solution();
        Solution test2 = new Solution();
        System.out.println(test.hashCode() + "!!!"+test2.hashCode());


        TreeSet<Message> people = new TreeSet<Message>(pcomp);
        people.add(new Message("Tom"));
        people.add(new Message("Nick"));
        people.add(new Message("Alice"));
        people.add(new Message("Bill"));

        for(Message p : people){

System.out.println(p.getId());
        }


    }


    public static class Message{


        private String message;
        private int id;

        public Message(String message) {
            this.message = message;
            this.id = new Random().nextInt(1000);
        }
        public String getMessage() {
            return message;
        }
        public Integer getId() {
            return id;
        }
        public String toString() {
            return "[" + id + "] " + message;
        }


    }

}
class MessageComparator implements Comparator<Solution.Message>{

    public int compare(Solution.Message a, Solution.Message b){
        return a.getId().compareTo(b.getId()); }
}
