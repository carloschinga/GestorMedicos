package exportar;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USUARIO
 */
public class TrabajadorJpaController {

    public List<Trabajador> findTrabajadorEntities() {
        Trabajador t1 = new Trabajador(1, 1, "40801418", "CHINGA", "RAMOS", "CARLOS ENRIQUE", 1000, 1);
        Trabajador t2 = new Trabajador(2, 1, "12345678", "ROLDAN", "MELENDEZ", "MARIA", 200, 1);
        List<Trabajador> lista = new ArrayList<>();
        lista.add(t1);
        lista.add(t2);
        return lista;
    }
}
