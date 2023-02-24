package Entity;

import static Entity.Benchmarks.*;

public class Benchmarking {
    public static void main(String[] args) {
        var string = "Hello";
        var string1 = "Helloasdsad";

        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        var target = 1;

        concatenationUsingPlus(string, string1);

        concatenationUsingStringBuilder(string, string1);

        binarySearch(arr, target);


    }
}
