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
        }
    }

    public void retirer(int index) throws IndexOutOfBoundsException{
        Objet obj = (Objet) objets.get(index);
        objets.retirer(index);
        interetIn = interetIn - obj.getInteret();
        masseIn = masseIn - obj.getMasse();
    }

    public static Sac optimiserSac(Sac sac, ListeChaine<Objet> obj){
        Sac sac1;
        Sac sac2;
        if (sac.objets.getDonne() == null){
            sac1 = new Sac(sac.masseSuporte);
            sac2 = new Sac(sac.masseSuporte);
        }else {
            sac1 = new Sac(sac.objets, sac.masseSuporte);
            sac2 = new Sac(sac.objets, sac.masseSuporte);
        }

        if (obj.getDonne().getMasse() + sac.masseIn <= sac.masseSuporte){
            try {
                sac1.add(obj.getDonne());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(obj.getSuiv() != null){
            sac1 = Sac.optimiserSac(sac1, obj.getSuiv());
            sac2 = Sac.optimiserSac(sac2, obj.getSuiv());
        }
        return sac1.interetIn > sac2.interetIn ? sac1 : sac2;
    }

    @Override
    public String toString() {
        return objets.toString();
    }
}
