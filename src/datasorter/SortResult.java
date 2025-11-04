package datasorter;

public class SortResult {
    int[] sortedArray;
    long timeTaken;
    long steps;

    public SortResult(int[] sortedArray, long timeTaken, long steps) {
        this.sortedArray = sortedArray;
        this.timeTaken = timeTaken;
        this.steps = steps;
    }
}
