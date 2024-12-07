/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int stampa;

    public MessageWrapper(int id, int stampa) {
        this.id = id;
        this.stampa = stampa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStampa() {
        return stampa;
    }

    public void setStampa(int stampa) {
        this.stampa = stampa;
    }
}