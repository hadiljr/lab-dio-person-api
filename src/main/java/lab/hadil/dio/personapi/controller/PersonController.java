package lab.hadil.dio.personapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lab.hadil.dio.personapi.dto.request.PersonDTO;
import lab.hadil.dio.personapi.dto.response.MessageResponseDTO;
import lab.hadil.dio.personapi.exception.PersonNotFoundException;
import lab.hadil.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@Api(value = "Lab DIO - API Person Java/Cloud", produces = "application/json")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add new person", produces = "application/json")
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping
    @ApiOperation(value = "Get all person", produces = "application/json")
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get person by Id", produces = "application/json")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete person", produces = "application/json")
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update person", produces = "application/json")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        //Validate.notNull(vehicleId, "Missing mandatory input parameter: vehicleId");
        return personService.update(id, personDTO);
    }
}
