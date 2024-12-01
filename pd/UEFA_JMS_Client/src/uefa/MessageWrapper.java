/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int numeroGoal;
    private String squadra;

    public MessageWrapper(int id, int numeroGoal, String squadra) {
        this.id = id;
        this.numeroGoal = numeroGoal;
        this.squadra = squadra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroGoal() {
        return numeroGoal;
    }

    public void setNumeroGoal(int numeroGoal) {
        this.numeroGoal = numeroGoal;
    }

    public String getSquadra() {
        return squadra;
    }

    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" + "id=" + id + ", numeroGoal=" + numeroGoal + ", squadra=" + squadra + '}';
    }    
}
