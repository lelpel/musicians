package ua.lelpel.pmumusicians.enitities;

import java.util.List;

/**
 * @author bruce
 * @date 13.04.2018
 */
abstract class BaseEntity {
    String name;

    public BaseEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
