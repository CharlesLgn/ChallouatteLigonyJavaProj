package com.interfaces;

import com.metier.Code;

public interface Arbre {
    /**
     * @return la taille
     */
    int taille();

    /**
     * @return vrai si l'arbre est vide
     */
    boolean estVide();

    /**
     * @param obj l'objet T cherché
     * @return vrai si l'arbre contient l'objet
     */
    boolean contient(Object obj);

    /**
     * ajoute une valeur à l'arbre
     * @param t la valeur à ajouter
     */
    void add(Code t);

    /**
     * rtire une valeur à la liste
     * @param t la valeur
     */
    void retirer(Code t);

    /**
     * change la valeur d'un element
     * @param nouveauElement la nouvelle valeur
     * @throws IndexOutOfBoundsException index > TAILLE_MAX
     */
    void set(Code old, Code nouveauElement) throws NullPointerException;

    /**
     * retire toute les valeurs de la liste
     */
    void vider();

    /**
     * recrélarbre de manière équilibré
     */
    void reorganiser();
}
