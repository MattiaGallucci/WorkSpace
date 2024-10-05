package coppia;

public class Pair<K, V> {
    private K key;
    private V value;
    
    // Generic constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value; }
    
        // Generic methods
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey() { return key; }
    public V getValue() { return value; }

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("hello", 1);
        Pair<String, Integer> pair2 = new Pair<>("hello", 1);
        System.out.println(pair1.getKey() + " " + pair1.getValue());
        System.out.println(pair2.getKey() + " " + pair2.getValue());
        
        if(Util.compare(pair1, pair2))
            System.out.println("Sono uguali");
    }
}