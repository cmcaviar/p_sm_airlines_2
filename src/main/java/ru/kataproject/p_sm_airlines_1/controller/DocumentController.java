package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDTO;

@Tag(name = "Document controller")
@RequestMapping(DocumentController.BASE_NAME)
public interface DocumentController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/document";

    @PostMapping("/create")
    @Operation(summary = "Create document", description = "Creates new document, returns id of created document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully returned",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Error while creating document", content = @Content)
    })
    ResponseEntity<Long> create(@RequestBody
                                @Parameter(description = "Full filled document DTO without id")
                                final DocumentDTO document);

    @PutMapping("/update")
    @Operation(summary = "Update document", description = "Edit document's fields, returns id of updated document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully updated",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Error while updating document", content = @Content)
    })
    ResponseEntity<Long> update(@RequestBody
                                @Parameter(description = "Full filled document DTO")
                                final DocumentDTO document);

    @GetMapping("/get-by-id")
    @Operation(summary = "Get document", description = "Provides document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully returned",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DocumentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
    })
    ResponseEntity<DocumentDTO> getById(@Parameter(description = "Document id") final Long id);

}
