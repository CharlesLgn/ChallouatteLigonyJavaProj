package sacados;

import com.util.ListeChaine;

public class Sac {
    private ListeChaine<Objet> objets;
    private int masseSuporte;
    private int masseIn;
    private int interetIn;

    public  Sac(Sac sac){
        this.objets = sac.objets;
        this.masseSuporte = sac.masseSuporte;
        masseIn = sac.masseIn;
        interetIn = sac.interetIn;
    }

    public Sac(ListeChaine<Objet> objets, int masseSuporte) {
        this.objets = objets;
        this.masseSuporte = masseSuporte;
        masseIn = getMasse(objets);
        interetIn = getInter(objets);
    }

    private int getMasse(ListeChaine<Objet> obj){
            if (obj.getSuiv() != null){
                return obj.getDonne().getMasse() + getMasse(obj.getSuiv());
            } else {
                return obj.getDonne().getMasse();
            }
    }
    private int getInter(ListeChaine<Objet> obj){
        if (obj.getSuiv() != null){
            return obj.getDonne().getInteret() + getInter(obj.getSuiv());
        } else {
            return obj.getDonne().getInteret();
        }
    }

    public Sac(int masseSuporte){
        objets = new ListeChaine<>();
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
        Sac autreSac;
        if (sac.objets.getDonne() == null){
            autreSac = new Sac(sac.masseSuporte);
        }else {
            autreSac = new Sac(sac.objets, sac.masseSuporte);
        }

        if (obj.getDonne().getMasse() + sac.masseIn <= sac.masseSuporte){
            try {
                sac.add(obj.getDonne());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(obj.getSuiv() != null){
            sac = Sac.optimiserSac(sac, obj.getSuiv());
            autreSac = Sac.optimiserSac(autreSac, obj.getSuiv());
        }
        return sac.interetIn > autreSac.interetIn ? sac : autreSac;
    }

    @Override
    public String toString() {
        return objets.toString();
    }
}
