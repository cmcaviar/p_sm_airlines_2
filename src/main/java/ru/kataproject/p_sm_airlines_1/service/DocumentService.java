package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Document;

public interface DocumentService {
    void createDocument(Document document);
    void updateDocument(Document document);
    Document getDocument(Long id);
}
