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

    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public ClientModel findById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
    }

    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    public ClientModel update(ClientModel clientModel, UUID id) {
        clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
        clientModel.setId(id);
        return clientModel;
    }

    public UUID delete(UUID id) {
        ClientModel clientRetail = clientRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
        clientRepository.delete(clientRetail);
        return id;
    }

}
