package Entity;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
public class Benchmarks {
    String string = "Hello";
    String string1 = "Hello";

    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int target = 1;

    @Benchmark
    public String concatenationUsingPlus() {
        return string + string1;
    }

    @Benchmark
    public String concatenationUsingStringBuilder() {
        var sb = new StringBuilder();
        sb.append(string);
        sb.append(string1);
        return sb.toString();
    }

    @Benchmark
    public int binarySearch() {

        var left = 0;
        var right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

