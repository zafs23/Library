
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CS 121: project 4: Library implements LibraryInteface manages collection of
 * books
 * 
 * @author sajiazafreen
 *
 */
public class Library implements LibraryInterface {
	private ArrayList<Book> bookList;

	/**
	 * Constructs a default instance of library
	 *
	 */
	public Library() {
		bookList = new ArrayList<Book>();
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> cloneBookList = new ArrayList<Book>();
		for (Book book : bookList) {
			cloneBookList.add(book);
		}
		return cloneBookList;
	}

	/**
	 * Sets the library book list
	 *
	 * @param bookList
	 */
	public void setBooks(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getBook(int index) {
		Book book;
		if (index >= 0 && index < bookList.size()) {
			book = bookList.get(index);
			return book;
		} else {
			return null;
		}
	}

	public void addBook(Book goodBook) {
		bookList.add(goodBook);
	}

	public void removeBook(int index) {
		if (index >= 0 && index < bookList.size()) {
			bookList.remove(index);
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < bookList.size(); i++) {
			output += bookList.get(i).toString();
			output += "\n";
		}
		return output;
	}

	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		Scanner fileScan, recordScan;

		File fileObject = new File(csvFilename);
		try {
			fileScan = new Scanner(fileObject);
			while (fileScan.hasNext()) {
				String record = fileScan.nextLine();
				recordScan = new Scanner(record);
				recordScan.useDelimiter(",");
				while (recordScan.hasNext()) {
					String title = recordScan.next();
					String author = recordScan.next();
					String genre = recordScan.next();
					String filepath = recordScan.next();
					Book newBook = new Book(title, author);
					newBook.setGenre(genre);
					newBook.setFilename(filepath);
					bookList.add(newBook);
				}
			}

		} catch (IOException e) {
			System.out.println("could not open file");

		}

	}
}