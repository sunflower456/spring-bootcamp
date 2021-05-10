package java8.step01.domain.exception;

public class AssignException extends RuntimeException {
	
	public AssignException() {
		super();
	}

	public AssignException(String message) {
		//
		super(message);
	}

	private static final long serialVersionUID = 869520952220689609L;

}
