package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Jogo;
import application.model.Modo;
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

    
    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("jogos", jogoRepo.findAll());

        return "/jogos/list";
    }

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("modo", modoRepo.findAll());
        return "/jogos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("id_genero") long id_genero,
        @RequestParam("modo") long[] ids_modo) {

        Optional<Genero> genero = generoRepo.findById(id_genero);

        if(genero.isPresent()) {
            Jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setTitulo(titulo);(genero.get());

            for (long a_id : ids_modo) {
                Optional<Modo> result_a = modoRepo.findById(a_id);
                if(result_a.isPresent()) {
                    jogo.getModo().add(result_a.get());
                }
            }

            jogoRepo.save(jogo);
        }

        return "redirect:/jogos/list";
    }
}