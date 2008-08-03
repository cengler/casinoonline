package parser;

import core.IMessage;

public abstract class Parser
{
	public abstract Object parse(IMessage is) throws ParserException;
	public abstract void renderizar(Object msg, IMessage imsg) throws ParserException;
}