package co.unicauca.service;

import java.util.List;
import co.unicauca.model.Usuario;

public interface UsuarioServicioInt {
	public List<Usuario> listarTodosLosUsuarios();
	public Usuario obtenerUsuarioPorID(Long id);
}
