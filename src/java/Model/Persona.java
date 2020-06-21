/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Persona {
    private String dui_persona;
    private String apellidos_persona;
    private String nombre_persona;

    public Persona(){
        
    }

    public Persona(String dui_persona, String apellidos_persona, String nombre_persona) {
        this.dui_persona = dui_persona;
        this.apellidos_persona = apellidos_persona;
        this.nombre_persona = nombre_persona;
    }
    
    
    public String getDui_persona() {
        return dui_persona;
    }

    public void setDui_persona(String dui_persona) {
        this.dui_persona = dui_persona;
    }

    public String getApellidos_persona() {
        return apellidos_persona;
    }

    public void setApellidos_persona(String apellidos_persona) {
        this.apellidos_persona = apellidos_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
    
}
