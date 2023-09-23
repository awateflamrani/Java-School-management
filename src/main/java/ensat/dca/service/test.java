package ensat.dca.service;

import ensat.dca.model.Etudiant;

public class test {
    public static void main(String[] args) {
        EtudiantService e = new EtudiantService();
        //e.create(new Etudiant("kkkkk","awtef","ggggg","ffff","fff"));
        System.out.println(e.findById("kkkkk"));
        Etudiant et=(Etudiant) e.findById("kkkkk");
        System.out.println(et);
    }
}
