import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * CS121: Project 4: Contains the Reader Panel and the Library Panel and
 * implements the book buttons and the load button in the library Panel
 * 
 * @author sajiazafreen
 *
 */

public class ReaderOfBooksPanel extends JPanel {

	Library library;
	LibraryPanel libraryPanel;
	ReaderPanel readerPanel;
	String informationBar;
	String bookFileCSV;
	BookButton bookButton;
	LoadButtonListener loadButtonListener;
	BookButtonListener bookButtonListener;

	public ReaderOfBooksPanel() {

		this.setPreferredSize(new Dimension(810, 610));

		library = new Library();
		libraryPanel = new LibraryPanel();
		this.add(libraryPanel);
		readerPanel = new ReaderPanel();
		add(readerPanel);
		loadButtonListener = new LoadButtonListener();
		libraryPanel.getLoadButton().addActionListener(loadButtonListener);

	}

	// action listener for all the book buttons in the library panel
	private class BookButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String bookButtonTitle = e.getActionCommand();
			for (Book book : library.getBooks()) {
				if (book.getTitle().length() > 20) {
					if (bookButtonTitle.equals(book.getTitle().substring(0, 20))) {
						readerPanel.getTextAreaPane().setText(book.getText());
						readerPanel.getTextAreaPane().setCaretPosition(0);
						if (book.getTitle().length() > 27) {
							readerPanel.getBookTitleLabel().setText("Title: " + book.getTitle() + "   ");
						} else {
							readerPanel.getBookTitleLabel().setText("Title: " + book.getTitle() + "           ");

						}
						if (book.getAuthor().length() > 8) {
							if(book.getAuthor().length() >16 ) {
							readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor().substring(0, 16) + "  ");
							} else {
								readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor() + "   ");
								
							}
						} else {
							readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor() + "    ");
						}

					}
				} else {
					if (bookButtonTitle.equals(book.getTitle())) {
						readerPanel.getTextAreaPane().setText(book.getText());
						readerPanel.getTextAreaPane().setCaretPosition(0);
						if (book.getTitle().length() < 10) {
							readerPanel.getBookTitleLabel()
									.setText("Title: " + book.getTitle() + "                       ");
						} else {
							readerPanel.getBookTitleLabel().setText("Title: " + book.getTitle() + "                  ");
						}
						if (book.getAuthor().length() > 8) {
							if(book.getAuthor().length() >16 ) {
							readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor().substring(0, 16) + "  ");
							} else {
								readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor() + "   ");
								
							}
						} else {
							readerPanel.getBookAuthorLabel().setText("By " + book.getAuthor() + "    ");
						}
						
					}
				}
				revalidate();
			}

		}
	}

	// action listener for the load button in the library panel
	private class LoadButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			bookFileCSV = libraryPanel.getTextField().getText();
			library.loadLibraryFromCSV(bookFileCSV);
			for (Book book : library.getBooks()) {
				bookButton = new BookButton(book);
				bookButtonListener = new BookButtonListener();
				bookButton.addActionListener(bookButtonListener);
				libraryPanel.getBookPanel().add(bookButton);
				revalidate();
			}

		}

	}

	/**
	 * Returns the load button listener for load button in the library panel
	 * 
	 * @return loadButtonListener
	 */
	public LoadButtonListener getLoadButtonListener() {
		return loadButtonListener;
	}

}
