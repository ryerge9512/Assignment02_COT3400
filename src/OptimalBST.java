public class OptimalBST {
    private Double[][] e;
    private Double[][] w;
    private int[][] root;

    private Double[] p;
    private Double[] q;
    private int[] keys;

    public OptimalBST(Double[] p, Double[] q, int[] keys){
        this.p = p;
        this.q = q;
        this.keys = keys;

        e = new Double[p.length][q.length];
        w= new Double[p.length][q.length];
        root = new int[p.length][q.length];

        findOptimalBST();
        constructOptimalBST();
    }

    public void findOptimalBST(){
        for(int i = 1; i < p.length; i++){
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }

        for(int l = 1; l < p.length; l++){
            for(int i = 1; i < p.length - l + 1; i++){
                int j = i + l - 1;
                e[i][j] = Double.POSITIVE_INFINITY;
                w[i][j] = w[i][j-1] + p[j] + q[j];

                for(int r = i; r < j; r++){

                    double t = (e[i][r-1] + e[r+1][j] + w[i][j]);

                    if(t < e[i][j]){
                        e[i][j] = t;
                        root[i][j] = r;
                        System.out.println("t: " + t);
                        System.out.println("root: " + r);
                    }
                }
            }
        }
    }

    public void constructOptimalBST(){
        // TODO: Need to fix logical error in findOptimalBST()
    }

    public Double[][] getE(){
        return e;
    }

    public Double[][] getW(){
        return w;
    }

    public int[][] getRoot(){
        return root;
    }


}
