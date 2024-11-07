/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_esercizio2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author matti
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "findByFirstLastName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName"),
    @NamedQuery(name = "findByAddress", query = "SELECT p FROM Person p WHERE p.address = :address"),
    @NamedQuery(name = "findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "findByJob", query = "SELECT p FROM Person p WHERE p.job = :job")
})

public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Character middleInitial;
    private Address address;
    private Job job;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Job> jobs = new ArrayList<>();


    public Person() {
    }

    public Person(String id, String firstName, String lastName, Character middleInitial, Address address, Job job) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address = address;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(Character middleInitial) {
        this.middleInitial = middleInitial;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
    
}
