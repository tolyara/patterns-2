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
	}
	
}

interface Streamer {
	
	void holdStream();
	
}

class YouTubeStreamer implements Streamer {
	
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







