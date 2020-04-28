package structural.composite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositeMain {

	public static void main(String[] args) {
		Folder folder = new Folder("Test");
		folder.addFolder(new Folder("Folder1"));
		folder.addFolder(new Folder("Folder2"));
		folder.addFile(new File("File1"));
		folder.showFolderContent();
	}

}

class Folder {

	String name;
	Date creationDate;
	List<Folder> folders = new ArrayList<>();
	List<File> files = new ArrayList<>();

	public Folder(String name) {
		this.name = name;
	}

	void addFolder(Folder folder) {
		folders.add(folder);
	}

	void removeFolder(Folder folder) {
		folders.remove(folder);
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	void addFile(File file) {
		files.add(file);
	}

	void removeFile(File file) {
		files.remove(file);
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	public void showFolderContent() {
		System.out.println("Current content of folder <" + name + ">");
		System.out.print("Folders: ");
		for (Folder folder : folders) {
			System.out.print(folder.name + " ");
		}
		System.out.print("\nFiles: ");
		for (File file : files) {
			System.out.print(file.name + " ");
		}

	}

}

class File {

	String name;

	public File(String name) {
		this.name = name;
	}

}


/////