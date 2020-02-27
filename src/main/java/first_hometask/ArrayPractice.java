package first_hometask;

import java.util.ArrayList;

public class ArrayPractice {

    public static void rectangleCounter(Integer[][] array) {
        ArrayList<Coordinates> coordinates = getCoordinatesForValue(array, 1);

        for (int i = 0; i < coordinates.size(); i++) {
            coordinates.get(i);

        }

    }

    public static ArrayList<Coordinates> getCoordinatesForValue(Integer[][] array, int value) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == value) {
                    coordinates.add(new Coordinates(i, j));
                }
            }
        }
        return coordinates;
    }


    public static void main(String[] args) {


        Integer[][] array2D = new Integer[][]{
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1, 1, 0, 0, 1, 1}};

        rectangleCounter(array2D);

    }

    public static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }
}
