import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfKeys = 10;
        int[] randomKeys = new int[numberOfKeys + 1];
        int[] dummyKeys = new int[numberOfKeys + 1];

        NumberGenerator generator = new NumberGenerator(numberOfKeys);

        String keysFilePath = "./" + numberOfKeys + ".keys.txt";
        String dummyKeysFilePath = "./" + (numberOfKeys + 1) + ".dummyKeys.txt";

        randomKeys = parseFile(randomKeys, keysFilePath);
        dummyKeys = parseFile(dummyKeys, dummyKeysFilePath);

        ProbabilityCalculator probabilities = new ProbabilityCalculator(randomKeys, dummyKeys);
        OptimalBST obst = new OptimalBST(probabilities.getP(), probabilities.getQ(), randomKeys);
    }

    public static int[] parseFile(int[] targetArray, String filePath){
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));

            for(int i = 0; sc.hasNextLine(); i++){
                targetArray[i] = Integer.parseInt(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return targetArray;
    }
}
