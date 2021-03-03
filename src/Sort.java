public class Sort {
    private int[] keys;
    private int[] temp;
    private int leftBegin = 0;
    private int rightEnd;

    public Sort(int[] keys){
        this.keys = keys;
        temp = new int[keys.length];
        rightEnd = keys.length - 1;
    }

    public void doMergeSort(){
        mergeSort(keys, temp, leftBegin, rightEnd);
    }

    public void mergeSort(int[] keys, int[] temp, int leftBegin, int rightEnd){
        int mid = (leftBegin + rightEnd) / 2;

        if(leftBegin < rightEnd){
            mergeSort(keys, temp, leftBegin, mid);
            mergeSort(keys, temp, mid + 1, rightEnd);
            merge(keys, temp, leftBegin, mid + 1, rightEnd);
        }
    }

    public void merge(int[] keys, int[] temp, int leftBegin, int rightBegin, int rightEnd) {
        int leftEnd = rightBegin - 1;
        int index = leftBegin;
        int length = rightEnd - leftBegin + 1;

        while(leftBegin <= leftEnd && rightBegin <= rightEnd){
            if(keys[leftBegin] <= keys[rightBegin]){
                temp[index++] = keys[leftBegin++];
            }else{
                temp[index++] = keys[rightBegin++];
            }
        }

        while(leftBegin <= leftEnd){
            temp[index++] = keys[leftBegin++];
        }

        while(rightBegin <= rightEnd){
            temp[index++] = keys[rightBegin++];
        }

        for(int i = 1; i <= length; i++, rightEnd--){
            keys[rightEnd] = temp[rightEnd];
        }
    }

    public int[] getKeys() {
        return keys;
    }
}
