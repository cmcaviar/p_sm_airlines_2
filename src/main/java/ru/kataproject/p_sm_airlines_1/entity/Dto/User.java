package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private Timestamp created;
}
