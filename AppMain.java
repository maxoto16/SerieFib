/**
 * AppMain.java - Fibonacci Series Implementation
 * Implements Fibonacci series using 4 different methods:
 * 1. String concatenation
 * 2. Bidimensional array
 * 3. Three variables approach
 * 4. Object-oriented approach with classes
 */
public class AppMain {
    
    public static void main(String[] args) {
        System.out.println("=== FIBONACCI SERIES IMPLEMENTATIONS ===\n");
        
        int n = 10; // Number of Fibonacci numbers to generate
        
        // Method 1: Using String concatenation
        System.out.println("1. Fibonacci using String concatenation:");
        fibonacciString(n);
        
        // Method 2: Using bidimensional array
        System.out.println("\n2. Fibonacci using bidimensional array:");
        fibonacciBidimensionalArray(n);
        
        // Method 3: Using 3 variables
        System.out.println("\n3. Fibonacci using 3 variables:");
        fibonacciThreeVariables(n);
        
        // Method 4: Using classes (OOP approach)
        System.out.println("\n4. Fibonacci using classes:");
        FibonacciGenerator generator = new FibonacciGenerator();
        generator.generateAndPrint(n);
    }
    
    /**
     * Method 1: Fibonacci using String concatenation
     */
    public static void fibonacciString(int n) {
        String series = "";
        int a = 0, b = 1;
        
        if (n >= 1) {
            series += a;
        }
        if (n >= 2) {
            series += ", " + b;
        }
        
        for (int i = 2; i < n; i++) {
            int next = a + b;
            series += ", " + next;
            a = b;
            b = next;
        }
        
        System.out.println("Series: " + series);
    }
    
    /**
     * Method 2: Fibonacci using bidimensional array
     */
    public static void fibonacciBidimensionalArray(int n) {
        if (n <= 0) return;
        
        // Using a 2D array where first row stores the series
        // and second row can store indices or other metadata
        int[][] fibArray = new int[2][n];
        
        // First row: Fibonacci numbers
        // Second row: Index positions
        if (n >= 1) {
            fibArray[0][0] = 0;
            fibArray[1][0] = 0;
        }
        if (n >= 2) {
            fibArray[0][1] = 1;
            fibArray[1][1] = 1;
        }
        
        for (int i = 2; i < n; i++) {
            fibArray[0][i] = fibArray[0][i-1] + fibArray[0][i-2];
            fibArray[1][i] = i;
        }
        
        System.out.print("Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibArray[0][i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
        
        System.out.print("Indices: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibArray[1][i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
    /**
     * Method 3: Fibonacci using exactly 3 variables
     */
    public static void fibonacciThreeVariables(int n) {
        if (n <= 0) return;
        
        int first = 0;   // Variable 1
        int second = 1;  // Variable 2
        int next;        // Variable 3
        
        System.out.print("Series: ");
        
        if (n >= 1) {
            System.out.print(first);
        }
        if (n >= 2) {
            System.out.print(", " + second);
        }
        
        for (int i = 2; i < n; i++) {
            next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
}

/**
 * Class-based approach for Fibonacci generation
 */
class FibonacciGenerator {
    private int first;
    private int second;
    private int current;
    
    public FibonacciGenerator() {
        this.first = 0;
        this.second = 1;
        this.current = 0;
    }
    
    /**
     * Generate the nth Fibonacci number
     */
    public int generateNth(int n) {
        if (n <= 0) return -1; // Invalid input
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        int a = 0, b = 1;
        for (int i = 2; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    /**
     * Generate and print Fibonacci series up to n terms
     */
    public void generateAndPrint(int n) {
        if (n <= 0) return;
        
        FibonacciNumber[] series = new FibonacciNumber[n];
        
        for (int i = 0; i < n; i++) {
            int value = generateNth(i + 1);
            series[i] = new FibonacciNumber(i + 1, value);
        }
        
        System.out.print("Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(series[i].getValue());
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
        
        System.out.println("Object details:");
        for (int i = 0; i < n; i++) {
            System.out.println("  Position " + series[i].getPosition() + 
                             ": " + series[i].getValue());
        }
    }
}

/**
 * Helper class to represent a Fibonacci number with its position
 */
class FibonacciNumber {
    private int position;
    private int value;
    
    public FibonacciNumber(int position, int value) {
        this.position = position;
        this.value = value;
    }
    
    public int getPosition() {
        return position;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "Fib(" + position + ") = " + value;
    }
}