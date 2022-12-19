package camel_case;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.IntFunction;

public class CamelCase {

	public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		if(string.matches(".*[^A-Za-z0-9].*"))
			throw new FormatacaoErrada("String tem caracteres não alfanuméricos");
		String[] palavras = separaMaiscula(string);
		for (String p : palavras)
		{
			l.add(formatarPalavra(p));
		}
		return l;
	}
	
	public boolean charETipo(String string, boolean isNumeric) {
		return (string.length() < 2) && (isNumeric == Character.isDigit(string.charAt(0)));
	}

	public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=[\\p{Lu}\\d])");
		List<String> subarray = new ArrayList<>();
		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() < 2)
			{
				boolean isNumeric = Character.isDigit(palavras[i].charAt(0));
				while((i < palavras.length-1) && charETipo(palavras[i+1],isNumeric))
				{
					palavras[i+1] = palavras[i] + palavras[i+1];
					i++;
				}
			}
			subarray.add(palavras[i]);
			
		}
		return subarray.toArray(new String[0]);
	}
	

	public String formatarPalavra(String string) {
		for(int i=0; i < string.length(); i++){
            
         if( !Character.isUpperCase( string.charAt(i)))
        	 return string.substring(0,1).toLowerCase() + string.substring(1);
        }
		return string;
	}

	
	 
}
