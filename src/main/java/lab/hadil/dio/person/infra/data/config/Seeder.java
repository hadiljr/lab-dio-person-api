package lab.hadil.dio.person.infra.data.config;

import io.github.jdataforger.Forger;
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
import java.util.Random;

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
        Forger forger = new Forger();
        int rndRegister = new Random().nextInt(100);


        for(int i=0;i<rndRegister;i++) {
            Person fakePerson = Person.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .cpf(forger.CPF().fake())
                    .birthDate(LocalDate.ofInstant(faker.date().birthday(10,80).toInstant(), ZoneId.systemDefault()))
                    .phones(Collections.singletonList(Phone.builder().number(faker.phoneNumber().phoneNumber()).type(PhoneType.MOBILE).build()))
                    .build();

            personRepository.save(fakePerson);
        }

    }

}
