package io.github.rodrigoqueiroz01.service;

import io.github.rodrigoqueiroz01.model.ClientRetailModel;
import io.github.rodrigoqueiroz01.repository.ClientRetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientRetailService {

    private ClientRetailRepository clientRetailRepository;

    public ClientRetailModel save(ClientRetailModel clientRetailModel) {
        return clientRetailRepository.save(clientRetailModel);
    }

    public ClientRetailModel findById(UUID id) {
        return clientRetailRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
    }

    public List<ClientRetailModel> findAll() {
        return clientRetailRepository.findAll();
    }

    public ClientRetailModel update(ClientRetailModel clientRetailModel, UUID id) {
        clientRetailRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
        clientRetailModel.setId(id);
        return clientRetailModel;
    }

    public UUID delete(UUID id) {
        ClientRetailModel clientRetail = clientRetailRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cliente de varejo inválido."));
        clientRetailRepository.delete(clientRetail);
        return id;
    }

}
