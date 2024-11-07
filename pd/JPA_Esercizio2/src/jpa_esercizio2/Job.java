/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_esercizio2;

/**
 *
 * @author matti
 */
public class Job {
    private Long id;
    private String title;
    private Float salary;
    private String employeedId;

    public Job() {
    }

    public Job(Long id, String title, Float salary, String employeedId) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.employeedId = employeedId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getEmployeedId() {
        return employeedId;
    }

    public void setEmployeedId(String employeedId) {
        this.employeedId = employeedId;
    }
    
    
}
