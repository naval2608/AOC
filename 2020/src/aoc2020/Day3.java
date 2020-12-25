package aoc2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Pos {
    int xCor;
    int yCor;

    @Override
    public String toString() {
        return "Pos{" + "xCor=" + xCor + ", yCor=" + yCor + '}';
    }
}
public class Day3 {

    ArrayList<List<String>> arr = new ArrayList<>();
    Pos pos = new Pos();
    int open = 0;
    int tree = 0;

    private int traverse(int right, int down) {
        tree = 0;
        pos.xCor = 0;
        pos.yCor = 0;
        int width = arr.get(0).size();
        while (pos.yCor < arr.size()-1) {
            pos.xCor = pos.xCor + right;
            pos.xCor = pos.xCor % width;
            pos.yCor = pos.yCor + down;
            //System.out.println(pos.toString());
            try {
                if (arr.get(pos.yCor).get(pos.xCor).equals("#")) {
                    tree++;
                    //System.out.println("Found tree:" + pos.toString());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("out of bound at:" + pos.toString());
            }
        }
        System.out.println("Total trees:" + tree);
        return tree;
    }

    private void createArray(String line) {
        List<String> row = Arrays.asList(line.split(""));
        arr.add(row);
    }

    private void printArr() {
        for(int i = 0; i<arr.size(); i++) {
            for(int j=0; j<arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Day3 d3 = new Day3();
        String file = "/Users/naval.gupta/code/AOC/2020/input/inputday3.txt";
        String example = "/Users/naval.gupta/code/AOC/2020/input/exampleday3";
        try(Stream<String> stream = Files.lines(Paths.get(file))) {
            stream.forEach( line -> {
                d3.createArray(line);
            });
            //d3.printArr();
            long tree = d3.traverse(1,1);
            System.out.println("mul:" + tree);
            tree *= d3.traverse(3,1);
            System.out.println("mul:" + tree);
            tree *= d3.traverse(5,1);
            System.out.println("mul:" + tree);
            tree *= d3.traverse(7,1);
            System.out.println("mul:" + tree);
            tree *= d3.traverse(1,2);
            System.out.println("mul:" + tree);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
