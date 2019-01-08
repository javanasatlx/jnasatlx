package com.jnasatlx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class holds the results of the Test and additional methods for ease of use.<br>
 * It also takes care of the randomness of the questions of part 2.<br>
 * The handling of the results after a conducted test can be affected in the method {@link TlxFrame#finished()}.
 * 
 * @author Bernhard Glaser
 * @version 1.01
 */

public class TlxResult{

	private static final Logger logger = Logger.getLogger(TlxResult.class.getName());

	private int[][] pairs = new int[15][2];

	private int[] part1Results = new int[]{0, 0, 0, 0, 0, 0};
	private int[] part2Results = new int[]{0, 0, 0, 0, 0, 0};

	private static String[] indexMeaning = new String[6];

	static{
		for (int j = 0; j < 6; j++){
			indexMeaning[j] = TlxLocalization.getTranslation("scale" + j + "Title");
		}
	}

	public TlxResult(){
		pairs[0] = new int[]{4, 3};
		pairs[1] = new int[]{2, 5};
		pairs[2] = new int[]{2, 4};
		pairs[3] = new int[]{1, 5};
		pairs[4] = new int[]{3, 5};
		pairs[5] = new int[]{1, 2};
		pairs[6] = new int[]{1, 3};
		pairs[7] = new int[]{2, 0};
		pairs[8] = new int[]{5, 4};
		pairs[9] = new int[]{3, 0};
		pairs[10] = new int[]{3, 2};
		pairs[11] = new int[]{0, 4};
		pairs[12] = new int[]{0, 1};
		pairs[13] = new int[]{4, 1};
		pairs[14] = new int[]{5, 0};
		shufflePairs();
	}

	/**
	 * Shuffles the pairs
	 * <a href="http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array">http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array</a>
	 */

	private void shufflePairs(){
		logger.finest("shuffling the pairs");
		List<int[]> toShuffleList = Arrays.asList(pairs);
		Collections.shuffle(toShuffleList);
		pairs = (int[][])toShuffleList.toArray();
	}

	int[][] getPairs(){
		return pairs;
	}

	int[] getPart1Results(){
		return part1Results;
	}

	int[] getPart2Results(){
		return part2Results;
	}

	private double[] getPart2ResultsWeights(){
		double[] r = new double[6];
		for (int i = 0; i < 6; i++){
			r[i] = getPart2Results()[i] / 15.0;
		}
		return r;
	}

	private double getOverall(){
		double overall = 0;
		for (int i = 0; i < 6; i++){
			overall += (getPart1Results()[i] * getPart2ResultsWeights()[i]);
		}
		return overall;
	}

	/**
	 * Get the result formatted in HTML to display it in the web.<br>
	 */
	String getAsHTML(){
		StringBuilder sb = new StringBuilder("<html>");
		sb.append("<meta charset=\"UTF-8\">");
		sb.append("<table border=\"1\">");
		sb.append("<tr><td></td><td>" + TlxLocalization.getTranslation("rating") + "</td><td>" + TlxLocalization.getTranslation("tally") + "</td><td>" + TlxLocalization.getTranslation("weight") + "</td></tr>");
		for (int i = 0; i < 6; i++){
			sb.append("<tr>");

			sb.append("<td>");
			sb.append(indexMeaning[i]);//category
			sb.append("</td>");

			sb.append("<td>");
			sb.append(this.getPart1Results()[i]);//rating
			sb.append("</td>");

			sb.append("<td>");
			sb.append(this.getPart2Results()[i]);//clicks
			sb.append("</td>");

			sb.append("<td>");
			sb.append(this.getPart2ResultsWeights()[i]);//weight
			sb.append("</td>");

			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("<br>");
		sb.append("" + TlxLocalization.getTranslation("overall") + " = " + this.getOverall() + "");
		sb.append("</html>");
		return sb.toString();
	}

	/**
	 * Get the result formatted in CSV to use it with a spreadsheet program.<br>
	 */

	private String getAsCSV(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++){
			sb.append(indexMeaning[i]);//category
			sb.append("; ");

			sb.append(this.getPart1Results()[i]);//rating
			sb.append("; ");

			sb.append(this.getPart2Results()[i]);//clicks
			sb.append("; ");

			sb.append(this.getPart2ResultsWeights()[i]);//weight
			sb.append("; ");

			sb.append("\r\n");
		}
		return sb.toString();
	}

	/**
	 * Get the result formatted in XML.<br>
	 * The corresponding schmea for further processing is called <code>tlxresult.xsd</code> and included in the project.<br>
	 */

	private String getAsXML(){
		StringBuilder sb = new StringBuilder();
		sb.append("<TlxResult overall=\"" + getOverall() + "\">\r\n");
		for (int i = 0; i < 6; i++){
			sb.append("\t<TlxSingleResult category=\"");
			sb.append(indexMeaning[i]);//category
			sb.append("\">\r\n");
			sb.append("\t\t<Rating>");
			sb.append(this.getPart1Results()[i]);//rating
			sb.append("</Rating>\r\n");
			sb.append("\t\t<Clicks>");
			sb.append(this.getPart2Results()[i]);//clicks
			sb.append("</Clicks>\r\n");
			sb.append("\t\t<Weight>");
			sb.append(this.getPart2ResultsWeights()[i]);//weight
			sb.append("</Weight>\r\n");
			sb.append("\t</TlxSingleResult>\r\n");
		}
		sb.append("</TlxResult>");
		return sb.toString();
	}

	/**
	 * Saves the result in a CSV file.<br>
	 * Returns false if something went wrong.
	 * 
	 * @param path The path where to save the csv-file, e.g. "c:/test/tlxresult.csv"
	 */

	public boolean saveAsCSV(String path){
		return saveStringToFile(path, getAsCSV());
	}

	/**
	 * Saves the result in an XML file.<br>
	 * Returns false if something went wrong.
	 * 
	 * @param path The path where to save the xml-file, e.g. "c:/test/tlxresult.xml"
	 */

	public boolean saveAsXML(String path){
		return saveStringToFile(path, getAsXML());
	}

	/**
	 * Saves the result in a HTML file.<br>
	 * Returns false if something went wrong.
	 * 
	 * @param path The path where to save the html-file, e.g. "c:/test/tlxresult.htm"
	 */

	public boolean saveAsHTML(String path){
		return saveStringToFile(path, getAsHTML());
	}

	/**
	 * Saves a small String to a file.<br>
	 * Returns false if something went wrong.
	 */

	private boolean saveStringToFile(String path, String toSaveString){
		File file = new File(path);

		try (PrintWriter printWriter = new PrintWriter(file, "UTF-8")) {
			printWriter.write(toSaveString);
		}
		catch (FileNotFoundException e){
			logger.severe("File not found: " + file.getAbsolutePath());
			e.printStackTrace();
			return false;
		}
		catch (UnsupportedEncodingException e){
			logger.severe("Unsupported Encoding exception: " + file.getAbsolutePath());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		String returnString = "";
		returnString += ("Part 1: " + Arrays.toString(part1Results));
		returnString += ("Part 2: " + Arrays.toString(part2Results));
		returnString += ("Overall: " + getOverall());
		return returnString;
	}

}
