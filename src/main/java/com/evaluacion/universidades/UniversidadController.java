package com.evaluacion.universidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universidades")
public class UniversidadController {

    @Autowired
    private UniversidadRepository repo;

    @GetMapping
    public List<Universidad> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Universidad crear(@RequestBody Universidad u) {
        return repo.save(u);
    }

    @PutMapping("/{id}")
    public Universidad actualizar(@PathVariable Long id, @RequestBody Universidad u) {
        u.setId(id);
        return repo.save(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
