package sn.testspring.GestionStock.sec.services;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.testspring.GestionStock.sec.dao.AppRoleRepositoriy;
import sn.testspring.GestionStock.sec.dao.UtilisateurRepositoriy;
import sn.testspring.GestionStock.sec.entities.AppRole;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private UtilisateurRepositoriy utilisateurRepositoriy;
    private AppRoleRepositoriy appRoleRepositoriy;
    private PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur saveNewUser(String usernam, String password, String repassword) {
        if (!password.equals(repassword)) throw new RuntimeException("password not match");
        String hashedPWD=passwordEncoder.encode(password);
        Utilisateur appUser =new Utilisateur();
        appUser.setCodeUtilisateur(UUID.randomUUID().toString());
        appUser.setUsername(usernam);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        Utilisateur savedAppUser= utilisateurRepositoriy.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole=appRoleRepositoriy.findByRoleName(roleName);
        if (appRole!=null) throw new RuntimeException("Role"+roleName+" existe déjà !");
        appRole =new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole=appRoleRepositoriy.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Utilisateur appUser=  utilisateurRepositoriy.findByUsername(username);
        if (appUser==null) throw new RuntimeException("utilisateur introuvable !");
        AppRole appRole=appRoleRepositoriy.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role introuvable !");
        appRole.setRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        Utilisateur appUser=  utilisateurRepositoriy.findByUsername(username);
        if (appUser==null) throw new RuntimeException("utilisateur introuvable !");
        AppRole appRole=appRoleRepositoriy.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role introuvable !");
        appRole.setRoleName(roleName);
        appUser.getAppRoles().remove(appRole);

    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepositoriy.findByUsername(username);
    }
}
