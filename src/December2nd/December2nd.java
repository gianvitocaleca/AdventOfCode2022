package December2nd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class December2nd {
    /**
     * Rock paper scissors
     * A = Rock
     * B = Paper
     * C = Scissors
     * X = Rock
     * Y = Paper
     * Z = Scissors
     * AX => draw
     * AY => loss
     * AZ => win
     * BX => win
     * BY => draw
     * BZ => loss
     * CX => loss
     * CY => win
     * CZ => draw
     * Rock 1
     * Paper 2
     * Scissors 3
     * 0 loss
     * 3 draw
     * 6 won
     */
    public static void main(String[] args) {
        Integer sum = 0;
        List<String> read;
        String data;

        try {
            File myObj = new File("src/December2nd/input2dicembre.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                read = Arrays.stream(data.split("\\s+")).toList();
                if(read.get(1).equals("X")) sum++;
                if(read.get(1).equals("Y")) sum = sum + 2;
                if(read.get(1).equals("Z")) sum = sum + 3;

                sum = sum + points(read).getPoints();

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static Result points(List<String> played){

        if(played.get(0).equals("A")){
            if(played.get(1).equals("Y")) return Result.WIN;
            if(played.get(1).equals("Z")) return Result.LOSS;
        }
        if(played.get(0).equals("B")){
            if(played.get(1).equals("Z")) return Result.WIN;
            if(played.get(1).equals("X")) return Result.LOSS;
        }
        if(played.get(0).equals("C")){
            if(played.get(1).equals("X")) return Result.WIN;
            if(played.get(1).equals("Y")) return Result.LOSS;
        }

        return Result.DRAW;
    }
}
