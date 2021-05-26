/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import domain.Cable;
import domain.Conector;
import domain.ControlProyector;
import domain.Laptop;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public interface IDispositivoDAO {
    public ArrayList<Cable> getCables();
    public ArrayList<Conector> getConectores();
    public ArrayList<ControlProyector> getControlesProyectores();
    public ArrayList<Laptop> getLaptops();
}
