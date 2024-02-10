package org.example.zecelainfo.services.interfaces;

import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.dto.UserClasaDTO;
import org.example.zecelainfo.models.UserClasa;
import org.example.zecelainfo.models.UserClasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserClasaService {
    Optional<UserClasa> create(UserClasaDTO UserClasaDTO, String authenticated_email);

    List<UserClasa> getUserClasses(String authenticated_email);

    void delete(UserClasaDTO UserClasaDTO, String authenticated_email);
}
