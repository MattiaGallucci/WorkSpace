package poo23.esercizio1;

import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args ){
    	Country italia = new Country("Italia", 100);
        Country malta = new Country("Malta", 10);
        Country usa = new Country("USA", 500);
        Country francia = new Country("Francia", 150);
        List<Country> countryList = Arrays.asList(italia, malta, usa, francia);
        
        ComparableDataSet<Country> countryDS = new ComparableDataSet<Country>();
        
        for(Country country : countryList)
        	countryDS.add(country);
        System.out.println("min = " + countryDS.getMinimum());
        System.out.println("max = " + countryDS.getMaximum());
        
    }
}
