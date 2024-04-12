import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    /*
     * 
     * public static int formingMagicSquare(List<List<Integer>> s) {
     * // find n for 3x3 [1,9] matrix.
     * // n is 15
     * // n for 2x2 [1,4]
     * // doesn't exist
     * 
     * // this is dividing the total to 3 equal value sections, so,
     * // x = [sum] / 3.
     * // sum = y(y+1)/2
     * // x = (y^2+y)/6
     * // y = n^2
     * // x = (n^4+n^2)/6
     * 
     * // calculate x
     * int n = s.size();
     * int y = n * n;
     * int magicalConst = (y * y + y) / 6;
     * 
     * // now, if simplified, the problem is changing as few numbers to achieve a
     * sum
     * // example:
     * // 5 3 4, what is the ideal change?
     * // scram this..
     * 
     * // let's deal by making every combination n-tuples.
     * // get a viable range for every element in the tuple,
     * // repeat for every tuple
     * // take the common-range.
     * // we have the max range of every element...
     * // i don't think this goes to the most optimal result, but an approximation
     * at
     * // best.
     * 
     * // update.. the matrices are 3x3 all the time.
     * 
     * // I can't figure out a mathematical solution, so,
     * // i think we'll have to brute force and try every combination after all,
     * // and then take the best case.
     * 
     * // i've just read that every element needs to be distinct, so,
     * // every elementh has 9 different configurations, making this thing much
     * more,
     * // viably computable through brute-force.
     * 
     * // let's do one magic square, not at minimal cost.
     * ArrayList<Integer> availableIntegers = new ArrayList<Integer>(9);
     * 
     * Integer sum;
     * 
     * Integer[] cost = new Integer[3];
     * 
     * for (List<Integer> row : s) {
     * // make the rows obey first.
     * sum = row.get(0) + row.get(1) + row.get(2);
     * 
     * if (sum == magicalConst)
     * continue;
     * else {
     * 
     * }
     * }
     * 
     * }
     */

    private static class Digits {

        static Integer getNearest(Integer n) {
            // try it, one below, one up etc.
            int upper = n;
            int lower = n;

            while (upper < 10 && lower > 0) {
                if (digitsAvailable[upper])
                    return upper;
                if (digitsAvailable[lower])
                    return lower;

                ++upper;
                ++lower;
            }

            return -1;
        }

        static boolean isAvailable(Integer n) {
            if (digitsAvailable[n])
                return true;
            else
                return false;

        }

        static void makeUnavailable(Integer n) {
            if (n < 0 || n > 9)
                throw new IllegalArgumentException();
            if (digitsAvailable[n] == false)
                throw new IllegalStateException();

            digitsAvailable[n] = false;
        }

        static final Boolean[] digitsAvailable = new Boolean[9];

        static {
            digitsAvailable[0] = false;

            for (int i = 1; i < 9; ++i) {
                digitsAvailable[i] = true;
            }
        }
    }
/*
    public static int formingMagicSquare(List<List<Integer>> s) {
        int n = s.size();
        int k = n * n;
        int sum = k * (k + 1) / 2;
        final int magicalConstant = sum / n; // dive it into n pieces.

        //each 3-member tuple must sum out to magicalConstant.
        //for 3x3 magicalConstant is 15. There are less than 40 sequences.



        return 0;
    }
*/

    public static int formingMagicSquare(List<List<Integer>> s) {
        //ATTENTION:
        // I checked an article that discussed the solution,
        // it appears that there are only 8 3x3 MagicSquares,
        // thus, the most straightforward solution is to,
        // find transformation price for every magic square and then
        // return the cost based on that.
        // ... and here I was trying to find _proper_ solutions..

        return 0;
    }

    private static Integer cost(Integer source, Integer target) {
        return Math.abs(source - target);
    }

    private static Integer cost(List<Integer> row, Integer magicalInteger) {
        Integer[] relationOfIntegers = new Integer[row.size()];

        // since they are all unique,
        // there'll be three values
        // if n = magicalInteger
        // n-1, n and n+1
        // minimal cost is, converting them according to their size to n.
        // sort them along with n

        ArrayList<Integer> elements = new ArrayList<Integer>(row.size() + 1);

        elements.addAll(row);
        elements.add(magicalInteger);
        elements.sort(Comparator.naturalOrder());

        return null;
    }

    private static Integer cost(List<List<Integer>> source, List<List<Integer>> target) {

        return null;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
