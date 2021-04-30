package m09_project_spingsecurity.demo.servicio;

import m09_project_spingsecurity.demo.model.Campeon;
import m09_project_spingsecurity.demo.repository.RepositoriCampeones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CampeonesService {


    @Autowired
    private RepositoriCampeones repositoriCampeones;

    public List<Campeon> listado(){
        List<Campeon> listaCampeones = new ArrayList<>();
        repositoriCampeones.findAll().forEach(campeon -> listaCampeones.add(campeon));
        return listaCampeones;
    }

    @PostConstruct
    public void init(){
        repositoriCampeones.save(new Campeon("Ahri", "Maga", "A distancia", "Mana", 125));
        repositoriCampeones.save(new Campeon("Sett", "Juggernaut", "Melee", "Courage", 75));

    }

    public Campeon findByName (String c){
        return repositoriCampeones.findById(c).orElse(null);
    }

    public void afegirCampeon (Campeon c){
        repositoriCampeones.save(c);
    }

    public void deleteByName (String c){
        repositoriCampeones.deleteById(c);
    }

    public void updateCampeon(Campeon c){
        repositoriCampeones.save(c);

    }

    public void sortByAttRange(){
        List<Campeon> listaCampeones = new ArrayList<>();
        repositoriCampeones.findAll().forEach(campeon -> listaCampeones.add(campeon));
        listaCampeones.sort(Comparator.comparingLong(Campeon::getAttackRange));
    }

}



