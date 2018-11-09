package com.util;

import com.interfaces.Arbre;
import com.metier.Code;

public class ArbreBinaire implements Arbre {

    private Code donne ;
    private ArbreBinaire brancheGauche;
    private ArbreBinaire brancheDroite;

    public ArbreBinaire(Code t){
        this.donne = t;
        brancheDroite=null;
        brancheGauche=null;
    }
    public ArbreBinaire(Code t, ArbreBinaire brancheGauche, ArbreBinaire brancheDroite){
        this.donne = t;
        this.brancheDroite = brancheDroite;
        this.brancheGauche = brancheGauche;
    }


    @Override
    public int taille() {
        if(brancheDroite == null && brancheGauche == null){
            return 1;
        }else if(brancheDroite != null && brancheGauche == null){
            return 1 + brancheDroite.taille();
        }else if(brancheDroite == null){
            return 1 + brancheGauche.taille();
        } else {
            return 1 + brancheGauche.taille() + brancheDroite.taille();
        }
    }

    @Override
    public boolean estVide() {
        return (donne == null && taille() == 1);
    }

    @Override
    public boolean contient(Object obj) {
        if(donne.equals(obj)){
            return true;
        }
        if(brancheDroite == null && brancheGauche == null){
            return false;
        }else if(brancheDroite != null && brancheGauche == null){
            return brancheDroite.contient(obj);
        }else if(brancheDroite == null){
            return brancheGauche.contient(obj);
        } else {
            return brancheGauche.contient(obj) || brancheDroite.contient(obj);
        }
    }

    @Override
    public void add(Code t) {
        if (t.getRomain() > donne.getRomain()){
            if (brancheDroite == null){
                brancheDroite = new ArbreBinaire(t);
            } else {
                brancheDroite.add(t);
            }
        } else if (t.getRomain() < donne.getRomain()){
            if (brancheGauche == null){
                brancheGauche = new ArbreBinaire(t);
            } else {
                brancheGauche.add(t);
            }
        } else {
            throw new IllegalArgumentException("the letter is added");
        }
    }

    @Override
    public void set(Code old, Code nouveauElement) throws NullPointerException {
        if (donne == old) {
            donne = nouveauElement;
        }
        if (old.getRomain() > donne.getRomain()){
            brancheDroite.set(old, nouveauElement);
        } else if (old.getRomain() < donne.getRomain()){
            brancheGauche.set(old, nouveauElement);
        }
    }

    public Code getByRomain(char a) throws Exception {
        if(donne.getRomain() == a){
            return donne;
        } else if(donne.getRomain() < a){
            return brancheDroite.getByRomain(a);
        } else if(donne.getRomain() > a){
            return brancheGauche.getByRomain(a);
        }
        throw new Exception("l'arbre ne contient pas la valeur");
    }

    @Override
    public void retirer(Code t) {

    }

    @Override
    public void vider() {

    }

    @Override
    public void reorganiser() {
        Code[] tab = toList().toTab();
        tri(tab);
        addOrganized(tab);
    }

    public static ArbreBinaire addOrganized(Code[] tab) {
        int pos = (tab.length-1) / 2;
        if(tab.length - pos == 1){
            return new ArbreBinaire(tab[pos]);
        } else {
            Code[] inf = new Code[pos],
                   sup = new Code[pos];
            for (int i=0 ; i<pos; i++){
                inf[i] = tab[i];
                sup[i] = tab[i+pos+1];
            }
            return new ArbreBinaire(tab[pos], addOrganized(inf), addOrganized(sup));
        }

    }

    public static void tri(Code[] tableau) {
        int longueur=tableau.length;
        if (longueur>0) {
            triFusion(tableau,0,longueur-1);
        }
    }

    private static void triFusion(Code[] tableau,int deb,int fin) {
        if (deb!=fin) {
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            fusion(tableau,deb,milieu,fin);
        }
    }

    private static void fusion(Code[] tableau,int deb1,int fin1,int fin2) {
        int deb2=fin1+1;

        Code[] table1=new Code[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++) {
            table1[i-deb1]=tableau[i];
        }

        int compt1=deb1;
        int compt2=deb2;

        for(int i=deb1;i<=fin2;i++) {
            if (compt1==deb2) {
                break;
            } else if (compt2==(fin2+1)) {
                tableau[i]=table1[compt1-deb1];
                compt1++;
            } else if (table1[compt1-deb1].getRomain() < tableau[compt2].getRomain()) {
                tableau[i]=table1[compt1-deb1];
                compt1++;
            } else {
                tableau[i]=tableau[compt2];
                compt2++;
            }
        }
    }

    private ListeChaine<Code> toList(){
        if(brancheDroite == null && brancheGauche == null){
            return new ListeChaine<>(donne, null, null);
        }else if(brancheDroite != null && brancheGauche == null){
            return new ListeChaine<>(donne, null, brancheDroite.toList());
        }else if(brancheDroite == null){
            return new ListeChaine<>(donne, brancheGauche.toList(), null);
        } else {
            return new ListeChaine<>(donne, brancheGauche.toList(), brancheDroite.toList());
        }
    }
}
