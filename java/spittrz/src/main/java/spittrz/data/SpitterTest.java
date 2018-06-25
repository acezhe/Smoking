package spittrz.data;

import org.springframework.stereotype.Component;
import spittrz.Spitter;
@Component
public class SpitterTest implements SpitterRepository {
    @Override
    public Spitter save(Spitter unsaved) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}
