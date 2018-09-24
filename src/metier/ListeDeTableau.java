package metier;

import com.sun.istack.internal.NotNull;

public class ListeDeTableau<T> {

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

    /**
     * @return la taille
     */
    public int taille(){
        return this.taille;
    }

    /**
     * @return vrai si la liste est vide
     */
    public boolean estVide() {
        return taille == 0;
    }

    /**
     * @param obj l'objet T cherché
     * @return vrai si la liste contient l'objet
     */
    public boolean contient(Object obj){
        return indexDe(obj) >= 0;
    }

    /**
     * @param obj l'objet T cherché
     * @return -1 si l'objet n'existe pas et sinon sa position dans la liste
     */
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

    /**
     * @param obj l'objet T cherché
     * @return -1 si l'objet n'existe pas et sinon sa dernière position dans la liste
     */
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

    /**
     * @param index l'index de l'objet
     * @return l'objet à l'index demandé
     * @throws IndexOutOfBoundsException index > TAILLE_MAX
     */
    public T get(int index) throws IndexOutOfBoundsException, ClassCastException{
        return (T) element[index];
    }

    /**
     * change la valeur d'un element
     * @param index le lieu de l'élément dans la liste
     * @param nouveauElement la nouvelle valeur
     * @throws IndexOutOfBoundsException index > TAILLE_MAX
     */
    public void set(int index, T nouveauElement) throws IndexOutOfBoundsException{
        element[index] = nouveauElement;
    }

    /**
     * ajoute une valeur à la liste
     * @param t la valeur à ajouter
     */
    public void add(T t) {
        assurerCapaciteInterne(taille + 1);  // Increments modCount!!
        element[taille++] = t;
    }

    /**
     * rtire une valeur à la liste
     * @param index le lieu de la valeur
     */
    public void retirer(int index) {
        int numMovement = taille - index - 1;
        if (numMovement > 0)
            System.arraycopy(element, index+1, element, index,
                    numMovement);
        element[--taille] = null;

    }

    public void vider(){
        for (int i = 0; i < taille; i++)
            element[i] = null;

        taille = 0;
    }

    private static int calculerCapacite(Object[] donneElement, int capaciteMin) {
        if (donneElement == ELEMENT_VIDE) {
            return Math.max(CAPACITE_PAR_DEFAUT, capaciteMin);
        }
        return capaciteMin;
    }

    private void assurerCapaciteInterne(int capaciteMin) {
        assurerCapaciteReel(calculerCapacite(element, capaciteMin));
    }

    private void assurerCapaciteReel(int capaciteMin) {
        if (capaciteMin - element.length > 0){
            grandir();
        }
    }

    private void grandir() {
        int oldCapacite = element.length;
        int newCapacite = oldCapacite + (oldCapacite >> 1);
        newCapacite = newCapacite <= oldCapacite ? CAPACITE_PAR_DEFAUT : newCapacite;
        element = copyDe(element, newCapacite);
    }

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
