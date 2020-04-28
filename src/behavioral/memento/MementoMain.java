package behavioral.memento;

import java.util.Date;

public class MementoMain {
	
	public static void main(String[] args) {
		VideoGame videoGame = new VideoGame();
		videoGame.setCurrentGamePoint("mission 1", "In the park.");
		System.out.println(videoGame);
		
		Saver saver = new Saver();
		saver.setSave(videoGame.createSave());
		
		videoGame.setCurrentGamePoint("mission 2", "In the hotel.");
		System.out.println(videoGame);
		
		videoGame.loadSave(saver.getSave());
		System.out.println(videoGame);
	}

}

class VideoGame {
	
	String currentMission;
	String currentSavePoint;
	Date currentSaveDate;
	
	public void setCurrentGamePoint(String currentMission, String currentSavePoint) {
		this.currentMission = currentMission;
		this.currentSavePoint = currentSavePoint;
		this.currentSaveDate = new Date();
	}

	Save createSave() {
		return new Save(currentMission, currentSavePoint);
	}
	
	void loadSave(Save save) {
		currentMission = save.getMission();
		currentSavePoint = save.getSavePoint();
		currentSaveDate = save.getSaveDate();
	}

	@Override
	public String toString() {
		return "VideoGame [currentMission=" + currentMission + ", currentSavePoint=" + currentSavePoint
				+ ", currentSaveDate=" + currentSaveDate + "]";
	}
	
}

class Save {
	
	final String mission;
	final String savePoint;
	final Date saveDate;
	
	public Save(String mission, String savePoint) {
		this.mission = mission;
		this.savePoint = savePoint;
		this.saveDate = new Date();
	}
	
	public String getMission() {
		return mission;
	}

	public String getSavePoint() {
		return savePoint;
	}

	public Date getSaveDate() {
		return saveDate;
	}
	
}

class Saver {
	
	Save save;

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}
	
}









