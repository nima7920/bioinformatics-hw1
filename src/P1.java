import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1 {


    public static String processFile(Scanner scanner){

        String currentID="";
        int currentLength=0,currentG=0,currentC=0;

        String maxID="";
        double maxRatio=0.0;

        boolean starting=true;
        while(scanner.hasNext()){
            String line=scanner.nextLine();
            if(line.startsWith(">")){

                if(!starting){
                    double currentRatio=(double)(currentC+currentG)/currentLength;
                    if(currentRatio>maxRatio){
                        maxRatio=currentRatio;
                        maxID=currentID;
                    }
                }
                currentID=line.substring(1);
//                System.out.println(currentID);
                currentLength=0;
                currentC=0;
                currentG=0;
                starting=false;


            }else{
                currentLength+=line.length();
                currentC+=line.split("C",-1).length-1;
                currentG+=line.split("G",-1).length-1;
//                System.out.println(currentLength+"/"+currentG+"/"+currentC);
            }

        }
        double currentRatio=(double)(currentC+currentG)/currentLength;
//                    System.out.println(currentLength+"/"+currentG+"/"+currentC);

//                    System.out.println(currentRatio);
        if(currentRatio>maxRatio){
            maxRatio=currentRatio;
            maxID=currentID;
        }
        maxRatio=maxRatio*100.0;
        String maxRatioStr= String.format("%.06f", maxRatio);
        return maxID+"\n"+maxRatioStr;
    }
    public static void main(String[] args) {

        File file=new File("src/rosalind_gc.txt");
        try {
            Scanner scanner=new Scanner(file);
            System.out.println(processFile(scanner));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
