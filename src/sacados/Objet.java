package sacados;

public class Objet {
    private int masse;
    private int interet;

    public Objet(int masse, int interet) {
        this.masse = masse;
        this.interet = interet;
    }

    public Objet() { }

    public int getMasse() {
        return masse;
    }

    public void setMasse(int masse) {
        this.masse = masse;
    }

    public int getInteret() {
        return interet;
    }

    public void setInteret(int interet) {
        this.interet = interet;
    }

}
