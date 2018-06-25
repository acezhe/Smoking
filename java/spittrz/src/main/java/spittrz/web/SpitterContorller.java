package spittrz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittrz.Spitter;
import spittrz.data.SpitterRepository;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterContorller {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterContorller(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Spitter spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterRepository.findByUsername(username));
        return "profile";
    }
}
