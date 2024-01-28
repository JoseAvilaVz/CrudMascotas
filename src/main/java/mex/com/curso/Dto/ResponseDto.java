package mex.com.curso.Dto;

public class ResponseDto {
	
	// Esta clase sirve para las respuestas de los servicios, permite 
	//contestar al cliente con un codigo de error por ejemplo
	
	private Integer code;
	private String message;
	private Object content; // un object recibe cualqueir tipo de dato
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
}
	

	

}
