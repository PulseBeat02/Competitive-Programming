package training_program;

/*
ID: brandonli
LANG: JAVA
TASK: gift1
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class gift2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("gift1.in"));
        PrintWriter pw = new PrintWriter(new File("gift1.out"));

        int np = sc.nextInt();
        List<String> people = new ArrayList<String>();
        for (int i = 0; i < np; i++) {
            people.add(sc.next());
        }

        Map<String, Integer> received = new HashMap<String, Integer>();
        for (String person : people) {
            received.put(person, 0);
        }
        Map<String, Integer> initial = new HashMap<String, Integer>();

        for (int i = 0; i < np; i++) {
            String person = sc.next();
            int amount = sc.nextInt();
            int recipients = sc.nextInt();

            initial.put(person, amount);

            int giftAmount = 0;
            if (recipients > 0) {
                giftAmount = amount / recipients;
                received.put(person, received.get(person) + amount % recipients);
            }
            for (int j = 0; j < recipients; j++) {
                String recipient = sc.next();
                received.put(recipient, received.get(recipient) + giftAmount);
            }
        }

        for (String person : people) {
            pw.println(person + " " + (received.get(person) - initial.get(person)));
        }

        pw.close();
        sc.close();
    }
}