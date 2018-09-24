package metier;

import interfaces.Carte;

public abstract class AbstractCarte<Cle, Val> implements Carte<Cle, Val> {

    protected AbstractCarte() {}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean estVide() {
        return (size() == 0);
    }

    @Override
    public boolean contientVal(Object val) {
        return false;
    }

    @Override
    public boolean contientCle(Object cle) {
        return false;
    }

    @Override
    public Val get(Object cle) {
        return null;
    }

    @Override
    public void insere(Cle cle, Val val) {

    }

    @Override
    public void insereTout(Carte<? extends Cle, ? extends Val> carte) {

    }

    @Override
    public void retirer(Cle cle) {

    }

    @Override
    public void vider() {

    }

    @Override
    public void remplacer(Cle cle, Val nouvelle) {

    }
}
