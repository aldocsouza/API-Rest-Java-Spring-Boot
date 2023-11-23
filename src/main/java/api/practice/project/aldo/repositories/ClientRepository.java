package api.practice.project.aldo.repositories;

import api.practice.project.aldo.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
}
