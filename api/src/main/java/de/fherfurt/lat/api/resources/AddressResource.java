package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.services.AddressService;
import de.fherfurt.lat.api.services.IAddressService;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class AddressResource {
    private final IAddressService addressService;

    public AddressResource() {
        this.addressService = new AddressService();
    }

    /**
     * Resource for getting all Addresses
     *
     * @return List of AddressDTOs
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressDto> getAddresses()
    {
        return addressService.
                getAllAddresses()
                .stream()
                .map(Mapper::addressToDto)
                .toList();
    }



}
