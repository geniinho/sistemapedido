package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Cliente;
import com.geninho.ordempedido.repositories.ClienteRepository;
import com.geninho.ordempedido.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cliente.getId(),cliente.getEmail(),cliente.getSenha(),cliente.getPerfis());
    }
}
