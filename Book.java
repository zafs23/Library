
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CS121: Project 4 implements Book Interface and represents books in a library
 * 
 * @author sajiazafreen
 *
 */
public class Book implements BookInterface {
	private String title, author, genre, filename;

	/**
	 * Constructor: Builds a book instance with given parameters
	 * 
	 * @param title
	 * 
	 *               book title
	 * 
	 * @param author
	 * 
	 *               book author
	 * 
	 */

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = null;
		this.filename = null;
	}

	/**
	 * returns the title of the book
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the book
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * returns the author of the book
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * sets the author of the book
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the genre of the book
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre of the book
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Returns the filename of the book
	 * 
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the filename of the book
	 * 
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		String output = "";
		output = "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nFilename: " + filename;
		return output;
	}

	public boolean isValid() {
		if (title != null && author != null && genre != null && filename != null) {
			File filenameExist = new File(filename);
			return (filenameExist.exists() && filenameExist.isFile());
		} else {
			return false;
		}
	}

	public String getText() {
		String textOutput = "";
		try {
			textOutput = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			return "Could not open file";
		}
		return textOutput;
	}

}
