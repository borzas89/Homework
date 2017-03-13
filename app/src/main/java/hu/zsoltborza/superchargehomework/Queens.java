package hu.zsoltborza.superchargehomework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borzas on 2017. 03. 13..
 */

// From http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html
public class Queens {


  public static  String str = null;
    public static List<String> placedQueens = new ArrayList<>();
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


    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     ***************************************************************************/
    public static void printQueens(int[] q) {


        String[] characters = new String [8];
        characters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j){
                   // System.out.print(characters[j] + n + " ");
                    placedQueens.add(i, characters[j] + n);
                }
              //  else           System.out.print(" ");
            }
           // System.out.println();
        }
       // System.out.println();
    }



    public List<String> printedQueens(int[] q) {

        List<String> placedQueens = new ArrayList<>();
        String[] characters = new String [8];
        characters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j){
                    //System.out.print(characters[j] + n + " ");
                    placedQueens.add(i,characters[j]+n);
                }
                //  else           System.out.print(" ");
            }
            // System.out.println();
        }
        //System.out.println();

        return placedQueens;
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

    public static List<String> getQueens(){

        List<String> queensList = new ArrayList<>();

        for (int i=0;i<92;i++){
            queensList.add(i,str);
        }


        return queensList;

    }


   /* public static void main(String[] args) {
      //  int n = Integer.parseInt(8);
        enumerate(8);
    }*/

}
