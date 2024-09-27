package proyecto;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    
	@Override
    public void write(int b) throws IOException {
        // Escribir el byte en el JTextArea
        textArea.append(String.valueOf((char)b));
        // Desplazar el cursor al final del JTextArea
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}