import java.util.Scanner;

public class MatrixCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n=== Matrix Calculator ===");
            System.out.println("1. Add matrices");
            System.out.println("2. Subtract matrices");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();


            if (option == 4) {
                System.out.println("Exiting Matrix Calculator. Goodbye!");
                running = false;
                continue;
            }


            if (option < 1 || option > 4) {
                System.out.println("Invalid choice. Please pick between 1 and 4.");
                continue;
            }


            System.out.print("Enter the number of rows for Matrix A: ");
            int rowsA = scanner.nextInt();
            System.out.print("Enter the number of columns for Matrix A: ");
            int colsA = scanner.nextInt();

            System.out.print("Enter the number of rows for Matrix B: ");
            int rowsB = scanner.nextInt();
            System.out.print("Enter the number of columns for Matrix B: ");
            int colsB = scanner.nextInt();


            if ((option == 1 || option == 2) && (rowsA != rowsB || colsA != colsB)) {
                if (option == 1) {
                    System.out.println("\nError: Matrices cannot be added. They must have the exact dimensions.");
                } else {
                    System.out.println("\nError: Matrices cannot be subtracted. They must have the exact dimensions.");
                }
                continue;
            }

            if (option == 3 && colsA != rowsB) {
                System.out.println("\nError: Matrices cannot be multiplied. Columns of A must equal rows of B.");
                continue; //
            }


            int[][] matrixA = new int[rowsA][colsA];
            System.out.println("\nEnter elements for Matrix A:");
            for (int i = 0; i < rowsA; i++) {
                System.out.print("Row " + (i + 1) + ": ");
                for (int j = 0; j < colsA; j++) {
                    matrixA[i][j] = scanner.nextInt();
                }
            }


            int[][] matrixB = new int[rowsB][colsB];
            System.out.println("\nEnter elements for Matrix B:");
            for (int i = 0; i < rowsB; i++) {
                System.out.print("Row " + (i + 1) + ": ");
                for (int j = 0; j < colsB; j++) {
                    matrixB[i][j] = scanner.nextInt();
                }
            }


            if (option == 1) {
                int[][] result = new int[rowsA][colsA];
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < colsA; j++) {
                        result[i][j] = matrixA[i][j] + matrixB[i][j];
                    }
                }


                System.out.println("\nResult:");
                for (int i = 0; i < rowsA; i++) {
                    System.out.print("[ ");
                    for (int j = 0; j < colsA; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println("]");
                }

            } else if (option == 2) {
                int[][] result = new int[rowsA][colsA];
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < colsA; j++) {
                        result[i][j] = matrixA[i][j] - matrixB[i][j];
                    }
                }


                System.out.println("\nResult:");
                for (int i = 0; i < rowsA; i++) {
                    System.out.print("[ ");
                    for (int j = 0; j < colsA; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println("]");
                }

            } else if (option == 3) {
                int[][] result = new int[rowsA][colsB];
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < colsB; j++) {
                        result[i][j] = 0;
                        for (int k = 0; k < colsA; k++) {
                            result[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                }


                System.out.println("\nResult:");
                for (int i = 0; i < rowsA; i++) {
                    System.out.print("[ ");
                    for (int j = 0; j < colsB; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println("]");
                }
            }
        }

        scanner.close();
    }
}
