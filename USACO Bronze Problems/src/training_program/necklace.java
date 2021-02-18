package training_program;

/*
ID: brandonli
LANG: JAVA
TASK: beads
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class beads {
   
    public static int chainLength (String s) {
        char [] sChar=s.toCharArray();
        int count=1;
        char lastColour=sChar[0];
        char currColour;
        boolean switchedColour=false;
        for (int i=1;i<sChar.length;i++) {
            currColour=sChar[i];
            if (currColour=='w') {
                count++;
            } else {
                if (lastColour=='w' || lastColour==currColour) {
                    lastColour=currColour;
                    count++;
                } else {
                    if (switchedColour) {
                        break;
                    } else {
                        switchedColour=true;
                        lastColour=currColour;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("beads.in"));
        br.readLine();
        String line=br.readLine();
        int maxLength=0;
        for (int i=0;i<line.length();i++) {
            int currLength=chainLength(line.substring(i,line.length())+line.substring(0,i));
            if (currLength>maxLength) {
                maxLength=currLength;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        pw.println(maxLength);
        pw.close();
        br.close();
        System.exit(0);
    }
}