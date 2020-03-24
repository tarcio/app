package app.generator.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MessageResourceTest {

	@Test
	public void testMessageEndpoint() {
		given().when().get("/message/test").thenReturn();
	}
}
