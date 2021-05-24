/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import domain.Prestamo;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrestamoDAOTest {
    
    public PrestamoDAOTest() {
    }

    @Test
    public void testGuardadoExitoso() {
        System.out.println("guardadoExitoso");
        //String idPrestamista, String nombrePrestamista, String fecha, String motivo, String lugar, String hora
        Prestamo prestamo = new Prestamo("S19014023", "Karina Valdes Iglesias", "21/05/2021", "Clase de matemicaticas discretas", "Salon 104","11:30");
        PrestamoDAO instance = new PrestamoDAO();
        boolean expResult = true;
        boolean result = instance.guardadoExitoso(prestamo);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRecuperar(){    
        PrestamoDAO instance = new PrestamoDAO();
        ArrayList<Prestamo> prestamos = instance.getPrestamos();
    
        assertFalse(prestamos.isEmpty());
    }
    
}
