package ua.lelpel.pmumusicians.enitities;

/**
 * @author bruce
 * @date 13.04.2018
 */
public class Musician extends BaseEntity {
    String description;

    public Musician(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
