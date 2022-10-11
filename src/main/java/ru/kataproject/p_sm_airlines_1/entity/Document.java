package ru.kataproject.p_sm_airlines_1.entity;

import lombok.Getter;
import lombok.Setter;
import ru.kataproject.p_sm_airlines_1.util.enums.DocumentType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "document_gen")
    @SequenceGenerator(name = "document_gen", sequenceName = "document_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document_type", nullable = false)
    private DocumentType documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "registration_address")
    private String registrationAddress;

    @Column(name = "where_issued")
    private String whereIssued;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;
}
