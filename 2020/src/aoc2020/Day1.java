package aoc2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Day1 {

    private final HashSet<Long> input = new HashSet<>();

    private void sumMultiplyByNumEnteries(int numEnteries) {
        if(numEnteries == 2) {
            this.input.forEach(i -> {
                if (input.contains(2020 - i)) {
                    System.out.println(String.format("Found match, %d+%d=2020, %d*%d=%d", i, 2020 - i, i, 2020 - i,
                            i * (2020 - i)));
                }
            });
        } else if(numEnteries == 3) {
            ArrayList<Long> arr = new ArrayList<>(input);
            for (int i = 0; i < arr.size(); i++) {
                long x = arr.get(i);
                //System.out.print(x);
                for (int j = i+1; j < arr.size(); j++) {
                    if(x+arr.get(j) > 2020) {
                        //System.out.print("+"+j + "> 2020 continuing...");
                        continue;
                    } else {
                        long y = arr.get(j);
                        if(input.contains(2020-x-y)) {
                            long z = 2020-x-y;
                            System.out.println(String.format("Found match, %d,%d,%d=2020, ans=%d", x, y, z, x*y*z));
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void main(final String[] args)
            throws IOException {
        Day1 d1 = new Day1();
        String input = "/Users/naval.gupta/code/AOC/2020/input/input.txt";
        try(Stream<String> stream = Files.lines(Paths.get(input))) {
            stream.forEach( inp -> {
                d1.input.add(Long.parseLong(inp));
            });
            d1.sumMultiplyByNumEnteries(3);
        }
    }
}
