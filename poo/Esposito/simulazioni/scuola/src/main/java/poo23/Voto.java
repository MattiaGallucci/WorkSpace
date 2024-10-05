package poo23;

public class Voto {
    private int voto;
    private Materia materia;
    
    public Voto(int voto, Materia materia) {
        this.voto = voto;
        this.materia = materia;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Voto [voto=" + voto + ", materia=" + materia + "]";
    }

    
}
