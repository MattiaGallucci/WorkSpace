package poo23;

public enum TipologiaLuogo {
    ESTERNO(0.1),
    INTERNO(0.15),
    VIP(0.2);

    private double percentuale;

    private TipologiaLuogo(double percentuale) {
        this.percentuale = percentuale;
    }

    public double getPercentuale() {
        return percentuale;
    }
}
