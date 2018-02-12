package org.genericenumtask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Level highLevel = (Level) ApplicationEnum.getInstance(Level.class, "High");
        System.out.println(highLevel.getValue());
        DocumentType documentType = (DocumentType) ApplicationEnum.getInstance(DocumentType.class, "text");
        System.out.println(documentType.getValue());
    }
}
