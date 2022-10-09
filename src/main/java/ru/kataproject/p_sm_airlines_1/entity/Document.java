package ru.kataproject.p_sm_airlines_1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.kataproject.p_sm_airlines_1.util.enums.DocumentType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private DocumentType documentType;

    private String documentNumber;

    private String registrationAddress;

    private String whereIssued;

    private String departmentCode;

    private Date dateOfIssue;
}
