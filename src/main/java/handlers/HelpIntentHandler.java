package handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {
	
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.HelpIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "Welcome to Tamagotchi on Alexa! This is a very basic port of the Tamagotchi game into Alexa"
				+ "To create a new pet, say 'create a new pet named 'insert name here''. "
				+ "To interact with your pet, state your action and the name of pet. "
				+ "For example, to feed your pet, you'd say 'feed *name of pet here*'. "
				+ "So far, you can play, shower, feed, and medicate your pet.";
		return input.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(speechText)
				.build();
	}
}
