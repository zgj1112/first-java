package steven.maven.example.Base;

public class Array7 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        Array7 array7 = new Array7();

        array7.printArray(numbers);
        System.out.println("Sum of array elements: " + array7.sumOfArray(numbers));
    }

    public void printArray(int[] array) {
        System.out.print("Array elements: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int sumOfArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
