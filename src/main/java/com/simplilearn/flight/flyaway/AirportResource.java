package com.simplilearn.flight.flyaway;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.simplilearn.flight.flyaway.entity.Airport;
import com.simplilearn.flight.flyaway.entity.Flight;
import com.simplilearn.flight.flyaway.entity.FlightBooking;
import com.simplilearn.flight.flyaway.entity.Passenger;
import com.simplilearn.flight.flyaway.entity.dao.AierportDAO;


@Path("/airports")
public class AirportResource {

	@GET
    @Produces("application/json")
    public List<Airport> getAirport() {
		List<Airport> airports = new ArrayList<>();
        AierportDAO dao = new AierportDAO();
		airports = dao.getAirports();
        return airports;
    }
 
    
    @POST
    @Consumes("application/json")    
    public Response addAirport(Airport airport){
    	airport.setIataCode(airport.getIataCode());
    	airport.setName(airport.getName());
    	airport.setCountryIsoCode(airport.getCountryIsoCode());
        AierportDAO dao = new AierportDAO();
        dao.addAirport(airport);
        return Response.ok().build();      
        
    }
    
    
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response updateAirport(@PathParam("id") int id, Airport airport){
        AierportDAO dao = new AierportDAO();
        int count = dao.updateAirport(id, airport);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public Response deleteAirport(@PathParam("id") int id){
        AierportDAO dao = new AierportDAO();
        int count = dao.deleteAirport(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}

