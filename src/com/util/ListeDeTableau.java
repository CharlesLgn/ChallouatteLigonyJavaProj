package com.util;

import com.sun.istack.internal.NotNull;
import interfaces.List;

public class ListeDeTableau<T> implements List<T> {

    private  static final int CAPACITE_PAR_DEFAUT = 10;

    private int taille;

    private static final Object[] ELEMENT_VIDE = {};

    private transient Object[] element;


    //Constructor
    public ListeDeTableau(int tailleInitial) {
        if (tailleInitial > 0) {
            this.element = new Object[tailleInitial];
        } else if (tailleInitial == 0) {
            this.element = ELEMENT_VIDE;
        } else {
            throw new IllegalArgumentException("taille impossible: "+
                    tailleInitial);
        }
    }
    public ListeDeTableau() {
        this.element = ELEMENT_VIDE;
        this.taille = 0;
    }


    @Override
    public int taille(){
        return this.taille;
    }

    @Override
    public boolean estVide() {
        return taille == 0;
    }

    @Override
    public boolean contient(Object obj){
        return indexDe(obj) >= 0;
    }

    @Override
    public int indexDe(Object obj) {
        if (obj == null) {
            for (int i=0 ; i < taille; i++){
                if(element[i] == null){
                    return i;
                }
            }
        } else {
            for (int i=0 ; i < taille; i++){
                if(obj.equals(element[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexDe(Object obj) {
        if (obj == null) {
            for (int i = taille-1; i >= 0; i--)
                if (element[i]==null)
                    return i;
        } else {
            for (int i = taille-1; i >= 0; i--)
                if (obj.equals(element[i]))
                    return i;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) throws IndexOutOfBoundsException, ClassCastException{
        return (T) element[index];
    }

    @Override
    public void set(int index, T nouveauElement) throws IndexOutOfBoundsException{
        element[index] = nouveauElement;
    }

    @Override
    public void add(T t) {
        assurerCapaciteInterne(taille + 1);  // Increments modCount!!
        element[taille++] = t;
    }

    @Override
    public void add(T t, int position) {
        assurerCapaciteInterne(taille + 1);  // Increments modCount!!
        if(position > ++taille){
            throw new IndexOutOfBoundsException();
        } else {
            int p = taille;
            while (p > position){
                this.element[p]=this.element[--p];
            }
            this.element[position] = t;
        }
    }

    @Override
    public void retirer(int index) {
        int numMovement = taille - index - 1;
        if (numMovement > 0)
            System.arraycopy(element, index+1, element, index,
                    numMovement);
        element[--taille] = null;

    }

    @Override
    public void vider(){
        for (int i = 0; i < taille; i++)
            element[i] = null;

        taille = 0;
    }

    /**
     * @param element la liste d'element
     * @param capaciteMin la capacité à comparer
     * @return capacité max de la liste
     */
    private static int calculerCapacite(Object[] element, int capaciteMin) {
        if (element == ELEMENT_VIDE) {
            return Math.max(CAPACITE_PAR_DEFAUT, capaciteMin);
        }
        return capaciteMin;
    }

    /**
     * verifie si la liste a sufisement de place
     */
    private void assurerCapaciteInterne(int capaciteMin) {
        assurerCapaciteReel(calculerCapacite(element, capaciteMin));
    }

    /**
     * change la taille en fonction de la capacité
     */
    private void assurerCapaciteReel(int capaciteMin) {
        if (capaciteMin - element.length > 0){
            grandir();
        }
    }

    /**
     * ajoute de l'espace à la liste
     */
    private void grandir() {
        int oldCapacite = element.length;
        int newCapacite = oldCapacite + (oldCapacite >> 1);
        newCapacite = newCapacite <= oldCapacite ? CAPACITE_PAR_DEFAUT : newCapacite;
        element = copyDe(element, newCapacite);
    }

    /**
     * copi la liste dans une list plus grande.
     */
    @NotNull
    private static <T> T[] copyDe(T[] original, int newLength) {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[newLength];
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

    @Override
    public String toString() {
        if (element == null)
            return "null";

        int iMax = taille - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(String.valueOf(element[i]));
            if (i == iMax)
                return sb.append(']').toString();
            sb.append(", ");
        }
    }
}
