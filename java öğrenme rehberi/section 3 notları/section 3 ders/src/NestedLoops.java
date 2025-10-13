public class NestedLoops {
    public static void main(String[] args) {
        // Çarpım tablosu oluştur (Laravel'de blade nested loop gibi)
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "x" + j + "=" + (i*j) + "\t");
            }
            System.out.println(); // Yeni satır
        }

        // 2D Array traversal (Laravel'de nested array gibi)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
