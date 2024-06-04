package classes;

public class ArraysProblems extends SortingAlgorithm {

    public int largestElement(int []arr){
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (maxElement<arr[i]){
                maxElement = arr[i];
            }
        }

        return maxElement;
    }
    public int secondLargestElement(int []arr){
        int maxElement = Integer.MIN_VALUE;
        int secondMaxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>maxElement){
                secondMaxElement = maxElement;
                maxElement = arr[i];
            } else if (arr[i]>secondMaxElement && arr[i]!=maxElement) {
                secondMaxElement =  arr[i];
            }
        }

        return secondMaxElement;
    }

    public boolean checkSortedArray(int [] arr){
        boolean isSorted = true;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i]<arr[i-1]){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
