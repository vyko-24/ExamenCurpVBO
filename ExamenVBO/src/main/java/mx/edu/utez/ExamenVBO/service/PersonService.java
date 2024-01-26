package mx.edu.utez.ExamenVBO.service;

import mx.edu.utez.ExamenVBO.config.ApiResponse;
import mx.edu.utez.ExamenVBO.model.person.Person;
import mx.edu.utez.ExamenVBO.model.person.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll(){
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        return new ResponseEntity<>(new ApiResponse(repository.findById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
    /*
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> update(Person person, Long id){
        repository.
    }

     */

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Person person){
        String a = String.valueOf(person.getSurname().charAt(0));
        String vocalPrimAp = String.valueOf(person.getSurname());
        String b = "";
        for (int z=1; z<=vocalPrimAp.length(); z++){
            String letra= String.valueOf(vocalPrimAp.charAt(z));
            if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")){
                b=letra;
                break;
            }
        }

        String c = String.valueOf(person.getLastname().charAt(0));
        String d = String.valueOf(person.getName().charAt(0));
        String anio = String.valueOf(person.getBirthdate().getYear());
        String e = anio.substring(2);
        String f = String.valueOf(person.getBirthdate().getMonthValue());
        int mes = Integer.parseInt(String.valueOf(person.getBirthdate().getDayOfMonth()));
        String g="";
        if (mes<10){
            g="0"+String.valueOf(person.getBirthdate().getDayOfMonth());
        }else{
            g=String.valueOf(person.getBirthdate().getDayOfMonth());
        }
        String h = String.valueOf(person.getSex().charAt(0));
        String i = String.valueOf(person.getEstado());
        String consIntPrimAp = String.valueOf(person.getSurname());
        String j ="";
        for (int z=1; z<=consIntPrimAp.length(); z++){
            String letra= String.valueOf(consIntPrimAp.charAt(z));
            if (!letra.equals("a") && !letra.equals("e") && !letra.equals("i") && !letra.equals("o") && !letra.equals("u")){
                j=letra;
                break;
            }
        }

        String consIntSegAp = String.valueOf(person.getLastname());
        String k ="";
        for (int z=1; z<=consIntSegAp.length(); z++){
            String letra= String.valueOf(consIntSegAp.charAt(z));
            if (!letra.equals("a") && !letra.equals("e") && !letra.equals("i") && !letra.equals("o") && !letra.equals("u")){
                k=letra;
                break;
            }
        }

        String constIntNomb = String.valueOf(person.getName());
        String l ="";
        for (int z=1; z<=constIntNomb.length(); z++){
            String letra= String.valueOf(constIntNomb.charAt(z));
            if (!letra.equals("a") && !letra.equals("e") && !letra.equals("i") && !letra.equals("o") && !letra.equals("u")){
                l=letra;
                break;
            }
        }

        Random random = new Random();
        char m = (char) (random.nextInt(26) + 'a');
        char n = (char) (random.nextInt(26) + 'a');

        person.setCurp(a+b+c+d+e+f+g+h+i+j+k+l+m+n);
        Optional<Person> foundPerson = repository.findByCurp(person.getCurp());
        if (foundPerson.isPresent())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true,"RecordAlreadyExist"), HttpStatus.BAD_REQUEST);
        person = repository.saveAndFlush(person);
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(person), HttpStatus.OK), HttpStatus.OK);
    }


}
