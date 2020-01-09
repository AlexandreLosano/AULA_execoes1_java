package modelo.execao;

public class ExecaoDeDominio extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExecaoDeDominio (String msg) {
		super(msg);
	}
	
}
