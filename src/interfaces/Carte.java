package interfaces;

/**
 * cette interface défini la notion de carte
 * une carte ne peut pas avoir deux clés identique
 * chaque clé n'est lié qu'à une valeur
 * @param <Cle>
 * @param <Val>
 */
public interface Carte<Cle, Val> extends  Entree<Cle, Val>{

    /**
     * @return le nombre de valeur dans la map
     */
    int size();

    /**
     * @return vrai si la carte est sans élément
     */
    boolean estVide();

    /**
     * @param val la valeur recherchée
     * @return vrai si la valeur se situe dans la carte
     */
    boolean contientVal(Object val);

    /**
     *
     * @param cle la cle recherchée
     * @return vrai si la cle se situe dans la carte
     */
    boolean contientCle(Object cle);

    /**
     * @param cle la clé de la valeur
     * @return la valeur lié à la clé dans la carte
     */
    Val get(Object cle);

    /**
     * insere une nouvelle valeur lié à une nouvelle clé dans la map
     * @param cle cle avec laquelle la valeur est associé
     * @param val valeur avec laquelle la cle est associé
     */
    void insere(Cle cle, Val val);

    /**
     * insere toute les valeur d'une carte dans une autre
     * @param carte la carte à insérer
     */
    void insereTout(Carte<? extends Cle, ? extends Val> carte);

    /**
     * retire la cle avec la valeur associé dans la map.
     * @param cle cle qui doit être retirer de la carte
     */
    void retirer(Cle cle);

    /**
     * retirer toutes les valeurs de la carte
     */
    void vider();

    /**
     * remplace une ancienne valeur par une nouvelle
     * @param cle la clé lié à l'ancienne valeur
     * @param nouvelle la nouvelle valeur
     */
    void remplacer(Cle cle, Val nouvelle);

    interface Entree<Cle, Val> {

        Cle getCle();

        Val getVaal();

        void setCle(Cle cle);

        void setVal(Val val);


    }
}
