package box;

public class BoxDemo {
    public class Box<T> {
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }
        
    public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
        BoxDemo boxDemo = new BoxDemo();    //! MODIFICATO
        Box<U> box = boxDemo.new Box<>();   //! MODIFICATO
        box.set(u);
        boxes.add(box);
    }
    
    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
        
        BoxDemo.<Integer>addBox(Integer.valueOf(10),
        listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }
}
