package sn.testspring.GestionStock.sec.services;

import sn.testspring.GestionStock.sec.entities.AppRole;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

public interface SecurityService {
    Utilisateur saveNewUser(String usernam,String password,String repassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    Utilisateur loadUserByUsername(String username);
}
