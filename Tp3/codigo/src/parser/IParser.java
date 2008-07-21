package parser;

import casino.msg.MSGCasino;

public interface IParser {

	/**
	 * 
	 * @param objeto
	 */
	public MSGCasino parsear(IMessage objeto);

	/**
	 * 
	 * @param mensaje
	 */
	public IMessage renderizar(MSGCasino mensaje);
}