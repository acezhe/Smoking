package qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

public class Factory {
    private People people;

    public Factory(@Qualifier("main") People people) {
        this.people = people;
    }

    public void who(){
        System.out.println(people.getName());
    }
}
