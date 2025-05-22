package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import application.repository.GeneroRepository;
import application.repository.JogoRepository;
import application.repository.ModoRepository;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepo;
    @Autowired
    private ModoRepository modoRepo;
    @Autowired
    private GeneroRepository generoRepo;
    @Autowired
    private PlataformaRepository plataformaRepo;

    
}