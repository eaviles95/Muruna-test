package cl.muruna.back.repository;

import cl.muruna.back.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {

}
