/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int sconto;

    public MessageWrapper(int id, int sconto) {
        this.id = id;
        this.sconto = sconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }
}