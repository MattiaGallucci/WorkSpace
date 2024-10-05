package poo23;

public class App 
{
    public static void main( String[] args )
    {
        Inventory<Integer> interi = new Inventory<>();
        interi.add(1);
        interi.add(3);
        interi.add(2);
        interi.add(1);
        interi.add(1);

        System.out.println(interi.count(1));
        System.out.println(interi.getMostCommon());

    }
}
