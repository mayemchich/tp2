import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class Test_jeu {

    @Test
    public void Test_Ferme_Jeu() throws JeuFermeException, DebitImpossibleException {
        Banque bank=mock(Banque.class);
        Jeu_interface jeu=new Jeu(bank);
        Joueur joueur=mock(Joueur.class);
        De de1=mock(De.class);
        De de2=mock(De.class);
        jeu.fermer();
        assertThrows(JeuFermeException.class,()->jeu.jouer(joueur,de1,de2));
    }
    @Test
    public void Joueur_insolvable_test() throws DebitImpossibleException {
        Banque bank=mock(Banque.class);
        when(bank.est_solvable()).thenReturn(true);

        Joueur joueur=mock(Joueur.class);
        when(joueur.mise()).thenReturn(15);
        doThrow(DebitImpossibleException.class).when(joueur).debiter(anyInt());
        Jeu_interface jeu=new Jeu(bank);
        De Mock1 = mock(De.class);
        De Mock2 = mock(De.class);
        try {
            jeu.jouer(joueur, Mock1, Mock2);
        } catch (DebitImpossibleException | JeuFermeException e) {
        }

        verify(Mock1, never()).lancer();
        verify(Mock2, never()).lancer();


    }
    @Test
    public void test_bank_insolvable_apres_gain_joueur(){
        Banque b=new Bank_min_plus_fond(10,500);
        Joueur j=mock(Joueur.class);
        when(j.mise()).thenReturn(10);
        De de1=mock(De.class);
        De de2=mock(De.class);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(5);
        Jeu_interface game=new Jeu(b);
        assertThrows(JeuFermeException.class,()->game.jouer(j,de1,de2));
        verify(j).crediter(2*10);
    }

}
