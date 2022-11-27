package ru.kataproject.p_sm_airlines_1.util.exceptions;

public class TicketNotFoundException extends AbstractResourceNotFoundException{

    public TicketNotFoundException(){
        this.message = buildMessage();
    }

    public TicketNotFoundException(String reservationNumber){
        this.message = buildMessage(reservationNumber);
    }

    private static final String RESOURCE_ALIAS = "Ticket";
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    protected String getResourceAlias() {
        return RESOURCE_ALIAS;
    }

    private String buildMessage(final String reservationNumber) {
        if(!Character.isDigit(reservationNumber.charAt(0))) {
            String messageBuilder = getResourceAlias() + "with reservation number" + reservationNumber +" is not found.";
            return messageBuilder;
        }  else {
            String messageBuilder = getResourceAlias() +"with id " + reservationNumber +" is not found.";
            return messageBuilder;
        }
    }

    private String buildMessage() {
        String messageBuilder = "No " +getResourceAlias()+"'s are found.";
        return messageBuilder;
    }
}
