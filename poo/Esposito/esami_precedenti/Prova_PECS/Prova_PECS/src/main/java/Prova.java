import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Shape {
    void draw() {}
}

class Circle extends Shape {
    void draw() {}
}

class Square extends Shape {
    void draw() {}
}

class Rectangle extends Shape {
    void draw() {}
}

public class Prova {
	
	public static void main(String[] args) {
		//? extends Shape i.e. can use any sub type of Shape, here Shape is Upper Bound in inheritance hierarchy
        List<? extends Shape> intList5 = new ArrayList<Shape>();
        List<? extends Shape> intList6 = new ArrayList<Circle>();
        List<? extends Shape> intList7 = new ArrayList<Rectangle>();
        List<? extends Shape> intList9 = new ArrayList<Object>();//ERROR.


        //? super Shape i.e. can use any super type of Shape, here Shape is Lower Bound in inheritance hierarchy
        List<? super Shape> inList5 = new ArrayList<Shape>();
        List<? super Shape> inList6 = new ArrayList<Object>();
        List<? super Shape> inList7 = new ArrayList<Circle>(); //ERROR.

        //-----------------------------------------------------------
        Circle circle = new Circle();
        Shape shape = circle; // OK. Circle IS-A Shape

        List<Circle> circles = new ArrayList<>();
        List<Shape> shapes = circles; // ERROR. List<Circle> is not subtype of List<Shape> even when Circle IS-A Shape

        List<? extends Circle> circles2 = new ArrayList<>();
        List<? extends Shape> shapes2 = circles2; // OK. List<? extends Circle> is subtype of List<? extends Shape>


        //-----------------------------------------------------------
        Shape shape2 = new Shape();
        Circle circle2= (Circle) shape2; // OK. with type casting

        List<Shape> shapes3 = new ArrayList<>();
        List<Circle> circles3 = shapes3; //ERROR. List<Circle> is not subtype of  List<Shape> even Circle is subetype of Shape

        List<? super Shape> shapes4 = new ArrayList<>();
        List<? super Circle> circles4 = shapes4; //OK.
        
		
		Fibonacci fib = IntStream.range(0, 10).collect(Fibonacci::new, Fibonacci::consume, Fibonacci::combine);
		fib.getLista().stream().forEach(System.out::println);
    }

    
    
    /*
     * Example for an upper bound wildcard (Get values i.e Producer `extends`)
     *
     * */
    public void testCoVariance(List<? extends Shape> list) {
        list.add(new Object());//ERROR
        list.add(new Shape()); //ERROR
        list.add(new Circle()); // ERROR
        list.add(new Square()); // ERROR
        list.add(new Rectangle()); // ERROR
        Shape shape= list.get(0);//OK so list act as produces only
    /*
     * You can't add a Shape,Circle,Square,Rectangle to a List<? extends Shape>
     * You can get an object and know that it will be an Shape
     */
    }
    
    
    /*
     * Example for  a lower bound wildcard (Put values i.e Consumer`super`)
     * */
    public void testContraVariance(List<? super Shape> list) {
        list.add(new Object());//ERROR
        list.add(new Shape());//OK
        list.add(new Circle());//OK
        list.add(new Square());//OK
        list.add(new Rectangle());//OK
        Shape shape= list.get(0); // ERROR. Type mismatch, so list acts only as consumer
        Object object= list.get(0); //OK gets an object, but we don't know what kind of Object it is.
        /*
         * You can add a Shape,Circle,Square,Rectangle to a List<? super Shape>
         * You can't get an Shape(but can get Object) and don't know what kind of Shape it is.
         */
    }
}
