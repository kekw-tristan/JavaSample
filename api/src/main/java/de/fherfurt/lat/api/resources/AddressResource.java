package de.fherfurt.lat.api.resources;

import de.fherfurt.lat.api.mapping.Mapper;
import de.fherfurt.lat.api.models.AddressDto;
import de.fherfurt.lat.api.services.AddressService;
import de.fherfurt.lat.api.services.IAddressService;
import de.fherfurt.lat.storage.models.Address;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * RESTful resource class for managing addresses.
 * <p>
 * This resource provides endpoints to retrieve, create, and manage address entities.
 * It interacts with the {@link IAddressService} to perform CRUD operations on addresses,
 * and uses the {@link Mapper} to convert between entities and data transfer objects (DTOs).
 * </p>
 *
 * <p>
 * The following HTTP methods are supported:
 * </p>
 * <ul>
 *     <li>GET - Retrieve all addresses or a specific address by ID</li>
 *     <li>POST - Create a new address</li>
 * </ul>
 *
 * @see IAddressService
 * @see Mapper
 * @see AddressService
 * @see AddressDto
 */
public class AddressResource {
    private final IAddressService addressService;

    /**
     * Constructs a new {@code AddressResource} and initializes the address service.
     * <p>
     * The {@link AddressService} is used as the implementation of {@link IAddressService}.
     * </p>
     */
    public AddressResource() {
        this.addressService = new AddressService();
    }

    /**
     * Retrieves a list of all addresses.
     * <p>
     * This method maps the {@link Address} entities to {@link AddressDto} objects and returns them as a JSON list.
     * </p>
     *
     * @return a list of {@link AddressDto} objects representing all addresses.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressDto> getAddresses() {
        return this.addressService
                .getAllAddresses()
                .stream()
                .map(Mapper::addressToDto)
                .toList();
    }

    /**
     * Retrieves a specific address by its ID.
     * <p>
     * If the address with the specified ID is found, it is returned as a JSON response.
     * If not found, a 404 (Not Found) status is returned.
     * </p>
     *
     * @param addressId the ID of the address to retrieve.
     * @return a {@link Response} containing the {@link AddressDto} if found, or a 404 status if not found.
     */
    @GET
    @Path("{addressId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddress(@PathParam("addressId") int addressId) {
        Optional<Address> address = this.addressService.getAddressById(addressId);

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

    /**
     * Creates a new address.
     * <p>
     * This method accepts an {@link AddressDto} in the request body, converts it to an {@link Address} entity,
     * and attempts to save it using the address service. If the address is successfully created, a 201 (Created)
     * status is returned. If the creation fails, a 304 (Not Modified) status is returned.
     * </p>
     *
     * @param addressDto the {@link AddressDto} representing the address to be created.
     * @param headers the HTTP headers of the request (optional, used for additional context if needed).
     * @return a {@link Response} indicating the outcome of the create operation.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAddress(AddressDto addressDto, @Context HttpHeaders headers) {
        Address address = Mapper.dtoToAddress(addressDto);

        // Call service to create address
        boolean isAdded = this.addressService.addAddress(address);

        if (isAdded) {
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .build();
        }
    }
}