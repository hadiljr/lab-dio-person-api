package lab.hadil.dio.personapi.repository;

import lab.hadil.dio.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
