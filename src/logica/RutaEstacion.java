/**
 *
 * @author root
 */
public class RutaEstacion{
  String id_ruta;
  String id_estacion;

  public RutaEstacion(String id_r, String id_e){
    this.id_ruta = id_r;
    this.id_estacion = id_e;
  }

  public String getId_ruta(){
    return id_ruta;
  }

  public String getId_estacion(){
    return id_estacion;
  }
}
