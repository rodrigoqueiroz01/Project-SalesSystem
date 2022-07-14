package io.github.rodrigoqueiroz01.repository;

import io.github.rodrigoqueiroz01.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> { }
