package ru.kataproject.p_sm_airlines_1.entity.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PassengerDTO {
    @Id
    private Long id;

    @NotBlank(message = "Необходимо указать паспортные данные")
    private String document;

    @Email(message = "Email должен быть корректным адресом электронной почты")
    @Size(min=15, max=200)
    private String email;

    @NotBlank(message = "Необходимо указать имя")
    @Size(min=1, max=40)
    private String first_name;

    @NotBlank(message = "Необходимо указать отчество")
    @Size(min=1, max=50)
    private String last_name;

    @NotBlank(message = "Необходимо указать фамилию")
    @Size(min=1, max=40)
    private String middle_name;

    @NotBlank(message = "Необходимо указать дату рождения")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate date_of_birth;
}
