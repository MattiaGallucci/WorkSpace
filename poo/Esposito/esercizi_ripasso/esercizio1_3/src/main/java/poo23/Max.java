package poo23;

import java.util.*;

public final class Max{
    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int start, int end){
        T maxElem = list.get(start);

        for(++start; start < end; start++)
            if(maxElem.compareTo(list.get(start)) < 0)
                maxElem = list.get(start);
        return maxElem;
    }
}

