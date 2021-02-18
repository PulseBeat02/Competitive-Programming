import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class test {

	//

	public static void main(String[] args) throws IOException {

		File folder = new File("C:\\Users\\Brandon Li\\Desktop\\minecraftsongs\\assets\\minecraft\\sounds");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				
				String name = listOfFiles[i].getName();
				int time = (int) calculateDuration(listOfFiles[i]);
				
				System.out.println(name + " " + time);
				
				PrintWriter pw = new PrintWriter(new File("C:\\Users\\Brandon Li\\Desktop\\minecraftsongs\\assets\\minecraft\\sounds\\" + name.substring(0, name.length()-4) + ".txt"));
				pw.println("Time: " + time);
				pw.close();

			}
		}

	}

	static double calculateDuration(final File oggFile) throws IOException {
		int rate = -1;
		int length = -1;

		int size = (int) oggFile.length();
		byte[] t = new byte[size];

		FileInputStream stream = new FileInputStream(oggFile);
		stream.read(t);

		for (int i = size - 1 - 8 - 2 - 4; i >= 0 && length < 0; i--) { // 4 bytes for "OggS", 2 unused bytes, 8 bytes
																		// for length
			// Looking for length (value after last "OggS")
			if (t[i] == (byte) 'O' && t[i + 1] == (byte) 'g' && t[i + 2] == (byte) 'g' && t[i + 3] == (byte) 'S') {
				byte[] byteArray = new byte[] { t[i + 6], t[i + 7], t[i + 8], t[i + 9], t[i + 10], t[i + 11], t[i + 12],
						t[i + 13] };
				ByteBuffer bb = ByteBuffer.wrap(byteArray);
				bb.order(ByteOrder.LITTLE_ENDIAN);
				length = bb.getInt(0);
			}
		}
		for (int i = 0; i < size - 8 - 2 - 4 && rate < 0; i++) {
			// Looking for rate (first value after "vorbis")
			if (t[i] == (byte) 'v' && t[i + 1] == (byte) 'o' && t[i + 2] == (byte) 'r' && t[i + 3] == (byte) 'b'
					&& t[i + 4] == (byte) 'i' && t[i + 5] == (byte) 's') {
				byte[] byteArray = new byte[] { t[i + 11], t[i + 12], t[i + 13], t[i + 14] };
				ByteBuffer bb = ByteBuffer.wrap(byteArray);
				bb.order(ByteOrder.LITTLE_ENDIAN);
				rate = bb.getInt(0);
			}

		}
		stream.close();

		double duration = (double) (length * 1000) / (double) rate;
		return duration;
	}

}
