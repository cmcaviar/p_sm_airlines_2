package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.kataproject.p_sm_airlines_1.util.enums.DocumentType;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Full info about document")
public class DocumentDTO {

    @Schema(description = "Unique id in database",example = "13")
    private Long id;

    @Schema(description = "Type of document(passport, birth certificate etc.)",example = "PASSPORT")
    private DocumentType documentType;

    @Schema(description = "Series and number of document",example = "7469 123456")
    private String documentNumber;

    @Schema(description = "Passport field Registration address",
            example = "Kazntip oblast , Siniy rayon, selo Shiryaevo")
    private String registrationAddress;

    @Schema(description = "Place where document was given",
            example = "Otdeleniem UFMS PO OBLASTI NA RAYONE")
    private String whereIssued;

    @Schema(description = "Code of department that gives document",example = "345-987 ")
    private String departmentCode;

    @Schema(description = "Date when document was given",example = "2022-07-09T15:58:09")
    private LocalDateTime dateOfIssue;

    //todo fix description and field after link to person
    @Schema(description = "Here will be link to person entity (maybe)",example = "Makarov Egor Fanovich")
    private String person = "link to person entity";
}
