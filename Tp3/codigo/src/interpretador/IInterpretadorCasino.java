package interpretador;

import parser.IMessage;

public interface IInterpretadorCasino {

	/**
	 * 
	 * @param mensaje
	 */
	public IMessage interpretar(IMessage mensaje);

}