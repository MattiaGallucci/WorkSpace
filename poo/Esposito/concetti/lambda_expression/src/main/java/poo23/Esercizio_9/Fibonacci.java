/* Scrivere un’applicazione che restituisca le prime 10 posizioni nella serie di Fibonacci, in cui
   ciascun numero è la somma dei due precedenti, eccetto i primi due che sono, per definizione, 0 e
   1. */

package poo23.Esercizio_9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Fibonacci {
    private List<Integer> lista;

    Fibonacci(){
        lista = new ArrayList<>();
    }

    public void consume(int curr){
        if(curr == 0)
            lista.add(0);
        else if(curr == 1)
            lista.add(1);
        else{
            int res = lista.get(lista.size() - 1) + lista.get(lista.size() - 2);
            lista.add(res);
        }
    }

    public void combine (Fibonacci f){
        lista.addAll(f.lista);
    }

    public List<Integer> getLista(){ return lista; }

    public static void main(String[] args) {
        Fibonacci fib = IntStream.range(0, 10).collect(Fibonacci::new, Fibonacci::consume, Fibonacci::combine);
        fib.getLista().stream().forEach(System.out::println);
    }
}
