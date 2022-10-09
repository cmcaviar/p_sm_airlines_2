package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Document;

@Tag(name = "Main example controller")
@RequestMapping(DocumentController.BASE_NAME)
public interface DocumentController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/document";

    @PostMapping("/create")
    @Operation(summary = "Create document", description = "Creates new document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error while creating document", content = @Content)
    })
    ResponseEntity<String> create(@RequestBody Document document);

    @PutMapping("/update")
    @Operation(summary = "Update document", description = "Edit document's fields")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error while updating document", content = @Content)
    })
    ResponseEntity<String> update(@RequestBody Document document);

    @GetMapping("/get-by-id")
    @Operation(summary = "Get document", description = "Provides document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Document not found", content = @Content)
    })
    ResponseEntity<Document> getById(Long id);

}
