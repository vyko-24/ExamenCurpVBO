package mx.edu.utez.ExamenVBO.model.person;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="people")
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String lastname;
    @Column(columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;
    @Column(length = 10, nullable = false)
    private String sex;
    @Column(length = 20)
    private String curp;
    @Column(length = 50, nullable = false)
    private String estado;

    public Person(Long id, String name, String surname, String lastname, LocalDate birthdate, String sex, String curp, String estado) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.curp = curp;
        this.estado = estado;
    }
}
