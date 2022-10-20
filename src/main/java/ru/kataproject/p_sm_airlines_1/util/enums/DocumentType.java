package ru.kataproject.p_sm_airlines_1.util.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DocumentType {
    PASSPORT ("LOCAL_PASSPORT"),
    FOREIGN_PASSPORT ("FOREIGN_PASSPORT"),
    BIRTH_CERTIFICATE ("BIRTH_CERTIFICATE"),
    MILITARY_PASSPORT ("MILITARY_PASSPORT");
    private final String documentName;

}
