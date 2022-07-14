package io.github.rodrigoqueiroz01.http.controller;

import io.github.rodrigoqueiroz01.http.dto.request.ClientRequest;
import io.github.rodrigoqueiroz01.http.dto.response.ClientResponse;
import io.github.rodrigoqueiroz01.http.mapper.ClientMapper;
import io.github.rodrigoqueiroz01.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.save(ClientMapper.toModel(clientRequest))));
    }

    @GetMapping("/{clientRetailId}")
    public ResponseEntity<ClientResponse> findById(@PathVariable String clientRetailId) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.findById(UUID.fromString(clientRetailId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponse>> findALl() {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponseList(clientService.findAll()));
    }

    @PutMapping("/{clientRetailId}")
    public ResponseEntity<ClientResponse> update(@PathVariable String clientRetailId, @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.update(ClientMapper.toModel(clientRequest), UUID.fromString(clientRetailId))));
    }

    @DeleteMapping("/{clientRetailId}")
    public ResponseEntity<UUID> delete(@PathVariable String clientRetailId) {
        return ResponseEntity.ok()
                .body(clientService.delete(UUID.fromString(clientRetailId)));
    }

}
