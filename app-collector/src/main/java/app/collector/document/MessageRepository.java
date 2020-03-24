package app.collector.document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;

import com.mongodb.client.MongoClient;

@ApplicationScoped
public class MessageRepository {

	@Inject
	private MongoClient mongoClient;

	public void save(Message message) {

		Document document = new Document();

		document.put("origin", message.getOrigin());
		document.put("message", message.getMessage());

		mongoClient.getDatabase("app").getCollection("message").insertOne(document);
	}
}
