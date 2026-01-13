package dev.dravinck.controller;

import dev.dravinck.domain.Users;
import dev.dravinck.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GET
  public List<Users> findAll() {
    return userService.findAll();
  }

  @GET
  @Path("/{id}")
  public Users findById(@PathParam("id") UUID id) {
    return userService.findById(id);
  }

  @POST
  public Response createUser(Users user) {
    Users created = userService.createUser(user);
    return Response.status(Response.Status.CREATED).entity(created).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteUser(@PathParam("id") String id) {
    userService.deleteById(id);
    return Response.noContent().build();
  }

  @PATCH
  @Path("/{id}")
  public Users updateUser(@PathParam("id") UUID id, Users userData) {
    return userService.updateUser(id, userData);
  }
}