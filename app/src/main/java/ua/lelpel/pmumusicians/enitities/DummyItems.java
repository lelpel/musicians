package ua.lelpel.pmumusicians.enitities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bruce
 * @date 13.04.2018
 */
public class DummyItems {
    private static String[] bandNames = new String[] {"Imagine Dragons", "Twenty One Pilots", "Royal Blood", "Justice"};

    public static List<Band> getBands() {
        List<Band> items = new ArrayList<>();

        items.add(new Band(bandNames[0], getMembers(bandNames[0])));
        items.add(new Band(bandNames[1], getMembers(bandNames[1])));
        items.add(new Band(bandNames[2], getMembers(bandNames[2])));
        items.add(new Band(bandNames[3], getMembers(bandNames[3])));

        return items;
    }

    public static List<Musician> getMembers(String title) {
        List<Musician> items = new ArrayList<>();

        if (title == null) {
            return items;
        }

        if (title.equals(bandNames[0])) {
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
        }


        if (title.equals(bandNames[1])) {
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
        }


        if (title.equals(bandNames[2])) {
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
        }


        if (title.equals(bandNames[3])) {
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
            items.add(new Musician("Dan Reynolds", ""));
        }
        return items;
    }
}
