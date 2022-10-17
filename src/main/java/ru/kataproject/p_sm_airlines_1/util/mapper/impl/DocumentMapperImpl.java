package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDTO;
import ru.kataproject.p_sm_airlines_1.util.mapper.DocumentMapper;
@Component
public class DocumentMapperImpl implements DocumentMapper {
    @Override
    public DocumentDTO convertToDTO(Document document) {
        return new DocumentDTO(document.getId(), document.getDocumentType(), document.getDocumentNumber(),
                document.getRegistrationAddress(), document.getWhereIssued(), document.getDepartmentCode(),
                document.getDateOfIssue(), document.getPerson());
    }

    @Override
    public Document convertToEntity(DocumentDTO documentDTO) {
        Document document = new Document();
        document.setId(documentDTO.getId());
        document.setDocumentType(documentDTO.getDocumentType());
        document.setDocumentNumber(documentDTO.getDocumentNumber());
        document.setRegistrationAddress(documentDTO.getRegistrationAddress());
        document.setWhereIssued(documentDTO.getWhereIssued());
        document.setDepartmentCode(documentDTO.getDepartmentCode());
        document.setDateOfIssue(documentDTO.getDateOfIssue());
        document.setPerson(documentDTO.getPerson());
        return document;
    }
}
