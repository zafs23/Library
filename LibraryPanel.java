import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * CS121: Project 4: Represents the Library Panel in GUI contains all book
 * buttons for each book in the library and the load button to load books in the
 * library from files
 * 
 * @author sajiazafreen
 *
 */

public class LibraryPanel extends JPanel {

	JPanel importBookPanel;
	JTextField libraryTextField;
	JPanel bookPanel;
	JButton loadButton;
	ReaderOfBooksPanel finalPanel;

	/**
	 * Constructs a Library in the GUI where all the book button will load and the
	 * Text field to input the library file and load button will be
	 */

	public LibraryPanel() {

		this.setPreferredSize(new Dimension(250, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		String titleLibrary = "Library";
		Border borderTitleLirary = BorderFactory.createTitledBorder(titleLibrary);
		setBorder(borderTitleLirary);

		// adding book panel in the library panel where all the book button will be
		// loaded
		bookPanel = new JPanel();
		add(bookPanel);
		String titleBookList = "Book List";
		Border borderTitleBookList = BorderFactory.createTitledBorder(titleBookList);
		bookPanel.setBorder(borderTitleBookList);

		bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

		// adding JScrollPane in the bookPanel
		JScrollPane bookListScrollPane = new JScrollPane(bookPanel);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(bookListScrollPane, BorderLayout.CENTER);
		bookListScrollPane.setPreferredSize(new Dimension(0, 500));

		// adding the import book panel where the load button and the library text field
		// will be
		importBookPanel = new JPanel();
		this.add(importBookPanel);
		String titleImportBook = "Import Books";
		Border borderTitleImportBook = BorderFactory.createTitledBorder(titleImportBook);
		importBookPanel.setBorder(borderTitleImportBook);
		importBookPanel.setLayout(new FlowLayout());
		libraryTextField = new JTextField(10);
		importBookPanel.add(libraryTextField);

		loadButton = new JButton("Load");
		importBookPanel.add(loadButton);

	}

	/**
	 * Returns load button in library panel
	 * 
	 * @return load button
	 */
	public JButton getLoadButton() {
		return loadButton;
	}

	/**
	 * Returns the Library Text Field where user will input file name
	 * 
	 * @return libraryTextField
	 */
	public JTextField getTextField() {
		return libraryTextField;
	}

	/**
	 * Returns the panel where all the buttons will load in the Library
	 * 
	 * @return bookPanel
	 */
	public JPanel getBookPanel() {
		return bookPanel;
	}

}
