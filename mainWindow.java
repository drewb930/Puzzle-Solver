package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class mainWindow extends JFrame{
	private static final long serialVersionUID = -3880026026104218593L;
	private JTextField[][] board = new JTextField[9][9];
	private JLabel[][] outBoard = new JLabel[9][9];
	private int[][] inputBoard = new int[9][9];
	private JLabel status = new JLabel();
	private JLabel status2 = new JLabel();
	private String name;
	
	public mainWindow(String name)
	{
		this.name = name;
		JFrame frame = new JFrame(name);
		frame.setSize(900,400);

		
		
		JPanel mainPanel = new JPanel(new GridBagLayout()); // sets main panel with default grid layout
		
		mainPanel.setBackground(new Color(128,0,0));
		
		GridBagConstraints mainGB = new GridBagConstraints(); // sets contraints fro panel 1
		mainGB.fill = GridBagConstraints.HORIZONTAL;
		mainGB.anchor = GridBagConstraints.WEST;
		mainGB.ipady = 10;
		mainGB.weightx = .5;
		mainGB.insets = new Insets(0,2,0,0);
		mainGB.gridx = 0;
		mainGB.gridy = 0;
		
		
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBackground(new Color(128,0,0));
		
		GridBagConstraints GB1 = new GridBagConstraints(); // sets contraints fro panel 1
		GB1.fill = GridBagConstraints.HORIZONTAL;
		GB1.anchor = GridBagConstraints.WEST;
		GB1.ipady = 10;
		GB1.weightx = .5;
		GB1.insets = new Insets(0,2,0,0);
		GB1.gridx = 0;
		GB1.gridy = 0;
		
		
		JLabel title = new JLabel("Welcome to Your very own Puzzle Solver.");
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		title.setForeground(Color.WHITE);
		panel1.add(title);
		
		JLabel subTitle = new JLabel("What would you like to do today?");
		subTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTitle.setForeground(Color.WHITE);
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GB1.gridy++;
		panel1.add(subTitle,GB1);
		mainPanel.add(panel1);
		
		
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.setBackground(new Color(128,0,0));
		
		GridBagConstraints GB2 = new GridBagConstraints(); // sets contraints fro panel 1
		GB2.fill = GridBagConstraints.HORIZONTAL;
		GB2.anchor = GridBagConstraints.WEST;
		GB2.ipady = 10;
		GB2.weightx = .5;
		GB2.insets = new Insets(0,2,0,0);
		GB2.gridx = 0;
		GB2.gridy = 0;
		
		
		JButton sudoku = new JButton("Sudoku Solver");
		sudoku.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 sudoku();
		      }
		} );
		
		
		JButton unscrambler = new JButton("Word Unscrambler");
		unscrambler.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  unscramble();
		      }
		} );
		
		panel2.add(sudoku,GB2);
		GB2.gridx++;
		panel2.add(unscrambler,GB2);
		
		mainGB.gridy++;
		mainPanel.add(panel2,mainGB);
		
		
		frame.getContentPane().add(mainPanel);
		
		frame.setVisible(true);

	}
	
	
	private void sudoku() {
		JFrame frame = new JFrame(name);
		frame.setSize(900,900);

		
		
		JPanel mainPanel = new JPanel(new GridBagLayout()); // sets main panel with default grid layout
		
		mainPanel.setBackground(new Color(128,0,0));
		
		GridBagConstraints mainGB = new GridBagConstraints(); // sets contraints fro panel 1
		mainGB.fill = GridBagConstraints.HORIZONTAL;
		mainGB.anchor = GridBagConstraints.WEST;
		mainGB.ipady = 10;
		mainGB.weightx = .5;
		mainGB.insets = new Insets(0,2,0,0);
		mainGB.gridx = 0;
		mainGB.gridy = 0;
		
		
		
		
		JPanel panel0 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb0 = new GridBagConstraints(); // sets contraints fro panel 1
		gb0.fill = GridBagConstraints.HORIZONTAL;
		gb0.anchor = GridBagConstraints.WEST;
		gb0.ipady = 10;
		gb0.weightx = .5;
		gb0.insets = new Insets(0,0,0,0);
		gb0.gridx = 0;
		gb0.gridy = 0;
		JLabel title = new JLabel("Welcome to Sudoku Solver");
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel0.add(title);
		mainPanel.add(panel0,gb0);
		
		
		JPanel panel1 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb1 = new GridBagConstraints(); // sets contraints fro panel 1
		gb1.fill = GridBagConstraints.HORIZONTAL;
		gb1.anchor = GridBagConstraints.WEST;
		gb1.ipady = 10;
		gb1.weightx = .5;
		gb1.insets = new Insets(0,0,0,0);
		gb1.gridx = 0;
		gb1.gridy = 0;
	
		
		
		for(int i =0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int row = i / 3;
				int col = j / 3;
				board[i][j] = new JTextField();
				if((row == 0 && (col == 0 || col == 2)) || (row == 1 && col == 1) || (row == 2 && (col == 0 || col == 2))) {
					board[i][j].setBackground(new Color(230,230,230));
				}
				board[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				board[i][j].setMinimumSize(new Dimension(15,20));
				board[i][j].setPreferredSize(new Dimension(25,30));
				board[i][j].setMaximumSize(new Dimension(35,40));
				gb1.gridy = i;
				gb1.gridx = j;
				panel1.add(board[i][j],gb1);
			}
			
		}
		gb1.gridx++;
		gb1.gridy = 4;
		JLabel lab = new JLabel("  ----------->  ");
		lab.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel1.add(lab,gb1);
		
		int offset = 10;
		for(int i =0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				outBoard[i][j] = new JLabel("-");
				outBoard[i][j].setMinimumSize(new Dimension(15,20));
				outBoard[i][j].setPreferredSize(new Dimension(25,30));
				outBoard[i][j].setMaximumSize(new Dimension(35,40));
				gb1.gridy = i;
				gb1.gridx = offset + j;
				panel1.add(outBoard[i][j],gb1);
			}
			mainGB.gridx = 0;
			mainGB.gridy++;
			mainPanel.add(panel1,mainGB);
			
		}
		
		
		JPanel panel2 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb2 = new GridBagConstraints(); // sets contraints fro panel 1
		gb2.fill = GridBagConstraints.HORIZONTAL;
		gb2.anchor = GridBagConstraints.WEST;
		gb2.ipady = 10;
		gb2.weightx = .5;
		gb2.insets = new Insets(0,0,0,0);
		gb2.gridx = 0;
		gb2.gridy = 0;
		
		JLabel input = new JLabel("Input");
		input.setFont(new Font("Tahoma", Font.PLAIN, 22));
		input.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(input,gb2);
		JButton loadButton2 = new JButton("Generate Output");
		loadButton2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 loadData();
		    	solve();
		      }
		} );
		loadButton2.setAlignmentX(SwingConstants.LEFT);
		loadButton2.setMaximumSize(new Dimension(5,20));
		loadButton2.setPreferredSize(new Dimension(20,20));
		gb2.gridx++;
		panel2.add(loadButton2,gb2);
		mainGB.gridy++;
		mainPanel.add(panel2, mainGB);
		gb2.gridx++;
		
		JLabel output = new JLabel("Output");
		output.setFont(new Font("Tahoma", Font.PLAIN, 22));
		output.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(output,gb2);
		
		status.setText("Status: Waiting for data");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		gb2.gridy++;
		gb2.gridx = 1;
		panel2.add(status,gb2);
		
		frame.getContentPane().add(mainPanel);
		
		
		frame.setVisible(true);
	}
	
	private void loadData() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j ++) {
				if(board[i][j].getText().compareTo("") != 0) {
					inputBoard[i][j] = Integer.parseInt(board[i][j].getText());
				}
				else {
					inputBoard[i][j] = 0;
				}
				System.out.print(inputBoard[i][j]);
			}
		}
		
	}

	
	private void solve() {
		sudokuSolve s = new sudokuSolve(inputBoard);
		s.solve(inputBoard);
		int[][] ob = s.getBoard();
		boolean boardGood = true;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(!s.isValid(ob, i, j)) {
					boardGood = false;
				}
			}
		}
		if(boardGood) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					outBoard[i][j].setText(String.valueOf(ob[i][j]));
				}
			}
			status.setText("Status: Output board has been calculated");
		}
		else {
			status.setText("Status: There was an error, please re-enter the board");
		}
	}
	
	public void unscramble() {
		JFrame frame = new JFrame(name);
		frame.setSize(900,400);

		
		
		JPanel mainPanel = new JPanel(new GridBagLayout()); // sets main panel with default grid layout
		
		mainPanel.setBackground(new Color(128,0,0));
		
		GridBagConstraints mainGB = new GridBagConstraints(); // sets contraints fro panel 1
		mainGB.fill = GridBagConstraints.HORIZONTAL;
		mainGB.anchor = GridBagConstraints.WEST;
		mainGB.ipady = 10;
		mainGB.weightx = .5;
		mainGB.insets = new Insets(0,2,0,0);
		mainGB.gridx = 0;
		mainGB.gridy = 0;
		
		
		
		
		JPanel panel0 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb0 = new GridBagConstraints(); // sets contraints fro panel 1
		gb0.fill = GridBagConstraints.HORIZONTAL;
		gb0.anchor = GridBagConstraints.WEST;
		gb0.ipady = 10;
		gb0.weightx = .5;
		gb0.insets = new Insets(0,0,0,0);
		gb0.gridx = 0;
		gb0.gridy = 0;
		JLabel title = new JLabel("Welcome to Word Unscrambler");
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel0.add(title);
		mainPanel.add(panel0,gb0);
		
		
		JPanel panel1 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb1 = new GridBagConstraints(); // sets contraints fro panel 1
		gb1.fill = GridBagConstraints.HORIZONTAL;
		gb1.anchor = GridBagConstraints.WEST;
		gb1.ipady = 10;
		gb1.weightx = .5;
		gb1.insets = new Insets(0,0,0,0);
		gb1.gridx = 0;
		gb1.gridy = 0;
	
		JLabel input = new JLabel("Input:   ");
		input.setFont(new Font("Tahoma", Font.PLAIN, 20));
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(input,gb1);
		
		JTextField in = new JTextField();
		gb1.gridx++;
		panel1.add(in,gb1);
		
		JLabel blank = new JLabel("   ");
		gb1.gridx++;
		panel1.add(blank,gb1);
		
		mainGB.gridy++;
		mainPanel.add(panel1,mainGB);
		
		
		JPanel panel2 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb2 = new GridBagConstraints(); // sets contraints fro panel 1
		gb2.fill = GridBagConstraints.HORIZONTAL;
		gb2.anchor = GridBagConstraints.WEST;
		gb2.ipady = 10;
		gb2.weightx = .5;
		gb2.insets = new Insets(0,0,0,0);
		gb2.gridx = 0;
		gb2.gridy = 0;
	
		JLabel output = new JLabel("Output:   ");
		output.setFont(new Font("Tahoma", Font.PLAIN, 20));
		output.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(output,gb2);
		
		JLabel out = new JLabel("---");
		out.setHorizontalAlignment(SwingConstants.CENTER);
		out.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gb2.gridx++;
		panel2.add(out,gb2);
		
		JLabel blank2 = new JLabel("   ");
		gb2.gridx++;
		panel2.add(blank2,gb2);
		
		mainGB.gridy++;
		
		mainPanel.add(panel2,mainGB);
		
		JPanel panel3 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb3 = new GridBagConstraints(); // sets contraints fro panel 1
		gb3.fill = GridBagConstraints.HORIZONTAL;
		gb3.anchor = GridBagConstraints.WEST;
		gb3.ipady = 10;
		gb3.weightx = .5;
		gb3.insets = new Insets(0,0,0,0);
		gb3.gridx = 0;
		gb3.gridy = 0;
		
		JButton calc = new JButton("Generate Unscrambled Word");
		calc.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  String inputWord = in.getText();
		    	  wordUnscramble wu = new wordUnscramble();
		    	  String word = wu.word(inputWord);
		    	  if(word.compareTo("") != 0) {
		    		  out.setText(word);
		    		  status2.setText("Status: Word was found");
		    	  }
		    	  else {
		    		  out.setText("Word was not found for " + in.getText());
		    		  status2.setText("Status: Word was not found");
		    	  }
		      }
		} );
		panel3.add(calc);
		
		mainGB.gridy++;
		
		mainPanel.add(panel3,mainGB);
		
		
		JPanel panel4 = new JPanel(new GridBagLayout()); // makes first panel
		
		GridBagConstraints gb4 = new GridBagConstraints(); // sets contraints fro panel 1
		gb4.fill = GridBagConstraints.HORIZONTAL;
		gb4.anchor = GridBagConstraints.WEST;
		gb4.ipady = 10;
		gb4.weightx = .5;
		gb4.insets = new Insets(0,0,0,0);
		gb4.gridx = 0;
		gb4.gridy = 0;
		
		status2.setText("Status: Waiting for scrambled word. May take long for large words");

		panel4.add(status2);
		
		mainGB.gridy++;
		
		mainPanel.add(panel4,mainGB);
		
		
		frame.getContentPane().add(mainPanel);
		
		
		frame.setVisible(true);
	}
	

}
