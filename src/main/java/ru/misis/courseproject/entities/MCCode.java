package ru.misis.courseproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MCCode {
    @Id
    @NotNull
    private Long MCC;
    @NotNull
    private String description;
    @OneToMany(mappedBy = "MCC")
    private Set<Transaction> transactions;

}
