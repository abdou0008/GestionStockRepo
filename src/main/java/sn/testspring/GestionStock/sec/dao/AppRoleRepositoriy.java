package sn.testspring.GestionStock.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.sec.entities.AppRole;

public interface AppRoleRepositoriy extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
