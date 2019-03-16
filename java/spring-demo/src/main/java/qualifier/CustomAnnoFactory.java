package qualifier;

public class CustomAnnoFactory {
    private People people;

    public CustomAnnoFactory(@Genre("slave") People people) {
        this.people = people;
    }

    public void who(){
        System.out.println(people.getName());
    }
}
