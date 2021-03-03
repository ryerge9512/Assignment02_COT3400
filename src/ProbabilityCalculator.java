public class ProbabilityCalculator {
    private int[] randomKeys;
    private int[] dummyKeys;
    private Double[] p;
    private Double[] q;
    private Double sum;

    public ProbabilityCalculator(int[] randomKeys, int[] dummyKeys){
        this.randomKeys = randomKeys;
        this.dummyKeys = dummyKeys;

        p = new Double[randomKeys.length];
        q = new Double[dummyKeys.length];

        sum = 0.0;

        calculateSum();
        calculateProbabilities();
    }

    public void calculateSum(){
        for(int key : randomKeys){
            sum += key;
        }

        for(int dummyKey : dummyKeys){
            sum += dummyKey;
        }
    }

    public void calculateProbabilities(){
        for(int i = 0; i < randomKeys.length; i++){
            p[i] = randomKeys[i]/sum;
        }

        for(int j = 0; j < dummyKeys.length; j++){
            q[j] = dummyKeys[j]/sum;
        }
    }

    public Double[] getP(){
        return p;
    }

    public Double[] getQ(){
        return q;
    }
}
