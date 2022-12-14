package ru.kataproject.p_sm_airlines_1.entity;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passenger", schema = "public")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NonNull
    @Column(name="document")
    private String document;  // Заглушка , здесь должна быть сущность Document

    @NonNull
    @Column(name="email")
    private String email;

    @NonNull
    @Column(name="first_name")
    private String first_name;

    @NonNull
    @Column(name="last_name")
    private String last_name;

    @NonNull
    @Column(name="middle_name")
    private String middle_name;

    @NonNull
    @Column(name="date_of_birth")
    private LocalDate date_of_birth;

}
