package handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

public class GuideIntentHandler implements RequestHandler {
	public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("GuideIntent"));
    }
	public Optional<Response> handle(HandlerInput input) {
		String speechText = "There are five traits in this game. "
				+ "Cleanliness, energy, health, happiness, and hunger. "
				+ "Shower to raise cleanliness, play with your pet to raise happiness, and feed your pet to keep him full. "
				+ "All actions take energy, so choose your actions carefully. To regain energy, "
				+ "simply wait and let your digital pet rest. "
				+ "If you leave your pet tired and unhealthy, then they become sick, which can quickly lead to the death of your pet. "
				+ "You can remove the sickness and increase health by giving the medications at a huge expense for happiness. "
				+ "A very low happiness makes it harder for you to raise their stats. "
				+ "If you pet remains starved or unhealthy for too long, they will die.";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withReprompt(speechText)
                .build();
		}
    }
