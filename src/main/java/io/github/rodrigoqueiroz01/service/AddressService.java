package io.github.rodrigoqueiroz01.service;

import io.github.rodrigoqueiroz01.model.AddresModel;
import io.github.rodrigoqueiroz01.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddresModel create(AddresModel addresModel) {
        return addressRepository.save(addresModel);
    }

    public AddresModel readById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Endereço inválido."));
    }

    public List<AddresModel> readAll() {
        return addressRepository.findAll();
    }

    public AddresModel update(AddresModel addresModel, UUID id) {
        addressRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Endereço inválido."));
        addresModel.setId(id);
        return addresModel;
    }

    public UUID delete(UUID id) {
        var addresModel = addressRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Endereço inválido."));
        addressRepository.delete(addresModel);
        return id;
    }

}
