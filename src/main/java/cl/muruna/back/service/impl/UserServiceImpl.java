package cl.muruna.back.service.impl;

import cl.muruna.back.exception.EntityNotFoundException;
import cl.muruna.back.exception.InvalidInputException;
import cl.muruna.back.model.Phone;
import cl.muruna.back.model.User;
import cl.muruna.back.repository.IUserRepository;
import cl.muruna.back.service.IPhoneService;
import cl.muruna.back.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final IPhoneService phoneService;

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-]).{8,}$";
    private static final Pattern patternPassWord = Pattern.compile(PASSWORD_REGEX);

    private static final Pattern patternEmail = Pattern.compile(EMAIL_REGEX);

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IPhoneService phoneService) {
        this.userRepository = userRepository;
        this.phoneService = phoneService;
    }

    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }


    public static boolean validatePassword(String password) {
        Matcher matcher = patternPassWord.matcher(password);
        return matcher.matches();
    }
    public static boolean validateEmail(String email) {
        Matcher matcher = patternEmail.matcher(email);
        return matcher.matches();
    }

    public boolean existMail(String email) {
        return userRepository.existsByMail(email);
    }
    public User createUser(User user) {
        if (validateEmail(user.getMail()) && validatePassword(user.getPassword()) && !existMail(user.getMail())) {
            User userAux = new User();
            userAux.setName(user.getName());
            userAux.setMail(user.getMail());
            userAux.setPassword(user.getPassword());
            userAux = userRepository.save(userAux);
            for (Phone phoneAux : user.getPhones()) {
                Phone phone = new Phone();
                phone.setCountryCode(phoneAux.getCountryCode());
                phone.setNumber(phoneAux.getNumber());
                phone.setCityCode(phoneAux.getCityCode());
                phone.setUser(userAux);
                userAux.getPhones().add(phone);
            }
            userRepository.save(userAux);
            return userAux;
        } else {
            throw new InvalidInputException(User.class.getSimpleName());
        }
    }

    public String deleteUser(UUID userId) {
        log.info("Iniciando método para eliminar un usuario");
        User user = getUserById(userId).orElseThrow(()
                -> new EntityNotFoundException(userId, User.class.getSimpleName()));
        userRepository.delete(user);
        return "Se ha eliminado un usuario";
    }

    public String updateUser(User user) {
        User userAux = getUserById(user.getId()).orElseThrow(() ->
                new EntityNotFoundException(user.getId(), User.class.getSimpleName()));
        if (user.getName() != null) {
            userAux.setName(user.getName());
        }
        if (user.getMail() != null) {
            userAux.setMail(user.getMail());
        }
        if (user.getPassword() != null) {
            userAux.setPassword(user.getPassword());
        }
        if (user.getCreatedAt() != null) {
            userAux.setCreatedAt(user.getCreatedAt());
        }
        // Actualizar los números de teléfono
        Set<Phone> updatedPhones = user.getPhones();
        if (updatedPhones != null && !updatedPhones.isEmpty()) {
            userAux.getPhones().clear();
            for (Phone phoneAux : updatedPhones) {
                Phone phone = new Phone();
                phone.setCountryCode(phoneAux.getCountryCode());
                phone.setNumber(phoneAux.getNumber());
                phone.setCityCode(phoneAux.getCityCode());
                phone.setUser(userAux);
                userAux.getPhones().add(phone);
            }
        }
        userRepository.save(userAux);
        return "Se ha actualizado el usuario";
    }

    public String updateIsActive(UUID id, Boolean active){
        User user = getUserById(id).orElseThrow(() ->
                new EntityNotFoundException(id, User.class.getSimpleName()));
        user.setIsActive(active);
        userRepository.save(user);
        return "Se ha modificado la actividad del usuario";
    }


    public List<User> getAllUsers() {
        log.info("Se traen todos los usuarios existentes");
        return userRepository.findAll();
    }
}
