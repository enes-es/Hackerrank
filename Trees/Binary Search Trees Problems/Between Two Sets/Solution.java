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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> divisorList, List<Integer> dividesList) {
        // Algorithm:
        // target number cannot be smaller than the largest number within divisorList
        // target number cannot be bigger than the half of the smallest number within
        // dividesList
        // thus target range is: [divisorList.max, (dividesList.minimum / 2.0).ceiling]
        // in each iteration,
        // check if divisible by every divisor,
        // check if divides every single divisor,
        // if yes, then it is valid.
        // increment count.

        int count = 0;
        int lowerRange; // inclusive
        int higherRange; // inclusive

        if (divisorList.isEmpty() || dividesList.isEmpty())
            return 0;

        lowerRange = divisorList.stream().min((a, b) -> a > b ? 1 : -1)
                .orElse(divisorList.get(0)); // in case there is only one element

        higherRange = dividesList.stream().max((a, b) -> a > b ? 1 : -1)
        .orElse(dividesList.get(0)); // in case there is only one element


        // target range cannot be more than half of the greatest to-divide number.
        higherRange = higherRange / 2 + 1;

        for (int i = lowerRange; i < higherRange; ++i) {
            final int _i = i; // patchwork fix to satisfy Stream requirement of referencing local variables
                              // only if they're final or effectively-final.

            // must divide every divides
            // must be divisible by every divisor
            if (dividesList.stream().noneMatch(divident -> divident % _i != 0) &&
                    divisorList.stream().noneMatch(divisor -> _i % divisor != 0)) {
                count++;
            }
        }
            System.out.println("count is: " + count);
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
