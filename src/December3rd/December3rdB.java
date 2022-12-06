package December3rd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class December3rdB {

    public static void main(String[] args) {
        String data1;
        String data2;
        String data3;
        List<String> list1;
        List<String> list2;
        List<String> list3;
        int sum = 0;
        try {
            File myObj = new File("src/December3rd/december3rd.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data1 = myReader.nextLine();
                data2 = myReader.nextLine();
                data3 = myReader.nextLine();
                list1 = Arrays.stream(data1.split("")).toList();
                list2 = Arrays.stream(data2.split("")).toList();
                list3 = Arrays.stream(data3.split("")).toList();
                sum += finder(list1,list2,list3);
            }
            System.out.println(sum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }

    private static int finder(List<String> data1, List<String> data2, List<String> data3){
        List<Integer> data1priorities = December3rd.priorityList(data1);
        List<Integer> data2priorities = December3rd.priorityList(data2);
        List<Integer> data3priorities = December3rd.priorityList(data3);
        for (Integer data1priority: data1priorities) {
            for (Integer data2priority : data2priorities) {
                for (Integer data3priority : data3priorities){
                    if (Objects.equals(data1priority, data2priority) && Objects.equals(data1priority, data3priority)){
                        return data1priority;
                    }
                }
            }
        }
        return 0;
    }
}
