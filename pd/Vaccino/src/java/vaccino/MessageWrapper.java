/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import java.io.Serializable;

/**
 *
 * @author matti
 */
public class MessageWrapper implements Serializable{
        private int id;
        private boolean interessatoVaccino;

    public MessageWrapper(int id, boolean interessatoVaccino) {
        this.id = id;
        this.interessatoVaccino = interessatoVaccino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInteressatoVaccino() {
        return interessatoVaccino;
    }

    public void setInteressatoVaccino(boolean interessatoVaccino) {
        this.interessatoVaccino = interessatoVaccino;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" + "id=" + id + ", interessatoVaccino=" + interessatoVaccino + '}';
    }
}
