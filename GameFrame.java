import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

public class GameFrame extends JFrame {
	private int prints = 0;
	private game game = new game();

	// starting dimensions of window (pixels)
	public static final int WIDTH = 500, HEIGHT = 300, REFRESH = 40;

	// where the game objects are displayed
	private JPanel panel = new JPanel() {
		Image img = Toolkit.getDefaultToolkit().getImage("bg.jpg");

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
			// tried to get rid of some stuttering, changing REFRESH
			// improved this issue
			panel.getToolkit().sync();
		}
	};
	private Timer timer;// timer that runs the game

	public GameFrame(String string) {
		super(string);
		setUpStuff();
	}

	/**
	 * Sets up the panel, timer, other initial objects in the game.
	 * The Timer goes off every REFRESH milliseconds. Every time the
	 * Timer goes off, the game is told to update itself and then the
	 * view is refreshed.
	 */
	private void setUpStuff() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.add(panel);
		this.pack();
		timer = new Timer(REFRESH, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.updateGame();
				panel.repaint();
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		timer.start();
		this.setVisible(true);
		panel.requestFocusInWindow();
		addKeys(panel);
	}

	/**
	 * Proper way to acquire keystrokes in an application.
	 * This method sets up the mapping which associates a Keystroke (you
	 * can Google Java KeyStroke API or examples) with an "action command" String
	 * 
	 * The second part maps the action command String with an Action.
	 * I have shown you two ways this can be done. You can write the code
	 * you want executed in the actionPerformed method or you can call the
	 * method from within the actionPerformed method call.
	 */
	private void addKeys(JPanel panel) {
		// this connects keystroke with a command
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up_key");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "up_key_r");

		panel.getActionMap().put("up_key_r", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("released the up arrow");
				game.upReleased(e);
			}
		});

		panel.getActionMap().put("up_key", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed up arrow");
				game.upHit(e);
			}
		});

	}

}
