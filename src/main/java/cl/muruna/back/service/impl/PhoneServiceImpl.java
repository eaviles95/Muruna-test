package cl.muruna.back.service.impl;

import cl.muruna.back.exception.EntityNotFoundExceptionId;
import cl.muruna.back.model.Phone;
import cl.muruna.back.repository.IPhoneRepository;
import cl.muruna.back.service.IPhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PhoneServiceImpl implements IPhoneService {

    private final IPhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(IPhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone createPhone(Phone phone) {
        log.info("Iniciando método para agregar telefono");
        Phone phoneAux = new Phone();
        phoneAux.setCityCode(phone.getCityCode());
        phoneAux.setNumber(phone.getNumber());
        phoneAux.setCountryCode(phone.getCountryCode());
        phoneRepository.save(phone);
        return phoneAux;
    }

    public Phone getPhoneById(Integer id){
        return phoneRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundExceptionId(id,Phone.class.getSimpleName()));
    }

}
