package cl.muruna.back.service.impl;

import cl.muruna.back.dto.PhoneDTO;
import cl.muruna.back.dto.UserDTO;
import cl.muruna.back.model.Phone;
import cl.muruna.back.model.User;
import cl.muruna.back.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setMail(user.getMail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setIsActive(Boolean.TRUE);
        newUser = repository.save(newUser);
        for (PhoneDTO phoneAux : user.getPhones()) {
            Phone phone = new Phone();
            phone.setCountryCode(phoneAux.getCountryCode());
            phone.setNumber(phoneAux.getNumber());
            phone.setCityCode(phoneAux.getCityCode());
            phone.setUser(newUser);
            newUser.getPhones().add(phone);
        }
        return repository.save(newUser);
    }


}
