package Function;
import Function.Wonderland;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MBgame extends JFrame {
		public MBgame() {
			startMBgame();
		}
		
		private void startMBgame() {
				add(new Wonderland());
				setResizable(false);
				pack();
				setTitle("MONKEY BANANA GAME");
		        setLocationRelativeTo(null);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				JFrame frame = new MBgame();
				@Override
				public void run() {
					frame.setVisible(true);				
				}
			});
		}
	}


