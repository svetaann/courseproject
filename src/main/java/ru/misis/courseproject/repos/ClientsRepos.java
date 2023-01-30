package ru.misis.courseproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.misis.courseproject.entities.Client;

public interface ClientsRepos extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    Client findClientByClientId(Long id);
}
