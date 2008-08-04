package implementations;

import java.io.IOException;

import core.ImplementationFactory;




public class Test {

	public static void main(String[] args) {
		
	try {
		ISuma s = ImplementationFactory.getImplementation(ISuma.class, false);
		IResta r = ImplementationFactory.getImplementation(IResta.class, true);
		System.out.println(s.suma(3, 4));
		System.out.println(r.restar(3, 4));
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
	}
}
