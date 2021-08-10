package br.com.zenite.zenite.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.zenite.zenite.model.UsuarioModel;
import br.com.zenite.zenite.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario(userName);
		usuario.orElseThrow(()-> new UsernameNotFoundException(userName + " not found"));
		
		return usuario.map(UserDetailsImpl:: new).get();
	}
}
