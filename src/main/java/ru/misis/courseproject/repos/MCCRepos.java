package ru.misis.courseproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.misis.courseproject.entities.MCCode;

public interface MCCRepos extends JpaRepository<MCCode,String > {
    MCCode findMCCodesByMCC(Long mcc);
}

