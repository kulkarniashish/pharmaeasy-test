package in.pharmeasy.user.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

@Produces(MediaType.APPLICATION_JSON)
public interface AbstractCrudService<T, ID extends Serializable> {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  Page<T> get(@QueryParam("page") @DefaultValue("0") Integer page,
      @QueryParam("size") @DefaultValue("100") Integer size);


  @GET
  @Path("/in")
  @Produces(MediaType.APPLICATION_JSON)
  List<T> getByIds(@QueryParam("ids") List<ID> ids);

  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  T save(T t);

  @PUT
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  List<T> saveAll(List<T> list);

  @DELETE
  @Path("/")
  void deleteAll();

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  T getById(@PathParam("id") ID id);

  @DELETE
  @Path("/{id}")
  void deleteById(@PathParam("id") ID id);

}