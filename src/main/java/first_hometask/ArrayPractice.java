package first_hometask;


public class ArrayPractice {

    public static int rectangleCounter(Integer[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heightMatrix = new int[m][n + 1];

        int counter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    heightMatrix[i][j] = 0;
                } else {
                    heightMatrix[i][j] = i == 0 ? 1 : heightMatrix[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < heightMatrix.length) {
                if (heightMatrix[i][j] == 1 && heightMatrix[i][j + 1] == 0) {
                    counter++;
                }
                j++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {


        Integer[][] array2D = new Integer[][]{
                {1, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 1, 1}};

        System.out.println(rectangleCounter(array2D));

    }
}
