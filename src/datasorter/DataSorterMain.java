package datasorter;

import java.util.*;

public class DataSorterMain {

    static Scanner scanner = new Scanner(System.in);
    static int[] dataset = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    enterNumbers();
                    break;
                case 2:
                    generateRandomNumbers();
                    break;
                case 3:
                    performSort("Bubble");
                    break;
                case 4:
                    performSort("Merge");
                    break;
                case 5:
                    performSort("Quick");
                    break;
                case 6:
                    compareAll();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    // Input numbers manually
    static void enterNumbers() {
        System.out.print("Enter numbers separated by spaces: ");
        scanner.nextLine(); // clear buffer
        String[] input = scanner.nextLine().trim().split("\\s+");
        dataset = new int[input.length];
        for (int i = 0; i < input.length; i++)
            dataset[i] = Integer.parseInt(input[i]);
        System.out.println("Numbers stored successfully!");
    }

    // Generate random dataset
    static void generateRandomNumbers() {
        System.out.print("Enter how many numbers to generate: ");
        int n = getIntInput();
        dataset = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            dataset[i] = rand.nextInt(1000); // numbers between 0–999
        System.out.println("Random dataset generated successfully!");
        System.out.println(Arrays.toString(dataset));
    }

    // Perform a selected sort
    static void performSort(String type) {
        if (dataset == null) {
            System.out.println("Please enter or generate numbers first!");
            return;
        }

        int[] dataCopy = Arrays.copyOf(dataset, dataset.length);
        SortResult result = null;

        switch (type) {
            case "Bubble":
                result = BubbleSort.sort(dataCopy);
                break;
            case "Merge":
                result = MergeSort.sort(dataCopy);
                break;
            case "Quick":
                result = QuickSort.sort(dataCopy);
                break;
        }

        System.out.println(type + " Sort Result: " + Arrays.toString(result.sortedArray));
        System.out.println("Steps: " + result.steps + " | Time: " + result.timeTaken + " ns");
    }

    // Compare all algorithms
    static void compareAll() {
        if (dataset == null) {
            System.out.println("Please enter or generate numbers first!");
            return;
        }

        int[] data1 = Arrays.copyOf(dataset, dataset.length);
        int[] data2 = Arrays.copyOf(dataset, dataset.length);
        int[] data3 = Arrays.copyOf(dataset, dataset.length);

        SortResult bubble = BubbleSort.sort(data1);
        SortResult merge = MergeSort.sort(data2);
        SortResult quick = QuickSort.sort(data3);

        System.out.println("\n--- Comparison Table ---");
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Steps", "Time (ns)");
        System.out.println("--------------------------------------------");
        System.out.printf("%-15s %-15d %-15d%n", "Bubble Sort", bubble.steps, bubble.timeTaken);
        System.out.printf("%-15s %-15d %-15d%n", "Merge Sort", merge.steps, merge.timeTaken);
        System.out.printf("%-15s %-15d %-15d%n", "Quick Sort", quick.steps, quick.timeTaken);
    }

    static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}