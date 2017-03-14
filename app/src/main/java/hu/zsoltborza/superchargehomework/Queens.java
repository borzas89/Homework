package hu.zsoltborza.superchargehomework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borzas on 2017. 03. 13..
 */

// From http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html
public class Queens {

    public static List<String> queensList = new ArrayList<>();
    public static  String[] characters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};



    public static List<String> getQueensList() {
        enumerate(8);
        return queensList;
    }

    public static void setQueensList(List<String> queensList) {
        Queens.queensList = queensList;
    }


    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }


    public static void printQueens(int[] q) {

        String item,actual = "";

        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j){

                    item = characters[j] + ++j + " ";
                    actual = actual + item;
                }
            }
        }
        queensList.add(actual);
    }



    /***************************************************************************
     *  Try all permutations using backtracking
     ***************************************************************************/
    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) printQueens(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1);
            }
        }
    }

  // public static void main(String[] args) {
       // int n = Integer.parseInt(8);
    //    enumerate(8);
   // }

}
