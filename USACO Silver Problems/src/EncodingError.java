import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodingError {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("encodingerror.txt"));
        List<Integer> list = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            list.add(Integer.parseInt(line));
            line = br.readLine();
        }
        System.out.println("Part One: " + calculate(list, 5));
    }
    public static int calculate(List<Integer> list, int preamble) {
        for (int i = preamble; i < list.size(); i++) {
            if (!checkValidity(list, i, preamble)) {
                return list.get(i);
            }
        }
        return -1;
    }

    public static boolean checkValidity(List<Integer> list, int index, int preamble) {
        List<List<Integer>> test = new ArrayList<>();
        for (int i = index - preamble; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                test.add(Arrays.asList(list.get(i), list.get(j)));
                if (list.get(i) + list.get(j) == list.get(index)) {
                    return true;
                }
            }
        }
        System.out.println(test);
        return false;
    }

}