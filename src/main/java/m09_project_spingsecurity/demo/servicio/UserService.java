package m09_project_spingsecurity.demo.servicio;

import m09_project_spingsecurity.demo.model.Campeon;
import m09_project_spingsecurity.demo.model.Usuari;
import m09_project_spingsecurity.demo.repository.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private RepositoriUsuaris repositoriUsuaris;

    public void add(Usuari u){
        u.setPassword(passwordEncoder(u.getPassword()));
        repositoriUsuaris.save(u);
    }

    public Usuari findById(String s){
        return repositoriUsuaris.findById(s).orElse(null);
    }

    @PostConstruct
    public void init() {
        repositoriUsuaris.save(new Usuari("admin", passwordEncoder("admin"), "admin", "ADMIN"));
        repositoriUsuaris.save(new Usuari("eric", passwordEncoder("eric"), "eric", "ADMIN"));
        repositoriUsuaris.save(new Usuari("montse", passwordEncoder("montse"), "montse", "USER"));


    }


    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
