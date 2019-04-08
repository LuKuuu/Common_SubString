

public class CommonSubString {
    public static void main(String[] args) {

        longestCommonSubstrings("oobcdcdha", "abt<?>cd</?>df");
//        longestCommonSubstrings("oob", "abt");

    }


    public static void longestCommonSubstrings(String newS, String oldS) {
        Point[][] table = new Point[newS.length()][oldS.length()];
        for (int i = 0; i < newS.length(); i++) {
            for (int j = 0; j < oldS.length(); j++) {
                table[i][j] = new Point(i, j);
            }
        }

        for (int i = 0; i < newS.length(); i++) {
            for (int j = 0; j < oldS.length(); j++) {
                if (newS.charAt(i) != oldS.charAt(j)) {
                    continue;
                }


                table[i][j].matched = true;
                if (i != 0 && j != 0) {
                    table[i - 1][j - 1].next = table[i][j];
                }

            }

        }

        printTable(table, newS, oldS);


    }


    private static void printTable(Point[][] table, String newS, String oldS) {
        for (int i = -1; i < table.length; i++) {
            for (int j = -1; j < table[0].length; j++) {
                if (i == -1 && j == -1) {
                    System.out.print(" ");

                } else if (i == -1) {
                    System.out.print(oldS.charAt(j));

                } else if (j == -1) {
                    System.out.print(newS.charAt(i));

                } else {
                    System.out.print(table[i][j].matched ? 1 : 0);

                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}



class Point {
    boolean matched;
    Point next;
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point getFinalPoint() {
        Point point = this;
        while (point.next != null) {
            point = point.next;
        }

        return point;

    }
}
