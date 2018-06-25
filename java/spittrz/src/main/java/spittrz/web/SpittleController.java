package spittrz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spittrz.Spittle;
import spittrz.data.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository repository;
    private static final String MAX_LONG_AS_STRING="9223372036854775807";


    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return repository.findSpittles(max, count);
    }

    @RequestMapping(value ="/{spittleId}" ,method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId,Model model){
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }


}
