package poo23;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
    private List<T> inventario;

    public Inventory() {
        inventario = new ArrayList<T>();
    }

    public void add(T oggetto) {
        inventario.add(oggetto);
    }
    public int count(T oggetto){
        long count = inventario.stream().filter(o->o.equals(oggetto)).count();
        return (int) count;
    }
    public T getMostCommon(){
        T mostCommon = null;
        for(T elem : inventario){
            if(count(elem) > count(mostCommon)){
                mostCommon = elem;
            }
        }
        return mostCommon;
    }

}
