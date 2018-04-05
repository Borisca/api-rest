package fr.hardis.formation.poe.fpgapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.hardis.formation.poe.fpgapi.api.UserExistException;
import fr.hardis.formation.poe.fpgapi.dao.UserDao;
import fr.hardis.formation.poe.fpgapi.model.User;

@Service
@Qualifier("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao daoUser;
	
	
	public Optional<User>  getUser(long id) {
		return daoUser.findById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor= {ConstraintViolationException.class})
	public void addUser(User user) throws Exception {
		boolean isExist = daoUser.existsById(user.getId());
		if ( isExist ) {
			throw new UserExistException("Fuck it exist !");
		}
		daoUser.save(user);	
	}
	
	public void deleteUser(User user) {
		daoUser.delete(user);
	}
	
	public List<User> getListUsers(){
		return daoUser.findAll();
	}
	
	public boolean isUserExist(User user) {
		return daoUser.existsById(user.getId());
	}
}
