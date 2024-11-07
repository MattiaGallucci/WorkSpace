package jpa_esercizio1;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-10-28T16:24:59")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, String> descrizione;
    public static volatile SingularAttribute<Book, String> titolo;
    public static volatile SingularAttribute<Book, Integer> isbn;
    public static volatile SingularAttribute<Book, String> categoria;
    public static volatile SingularAttribute<Book, Integer> prezzo;

}