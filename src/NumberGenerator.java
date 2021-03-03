import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class NumberGenerator {
    private int[] randomKeys;
    private int[] dummyKeys;
    private Sort keySorter;
    private Sort dummySorter;
    private Random generator;
    private File file;

    public NumberGenerator(int numKeys) {
        generator = new Random();
        randomKeys = new int[numKeys + 1];
        dummyKeys = new int[numKeys + 1];

        for(int i = 0; i < randomKeys.length; i++){
            randomKeys[i] = generator.nextInt((1000 - 1) + 1) + 1;
        }

        for(int j = 0; j < dummyKeys.length; j++){
            dummyKeys[j] = generator.nextInt((1000 - 1) + 1) + 1;
        }

        sort(randomKeys, dummyKeys);
    }

    public void sort(int[] randomKeys, int[] dummyKeys){
        int[] temp;
        keySorter = new Sort(randomKeys);
        dummySorter = new Sort(dummyKeys);

        keySorter.doMergeSort();
        dummySorter.doMergeSort();

        temp = keySorter.getKeys();
        temp[0] = 0;

        writeToFile(temp, keySorter.getKeys().length - 1, "keys");
        writeToFile(dummySorter.getKeys(), dummyKeys.length, "dummyKeys");

    }

    public void writeToFile(int[] values, int numOfValues, String fileLabel){
        String fileName = "./" + numOfValues + "." + fileLabel + ".txt";

        try{
            file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);

            for (int value : values) {
                printWriter.println(value);
            }

            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
