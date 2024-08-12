package br.com.soc.sistema.exception;

public class TechnicalException extends RuntimeException{

	private static final long serialVersionUID = 218857648475568706L;

	public TechnicalException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
	
	public TechnicalException(String mensagem) {
		super(mensagem);
	}
	
}
