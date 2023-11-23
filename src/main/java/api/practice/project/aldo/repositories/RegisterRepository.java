package api.practice.project.aldo.repositories;

import api.practice.project.aldo.models.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Integer> {
}
