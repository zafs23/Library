
import javax.swing.JFrame;

/**
 * CS121: Project 4: Reader of Books: Loads books from a file and uploads book
 * button in the GUI User can read books from selecting books from the library
 * which will show in the reader panel
 * 
 * @author sajiazafreen
 *
 */

public class ReaderOfBooks {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Reader of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}
