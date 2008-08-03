package servicios;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Factory de todas las implementaciones de interfaces en el casino.
 * 
 * @author Grupo2
 */
public final class ImplementationFactory 
{
    /**
     * Propiedades que contienen para cada interfaz, el nombre de la implementacion.
     */
	private static Properties properties;
	
	/**
	 * Nombre del archivo con las implementaciones.
	 */
	private static String fileName;
	
    private static Logger logger = Logger.getLogger(ImplementationFactory.class);
    
	/**
	 * Constructor privado.
	 */
	private ImplementationFactory()	{}
	
	/**
	 * A partir de la interfaz pasada como parametro, obtiene la implementacion que este configurada.
	 * La definicion de la implementacion asociada a cada interfaz se encuentra en un archivo de properties.
	 * 
	 * @param <T> Parámetro de clase.
	 * @param interfaceClass Clase de la interfaz de la cual se quiere la implementacion
	 * @param singletonInstance Indica si debe o no devolver una instancia singleton de la implementacion o si debe
	 * crear una nueva implementacion para esta invocacion.
	 * 
	 * @return Implementacion configurada para la interfaceClass
	 * 
	 * @throws IOException Si no se pudo levantar la definicion de las implementaciones
	 * @throws ClassNotFoundException Si no se encontro la implementacion en el classpath
	 * @throws IllegalAccessException Si no tiene permisos para instanciar la clase
	 * @throws InstantiationException Si no pudo instanciar la clase por otro motivo (ej. no tiene constructor vacio)
	 * o no existe una implementacion para la interfaz pasada
 	 */
	public static synchronized <T> T  getImplementation(Class<T>  interfaceClass, boolean singletonInstance) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		logger.debug("Va a buscar la implementacion de " + interfaceClass.getName());
		
		if(properties==null)
		{
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			properties = new Properties();
			
			fileName = ImplementationFactory.class.getName().replace('.', '/') + ".properties";
			
			logger.debug("Va a leer las implementaciones del archivo " + fileName);

			InputStream is = cl.getResourceAsStream(fileName);
      
			if(is!=null)
				properties.load(is);
			else
				throw new InstantiationException(ImplementationFactory.class.getName() + 
						 ": No se encontro el archivo " + fileName +
						 " con la definicion de las implementaciones, verifique " + 
						 "que este archivo se encuentre en el classpath.");
				
			
			logger.debug("Implementaciones leidas: ");
			for(Object o : properties.keySet())
				logger.debug("\t" + o.toString() + " = " + properties.getProperty(o.toString()));
			
			is.close();
		}

		//
		
		Object instance = null;
		
		String implementation = properties.getProperty(interfaceClass.getName());
	    
		if(implementation==null)
			throw new InstantiationException(ImplementationFactory.class.getName() + 
											 ": No se encontro implementacion para la interfaz " + interfaceClass.getName() +
											 ". Verifique que se registro la implementacion de esta interfaz en el archivo " + fileName +
											 " y que este archivo se encuentre en el classpath.");

		logger.debug("Va a instanciar la implementacion " + implementation);
		

        if(singletonInstance)
        {
        	Class implementationClass = Class.forName(implementation);
        	try 
        	{
				Method m = implementationClass.getDeclaredMethod("getInstance", (Class[])null);
				instance = m.invoke(implementationClass, (Object[])null);
			} 
        	catch (Exception e)
			{
				throw new InstantiationException(ImplementationFactory.class.getName() + 
						 ": No se encontro el metodo getInstance para la implementacion " +
        				 " para la interfaz " + interfaceClass.getName() +
						 ". Verifique que se registro la implementacion de esta interfaz en el archivo " + fileName +
						 " y que este archivo se encuentre en el classpath.");
			}
        }
        else
        {
    		Class implementationClass = Class.forName(implementation);
            instance = implementationClass.newInstance(); 
        }
        
        return (T)instance;
	}
}