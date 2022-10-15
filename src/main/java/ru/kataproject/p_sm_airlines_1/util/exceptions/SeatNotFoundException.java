package ru.kataproject.p_sm_airlines_1.util.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * It's simple message and http-status
 */
@Getter
@Setter
@NoArgsConstructor
public class SeatNotFoundException extends AbstractResourceNotFoundException{
    private final String resourceAlies = "Seat";
    protected String getResourceAlias() {
        return resourceAlies;
    }
    public SeatNotFoundException(Long id) {
        super(id.toString());
    }

}
