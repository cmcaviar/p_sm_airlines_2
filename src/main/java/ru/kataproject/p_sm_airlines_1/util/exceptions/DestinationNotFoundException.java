package ru.kataproject.p_sm_airlines_1.util.exceptions;

public class DestinationNotFoundException extends AbstractResourceNotFoundException{

    public DestinationNotFoundException() {
        this.message = buildMessage();
    }

    public DestinationNotFoundException(String resourceCity) {
        this.message = buildMessage(resourceCity);
    }

    private static final String RESOURCE_ALIAS = "Destination";
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
    @Override
    protected String getResourceAlias() {
        return RESOURCE_ALIAS;
    }

    private String buildMessage(final String resourceCity) {
        if (!Character.isDigit(resourceCity.charAt(0))) {
            String messageBuilder = getResourceAlias() + " with city/country " +
                    resourceCity +
                    " is not found.";
            return messageBuilder;
        } else {
            String messageBuilder = getResourceAlias() + " with id " +
                    resourceCity +
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
