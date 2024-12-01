/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import java.io.Serializable;

/**
 *
 * @author matti
 */
public class MessageWrapper implements Serializable{
    private int id;
    private String cantante;
    private String parole;

    public MessageWrapper(int id, String cantante, String parole) {
        this.id = id;
        this.cantante = cantante;
        this.parole = parole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getParole() {
        return parole;
    }

    public void setParole(String parole) {
        this.parole = parole;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" + "id=" + id + ", cantante=" + cantante + ", parole=" + parole + '}';
    }
}
