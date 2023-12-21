package cl.muruna.back.repository;

import cl.muruna.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    boolean existsByMail(String email);

    User findByName(String name);
}
