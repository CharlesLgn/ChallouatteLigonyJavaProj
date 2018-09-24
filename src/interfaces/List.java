package interfaces;

public interface List<T> {

    /**
     * @return la taille
     */
    int taille();

    /**
     * @return vrai si la liste est vide
     */
    boolean estVide();

    /**
     * @param obj l'objet T cherché
     * @return vrai si la liste contient l'objet
     */
    boolean contient(Object obj);

    /**
     * @param obj l'objet T cherché
     * @return -1 si l'objet n'existe pas et sinon sa position dans la liste
     */
    int indexDe(Object obj);

    /**
     * @param obj l'objet T cherché
     * @return -1 si l'objet n'existe pas et sinon sa dernière position dans la liste
     */
    int lastIndexDe(Object obj);

    /**
     * @param index l'index de l'objet
     * @return l'objet à l'index demandé
     * @throws IndexOutOfBoundsException index > TAILLE_MAX
     */
    T get(int index) ;

    /**
     * change la valeur d'un element
     * @param index le lieu de l'élément dans la liste
     * @param nouveauElement la nouvelle valeur
     * @throws IndexOutOfBoundsException index > TAILLE_MAX
     */
    void set(int index, T nouveauElement) throws IndexOutOfBoundsException;

    /**
     * ajoute une valeur à la liste
     * @param t la valeur à ajouter
     */
    void add(T t);

    /**
     * rtire une valeur à la liste
     * @param index le lieu de la valeur
     */
    void retirer(int index);

    /**
     * retire toute les valeurs de la liste
     */
    void vider();

}
