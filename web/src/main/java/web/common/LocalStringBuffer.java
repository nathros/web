package web.common;

public class LocalStringBuffer {

	public StringBuilder buffer;

	public LocalStringBuffer(int startSize) {
		buffer = new StringBuilder(startSize);
	}

	public void ln(String line) {
		buffer.append(line);
		buffer.append("\n");
	}

	public void l(String line) {
		buffer.append(line);
	}

	public String toString() {
		return buffer.toString();
	}

}
