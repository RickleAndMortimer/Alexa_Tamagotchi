package handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import game.Game;

public class NewPetIntentHandler implements RequestHandler {
	public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("NewPetIntent"));
    }
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Slot> slots = ((IntentRequest)input.getRequestEnvelope().getRequest()).getIntent().getSlots();
        String name = slots.get("name").getValue();

        return input.getResponseBuilder()
                .withSpeech(Game.createPet(name))
                .withReprompt(Game.createPet(name))
                .build();
		}
    }
