package m09_project_spingsecurity.demo.controlador;

import m09_project_spingsecurity.demo.model.Campeon;
import m09_project_spingsecurity.demo.servicio.CampeonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorCampeones {
    String nom;
    @Autowired
    private CampeonesService serveiCampeon;

    @GetMapping("/")
    public  String  inici(Model m){
        serveiCampeon.sortByAttRange();
        m.addAttribute("llistaCampeon",serveiCampeon.listado());
        m.addAttribute("Campeon",new Campeon());
        return "home";
    }

    @GetMapping("/home")
    public String llistarCampeon(Model m){
        serveiCampeon.sortByAttRange();
        m.addAttribute("llistaCampeon",serveiCampeon.listado());
        m.addAttribute("Campeon",new Campeon());
        return "home";
    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeCampeon(@PathVariable("name") String campeon){

        serveiCampeon.deleteByName(campeon);
        return "redirect:/";
    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateCampeon(@PathVariable("name") String campeon, Model m){
        nom = campeon;
        m.addAttribute("Campeon",serveiCampeon.findByName(campeon));

        return "/updateCampeon";
    }

    @PostMapping("/updateCampeon")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String updateCampeonpost(@ModelAttribute("Campeon") Campeon e){
        serveiCampeon.updateCampeon(e);
        return "redirect:/";

    }

    @RequestMapping("/afegir")
    public String afegirCampeon(Model model) {
        model.addAttribute("Campeon", new Campeon());
        return "afegirCampeon";
    }

    @PostMapping("/afegirCampeon")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String AfegirCampeon(@ModelAttribute("Campeon") Campeon e){
        serveiCampeon.afegirCampeon(e);
        return "redirect:/";
    }

}
