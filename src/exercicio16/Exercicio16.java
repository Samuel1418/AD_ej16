/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio16;
import exercicio13.Exercicio13;
import exercicio13.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Exercicio16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, XMLStreamException, ClassNotFoundException {
        //Para leer el archivo
        FileInputStream leer2 = new FileInputStream("/home/oracle/Desktop/ProbaExer4/exerc13.txt");
        ObjectInputStream escribir2 = new ObjectInputStream(leer2);
        
        //creamos el archivo en donde se va guardar
        File fil= new File("/home/oracle/Desktop/ProbaExer4/products.xml");
	FileWriter escribir = new FileWriter(fil);
        
        //Para escribir el xml damos el archivo escribir de arriba
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(escribir); 
        
        //Creamos objeto 
         Product obj = (Product) escribir2.readObject(); //Para que lea los datos
         
	
        
        writer.writeStartDocument("1.0");
        writer.writeStartElement("Productos");
        while(obj!=null){
        writer.writeStartElement("Producto");
        writer.writeStartElement("codigo");
        writer.writeCharacters(obj.getCod());
        writer.writeEndElement();
        writer.writeStartElement("Descripcion");
        writer.writeCharacters(obj.getDesc());
        writer.writeEndElement();
        writer.writeStartElement("Prezo");
        writer.writeCharacters(Double.toString(obj.getPrezo()));
        writer.writeEndElement();
        writer.writeEndElement();
        obj = (Product) escribir2.readObject(); //Para que vaya leyendo a medida
        }
        writer.writeEndElement(); 
        writer.writeEndDocument(); 
        escribir2.close();
        writer.close();
    
    }
    
}
