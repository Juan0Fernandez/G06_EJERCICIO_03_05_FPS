
package controlador;

import java.util.ArrayList;
import modelo.Universidad;
import servicio.UniversidadServiceImpl;

public class ControladorUniversidad {
    private UniversidadServiceImpl uniServiceImpl = new UniversidadServiceImpl();
    
    private boolean validarTelefono(String tlf){
        if(tlf.length()==0)
            return false;
        for(int i=0;i<tlf.length();i++){
            if(tlf.charAt(i)>'9' || tlf.charAt(i)<'0' ){
                System.err.println("Numero invalido");
                return false;
            }
        }
        return true;
    }
    
    private boolean validarInfo(String nom, String dir, String ciudad, String tipo){
        if(nom.length()==0 || dir.length()==0 || ciudad.length()==0 || tipo.length()==0){
            return false;
        }
        return true;
    }
    
    public boolean anadirUniversidad(String nomb, String cuidad, String tlf, String dir, String tipo){
        if(validarTelefono(tlf) && validarInfo(nomb, dir, cuidad, tipo) ){
            uniServiceImpl.anadirUniversidad(new Universidad(nomb, cuidad, tlf, dir, tipo));
            return true;
        }else{
            System.err.println("Datos mal ingresados");
            return false;
        }
        
    }
    
    public void borrarUniversidad(int i){
        uniServiceImpl.borrarUniversidad(i);
    }
    
    public ArrayList<Universidad> getLista(){
        return uniServiceImpl.getLista();
    }
    
    public boolean modificarUniversidad(int i, String nomb, String cuidad, String tlf, String dir, String tipo) {
        if(validarTelefono(tlf) && validarInfo(nomb, dir, cuidad, tipo) ){
            uniServiceImpl.modificarUniversidad(i,new Universidad(nomb, cuidad, tlf, dir, tipo));
            return true;
        }else{
            System.err.println("Datos mal ingresados");
            return false;
        }
        
    }
    
}
