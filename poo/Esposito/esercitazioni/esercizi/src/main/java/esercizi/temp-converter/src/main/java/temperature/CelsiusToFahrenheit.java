

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Scrivi la temperatura in gradi centigradi: ");
        int c = sc.nextInt();
        sc.close();

        float f = ((float)c * 9) / 5 + 32;

        System.out.println("La temperatura in gradi Fahrenheit è: " + f);

    }
}
