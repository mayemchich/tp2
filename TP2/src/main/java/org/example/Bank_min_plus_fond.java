package org.example;

public class Bank_min_plus_fond implements  Banque{
    int fond_min;
    int fond_actuel;
    public Bank_min_plus_fond(int fond_min, int fond_actuel)
    {
        fond_min=fond_min;
        fond_actuel=fond_actuel;

    }
    @Override
    public void crediter(int somme) {
        fond_actuel += somme;
    }

    @Override
    public boolean est_solvable() {
        return fond_actuel >= fond_min;
    }

    @Override
    public void debiter(int somme) {
        fond_actuel -= somme;
    }
}