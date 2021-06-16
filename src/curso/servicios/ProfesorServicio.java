package curso.servicios;

import curso.entidades.Profesor;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class ProfesorServicio  {
    
    public void crearProfesor(Integer documento, String nombre, String apellido,
            Integer telefono, Integer sueldo){
        
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        em.getTransaction().begin();
        
        Profesor profesor = new Profesor();
        
        profesor.setDocumento(documento);
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setTelefono(telefono);
        profesor.setSueldo(sueldo);
        
        em.persist(profesor);
        em.getTransaction().commit();
        
        
    }
    
    

}
