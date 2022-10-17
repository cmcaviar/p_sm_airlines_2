package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DocumentController;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDTO;
import ru.kataproject.p_sm_airlines_1.service.DocumentService;
import ru.kataproject.p_sm_airlines_1.util.mapper.DocumentMapper;

@RestController
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {

    private final DocumentService documentService;
    private final DocumentMapper documentMapper;

    @Override
    public ResponseEntity<Long> create(@RequestBody final DocumentDTO documentDTO) {
        Document document = documentMapper.convertToEntity(documentDTO);
        documentService.createDocument(document);
        return new ResponseEntity<>(document.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> update(@RequestBody final DocumentDTO documentDTO) {
        Document document = documentMapper.convertToEntity(documentDTO);
        documentService.updateDocument(document);
        return new ResponseEntity<>(document.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DocumentDTO> getById(@RequestParam final Long id) {
        DocumentDTO document = documentMapper.convertToDTO(documentService.getDocument(id)) ;
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

}
