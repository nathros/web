package web.common;

public class LocalStringBuffer {

	public StringBuffer buffer;

	public LocalStringBuffer(int startSize) {
		buffer = new StringBuffer(startSize);
	}

	public void ln(String line) {
		buffer.append(line);
		buffer.append("\n");
	}

	public String toString() {
		return buffer.toString();
	}

}
