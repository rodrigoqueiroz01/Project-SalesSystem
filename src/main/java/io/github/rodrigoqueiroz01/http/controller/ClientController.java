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
    public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.create(ClientMapper.toModel(clientRequest))));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponse> readById(@PathVariable String clientId) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.readById(UUID.fromString(clientId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponse>> readALl() {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponseList(clientService.readAll()));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponse> update(@PathVariable String clientId, @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok()
                .body(ClientMapper.toResponse(clientService.update(ClientMapper.toModel(clientRequest), UUID.fromString(clientId))));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<UUID> delete(@PathVariable String clientId) {
        return ResponseEntity.ok()
                .body(clientService.delete(UUID.fromString(clientId)));
    }

}
