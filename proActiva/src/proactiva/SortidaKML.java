package proactiva;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran Veciana
 */

public class SortidaKML {
    
    private PrintWriter fitxer;
    
    
    //MÈTODES
    
    public void definirEstils(){
        try{
            fitxer = new PrintWriter("fitxerKML.kml","UTF-8");
            fitxer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            fitxer.println("<kml xmlns=\"http://earth.google.com/kml/2.2\">");
            fitxer.println("    <Document>");
            fitxer.println("        <Style id=\"myDefaultStyles\">");
            fitxer.println("            <LineStyle>");
            fitxer.println("                <color>FF0000FF</color>");
            fitxer.println("                <width>3.0</width>");
            fitxer.println("            </LineStyle>");
            fitxer.println("            <IconStyle>");
            fitxer.println("                <scale>1.0</scale>");
            fitxer.println("                <Icon>");
            fitxer.println("                    <href>http://maps.google.com/mapfiles/kml/shapes/flag.png</href>");
            fitxer.println("                </Icon>");
            fitxer.println("                <hotSpot yunits=\"fraction\" y=\"0.0\" xunits=\"fraction\" x=\"0.45\"/>");
            fitxer.println("            </IconStyle>");
            fitxer.println("        </Style>");
        }
        catch(FileNotFoundException | UnsupportedEncodingException e){
            System.err.println("ERROR EN LA CREACIÓ DEL KML");
        }
    }
    
    public void pintarCircuit(List<String> coo){
        fitxer.println("<Placemark>");
        fitxer.println("    <name>Circuit</name>");
        fitxer.println("    <styleUrl>#myDefaultStyles</styleUrl>");
        fitxer.println("    <LineString>");
        fitxer.println("        <extrude>false</extrude>");
        fitxer.println("        <tessellate>true</tessellate>");
        fitxer.println("        <altitudeMode>clampToGround</altitudeMode>");
        fitxer.println("        <coordinates>");
        
        String delimitadors= ",";
        
        for(String c : coo){
            
            String[] coordenadesSeparades = c.split(delimitadors);
            
            fitxer.print(coordenadesSeparades[1]);
            fitxer.print(",");
            fitxer.print(coordenadesSeparades[0]);
            fitxer.println(",0.0");
        }
        
        fitxer.println("        </coordinates>");
        fitxer.println("    </LineString>");
        fitxer.println("</Placemark>");
    }
    
    public void pintarPunts(ArrayList<String> nom,ArrayList<String> coo){
        
        String delimitadors= ",";
        for(int i=0;i<nom.size();i++){
            String[] coordenadesSeparades = coo.get(i).split(delimitadors);
            fitxer.println("<Placemark>");
            fitxer.print("    <name>");
            fitxer.print(nom.get(i)); //nom del lloc
            fitxer.println("</name>");
            fitxer.println("    <styleUrl>#myDefaultStyles</styleUrl>");
            fitxer.println("    <Point>");
            fitxer.print("        <coordinates>");
            fitxer.print(coordenadesSeparades[1]);
            fitxer.print(",");
            fitxer.print(coordenadesSeparades[0]);
            fitxer.println(",0.0</coordinates>");
            fitxer.println("    </Point>");
            fitxer.println("</Placemark>");
        }
        fitxer.println("    </Document>");
        fitxer.println("</kml>");
        fitxer.close();
    }
   
}