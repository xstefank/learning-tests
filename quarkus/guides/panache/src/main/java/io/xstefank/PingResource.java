package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Path("/ping")
@ApplicationScoped
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello change";
    }

    @GET
    @Path("add/{person}")
    @Transactional
    public String addPersion(@PathParam("person") String personName) {
        Person person = new Person();
        person.name = personName;
        person.birth = LocalDate.of(1910, Month.FEBRUARY, 1);
        person.status = Status.Alive;

        // persist it
        person.persist();
        return "done";
    }
    
    @DELETE
    @Path("delete")
    @Transactional
    public void delete() {
        Person.deleteMartins();
    }
    
    @GET
    @Path("{person}")
    @Transactional
    public String post(@PathParam("person") String personName) {
        Person person = new Person();
        person.name = personName;
        person.birth = LocalDate.of(1910, Month.FEBRUARY, 1);
        person.status = Status.Alive;

        // persist it
        person.persist();

        // note that once persisted, you don't need to explicitly save your entity: all
        // modifications are automatically persisted on transaction commit.

        // check if it's persistent
        if(person.isPersistent()){
            // delete it
            person.delete();
        }

        // getting a list of all Person entities
        List<Person> allPersons = Person.listAll();
        System.out.println("All persons: " + allPersons);

        // finding a specific person by ID
        person = Person.findById(1L);
        System.out.println("Person by id 1:" + person);

        // finding all living persons
        List<Person> livingPersons = Person.list("status", Status.Alive);
        System.out.println("Living persons: " + livingPersons);

        // counting all persons
        long countAll = Person.count();
        System.out.println("Person count: " + countAll);

        // counting all living persons
        long countAlive = Person.count("status", Status.Alive);
        System.out.println("Count living: " + countAlive);

        // delete all living persons
        Person.delete("status", Status.Alive);
        System.out.println("Person after remove alive: " + Person.listAll());

        // delete all persons
        Person.deleteAll();
        System.out.println("Persons after delete all: " + Person.listAll());

        return "done";
    }
}
