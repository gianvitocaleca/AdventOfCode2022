import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DueDicembreSecond {
    /**
     * Rock paper scissors
     * A = Rock
     * B = Paper
     * C = Scissors
     * X = lose
     * Y = draw
     * Z = win
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
            File myObj = new File("input2dicembre.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                read = Arrays.stream(data.split("\\s+")).toList();
                sum = sum + points(read.get(0),result(read)) + result(read).getPoints();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static Result result(List<String> played){

        if(played.get(1).equals("X")){
            return Result.LOSS;
        }
        if(played.get(1).equals("Y")){
            return Result.DRAW;
        }
        return Result.WIN;

    }

    private static int points(String let, Result res){
        if(res.equals(Result.LOSS)){
            if(let.equals("A")) return 3;
            if(let.equals("B")) return 1;
            if(let.equals("C")) return 2;
        }
        if(res.equals(Result.DRAW)){
            if(let.equals("A")) return 1;
            if(let.equals("B")) return 2;
            if(let.equals("C")) return 3;
        }
        if(let.equals("A")) return 2;
        if(let.equals("B")) return 3;
        return 1;
    }
}
