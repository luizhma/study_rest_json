package luiz_hma.study_rest_json.controller;

import luiz_hma.study_rest_json.model.bean.Livro;
import luiz_hma.study_rest_json.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/livros")
public class LivroResource {

    @Autowired
    private LivroRepository livroRepo;

    @GetMapping ("/lista")
    public List<Livro> listarLivros(){
        return livroRepo.findAll();
    }
    /*
    @PostMapping ("/salvar")
    @ResponseStatus (HttpStatus.CREATED)
    public void salvar (@RequestBody Livro livro, HttpServletResponse response){
        Livro l = livroRepo.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(l.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }

     */
/* Retornar objeto criado em formato JSON */
    @PostMapping ("/salvar")
    public ResponseEntity<Livro> salvar (@RequestBody Livro livro, HttpServletResponse response){
        Livro l = livroRepo.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(l.getId()).toUri();
        return ResponseEntity.created(uri).body(l);
    }

    @GetMapping ("/{id}")
    public Livro burcarPorID(@PathVariable Long id){
        return livroRepo.getOne(id);
    }
}
