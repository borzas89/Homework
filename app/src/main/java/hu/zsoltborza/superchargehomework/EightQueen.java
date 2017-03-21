package hu.zsoltborza.superchargehomework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Borzas on 2017. 03. 13..
 */
// From http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html
public class EightQueen {

    private static List<Position> queensPositionList = new ArrayList<>();

    private static List<String> queensStringList = new ArrayList<>();

    public static List<String> getQueensStringList() {
        if(queensStringList.size() == 0){
            EightQueen.queenFinderByN(8);
        }

        return queensStringList;
    }

    public static List<Position> getQueensPositionList() {

        if(queensPositionList.size()==0){
            EightQueen.queenFinderByN(8);
        }
        return queensPositionList;

    }

        private static void printQueenPositionsAsList(int[] queenArray) {

            int n = queenArray.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (queenArray[i] == j){

                        // index of the array is the row, array values are the column
                        queensPositionList.add(new Position( queenArray[i],i));
                    }
                }
            }

    }

    /**
     * Displaying queens position's as strings in listview
     * @param queenArray
     */
    public static void printQueensToStringList(int[] queenArray) {

        String item,actual = "";
        String[] characters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

        int n = queenArray.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queenArray[i] == j){

                    // columns: A-H , rows: 1-8 conversion
                    item = characters[j] + ++j + " ";
                    actual = actual + item;

                }
            }
        }

        queensStringList.add(actual);

    }

    // finding permutations...
    public static void findQueens(int[] queenArray, int rowCount) {
        int n = queenArray.length;
        if (rowCount == n) {
            printQueenPositionsAsList(queenArray);
            printQueensToStringList(queenArray);
        } else {
            for (int i = 0; i < n; i++) {
                queenArray[rowCount] = i;
                if (isPlacedSafe(queenArray, rowCount)) {
                    findQueens(queenArray, rowCount + 1);
                }
            }
        }
    }


    public static boolean isPlacedSafe(int[] q, int n) {

        for (int i = 0; i < n; i++) {

            if (q[i] == q[n]) return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }


    // making an array for queens place
    // n - how many queens we want to add to a chessboard
    public static void queenFinderByN(int n) {
        int[] queenArray = new int[n];
        // starting to place a queen in the 0 row
        findQueens(queenArray, 0);

    }

}
