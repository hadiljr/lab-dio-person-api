package lab.hadil.dio.person.infra.data.config;

import lab.hadil.dio.person.domain.entity.Person;
import lab.hadil.dio.person.domain.entity.Phone;
import lab.hadil.dio.person.domain.enums.PhoneType;
import lab.hadil.dio.person.infra.data.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Locale;

import com.github.javafaker.Faker;

@Component
@Profile("dev")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Seeder {

    private PersonRepository personRepository;


    @EventListener
    public void seed(ContextRefreshedEvent event){
        seedPerson();
    }

    private void seedPerson(){
        Faker faker = new Faker(new Locale("pt-BR"));
        String[] cpfs = {"756.361.380-32","536.890.330-80","819.078.380-74"};
        for(String cpf:cpfs) {
            Person fakePerson = Person.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .cpf(cpf)
                    .birthDate(LocalDate.ofInstant(faker.date().birthday(10,80).toInstant(), ZoneId.systemDefault()))
                    .phones(Collections.singletonList(Phone.builder().number(faker.phoneNumber().phoneNumber()).type(PhoneType.MOBILE).build()))
                    .build();

            personRepository.save(fakePerson);
        }

    }

}
