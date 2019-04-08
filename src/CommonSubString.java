import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class CommonSubString {
    public static void main(String[] args) {

        longestCommonSubstrings("oobcdcdha", "abt<?>cd</?>df");
//        longestCommonSubstrings("oob", "abt");

    }


    private class Point{
        int x;
        int y;
        Point realPoint;
        public Point(int x, int y){
            x = x;
            y = y;
        }
    }

    public static Set<String> longestCommonSubstrings(String newS, String oldS) {
        int[][] table = new int[newS.length()][oldS.length()];
        int longest = 0;
        Set<String> result = new HashSet<>();

        for (int i = 0; i < newS.length(); i++) {
            for (int j = 0; j < oldS.length(); j++) {
                if (newS.charAt(i) != oldS.charAt(j)) {
                    continue;
                }

                table[i][j] = (i == 0 || j == 0) ? 1
                        : 1 + table[i - 1][j - 1];
                if (table[i][j] > longest) {
                    longest = table[i][j];
                    result.clear();
                }
                if (table[i][j] == longest) {
                    result.add(newS.substring(i - longest + 1, i + 1));
                }
            }
        }
        printTable(table, newS, oldS);


        return result;
    }

    private static void printTable(int[][] table, String newS, String oldS){
        for (int i=-1;i<table.length;i++){
            for(int j=-1;j<table[0].length;j++){
                if(i==-1 && j==-1){
                    System.out.print(" ");

                }else if (i==-1){
                    System.out.print(oldS.charAt(j));

                }else if (j==-1){
                    System.out.print(newS.charAt(i));

                }else{
                    System.out.print(table[i][j]);

                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void test(int N, int M){
//        IList<V> Vs; // saved V's indexed on d
//        IList<Snake> snakes; // list to hold solution
//
//        Point p = new Point( N, M ); // start at the end
//
//        for ( int d = vs.Count - 1 ; p.X > 0 || p.Y > 0 ; d-- )
//        {
//            var V = Vs[ d ];
//
//            int k = p.X - p.Y;
//
//            // end point is in V
//            int xEnd = V[ k ];
//            int yEnd = x - k;
//
//            // down or right?
//            bool down = ( k == -d || ( k != d && V[ k - 1 ] < V[ k + 1 ] ) );
//
//            int kPrev = down ? k + 1 : k - 1;
//
//            // start point
//            int xStart = V[ kPrev ];
//            int yStart = xStart - kPrev;
//
//            // mid point
//            int xMid = down ? xStart : xStart + 1;
//            int yMid = xMid - k;
//
//            snakes.Insert( 0, new Snake( /* start, mid and end points */ ) );
//
//            p.X = xStart;
//            p.Y = yStart;
//        }
    }


}
