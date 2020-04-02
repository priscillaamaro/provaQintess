package provaQuintess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//Classe pra calculo do tempo de processamento.

public class TempoDeProcessamento {
	
	public static void main(String[] args) throws ParseException {
		
		long tempoInicial = System.currentTimeMillis();
		
		
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial) );
	}

}
