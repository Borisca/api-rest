package fr.hardis.formation.poe.fpgapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hardis.formation.poe.fpgapi.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
