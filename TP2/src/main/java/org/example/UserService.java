package org.example;
import org.example.ServiceException;
public class UserService {
    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public void  creerUtilisateur(Utilisateur utilisateur) throws
            ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }
    public boolean creerUtilisateurReturnBoolean(Utilisateur utilisateur)
            throws ServiceException{
        return   utilisateurApi.creerUtilisateurboolean(utilisateur);
    }
    public int creerUtilisateurReturnId(Utilisateur utilisateur)
            throws ServiceException{
        return  utilisateurApi.creerUtilisateurReturnId(utilisateur);
    }
}
