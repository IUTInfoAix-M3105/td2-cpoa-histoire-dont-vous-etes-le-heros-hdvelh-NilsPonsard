/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.text.ChoiceFormat;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
	private int id;
	private String playerAnswer;
	private int chosenPath;
	private GUIManager gui;
	private Scanner reader;
	private static int lastId = 0;

	public Event() {

	}

	public Event(GUIManager gui, String data) {
		super(data);
		this.gui = gui;
		reader = gui.getInputReader();
		id = ++lastId;
		chosenPath = -1;

	}

	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return this.reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		/* TO BE COMPLETED */
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		/* TO BE COMPLETED */
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		/* TO BE COMPLETED */
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		/* TO BE COMPLETED */
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		/* TO BE COMPLETED */
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	public Event run() {
		gui.outputln(this.toString());
		gui.output(PROMPT_ANSWER);
		playerAnswer = reader.next();
		while (true) {
			chosenPath = interpretAnswer();
			if (chosenPath != -1 && this.hasDaughters() && this.getDaughter(chosenPath) != null)
				break;
			else
				gui.outputln(WARNING_MSG_INTEGER_EXPECTED);
		}
		return this.getDaughter(chosenPath);
	}

	private int interpretAnswer() {
		int res;
		try {
			res = Integer.parseInt(playerAnswer);
		} catch (NumberFormatException exception) {
			res = -1;
		}
		return res;
	}
}

// eof