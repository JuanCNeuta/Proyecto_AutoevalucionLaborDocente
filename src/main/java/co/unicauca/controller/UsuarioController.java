package co.unicauca.controller;

import co.unicauca.model.Usuario;
import co.unicauca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping({"/usuarios"})
    public Iterable<Usuario> obtenerUsuarios(Model model) {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setUsuario(usuarioActualizado.getUsuario());
            usuarioExistente.setContraseña(usuarioActualizado.getContraseña());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
