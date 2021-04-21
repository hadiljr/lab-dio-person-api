package lab.hadil.dio.personapi.service;

import lab.hadil.dio.personapi.dto.request.PersonDTO;
import lab.hadil.dio.personapi.dto.response.MessageResponseDTO;
import lab.hadil.dio.personapi.entity.Person;
import lab.hadil.dio.personapi.mapper.PersonMapper;
import lab.hadil.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
