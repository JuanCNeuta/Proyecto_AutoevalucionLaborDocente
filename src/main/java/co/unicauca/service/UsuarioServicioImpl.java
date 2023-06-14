package co.unicauca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.unicauca.model.Usuario;
import co.unicauca.repository.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicioInt {
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario obtenerUsuarioPorID(Long id) {
		return usuarioRepo.findById(id).get();
	}

	public List<Usuario> obtenerUsuariosPorRol(String rol) {
        return usuarioRepo.findAllByRol(rol);
    }
}
