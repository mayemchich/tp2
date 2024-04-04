package org.example;

public class Jeu implements Jeu_interface{
    Banque local_bank;
    public Jeu(Banque labanque)
    {
        this.local_bank=labanque;
    }
    @Override
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if(local_bank.est_solvable())
        {

            int Somme_jet=de1.lancer()+de2.lancer();
            if(Somme_jet==7)
            {
                joueur.crediter(2*joueur.mise());
                local_bank.debiter(2*joueur.mise());
                if(!local_bank.est_solvable())
                {
                    fermer();
                    throw new JeuFermeException("BANQUE PAS SOLVABLE");
                }

            }
            else {
                joueur.debiter(joueur.mise());
            }
        }
        else {
            fermer();
            throw new JeuFermeException("BANQUE PAS SOLVABLE");
        }
    }

    @Override
    public void fermer() {
        jeu_ouvert=false;
    }
    boolean jeu_ouvert=true;
    @Override
    public boolean estOuvert() {
        return jeu_ouvert;
    }
}
