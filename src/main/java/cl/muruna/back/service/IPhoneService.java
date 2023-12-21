package cl.muruna.back.service;

import cl.muruna.back.dto.PhoneDTO;
import cl.muruna.back.model.Phone;

public interface IPhoneService {

    public Phone createPhone(Phone phone);

    public Phone getPhoneById(Integer id);

}
