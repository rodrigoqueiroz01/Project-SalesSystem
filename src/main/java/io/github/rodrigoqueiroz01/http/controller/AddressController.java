package io.github.rodrigoqueiroz01.http.controller;

import io.github.rodrigoqueiroz01.http.dto.request.AddressRequest;
import io.github.rodrigoqueiroz01.http.dto.response.AddressResponse;
import io.github.rodrigoqueiroz01.http.mapper.AddressMapper;
import io.github.rodrigoqueiroz01.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
@Validated
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> create(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok()
                .body(AddressMapper.toResponse(addressService.create()))
    }

}
