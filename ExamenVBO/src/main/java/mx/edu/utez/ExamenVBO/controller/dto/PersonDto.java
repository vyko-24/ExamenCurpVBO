package mx.edu.utez.ExamenVBO.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenVBO.model.person.Person;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class PersonDto {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private LocalDate birthdate;
    private String sex;
    private String curp;
    private String estado;

    public Person toEntity(){
        return new Person(id, name, surname,lastname, birthdate, sex, curp, estado);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", sex='" + sex + '\'' +
                ", estado='" + estado + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }
}
