package com.jnasatlx;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.jnasatlx.TlxLocalization.TlxLanguage;

/**
 * Start here.<br>
 * <br>
 * Hart and Staveland's NASA Task Load Index (NASATLX) is a questionniare for measuring subjective work load of a given task.<br>
 * <br>
 * This work is a complete Java-Port of the NASA TLX Test implemented in Html and Javascript by Keith Vertanen.<br>
 * <br>
 * See these links:<br>
 * <ul>
 * <li><a href="http://www.keithv.com/software/nasatlx/">http://www.keithv.com/software/nasatlx/</a></li>
 * <li><a href="http://humansystems.arc.nasa.gov/groups/TLX/tlxpublications.html">http://humansystems.arc.nasa.gov/groups/TLX/tlxpublications.html</li>
 * </ul>
 * 
 * @author Bernhard Glaser
 * @version 1.01
 */

public class TlxFrame extends JFrame{

	private static final long serialVersionUID = 1244535297267562936L;

	private static final Logger logger = Logger.getLogger(TlxFrame.class.getName());

	private TlxResult result = new TlxResult();

	private CardLayout cardLayout = new CardLayout();

	private JPanel uberCardPanel = new JPanel();
	private HashMap<String, JPanel> cardMap = new HashMap<>();
	private Card1Panel card1Panel = new Card1Panel();
	private Card2Panel card2Panel = new Card2Panel();
	private Card3Panel card3Panel = new Card3Panel();

	public TlxFrame(){
		logger.finest("Running Constructor of TlxFrame");
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 10, 10);

		uberCardPanel.setLayout(cardLayout);
		addCard("1", card1Panel);
		addCard("2", card2Panel);
		addCard("3", card3Panel);

		this.add(uberCardPanel, gbc);
		this.pack();

		TlxFrame.setMinPrefSize(this, new Dimension(1024, 768));
		TlxFrame.centerOnScreen(this);
		TlxFrame.mazimizeFrame(this);

		showCard("1");
	}

	private void addCard(String constraintsKey, JPanel panel){
		cardMap.put(constraintsKey, panel);
		uberCardPanel.add(panel, constraintsKey);
	}

	private void showCard(String constraintsKey){
		cardLayout.show(uberCardPanel, constraintsKey);
		JPanel panel = cardMap.get(constraintsKey);
		this.setTitle(panel.getName());
	}

	/**
	 * Called when the test is completed by the test subject.
	 */

	void finished(){

		//Examples for handling the result

		/*
		System.out.println("***********************************");
		System.out.println("HTML");
		System.out.println(result.getAsHTML());
		System.out.println("***********************************");
		*/
		//System.out.println("Saving results as HTML: "+result.saveAsHTML("c:/test/tlxresult.htm"));

		/*
		System.out.println("***********************************");
		System.out.println("CSV");
		System.out.println(result.getAsCSV());
		System.out.println("***********************************");
		*/
		//System.out.println("Saving results as CSV: "+result.saveAsCSV("c:/test/tlxresult.csv"));

		/*
		System.out.println("***********************************");
		System.out.println("XML");
		System.out.println(result.getAsXML());
		System.out.println("***********************************");
		*/
		//System.out.println("Saving results as XML: "+result.saveAsXML("c:/test/tlxresult.xml"));

		/*
		System.out.println("***********************************");
		System.out.println("content");
		System.out.println(result);
		System.out.println("***********************************");
		*/

		JOptionPane.showMessageDialog(this, result.getAsHTML());
		System.exit(0);
	}

	/**
	 * <u>Example call:</u> <code>java -jar jnasatlx.jar -language german -loglevel debug</code>
	 * 
	 * @param args
	 * Optional starting parameters:<br>
	 * <ul>
	 * <li><code>-help</code>: print a help</li>
	 * <li><code>-language</code>: english, german</li>
	 * <li><code>-loglevel</code>: debug, info, warn, off, all</li>
	 * </ul>
	 */

	public static void main(String args[]){
		Logger.getGlobal().setLevel(Level.WARNING);
		Logger.getGlobal().addHandler(new StreamHandler(System.out, new SimpleFormatter()));
		for (int i = 0; i < args.length; i++){
			args[i] = args[i].toLowerCase();
		}
		if (args.length > 0){
			for (int i = 0; i < args.length; i++){
				switch (args[i]){
				case "-help":
				case "-h":{
					printHelpAndExit();
				}
				case "-language":{
					if (args.length >= (i + 1)){
						switch (args[i + 1]){
						case "english":
						case "englisch":{
							TlxLocalization.setLanguage(TlxLanguage.ENGLISH);
							i = i + 1;
							break;
						}
						case "german":
						case "deutsch":{
							TlxLocalization.setLanguage(TlxLanguage.GERMAN);
							i = i + 1;
							break;
						}
						default:{
							System.out.println("Unkown language: " + args[i + 1]);
							printHelpAndExit();
						}
						}
					}
					else{
						printHelpAndExit();
					}
					break;
				}
				case "-loglevel":{
					if (args.length >= (i + 1)){
						switch (args[i + 1]){
						case "debug":
							Logger.getGlobal().setLevel(Level.FINEST);
							i = i + 1;
							break;
						case "info":
							Logger.getGlobal().setLevel(Level.INFO);
							i = i + 1;
							break;
						case "warn":
							Logger.getGlobal().setLevel(Level.WARNING);
							i = i + 1;
							break;
						case "off":
							Logger.getGlobal().setLevel(Level.OFF);
							i = i + 1;
							break;
						case "all":
							Logger.getGlobal().setLevel(Level.ALL);
							i = i + 1;
							break;
						default:{
							printHelpAndExit();
						}
						}
					}
					else{
						printHelpAndExit();
					}
					break;
				}
				default:{
					printHelpAndExit();
				}
				}
			}
		}
		TlxFrame n = new TlxFrame();
		n.setVisible(true);
	}

	private static void printHelpAndExit(){
		StringBuffer help = new StringBuffer();
		help.append("This program supports the following command line options: \r\n");
		help.append("-language followed by ENGLISH (default) or GERMAN: set the language used in the tlx test \r\n");
		help.append("-loglevel followed by DEBUG, INFO, WARN, OFF or ALL: set the logging mode used in the tlx test \r\n");
		help.append("-help or -h: to show this help\r\n");
		System.out.println(help);
		System.exit(0);
	}

	/**
	 * The Card1Panel shows the scales in the first part of the tlx test
	 */

	class Card1Panel extends JPanel{

		private static final long serialVersionUID = -6660146201416213495L;

		private final TlxScalePanel[] scalePanels;

		Card1Panel(){
			this.setName(TlxLocalization.getTranslation("quest1Title"));

			JLabel label = new JLabel(TlxLocalization.getTranslation("quest1Desc"));

			TlxScalePanel n0 = new TlxScalePanel(TlxLocalization.getTranslation("scale0Title"), TlxLocalization.getTranslation("scale0Left"), TlxLocalization.getTranslation("scale0Right"), TlxLocalization.getTranslation("scale0Desc"));
			TlxScalePanel n1 = new TlxScalePanel(TlxLocalization.getTranslation("scale1Title"), TlxLocalization.getTranslation("scale1Left"), TlxLocalization.getTranslation("scale1Right"), TlxLocalization.getTranslation("scale1Desc"));
			TlxScalePanel n2 = new TlxScalePanel(TlxLocalization.getTranslation("scale2Title"), TlxLocalization.getTranslation("scale2Left"), TlxLocalization.getTranslation("scale2Right"), TlxLocalization.getTranslation("scale2Desc"));
			TlxScalePanel n3 = new TlxScalePanel(TlxLocalization.getTranslation("scale3Title"), TlxLocalization.getTranslation("scale3Left"), TlxLocalization.getTranslation("scale3Right"), TlxLocalization.getTranslation("scale3Desc"));
			TlxScalePanel n4 = new TlxScalePanel(TlxLocalization.getTranslation("scale4Title"), TlxLocalization.getTranslation("scale4Left"), TlxLocalization.getTranslation("scale4Right"), TlxLocalization.getTranslation("scale4Desc"));
			TlxScalePanel n5 = new TlxScalePanel(TlxLocalization.getTranslation("scale5Title"), TlxLocalization.getTranslation("scale5Left"), TlxLocalization.getTranslation("scale5Right"), TlxLocalization.getTranslation("scale5Desc"));

			scalePanels = new TlxScalePanel[]{n0, n1, n2, n3, n4, n5};

			JButton button = new JButton(TlxLocalization.getTranslation("continueButton"));
			button.addActionListener(e -> {
					boolean allOk = true;
					for (TlxScalePanel sp: scalePanels){
						if (sp.getSelectedValue() == -1){
							sp.markRed();
							allOk = false;
						}
					}
					if (allOk){
						for (int i = 0; i < scalePanels.length; i++){
							result.getPart1Results()[i] = scalePanels[i].getSelectedValue();
						}
						showCard("2");
					}
				}
			);

			this.setLayout(new GridBagLayout());
			// gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
			GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 10, 10);
			this.add(label, gbc);
			gbc.gridy++;
			this.add(n0, gbc);
			gbc.gridy++;
			this.add(n1, gbc);
			gbc.gridy++;
			this.add(n2, gbc);
			gbc.gridy++;
			this.add(n3, gbc);
			gbc.gridy++;
			this.add(n4, gbc);
			gbc.gridy++;
			this.add(n5, gbc);
			gbc.gridy++;
			this.add(button, gbc);
		}

		public TlxScalePanel[] getScalePanels(){
			return scalePanels;
		}

	}

	/**
	 * The Card2Panel prepares the test subject for the second part of the test
	 */

	class Card2Panel extends JPanel{

		private static final long serialVersionUID = -2661200935539051347L;

		Card2Panel(){
			this.setName(TlxLocalization.getTranslation("quest2Title"));
			this.setLayout(new GridBagLayout());

			JTextArea area = new JTextArea(TlxLocalization.getTranslation("quest2Desc"));
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			area.setEditable(false);
			TlxFrame.setMinPrefSize(area, new Dimension(350, 80));
			JButton button = new JButton(TlxLocalization.getTranslation("continueButton"));
			button.addActionListener(e -> showCard("3"));

			// gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
			GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 10, 10);
			this.add(area, gbc);
			gbc.gridy++;
			this.add(button, gbc);
		}

	}

	/**
	 * The Card3Panel holds the questions of the second part of the test
	 */

	class Card3Panel extends JPanel{

		private static final long serialVersionUID = -5833038044532947048L;
		CardLayout innerCardLayout = new CardLayout();
		private int aktKey = 0;

		Card3Panel(){
			this.setName(TlxLocalization.getTranslation("quest3Title"));
			this.setLayout(innerCardLayout);
			for (int i = 0; i < 15; i++){
				this.add(new ComparisonCardPanel(i), Integer.toString(i));
			}
		}

		private void nextCard(){
			aktKey++;
			if (aktKey != 15){
				innerCardLayout.show(this, Integer.toString(aktKey));
			}
			else{
				finished();
			}
		}

		class ComparisonCardPanel extends JPanel{

			private static final long serialVersionUID = -4586116273649879804L;

			Dimension buttonDimension = new Dimension(350, 25);
			Dimension textareaDimension = TlxScalePanel.getScaleDescTextAreaDimension();

			private JButton button0;
			private JButton button1;
			private JTextArea textarea0;
			private JTextArea textarea1;
			private JLabel orLabel;

			ComparisonCardPanel(final int index){
				final int int0 = result.getPairs()[index][0];
				final int int1 = result.getPairs()[index][1];

				this.setLayout(new GridBagLayout());

				button0 = new JButton(TlxLocalization.getTranslation("scale" + int0 + "Title"));
				TlxFrame.setMinPrefSize(button0, textareaDimension);
				button1 = new JButton(TlxLocalization.getTranslation("scale" + int1 + "Title"));
				TlxFrame.setMinPrefSize(button1, textareaDimension);

				textarea0 = new JTextArea(TlxLocalization.getTranslation("scale" + int0 + "Desc"));
				textarea0.setLineWrap(true);
				textarea0.setWrapStyleWord(true);
				textarea0.setEditable(false);
				TlxFrame.setMinPrefSize(textarea0, textareaDimension);
				textarea1 = new JTextArea(TlxLocalization.getTranslation("scale" + int1 + "Desc"));
				textarea1.setLineWrap(true);
				textarea1.setWrapStyleWord(true);
				textarea1.setEditable(false);
				TlxFrame.setMinPrefSize(textarea1, textareaDimension);

				orLabel = new JLabel(TlxLocalization.getTranslation("or"));

				// gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
				GridBagConstraints gbc = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 10, 10);
				this.add(new JLabel(TlxLocalization.getTranslation("quest3Desc")), gbc);
				gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 10, 10);
				this.add(button0, gbc);
				gbc.gridx++;
				this.add(textarea0, gbc);
				gbc.gridx = 0;
				gbc.gridy++;
				gbc.anchor = GridBagConstraints.CENTER;
				this.add(orLabel, gbc);
				gbc.gridy++;
				this.add(button1, gbc);
				gbc.gridx++;
				this.add(textarea1, gbc);

				button0.addActionListener(e -> {
						result.getPart2Results()[int0]++;
						nextCard();
					}
				);

				button1.addActionListener(e -> {
						result.getPart2Results()[int1]++;
						nextCard();
					}
				);
			}
		}
	}

	/**
	 * Centers a component on the main screen
	 */

	private static void centerOnScreen(Component c){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = c.getSize();
		int x = (screenSize.width - size.width) / 2;
		c.setBounds(x, (screenSize.height - size.height) / 2, size.width, size.height);
	}

	/**
	 * Sets both minimal and preferred size for a component
	 */

	private static void setMinPrefSize(Component c, Dimension d){
		c.setMinimumSize(d);
		c.setPreferredSize(d);
	}

	/**
	 * Sets a JFrame in the maximized state
	 */

	private static void mazimizeFrame(JFrame frame){
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

}
