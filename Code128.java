package proyecto;

public class Code128
{
  private static int testNumeric(char[] text, int i, int mini)
  {
    mini--;
    if (i + mini < text.length)
      for (; mini >= 0; mini--)
        if ((text[i + mini] < 48) || (text[i + mini] > 57))
          break;
    return mini;
  }

  /**
   * Codificador de código de barras 128...</br>
   * Ejemplo: System.out.println(Code128.codeIt("Hola Mundo"));
   *
   * @param textToCode el texto que desea codificar
   * @return el texto codificado
   */
  public static String codeIt(String textToCode)
  {
    char[] text = textToCode.toCharArray();
    int checksum = 0; // caractere de v�rification�
    int mini; //nombre de caractères numéricos
    int char2; // tratamiento de 2 caracteres a la vez
    boolean tableB = true; // boolean para verificar si se debe usar la tabla B del código 128

    String code128 = "";

    for (char c : text)
      if ((c < 32) || (c > 126))
        return null;

    for (int i = 0; i < text.length;)
    {
      if (tableB)
      {
        // interesante pasar a la tabla C para 4 dígitos al principio o al final o para 6 dígitos
        mini = ((i == 0) || (i + 3 == text.length - 1) ? 4 : 6);

        // si los mini caracteres a partir de index son numéricos, entonces mini = 0
        mini = testNumeric(text, i, mini);

        // si mini < 0 pasamos a la tabla C
        if (mini < 0)
        {
          code128 += (char) (i == 0 ? 210 : 204); // comenzar en la tabla C o cambiar a la tabla C
          tableB = false;
        }
        else if (i == 0)
          code128 += (char) 209; // comenzar en la tabla B
      }

      if (!tableB)
      {
        // estamos en la tabla C, vamos a intentar procesar 2 dígitos
        mini = testNumeric(text, i, 2);

        if (mini < 0)
        {
          // ok para 2 dígitos, procesarlos
          char2 = Integer.parseInt("" + text[i] + text[i + 1]);
          char2 += (char2 < 95 ? 32 : 100);
          code128 += (char) char2;
          i += 2;
        }
        else
        {
          // estamos en la tabla C, vamos a intentar procesar 4 dígitos
          code128 += (char)205;
          tableB = true;
        }
      }
       if (tableB)
    	   code128 += text[i++];
    } 	
     
    for (int i = 0; i <code128.length(); i++)
    {
    	char2 = code128.charAt(i);
    	char2 -= (char2 < 127 ? 32 : 100);
    	checksum = ((i == 0 ? char2 : checksum) + i * char2) % 103;
       
    }
    
    checksum += (checksum < 95 ? 32 : 100);
    
   return code128 += ("" + (char) checksum + (char) 211);
  }


}