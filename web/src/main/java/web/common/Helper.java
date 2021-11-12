package web.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class Helper {

	final static Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

	public static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		return b;
	}

	// https://github.com/corretto/corretto-11/issues/118
	public static String generateCAPTCHAImageAsBase64(final int number1, final int number2) {
		final int height = 256;
		final int width = (int) (height * 1.5);

		//https://dukesoftware00.blogspot.com/2012/07/create-indexed-256-png-using-pngj.html
		final int[] colourMap = {  0x00000000, 0xff000000, 0xffffffff, 0xff00FFFF, 0xffFFFF00, 0xFF00FF00, 0x8800FF00 };
		IndexColorModel colorModel = new IndexColorModel(8, colourMap.length, colourMap, 0, true, 0, DataBuffer.TYPE_BYTE);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_INDEXED, colorModel);

		Graphics2D g2d = bufferedImage.createGraphics();
		Font font = new Font(null, Font.BOLD, height / 3);
		g2d.setFont(font);
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		Random rand = new Random();

		g2d.setStroke(new BasicStroke((Math.abs(rand.nextInt()) % (height / 4)) + 5));
		g2d.setColor(Color.yellow);
		g2d.drawLine(Math.abs(rand.nextInt() % width), 0, Math.abs(rand.nextInt() % width), width);

		g2d.setStroke(new BasicStroke((Math.abs(rand.nextInt()) % (height / 4)) + 5));
		g2d.setColor(Color.green);
		g2d.drawLine(Math.abs(rand.nextInt() % width), 0, Math.abs(rand.nextInt() % width), width);

		g2d.setStroke(new BasicStroke((Math.abs(rand.nextInt()) % (height / 4)) + 5));
		g2d.setColor(Color.cyan);
		g2d.drawLine(0, Math.abs(rand.nextInt() % height), width, Math.abs(rand.nextInt() % height));

		// g2d.setColor(new Color(0, 0, 255));
		// g2d.fillRect(0, 0, width, height); // Fill background
		g2d.setColor(new Color(0, 0, 0));

		int degreesFirst = 30 + (rand.nextInt() % 90);
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.rotate(Math.toRadians(degreesFirst), 10, 10);
		Font rotatedFont = font.deriveFont(affineTransform);

		g2d.setFont(rotatedFont);
		g2d.drawString(String.valueOf(number1), width / 6, height / 3);

		int degreesSecond = degreesFirst + (rand.nextInt() % 90);
		affineTransform = new AffineTransform();
		affineTransform.rotate(Math.toRadians(degreesSecond), 10, 10);
		rotatedFont = font.deriveFont(affineTransform);
		g2d.setFont(rotatedFont);
		g2d.drawString(String.valueOf(number2), (int) (width / 6 * 3.5), (int) (height / 6 * 1.5));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedImage, "png", baos);
		} catch (IOException e) {
			return null;
		}
		byte[] bytes = baos.toByteArray();
		String b64 = new String(Base64.getEncoder().encode(bytes));

		// Save to file in working directory
		// File outputfile = new File("CAPTCHA.png");
		// try {
		// ImageIO.write(bufferedImage, "png", outputfile);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return "data:image/png;base64," + b64;
	}
}
