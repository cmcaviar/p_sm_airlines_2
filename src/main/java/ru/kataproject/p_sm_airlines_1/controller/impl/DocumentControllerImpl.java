package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DocumentController;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.service.DocumentService;

@RestController
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {

    private final DocumentService documentService;

    @Override
    public ResponseEntity<String> create(@RequestBody Document document) {
        documentService.createDocument(document);
        return new ResponseEntity<>(document.getId().toString(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Document document) {
        documentService.updateDocument(document);
        return new ResponseEntity<>(document.getId().toString(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Document> getById(@RequestParam Long id) {
        Document document = documentService.getDocument(id);
        if (document == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

}
