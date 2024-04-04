import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont",
                "jeandupont@email.com");
        // TODO : Configuration du comportement du mock, utiliser la
//directive « when » avec sa méthode « thenReturn »
// ...

        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        // TODO : Création du service avec le mock
// ...
        UserService userService=new UserService(utilisateurApiMock);
        // TODO : Appel de la méthode à tester
        // ...
        userService.creerUtilisateur(utilisateur);

        // TODO : Vérification de l'appel à l'API
        // ...
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    @Test
    public void Test_Creation_user_with_exception()throws ServiceException
    {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont",
                "jeandupont@email.com");
        doThrow(new ServiceException("Echec de la creation de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService=new UserService(utilisateurApiMock);
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            // userService.creerUtilisateur(utilisateur);
        });


        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
    @Test
    public void Test_Creation_user_with_error_validation()throws ServiceException
    {
        Utilisateur utilisateur = new Utilisateur(null, null,
                null);
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService=new UserService(utilisateurApiMock);

        userService.creerUtilisateur(utilisateur);



        verify(utilisateurApiMock,never()).creerUtilisateur(utilisateur);
    }

    @Test
    public void Test_Creation_user_with_returned_id() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateurboolean(utilisateur)).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        assertTrue(userService.creerUtilisateurReturnBoolean(utilisateur));
        verify(utilisateurApiMock).creerUtilisateurboolean(utilisateur);
        int idUtilisateur = 123;
        when(utilisateurApiMock.creerUtilisateurReturnId(utilisateur)).thenReturn(idUtilisateur);
        assertEquals(idUtilisateur,userService.creerUtilisateurReturnId(utilisateur));
        verify(utilisateurApiMock).creerUtilisateurReturnId(utilisateur);




    }
    @Captor
    private ArgumentCaptor<Utilisateur> argumentCaptor;

    @Test
    public void Test_Creation_user_with_capture()throws ServiceException
    {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateurboolean(any(Utilisateur.class))).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        System.out.println(utilisateurCapture);
        assertEquals("Jean", utilisateurCapture.getName());
        assertEquals("Dupont", utilisateurCapture.getLastname());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());

    }

}