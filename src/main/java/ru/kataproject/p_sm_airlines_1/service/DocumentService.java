package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Document;

public interface DocumentService {
    void createDocument(final Document document);
    void updateDocument(final Document document);
    Document getDocument(final Long id);
}
