package app.generator.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import app.generator.service.MessageService;

@Path("/message")
public class MessageResource {

	@Inject
	private MessageService messageService;

	@GET
	@Path("{message}")
	@Produces(MediaType.TEXT_PLAIN)
	public String send(@PathParam("message") String message) {
		messageService.send(message);
		return String.format("Message '%s' sent!", message);
	}
}
