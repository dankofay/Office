package logos.office.officeProject.model;

public class Message {

	int a;

	public Message(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Message() {
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (a != other.a)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [a=" + a + "]";
	}
	
}
