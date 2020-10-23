package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Usuario;
import br.com.fiap.teleorg.repository.UsuarioRepository;
import br.com.fiap.teleorg.service.exeption.DataIntegretyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public Usuario findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Object findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario insert(Usuario usuario) {
        usuario.setId(null);
        usuario = repository.saveAndFlush(usuario);
        return usuario;
    }

    private void updateUsuario(Usuario newUsuario, Usuario usuario) {
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setLogin(usuario.getLogin());
        newUsuario.setSenha(usuario.getSenha());
        newUsuario.setStatus(usuario.getStatus());
        newUsuario.setTipo(usuario.getTipo());
    }

    public Usuario update(Usuario usuario) {
        Usuario newUsuario = (Usuario) findById(usuario.getId());
        updateUsuario(newUsuario, usuario);
        return repository.saveAndFlush(newUsuario);
    }

    public void delete(String login) {
        findByLogin(login);
        try {
            repository.deleteByLogin(login);
        } catch (DataIntegretyException e) {
            throw new DataIntegretyException("Não é possível deletar o Usuario");
        }
    }

}
