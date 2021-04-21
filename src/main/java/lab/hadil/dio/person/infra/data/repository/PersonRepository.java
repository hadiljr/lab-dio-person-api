package lab.hadil.dio.person.infra.data.repository;

import lab.hadil.dio.person.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
