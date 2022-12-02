
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;


public class PrimoDicembre {

    public static void main(String[] args) {
        List<Integer> folletti = new ArrayList<>();
        Integer sum = 0;
        String data;

        try {
            File myObj = new File("input1dicembre.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();


                if(!data.equals("")){
                    sum = sum + Integer.parseInt(data);
                }else{
                    folletti.add(sum);
                    sum = 0;
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        folletti.sort(Comparator.reverseOrder());
        System.out.println(folletti.get(0));
        int top3 = folletti.get(0) + folletti.get(1) + folletti.get(2);
        System.out.println(top3);
    }

}
