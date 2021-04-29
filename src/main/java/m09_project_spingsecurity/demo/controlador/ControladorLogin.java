package m09_project_spingsecurity.demo.controlador;

import m09_project_spingsecurity.demo.model.Usuari;
import m09_project_spingsecurity.demo.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ControladorLogin {

    @Autowired
    private UserService servei;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/registration")
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.add(e);
        return "redirect:/";
    }

}
