package cl.muruna.back.service;

import cl.muruna.back.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    public User createUser(User user);

    public String deleteUser(UUID userId);

    public String updateUser(User user);

    public List<User> getAllUsers();

    public String updateIsActive(UUID id, Boolean active);

}
