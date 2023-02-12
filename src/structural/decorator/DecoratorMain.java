package structural.decorator;

import java.io.FileNotFoundException;

//InputStream
//InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("")));

public class DecoratorMain {

	public static void main(String[] args) throws FileNotFoundException {
		YouTubeStreamer streamer = new YouTubeStreamer();
		streamer.holdStream();

		System.out.println();
		AdvancedYouTubeStreamer advancedStreamer = new AdvancedYouTubeStreamer(new YouTubeStreamer());
		advancedStreamer.holdStream();

		System.out.println();
		ExperiencedYouTubeStreamer experiencedStreamer = new ExperiencedYouTubeStreamer(new YouTubeStreamer());
		experiencedStreamer.holdStream();

		System.out.println();
		ExperiencedYouTubeStreamer superExperiencedStreamer = new ExperiencedYouTubeStreamer(new AdvancedYouTubeStreamer(new YouTubeStreamer()));
		superExperiencedStreamer.holdStream();
	}
	
}

interface Streamer {
	
	void holdStream();
	
}

// use case - the class is final and we cannot extend from it
final class YouTubeStreamer implements Streamer {
	
	@Override
	public void holdStream() {
		System.out.println("Holding a stream...");
	}
	
}

abstract class StreamerDecorator implements Streamer {
	
	Streamer streamer;

	public StreamerDecorator(Streamer streamer) {
		this.streamer = streamer;
	}

	@Override
	public abstract void holdStream();
	
}

class AdvancedYouTubeStreamer extends StreamerDecorator {

	public AdvancedYouTubeStreamer(Streamer streamer) {
		super(streamer);
	}
	
	void gatherDonuts() {
		System.out.println("Collecting donuts from viewers...");
	}
	
	@Override
	public void holdStream() {
		streamer.holdStream();
		gatherDonuts();
	}	
	
}

class ExperiencedYouTubeStreamer extends StreamerDecorator {

	public ExperiencedYouTubeStreamer(Streamer streamer) {
		super(streamer);
	}

	void makeAdvertisingIntegration() {
		System.out.println("Make advertising integration...");
	}

	@Override
	public void holdStream() {
		streamer.holdStream();
		makeAdvertisingIntegration();
	}

}







