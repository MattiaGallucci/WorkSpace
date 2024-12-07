/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

import java.io.Serializable;

/**
 *
 * @author matti
 */
public class MessageWrapper implements Serializable{
    private int id;
    private int giacenza;

    public MessageWrapper(int id, int giacenza) {
        this.id = id;
        this.giacenza = giacenza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" + "id=" + id + ", giacenza=" + giacenza + '}';
    }
}
