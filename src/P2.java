import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2 {


    public static String reverseComplement(String dna){
        String result="";
        for (int i = 0; i <dna.length() ; i++) {
            char symbol=dna.charAt(i);
            switch (symbol){
                case 'A':{
                    result="T"+result;
                    break;
                } case 'C':{
                    result="G"+result;
                    break;
                } case 'T':{
                    result="A"+result;
                    break;
                } case 'G':{
                    result="C"+result;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        File file=new File("src/rosalind_revc.txt");
        try {
            Scanner scanner=new Scanner(file);
            String dna=scanner.nextLine();
            System.out.println(reverseComplement(dna));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
