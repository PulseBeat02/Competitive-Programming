import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class resize {

	public static void main(String[] args) throws MalformedURLException {

		File f = new File("C:\\Users\\Brandon Li\\Downloads");
		URL img = f.toURL();
		ImageIcon icon = new ImageIcon(img);

		int width = 640;
		int height = 512;
		icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));

	}

}
