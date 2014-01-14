package com.jnasatlx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A special JPanel with a scale of 20 buttons.
 * 
 * @author Bernhard Glaser
 * @version 1.0
 */

public class TlxScalePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Dimension scaleButtonDimension = new Dimension(30, 30);
	private static Dimension scaleDescTextAreaDimension = new Dimension(350, 80);

	private JLabel scaleTitleLabel = new JLabel();
	private JLabel scaleLowLabel = new JLabel();
	private JLabel scaleHighLabel = new JLabel();

	private JTextArea scaleDescTextArea = new JTextArea() {

		private static final long serialVersionUID = -1122531795853779840L;

		@Override
		public Dimension getMinimumSize(){
			return scaleDescTextAreaDimension;
		}

		@Override
		public Dimension getPreferredSize(){
			return scaleDescTextAreaDimension;
		}
	};

	private JButton[] buttons = new JButton[20];

	private static Color selectedColor = Color.YELLOW;
	private static Color notSelectedColor = new JButton().getBackground();

	private int selectedValue = -1;

	public TlxScalePanel(String scaleTitleText, String scaleLowText, String scaleHighText, String scaleDescriptionText){
		super();
		this.setLayout(new GridBagLayout());

		scaleTitleLabel.setText(scaleTitleText);
		scaleLowLabel.setText(scaleLowText);
		scaleHighLabel.setText(scaleHighText);
		scaleDescTextArea.setLineWrap(true);
		scaleDescTextArea.setWrapStyleWord(true);
		scaleDescTextArea.setEditable(false);
		scaleDescTextArea.setText(scaleDescriptionText);
		scaleDescTextArea.setBackground(new JFrame().getBackground());

		// gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 20, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0);
		this.add(scaleTitleLabel, gbc);

		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new ScaleButton(i);
			this.add(buttons[i], gbc);
			gbc.gridx++;
		}

		gbc = new GridBagConstraints(0, 2, 10, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0);
		this.add(scaleLowLabel, gbc);

		gbc = new GridBagConstraints(10, 2, 10, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0);
		this.add(scaleHighLabel, gbc);

		gbc = new GridBagConstraints(21, 0, 1, 4, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 20, 10, 0), 10, 10);
		this.add(scaleDescTextArea, gbc);
	}

	public void markRed(){
		scaleTitleLabel.setForeground(Color.RED);
	}

	class ScaleButton extends JButton{

		private static final long serialVersionUID = 1L;
		int index = -1;

		public ScaleButton(int index){
			this.index = index;
			this.setBackground(notSelectedColor);
			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e){
					buttonActionPerformed();
				}
			});
		}

		private void buttonActionPerformed(){
			selectedValue = (index + 1) * 5;
			for (JButton button: buttons){
				button.setBackground(notSelectedColor);
			}
			this.setBackground(selectedColor);
			scaleTitleLabel.setForeground(Color.BLACK);
		}

		@Override
		public Dimension getMinimumSize(){
			return scaleButtonDimension;
		}

		@Override
		public Dimension getPreferredSize(){
			return scaleButtonDimension;
		}

		public int getIndex(){
			return index;
		}

		public void setIndex(int index){
			this.index = index;
		}

	}

	public int getSelectedValue(){
		return selectedValue;
	}

	public void setSelectedValue(int selectedValue){
		this.selectedValue = selectedValue;
	}

	public static Dimension getScaleDescTextAreaDimension(){
		return scaleDescTextAreaDimension;
	}
}
