package poo23;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main 
{
    public static void main( String[] args ){
        Collection<Integer> intList = Arrays.asList(5, 22, 34, 12, 75, 123, 64, 32, 100, 22);
        int count = Algorithm.countIf(intList, new OddNumber());
        System.out.println("Odd numbers: " + count);
        count = Algorithm.countIf(intList, new EvenNumber());
        System.out.println("Even numbers: " + count);
        count = Algorithm.countIf(intList, new PalindromicNumber());
        System.out.println("Palindromic numbers: " + count);

        List<Integer> evenList = intList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList = intList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println("Even numbers: " + evenList);
        System.out.println("Odd numbers: " + oddList);
    }
    
    static class OddNumber implements UnaryPredicate<Integer>{
        @Override
        public boolean test(Integer elem) {
            return elem % 2 != 0;
        }
    }
    
    static class EvenNumber implements UnaryPredicate<Integer>{
        @Override
        public boolean test(Integer elem) {
            return elem % 2 == 0;
        }
    }

    static class PalindromicNumber implements UnaryPredicate<Integer>{
        @Override
        public boolean test(Integer elem) {
            String str = elem.toString();
            int len = str.length();
            for(int i=0; i<len/2; i++)
                if(str.charAt(i) != str.charAt(len-i-1))
                    return false;
            return true;
        }
    }
}
