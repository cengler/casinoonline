package apuestas.csv;

import java.io.File;
import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class CsvParser {

	
	public static void main(String[] args) {
		try {
			leer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leer() throws Exception
	{
		CSVReader reader = new CSVReader(new FileReader(new File("I:/- 21-07-08/TPPP/Tp3/codigo/test/apuestas/csv/ldp.csv")));
		
		//while
		String[] apu = reader.readNext();
		
		for (String s : apu)
			System.out.println(s.trim());
	}
	
	public static void leer2() throws Exception
	{
		
		/*
		 * CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
    String [] nextLine;
    while ((nextLine = reader.readNext()) != null) {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
    }
		 */
	    //FwkFileUploadServletReponse response = new FwkFileUploadServletReponse();               
	    ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
	    //strat.setType( Entry<ResultadoApuestaCraps, String> );   
	    /*String[] columns = new String[]{REGION, SUB_ALM, DESC_SUB_ALM, }; 
	    strat.setColumnMapping(columns);
	    CsvToBean csv = new CsvToBean();
	    List<AdnTmpProyeccionesVenta> tmpProyecciones = (List<AdnTmpProyeccionesVenta>)csv.parse(strat, reader);
	    response.setContentType("text/xml");
	    response.setContent(tmpProyeccionesToXML(tmpProyecciones).getBytes());*/

	}
}
