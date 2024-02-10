package org.example.zecelainfo.repositories;

import org.example.zecelainfo.models.*;
import org.hibernate.mapping.Array;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserClasaRepository extends JpaRepository<UserClasa, Integer> {
    // Custom queries if needed
    List<UserClasa> findUserClasasByUser(User user);
    void deleteUserClasaByUserAndClasa(User user, Clasa clasa);
}

