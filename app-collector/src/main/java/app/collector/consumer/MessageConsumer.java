package app.collector.consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import app.collector.document.Message;
import app.collector.service.MessageService;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class MessageConsumer {

	@Inject
	private MessageService messageService;

	@Incoming("app-message")
	public void consume(JsonObject streamMessage) {

		Message message = new Message();

		message.setOrigin(streamMessage.getString("origin"));
		message.setMessage(streamMessage.getString("message"));

		messageService.save(message);
	}
}
