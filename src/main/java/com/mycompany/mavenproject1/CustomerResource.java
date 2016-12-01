package com.mycompany.mavenproject1;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// book resource class handles the mapping of the book resource API 
@Path("/customers")
public class CustomerResource {

    CustomerService customerService = new CustomerService();

    public CustomerResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> listCustomers() {
        return customerService.retrieveCustomers();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        return customerService.retrieveCustomer(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Customer saveCustomer(Customer b) {
        return customerService.createCustomer(b);
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void removeCustomer(@PathParam("id") int id) {
        customerService.deleteCustomer(id);
    }
}
