package io.github.rodrigoqueiroz01.service;

import io.github.rodrigoqueiroz01.model.ClientModel;
import io.github.rodrigoqueiroz01.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientModel create(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public ClientModel readById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente inválido."));
    }

    public List<ClientModel> readAll() {
        return clientRepository.findAll();
    }

    public ClientModel update(ClientModel clientModel, UUID id) {
        clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente inválido."));
        clientModel.setId(id);
        return clientModel;
    }

    public UUID delete(UUID id) {
        var clientModel = clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente inválido."));
        clientRepository.delete(clientModel);
        return id;
    }

}
