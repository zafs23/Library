
import javax.swing.JButton;

/**
 * CS121: Project 4 BookButton extends JButton represents Book Buttons of a
 * Library in GUI
 * 
 * @author sajiazafreen
 *
 */

public class BookButton extends JButton {

	Book book;

	/**
	 * Constructor: Builds a button in Library Panel for each book in the library
	 * 
	 * @param book Button for book
	 */
	public BookButton(Book book) {
		this.book = book;
		if (book.getTitle().length() > 20) {
			this.setText(book.getTitle().substring(0, 20));
		} else {
			this.setText(book.getTitle());
		}
		this.setToolTipText(book.toString());
	}

}
