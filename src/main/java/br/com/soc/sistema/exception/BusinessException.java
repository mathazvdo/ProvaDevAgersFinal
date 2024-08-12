package br.com.soc.sistema.exception;

// Extende a classe RuntimeException para criar uma exceção de negócios personalizada
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -4984332378454049929L;

	// Construtor que aceita apenas uma mensagem
    public BusinessException(String message) {
        super(message);
    }

    // Construtor que aceita uma mensagem e uma causa (outra exceção)
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
