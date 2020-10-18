package main;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import handlers.*;

public class TamagotchiStreamHandler extends SkillStreamHandler {
	 public static Skill GetSkills() {
	        return Skills.standard()
	       	     .addRequestHandler(new CancelandStopIntentHandler())
	       	     .addRequestHandler(new HelpIntentHandler())
	       	     .addRequestHandler(new FeedIntendHandler())
	       	     .addRequestHandler(new NewPetIntentHandler())
	       	     .addRequestHandler(new CheckAllIntentHandler())
	       	     .addRequestHandler(new CheckStatusIntentHandler())
	       	     .addRequestHandler(new PlayIntentHandler())
	       	     .addRequestHandler(new LaunchRequests())
	       	     .addRequestHandler(new FallbackIntentHandler())
	       	     .addRequestHandler(new SessionEndedRequestHandler())
	       	     .addRequestHandler(new ShowerIntentHandler())
	       	     .addRequestHandler(new GiveMedicineIntentHandler())
	       	     .addRequestHandler(new GuideIntentHandler())
	        	.build();
	    }
	public TamagotchiStreamHandler() {
        super(GetSkills());
    }

}