/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_esercizio1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author matti
 */
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", 10, "Book1", 1111, "Fantasy"); 
        Book book2 = new Book("Book2", 20, "Book2", 2222, "Thriller"); 
        Book book3 = new Book("Book3", 30, "Book3", 3333, "Thriller"); 
        Book book4 = new Book("Book4", 40, "Book4", 4444, "Horror"); 
        Book book5 = new Book("Book5", 50, "Book5", 5555, "Fantasy"); 
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book1);
        em.persist(book2);
        em.persist(book3);
        em.persist(book4);
        em.persist(book5);
        tx.commit();
        
        Query query = em.createNamedQuery("searchByCategoria");
        query.setParameter("categoria", "Fantasy");
        List<Book> books = query.getResultList();
        
        query = em.createNamedQuery("searchByTitolo");
        query.setParameter("titolo", "Book3");
        Book bookRes1 = (Book) query.getSingleResult();
        
        query = em.createNamedQuery("searchByIsbn");
        query.setParameter("isbn", 5555);
        Book bookRes2 = (Book) query.getSingleResult();
        
        em.close();
        emf.close();
        
        System.out.println(books);
        System.out.println(bookRes1);
        System.out.println(bookRes2);
    }
}
