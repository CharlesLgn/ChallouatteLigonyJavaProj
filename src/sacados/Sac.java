package sacados;

import com.util.ListeChaine;

public class Sac {
    private ListeChaine<Objet> objets;
    private int masseSuporte;
    private int masseIn;
    private int interetIn;

    public Sac(ListeChaine<Objet> objets, int masseSuporte) {
        this.objets = objets;
        this.masseSuporte = masseSuporte;
        masseIn = 0;
        interetIn = 0;
    }

    public ListeChaine<Objet> getObjets() {
        return objets;
    }

    public void setObjets(ListeChaine<Objet> objets) {
        this.objets = objets;
    }

    public int getMasseSuporte() {
        return masseSuporte;
    }

    public void setMasseSuporte(int masseSuporte) {
        this.masseSuporte = masseSuporte;
    }

    public int getMasseIn(){
        return masseIn;
    }

    public int getInteretIn() {
        return interetIn;
    }

    public void add(Objet obj) throws Exception {
        if(obj.getMasse() + masseIn <= masseSuporte) {
            objets.add(obj);
            masseIn = obj.getMasse() + masseIn;
            interetIn = obj.getInteret() + interetIn;
        } else {
            throw new Exception("masse non suporter");
        }
    }

    public void retirer(int index) throws IndexOutOfBoundsException{
        Objet obj = objets.get(index);
        objets.retirer(index);
        interetIn = interetIn - obj.getInteret();
        masseIn = masseIn - obj.getMasse();
    }

    public static Sac optimiserSac(Sac sac, ListeChaine<Objet> obj){

        return sac;
    }
}
