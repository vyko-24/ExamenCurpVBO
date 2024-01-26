package mx.edu.utez.ExamenVBO.controller.dto;

import mx.edu.utez.ExamenVBO.config.ApiResponse;
import mx.edu.utez.ExamenVBO.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
        return service.findAll();
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody PersonDto dto){
        System.out.println(dto);
        return service.save(dto.toEntity());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody PersonDto dto, @PathVariable Long id){
        return service.save(dto.toEntity());
    }
}
