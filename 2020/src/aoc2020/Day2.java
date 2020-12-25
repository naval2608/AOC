package aoc2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day2 {

    private static Boolean countValid(String puzzle) {
        String[] spl1 = puzzle.split("-");
        String[] sp2 = spl1[1].split(" ",2);
        String[] sp3 = sp2[1].split(": ");
        int max = Integer.parseInt(sp2[0]);
        int min = Integer.parseInt(spl1[0]);
        char alphabet = sp3[0].charAt(0);
        String pwd = sp3[1];

        int count = 0;
        for(int i =0; i<pwd.length(); i++) {
            char charAt = pwd.charAt(i);
            if(charAt == alphabet) count++;
        }
        //System.out.println(String.format("%s => %s %d %d %s", puzzle, alphabet, min, max, pwd));
        if(count >= min && count <= max) {
            System.out.println(String.format("VALID %s => %s %d %d %s", puzzle, alphabet, min, max, pwd));
            return true;
        }
        else {
            System.out.println(String.format("INVALID %s => %s %d %d %s", puzzle, alphabet, min, max, pwd));
            return false;
        }
    }

    private static Boolean positionValid(String puzzle) {
        String[] spl1 = puzzle.split("-");
        int pos1 = Integer.parseInt(spl1[0]);

        String[] sp2 = spl1[1].split(" ",2);
        int pos2 = Integer.parseInt(sp2[0]);

        String[] sp3 = sp2[1].split(": ");
        char alphabet = sp3[0].charAt(0);
        String pwd = sp3[1];

        int count = 0;
        if(pwd.charAt(pos1-1) == alphabet) count++;
        if(pwd.charAt(pos2-1) == alphabet) count++;

        if(count == 1) {
            System.out.println(String.format("VALID %s => %s %d %d %s", puzzle, alphabet, pos1, pos2, pwd));
            return true;
        }
        else {
            System.out.println(String.format("INVALID %s => %s %d %d %s", puzzle, alphabet, pos1, pos2, pwd));
            return false;
        }
    }

    public static void main(String[] args)
            throws IOException {
        String filename = "/Users/naval.gupta/code/AOC/2020/input/input-day2.txt";
        String example = "/Users/naval.gupta/code/AOC/2020/input/example-day2.txt";
        final AtomicInteger valid = new AtomicInteger();
        try(Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach( puzzle -> {
                if(positionValid(puzzle)) {
                    valid.getAndIncrement();
                }
            });
            System.out.println("total valid:" + valid);
        }

    }

}
