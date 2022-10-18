package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.repository.DocumentRepository;
import ru.kataproject.p_sm_airlines_1.service.DocumentService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.DocumentNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.handlers.DocumentExceptionHandler;

@Service
@RequiredArgsConstructor
@DocumentExceptionHandler
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public void createDocument(final Document document) {
        document.setId(null);
        documentRepository.save(document);
    }

    @Override
    public void updateDocument(final Document document) {
        documentRepository.save(document);
    }

    @Override
    public Document getDocument(final Long id) {
        Document result = documentRepository.findById(id).orElse(null);
        if (result == null){
            throw new DocumentNotFoundException(id);
        }
        return result;
    }
}
