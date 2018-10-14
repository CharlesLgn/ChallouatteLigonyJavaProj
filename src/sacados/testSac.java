package sacados;

import com.util.ListeChaine;

public class testSac {
    public static void main(String[] args){
        ListeChaine<Objet> obj = new ListeChaine<>(new Objet(1,5),
                                 new ListeChaine<>(new Objet(1,4),
                                 new ListeChaine<>(new Objet(2,9),
                                 new ListeChaine<>(new Objet(1,7),
                                 new ListeChaine<>(new Objet(3,20),
                                 new ListeChaine<>(new Objet(2,12)))))));
        Sac test = new Sac(4);
        test = Sac.optimiserSac(test, obj);
        ListeChaine<Objet> obj2 = test.getObjets();
        System.out.println(obj2);
        System.out.println(test.getMasseIn());

    }
}
