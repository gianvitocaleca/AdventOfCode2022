package December3rd;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class December3rd {
    public static void main(String[] args) {
        String data;
        List<String> list;
        List<String> firstHalf;
        List<String> secondHalf;
        int sum = 0;
        try {
            File myObj = new File("src/December3rd/december3rd.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                list = Arrays.stream(data.split("")).toList();
                firstHalf = firstHalf(list);
                secondHalf = secondHalf(list);
                sum += finder(firstHalf,secondHalf);
            }
            System.out.println(sum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }


    private static List<String> firstHalf(List<String> list){
        List<String> firstHalf = new ArrayList<>();
        for(int i = 0; i< list.size()/2; i++){
            firstHalf.add(list.get(i));
        }
        return firstHalf;
    }

    private static List<String> secondHalf(List<String> list){
        List<String> secondHalf = new ArrayList<>();
        for(int i = list.size()/2; i< list.size(); i++){
            secondHalf.add(list.get(i));
        }
        return secondHalf;
    }

    private static int finder(List<String> firstHalf, List<String> secondHalf){
        List<Integer> firstPriorities = priorityList(firstHalf);
        List<Integer> secondPriorities = priorityList(secondHalf);
        for (Integer firstPriority : firstPriorities) {
            for (Integer secondPriority : secondPriorities) {
                if (Objects.equals(firstPriority, secondPriority)) {
                    return firstPriority;
                }
            }
        }
        return 0;
    }

    static List<Integer> priorityList(List<String> data){
        List<Integer> priorities = new ArrayList<>();
        for(String s: data){
            priorities.add(getPriority(s));
        }
        return priorities;
    }

    private static int getPriority(String string){
        char a = string.charAt(0);
        int x;
        if(Character.isUpperCase(a)){
            x = a - 38;
        }else{
            x = a - 96;
        }
        return x;
    }
}
