package common;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class Common {

	public static String picPath;
	public static JDesktopPane setDesk(String pic){
		picPath = pic;
		JDesktopPane deck = new JDesktopPane(){
			public void paintComponent(Graphics g) {
				Image image;
				try {
					image = ImageIO
							.read(new File(picPath));
					Image i = image.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
					g.drawImage(i, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return deck;
	}
}
