import javax.swing.*;

public class SwingGraphicsGame {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameFrame wnd = new GameFrame("Geometry Dash");

				wnd.setVisible(true);
				//do we want to have the screen and square move automatically to the right, or do we want to set all o the triangles and platforms to move to the left?

			}
		});
	}
}