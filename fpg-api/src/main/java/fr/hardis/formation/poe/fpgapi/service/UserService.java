package fr.hardis.formation.poe.fpgapi.service;

import java.util.List;
import java.util.Optional;

import fr.hardis.formation.poe.fpgapi.model.User;

public interface UserService {
	public Optional<User>  getUser(long id);
	public void addUser(User user)throws Exception;
	public void deleteUserById(Long id);
	public List<User> getListUsers();
	public boolean isUserExist(User user);
	public void updateUser(User user);
}
