package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.IAddressRepository;
import de.fherfurt.lat.storage.data.repositories.IStudioRepository;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

import java.util.List;
import java.util.Optional;

public class StudioService implements IStudioService {

    private final IStudioRepository studioRepository;

    public StudioService() {
        this(DataController
                .getInstance()
                .getStudioRepository());
    }

    public StudioService(IStudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public List<Studio> getAllStudios() {
        return studioRepository.getAllStudios();
    }

    @Override
    public Optional<Studio> getStudioById(int studioId) {
        return Optional.ofNullable(studioRepository.getStudio(studioId));
    }

    @Override
    public boolean addStudio(Studio studio) {
        return studioRepository.createStudio(studio);
    }


    @Override
    public boolean deleteStudio(int studioId) {
        return studioRepository.deleteStudio(studioId);
    }
}