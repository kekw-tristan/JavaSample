package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;

import java.util.List;
import java.util.Optional;

public interface IStudioService {

    List<Studio> getAllStudios();

    List<Studio> getStudiosByAddress(Address address);

    Optional<Studio> getStudioById(int studioId);

    boolean addStudio(Studio studio);

    boolean deleteStudio(int studioId);
}
