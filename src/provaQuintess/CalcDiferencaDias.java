package provaQuintess;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalcDiferencaDias {
	
	public long calculaDiferencaDias(Date dataInicio, Date dataFim){
		
	    long diffInMillies = Math.abs(dataFim.getTime() - dataInicio.getTime());
	    long diferenca = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
	   return diferenca;
	}
	


	

}
