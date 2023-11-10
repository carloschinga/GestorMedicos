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
public class FondoPensionJpaController {

    public List<FondoPension> findFondoPensionEntities() {
        FondoPension fp1= new FondoPension(1, "ONP",0.13,0,0);
        FondoPension fp2= new FondoPension(2, "PRIMA",0.15,0.02, 0.03);
        List<FondoPension> lista = new ArrayList<>();
        lista.add(fp1);
        lista.add(fp2);
        return lista;
    }
}
