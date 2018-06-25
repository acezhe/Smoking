package spittrz.data;

import spittrz.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter unsaved);

    Spitter findByUsername(String username);
}
