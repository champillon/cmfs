package th.or.operationsmile.cmfs.exception;

public class ErrorFieldException extends Exception {
	private String field;
	
	public ErrorFieldException(String message, String field){
		super(message);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
