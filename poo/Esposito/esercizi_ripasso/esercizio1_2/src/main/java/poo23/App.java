package poo23;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Ciao", "Sono","Mattia"};
        Swap.swap(intArray, 0, 4);
        Swap.swap(strArray, 0, 2);
        System.out.println(Arrays.asList(intArray));
        System.out.println(Arrays.asList(strArray));
    }
}
