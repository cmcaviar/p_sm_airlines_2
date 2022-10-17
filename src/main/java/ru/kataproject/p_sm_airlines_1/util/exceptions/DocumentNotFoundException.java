package ru.kataproject.p_sm_airlines_1.util.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
public class DocumentNotFoundException extends AbstractResourceNotFoundException{
    private static final String RESOURCE_ALIAS = "Document";
    private final String message;

    private String buildMessage(final Long documentId) {
        String messageBuilder = getResourceAlias() + " with id " + documentId.toString() + " is not found.";
        return messageBuilder;
    }
    private String buildMessage() {
        String messageBuilder = "No " + getResourceAlias() + "s are found.";
        return messageBuilder;
    }
    public DocumentNotFoundException(){
        message = buildMessage();
    }
    public DocumentNotFoundException(final Long documentID){
        message = buildMessage(documentID);
    }

    @Override
    protected String getResourceAlias() {
        return RESOURCE_ALIAS;
    }
}
