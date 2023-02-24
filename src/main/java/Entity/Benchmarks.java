package Entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
public class Benchmarks {
    @Contract(pure = true)
    @Benchmark
    public static @NotNull String concatenationUsingPlus(String string1, String string2) {
        return string1 + string2;
    }

    @Benchmark
    public static @NotNull String concatenationUsingStringBuilder(String string1, String string2) {
        StringBuilder sb = new StringBuilder();
        sb.append(string1);
        sb.append(string2);
        return sb.toString();
    }


    @Contract(pure = true)
    @Benchmark
    public static int binarySearch(int @NotNull [] arr, int x) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

}

