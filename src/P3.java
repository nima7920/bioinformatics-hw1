import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3 {

    public static String produceStrings(String[] symbols, int n) {
        String result = "", currentString = "";
        int symbolNum = symbols.length;

        for (int i = 0; i < n; i++) {
            currentString += symbols[0];
        }
        result += (currentString + "\n");
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < symbols.length; j++) {
                currentString = currentString.substring(0, i);
            }
        }
        return result;
    }

    public static List<String> generateStrings(String[] symbols, int n) {
        if (n == 1) {
            List<String> results = new ArrayList<>();
            for (int i = 0; i < symbols.length; i++) {
                results.add(symbols[i]);
            }
            return results;
        }
        List<String> results = new ArrayList<>();
        List<String> preResults = generateStrings(symbols, n - 1);
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < preResults.size(); j++) {
                String currentString = symbols[i] + preResults.get(j);
                results.add(currentString);
            }
        }
        return results;
    }

    public static void main(String[] args) {

        File file = new File("src/rosalind_lexf.txt");
        try {
            Scanner scanner = new Scanner(file);
            String[] symbols = scanner.nextLine().split(" ");
            int n = Integer.parseInt(scanner.nextLine());
            List<String> result=generateStrings(symbols,n);
            for (int i = 0; i <result.size() ; i++) {
                System.out.println(result.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
