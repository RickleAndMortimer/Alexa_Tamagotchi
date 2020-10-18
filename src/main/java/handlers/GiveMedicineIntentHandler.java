package handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;

import game.Game;

public class GiveMedicineIntentHandler implements RequestHandler {
	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName("GiveMedicineIntent"));
	}
	
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Slot> slots = ((IntentRequest)input.getRequestEnvelope().getRequest()).getIntent().getSlots();
        String name = slots.get("name").getValue();

		return input.getResponseBuilder()		
				.withSpeech(Game.giveMedicine(name))
				.withReprompt(Game.giveMedicine(name))
				.build();
	}
}