package io.github.rodrigoqueiroz01.http.controller;

import io.github.rodrigoqueiroz01.http.dto.request.ClientRetailRequest;
import io.github.rodrigoqueiroz01.http.dto.response.ClientRetailResponse;
import io.github.rodrigoqueiroz01.http.mapper.ClientRetailMapper;
import io.github.rodrigoqueiroz01.service.ClientRetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vendas")
@AllArgsConstructor
@Validated
public class ClientRetailController {

    private final ClientRetailService clientRetailService;

    @PostMapping
    public ResponseEntity<ClientRetailResponse> save(@RequestBody ClientRetailRequest clientRetailRequest) {
        return ResponseEntity.ok()
                .body(ClientRetailMapper.toResponse(clientRetailService.save(ClientRetailMapper.toModel(clientRetailRequest))));
    }

    @GetMapping("/{clientRetailId}")
    public ResponseEntity<ClientRetailResponse> findById(@PathVariable String clientRetailId) {
        return ResponseEntity.ok()
                .body(ClientRetailMapper.toResponse(clientRetailService.findById(UUID.fromString(clientRetailId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientRetailResponse>> findALl() {
        return ResponseEntity.ok()
                .body(ClientRetailMapper.toResponseList(clientRetailService.findAll()));
    }

    @PutMapping("/{clientRetailId}")
    public ResponseEntity<ClientRetailResponse> update(@PathVariable String clientRetailId, @RequestBody ClientRetailRequest clientRetailRequest) {
        return ResponseEntity.ok()
                .body(ClientRetailMapper.toResponse(clientRetailService.update(ClientRetailMapper.toModel(clientRetailRequest), UUID.fromString(clientRetailId))));
    }

    @DeleteMapping("/{clientRetailId}")
    public ResponseEntity<UUID> delete(@PathVariable String clientRetailId) {
        return ResponseEntity.ok()
                .body(clientRetailService.delete(UUID.fromString(clientRetailId)));
    }

}
