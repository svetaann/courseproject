package ru.misis.courseproject.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long typeId;
    @NotNull
    private String typeName;
    @OneToMany(mappedBy = "typeId")
    private Set<Transaction> transactions;
}
