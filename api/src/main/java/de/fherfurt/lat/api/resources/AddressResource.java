package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.services.AddressService;
import de.fherfurt.lat.api.services.IAddressService;
import de.fherfurt.lat.storage.models.Address;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

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
        return this.addressService.
                getAllAddresses()
                .stream()
                .map(Mapper::addressToDto)
                .toList();
    }

    @GET
    @Path("{addressId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@PathParam("addressId") int addressId) {
        Optional<Address> address = this.addressService.getAddressById((addressId));

        if (address.isPresent()) {
            return Response
                    .ok(Mapper.addressToDto(address.get()))
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

}
