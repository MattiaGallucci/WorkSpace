

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Scrivi la temperatura in Fahrenheit: ");
        int f = sc.nextInt();
        sc.close();
        
        float c = ((float)f - 32) * 5 / 9;
        
        System.out.println("La temperatura in Celsius è " + c + "°C");
    }
}