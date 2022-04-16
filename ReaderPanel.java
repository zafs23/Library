
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * CS121: Project 4 : Contains the JTextPane in the GUI for the user to read
 * books from the library and to scroll use the page up and down button
 * 
 * @author sajiazafreen
 *
 */

public class ReaderPanel extends JPanel {

	JPanel readerInformationPanel;// all these should be private
	JPanel readerTextAreaPanel;
	JPanel readerNavigationPanel;
	JTextPane bookAreaPane;
	JLabel informationBarLabel;
	JLabel bookPageLabel;
	JLabel bookInfoTitle;
	JLabel bookInfoAuthor;

	JScrollBar verticalScrollBar;
	JScrollPane bookAreaScroll;
	JButton navigationButtonDown;
	JButton navigationButtonUp;

	String informationPage;
	int extentValue;

	/**
	 * Contructs a Reader panel in the GUI and contains the JTextPane and the scroll
	 * buttons
	 */

	public ReaderPanel() {
		this.setPreferredSize(new Dimension(550, 600));
		String titleReader = "Reader";
		Border borderTitleReader = BorderFactory.createTitledBorder(titleReader);
		this.setBorder(borderTitleReader);

		// readerInformationPanel where the book title, author and page number
		// will show
		readerInformationPanel = new JPanel();
		add(readerInformationPanel);
		readerInformationPanel.setPreferredSize(new Dimension(540, 50));
		String titleInformation = "Information";
		Border borderTitleInformation = BorderFactory.createTitledBorder(titleInformation);
		readerInformationPanel.setBorder(borderTitleInformation);

		readerInformationPanel.setLayout(new BorderLayout());

		String bookTitle = "";
		String bookAuthor = "";

		bookInfoTitle = new JLabel(bookTitle);
		readerInformationPanel.add(bookInfoTitle, BorderLayout.WEST);

		bookInfoAuthor = new JLabel(bookAuthor);
		readerInformationPanel.add(bookInfoAuthor, BorderLayout.CENTER);

		bookPageLabel = new JLabel(informationPage);
		readerInformationPanel.add(bookPageLabel, BorderLayout.EAST);

		// adding the text area panel where the book can be read
		readerTextAreaPanel = new JPanel();
		add(readerTextAreaPanel);
		readerTextAreaPanel.setLayout(new BoxLayout(readerTextAreaPanel, BoxLayout.Y_AXIS));
		readerTextAreaPanel.setPreferredSize(new Dimension(540, 445));
		String titleTextAreaPanel = "Content";
		Border borderTitleTextArea = BorderFactory.createTitledBorder(titleTextAreaPanel);
		readerTextAreaPanel.setBorder(borderTitleTextArea);

		bookAreaPane = new JTextPane();
		readerTextAreaPanel.add(bookAreaPane);
		StyledDocument text = bookAreaPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		text.setParagraphAttributes(0, text.getLength(), center, false);

		// adding the scrollPane in the JTextPane
		bookAreaScroll = new JScrollPane(bookAreaPane);
		readerTextAreaPanel.add(bookAreaScroll);

		bookAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookAreaScroll.setPreferredSize(new Dimension(0, 200));
		verticalScrollBar = new JScrollBar();
		verticalScrollBar = bookAreaScroll.getVerticalScrollBar();
		NavigationAdjustmentListener adjustmentListener = new NavigationAdjustmentListener();
		verticalScrollBar.addAdjustmentListener(adjustmentListener);

		// adding the navigation panel where the page up and down button will be
		readerNavigationPanel = new JPanel();
		add(readerNavigationPanel);
		readerNavigationPanel.setPreferredSize(new Dimension(540, 60));
		String titleNavigationPanel = "Navigation";
		Border borderNavigationPanel = BorderFactory.createTitledBorder(titleNavigationPanel);
		readerNavigationPanel.setBorder(borderNavigationPanel);
		navigationButtonUp = new JButton("Page Up");
		navigationButtonDown = new JButton("Page Down");
		readerNavigationPanel.add(navigationButtonUp);
		readerNavigationPanel.add(navigationButtonDown);
		NavigationButtonListener navigationButtonListener = new NavigationButtonListener();
		navigationButtonDown.addActionListener(navigationButtonListener);
		navigationButtonUp.addActionListener(navigationButtonListener);
	}

	// action listener to the up and down buttons
	private class NavigationButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonUp = e.getActionCommand();
			String buttonDown = e.getActionCommand();
			extentValue = verticalScrollBar.getModel().getExtent();
			if (buttonDown.equals("Page Down")) {
				verticalScrollBar.setValue(verticalScrollBar.getValue() + extentValue);// next
																						// line
			}
			if (buttonUp.equals("Page Up")) {
				verticalScrollBar.setValue(verticalScrollBar.getValue() - extentValue);
			}
			revalidate();

		}
	}

	// adjustment listener to the scroll pane which will update the page number
	private class NavigationAdjustmentListener implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			int x = 0;
			int condition = 0;
			int totalLength = verticalScrollBar.getMaximum();
			double currentValue = e.getValue();
			int pageNumber = 0;
			extentValue = verticalScrollBar.getModel().getExtent();
			double pageDivision = (double) totalLength / (double) extentValue;
			double totalPageNumber = Math.ceil(pageDivision);
			int totalPageNumberInt = (int) totalPageNumber;
			int page[] = new int[totalPageNumberInt];
			for (int i = 0; i < page.length - 1; i++) {
				page[i] = extentValue * (i);
				if ((int) pageDivision < pageDivision) {
					x = i + 2;
				} else if ((int) pageDivision == pageDivision) {
					x = i + 1;
				}
			}

			if ((int) pageDivision < pageDivision) {
				if (currentValue >= ((int) pageDivision - 1) * extentValue
						&& currentValue < (pageDivision - 1) * extentValue) {
					if (verticalScrollBar.getMaximum() - extentValue == currentValue) {
						pageNumber = totalPageNumberInt;
					} else {
						pageNumber = totalPageNumberInt - 1;
					}
				} else if (currentValue >= (pageDivision - 1) * extentValue) {
					pageNumber = totalPageNumberInt;
				} else if (currentValue == (pageDivision - 1) * extentValue) {
					pageNumber = totalPageNumberInt;
				} else {
					for (int i = 0; i < page.length - 1; i++) {
						if (currentValue >= page[i] && currentValue < page[i + 1]) {
							pageNumber = i + 1;
						}
					}
				}
			} else if ((int) pageDivision == pageDivision) {
				int i = 0;
				if (condition == 1 && i == page.length) {
					pageNumber = totalPageNumberInt;
					condition = 0;
				} else {
					for (; i < page.length - 1; i++) {
						if (currentValue >= page[i] && currentValue < page[i + 1]) {
							pageNumber = i + 1;
							condition = 1;
						}
					}
				}
			}

			if (verticalScrollBar.getMaximum() - extentValue == currentValue) {
				navigationButtonDown.setForeground(Color.black);
				navigationButtonDown.setEnabled(false);
			} else {
				navigationButtonDown.setEnabled(true);
			}
			if (verticalScrollBar.getMinimum() == currentValue) {
				navigationButtonUp.setForeground(Color.black);
				navigationButtonUp.setEnabled(false);
			} else {
				navigationButtonUp.setEnabled(true);
			}
			String informationPageNumber = Integer.toString(pageNumber);
			String informationPageTotal = Integer.toString(x);
			informationPage = "Page: " + informationPageNumber + "\\" + informationPageTotal;

			bookPageLabel.setText(informationPage);
			revalidate();

		}
	}

	/**
	 * Returns the book area pane where the contents of the book will show
	 * 
	 * @return bookArePane
	 */
	public JTextPane getTextAreaPane() {
		return bookAreaPane;
	}

	/**
	 * Returns the book title of the current reading book
	 * 
	 * @return bookInfoTitle
	 */
	public JLabel getBookTitleLabel() {
		return bookInfoTitle;
	}

	/**
	 * Returns the book author of the current reading book
	 * 
	 * @return bookInfoAuthor
	 */
	public JLabel getBookAuthorLabel() {
		return bookInfoAuthor;
	}
}