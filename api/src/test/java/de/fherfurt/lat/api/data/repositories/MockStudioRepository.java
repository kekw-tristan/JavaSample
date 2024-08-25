package de.fherfurt.lat.api.data.repositories;

import de.fherfurt.lat.storage.data.repositories.IStudioRepository;
import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.ArrayList;

public class MockStudioRepository implements IStudioRepository {
    public static final Address firstAddress = new Address (
            25,
            "Altonaer strasse",
            "99085",
            "Erfurt",
            "DE"
    );

    public static final Address secondAddress = new Address (
            8,
            "Ernst-Abbe-Platz",
            "77043",
            "Jena",
            "DE"
    );

    public static final Studio firstStudio = new Studio (
        98.25,
        1
    );

    public static final Studio secondStudio = new Studio (
            135.89,
            2
    );

    public static final Studio updatedFirstStudio = new Studio (
            110.00,
            1
    );

    public static List<Studio> studios = new ArrayList<>();

    private static void resetStudiosList() {
        studios = new ArrayList<>();
        studios.add(firstStudio);
        studios.add(secondStudio);
    }

    public MockStudioRepository() { resetStudiosList(); }

    @Override
    public List<Studio> getAllStudios() { return new ArrayList<>(studios); }

    @Override
    public Studio getStudio( int studioId ) {
        if (studioId < 0 || studioId >= studios.size()) {
            return null;
        } else {
            return studios.get(studioId);
        }
    };

    @Override
    public boolean createStudio( Studio studio ) {
        studios.add(studio);
        return true;
    }

    @Override
    public boolean updateStudio( Studio studio ) {
        Studio foundStudio = getStudio(studio.getId());
        if (foundStudio != null) {
            studios.set(foundStudio.getId(), studio); // macht das sinn mit der id?
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudio( int studioId ) {
        Studio foundStudio = getStudio(studioId);
        if (foundStudio != null) {
            studios.remove(foundStudio);
            return true;
        } else {
            return false;
        }
    }
}
