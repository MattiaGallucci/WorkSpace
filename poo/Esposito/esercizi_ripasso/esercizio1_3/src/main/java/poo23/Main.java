package poo23;

import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main( String[] args )
    {
        List<Integer> intList = Arrays.asList(10, 100, 32, 5, 33, 765, 32 ,432, 1);

        System.out.println(Max.max(intList, 0, 5));
        System.out.println(Max.max(intList, 3, 7));
        System.out.println(Max.max(intList, 6, 8));
    }
}
