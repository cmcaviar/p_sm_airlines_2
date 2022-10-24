package ru.kataproject.p_sm_airlines_1.util.exceptions;

public class PassengerNotFoundException extends AbstractResourceNotFoundException{

    public PassengerNotFoundException() {
        this.message = buildMessage();
    }

    public PassengerNotFoundException(String resourceCity) {
        this.message = buildMessage(resourceCity);
    }

    private static final String RESOURCE_ALIAS = "Passenger";
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
    @Override
    protected String getResourceAlias() {
        return RESOURCE_ALIAS;
    }

    private String buildMessage(final String resourceId) {
        if (!Character.isDigit(resourceId.charAt(0))) {
            String messageBuilder = getResourceAlias() + " with id " +
                    resourceId +
                    " is not found.";
            return messageBuilder;
        } else {
            String messageBuilder = getResourceAlias() + " with id " +
                    resourceId +
                    " is not found.";
            return messageBuilder;
        }
    }
    private String buildMessage() {
        String messageBuilder = "No " + getResourceAlias() +
                "s are found.";
        return messageBuilder;
    }
}
