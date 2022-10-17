package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.kataproject.p_sm_airlines_1.util.enums.DocumentType;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private DocumentType documentType;
    private String documentNumber;
    private String registrationAddress;
    private String whereIssued;
    private String departmentCode;
    private LocalDateTime dateOfIssue;
    private String person = "link to person entity";
}
