package app.generator.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class MessageService {

	@Inject
	@Channel("app-message")
	private Emitter<JsonObject> messageEmitter;

	public void send(String message) {
		send("app-generator", message);
	}

	public void send(String origin, String message) {

		JsonObject streamMessage = new JsonObject();

		streamMessage.put("origin", origin);
		streamMessage.put("message", message);

		messageEmitter.send(streamMessage);
	}
}
