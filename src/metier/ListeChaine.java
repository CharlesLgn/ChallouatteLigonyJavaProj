package metier;

import interfaces.List;

import java.util.LinkedList;

public class ListeChaine<T> implements List<T> {

    private transient T donne;
    private ListeChaine<T> pred;
    private ListeChaine<T> suiv;

    //Constructor
    public ListeChaine(){
        pred = null;
        suiv = null;
    }
    public ListeChaine(T donne){
        this.donne = donne;
        pred = null;
        suiv = null;
    }

    @SuppressWarnings("unchecked")
    public ListeChaine(T donne, ListeChaine<? extends T> pred, ListeChaine<? extends T> suiv){
        this.donne = donne;
        this.pred = (ListeChaine<T>) pred;
        this.suiv = (ListeChaine<T>) suiv;
    }

    @SuppressWarnings("unchecked")
    public ListeChaine(T donne, ListeChaine<? extends T> pred){
        this.donne = donne;
        this.pred = (ListeChaine<T>) pred;
    }

    @Override
    public int taille() {
        if (suiv == null) {
            return 1;
        }
        return (suiv.taille() + 1);
    }

    @Override
    public boolean estVide() {
        return (taille() == 1 && donne == null);
    }

    @Override
    public boolean contient(Object obj) {
        if(donne.equals(obj)){
            return true;
        } else if (suiv != null){
            return suiv.contient(obj);
        }
        return false;
    }

    @Override
    public int indexDe(Object obj) {
        return indexDe(obj, 0);
    }

    /**
     * methode pour trouver l'index
     */
    private int indexDe(Object obj, int index){
        if(donne.equals(obj)){
            return index;
        } else if (suiv != null){
            return suiv.indexDe(obj, index + 1);
        }
        return -1;
    }

    @Override
    public int lastIndexDe(Object obj) {
        return last().lastIndexDe(obj, taille());
    }

    private  ListeChaine<T> last(){
        if(suiv == null){
            return this;
        } else {
            return suiv.last();
        }
    }

    private int lastIndexDe(Object obj, int index) {
        if(donne.equals(obj)){
            return index;
        } else if (pred != null){
            return pred.indexDe(obj, index - 1);
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if(index == 0) {
            return donne;
        } else if(suiv != null && index > 0){
            return suiv.get(index-1);
        }
        throw new IllegalArgumentException("index out of Bound");
    }

    @Override
    public void set(int index, T nouveauElement) throws IndexOutOfBoundsException {

    }

    @Override
    public void add(T t) {
        ListeChaine<T> newVal = new ListeChaine<>(t, this, null);
        suiv = newVal;
    }

    @Override
    public void add(T t, int position) {
        if(position == 0){
            ListeChaine<T> nouv = new ListeChaine<>(this.donne, null, this.suiv);
            this.donne = t;
            this.suiv = nouv;
            if (pred == null){
                nouv.pred = this;
            }
        } else if (suiv != null) {
            suiv.add(t, position-1);
        } else if ((suiv == null) && (position == 1)){
            add(t);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void retirer(int index) {
        if(index == 1){
            ListeChaine<T> valSuiv = (suiv == null ? null : suiv.suiv);
            suiv = valSuiv;
        }else{
            retirer(index-1);
        }
    }

    @Override
    public void vider() {
        suiv = null;
        pred = null;
        donne = null;
    }

    @Override
    public String toString() {
        return toString(true);
    }

    private String toString(boolean first){
        StringBuilder sb = new StringBuilder();
        if(first){
            sb.append("[");
        }
        if(suiv == null){
            return sb.toString() + donne +"]";
        } else {
            return sb.toString() + donne + "," + suiv.toString(false);
        }

    }
}
