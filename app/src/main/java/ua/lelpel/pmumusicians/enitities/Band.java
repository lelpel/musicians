package ua.lelpel.pmumusicians.enitities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bruce
 * @date 13.04.2018
 */
public class Band extends BaseEntity {
    private final List<Musician> members;

    public Band(String name, List<Musician> members) {
        super(name);
        this.members = members;
    }
}
