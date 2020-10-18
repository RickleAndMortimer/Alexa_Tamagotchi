package handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import game.Game;

public class CheckAllIntentHandler implements RequestHandler {
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("CheckAllIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder()		
				.withSpeech(Game.checkAll())
				.withReprompt(Game.checkAll())
				.build();
	}
}
