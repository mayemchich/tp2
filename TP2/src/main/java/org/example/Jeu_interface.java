package org.example;

public interface Jeu_interface {
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException;
    public void fermer();
    public boolean estOuvert();
}
