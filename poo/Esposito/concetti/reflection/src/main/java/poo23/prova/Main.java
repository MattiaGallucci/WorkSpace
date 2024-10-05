package poo23.prova;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import poo23.allegati.Prodotto;

public class Main {
    public static void main(String[] args) throws Exception{
        List<Prodotto> lista = new ArrayList<>();
        Prodotto p = new Prodotto("Coca", 1);
        //System.out.println(p);
        lista.add(p);
        
        //! INVOCA METODO
        Class<?> c = p.getClass();
        Method m = c.getDeclaredMethod("ciao");
        //m.invoke(p);
       
        //! MODIFICA ATTRIBUTO
        Field[] attr = //p.getClass().getDeclaredFields();
                       //Prodotto.class.getDeclaredFields();    // Letterale di classe
                       Class.forName("poo23.allegati.Prodotto").getDeclaredFields(); 
        for(Field f : attr){
            if(f.getName().equals("denominazione")){
                f.setAccessible(true);
                f.set(p, "Coca-Cola");
            }
        }
        //System.out.println(p);

        //! CREA ISTANZA SENZA SAPERE NOME DELLA CLASSW
        Constructor<?>[] costruttori = c.getConstructors();
        for (Constructor<?> costruttore : costruttori) {
            System.out.println("Nome del costruttore: " + costruttore.getName());

            Parameter[] parametri = costruttore.getParameters();
            System.out.println("Lista dei parametri:");
            for (Parameter parametro : parametri) {
                System.out.println("  Tipo: " + parametro.getType().getName());
                System.out.println("  Nome: " + parametro.getName());
            }
        }
        Constructor costruttore = p.getClass().getConstructor(String.class, int.class);
        Prodotto prodotto = (Prodotto) costruttore.newInstance("Acqua", 1);
        //System.out.println(prodotto);
        lista.add(prodotto);
        System.out.println(lista);

        /*Method[] meth = p.getClass().getDeclaredMethods();
        for(Method m : meth){
            if(m.getName().equals("ciao")){
                m.invoke(p);
            }
        }*/
    }
}
