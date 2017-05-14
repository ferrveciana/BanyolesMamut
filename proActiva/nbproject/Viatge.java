package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viatge {

  private ArrayList<String> clients;
  private ArrayList<String> rutes;
  private LocalDate dataInici;
  private LocalTime horaInici;
  private int nombreDies;
  private float preuMaxim;
  private String categoria;
  
  
  public Viatge (LocalDate _dataInici, LocalTime _horaInici, int _nombreDies, float _preuMaxim, String _categoria, ArrayList<String> _clients, ArrayList<String> _rutes) {
        
      dataInici = _dataInici;
      horaInici = _horaInici;
      nombreDies = _nombreDies;
      preuMaxim = _preuMaxim;
      categoria = _categoria;
      clients = _clients;
      rutes = _rutes;
  }
}


