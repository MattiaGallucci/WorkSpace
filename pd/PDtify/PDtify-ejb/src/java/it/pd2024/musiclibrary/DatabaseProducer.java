/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matti
 */
public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName ="MusicLibraryPU") 
    private EntityManager em;  
}
