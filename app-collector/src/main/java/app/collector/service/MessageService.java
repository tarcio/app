package app.collector.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import app.collector.document.Message;
import app.collector.document.MessageRepository;

@ApplicationScoped
public class MessageService {

	@Inject
	private MessageRepository messageRepository;

	public void save(Message message) {

		assert message != null : "Message should not be null";
		assert message.getOrigin() != null : "Message origin should not be null";
		assert message.getMessage() != null : "Message value should not be null";

		messageRepository.save(message);
	}
}
