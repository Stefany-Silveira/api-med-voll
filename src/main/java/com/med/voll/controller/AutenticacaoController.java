package com.med.voll.controller;

import com.med.voll.domain.usuario.Usuario;
import com.med.voll.infra.security.DadosTokenJWT;
import com.med.voll.infra.security.TokenService;
import jakarta.validation.Valid;
import com.med.voll.domain.usuario.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}