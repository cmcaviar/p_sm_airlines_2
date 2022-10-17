package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDTO;

public interface DocumentMapper {
    DocumentDTO convertToDTO(Document document);
    Document convertToEntity(DocumentDTO documentDTO);
}
