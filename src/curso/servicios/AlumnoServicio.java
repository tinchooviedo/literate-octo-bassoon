package curso.servicios;

import curso.entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AlumnoServicio {

    public void crearAlumno(Integer documento, String nombre, String apellido, Integer edad) {

        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        em.getTransaction().begin();

        Alumno alumno = new Alumno();

        alumno.setDocumento(documento);

        alumno.setNombre(nombre);

        alumno.setApellido(apellido);

        alumno.setEdad(edad);

        em.persist(alumno);
        em.getTransaction().commit();

    }

    public void editarAlumno(Integer documento, String nombre) {

        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        em.getTransaction().begin();

        Alumno alumno = em.find(Alumno.class,documento);

        alumno.setNombre(nombre);

        em.merge(alumno);
        em.getTransaction().commit();

    }

    public void eliminarAlumno(Integer documento) {

        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        em.getTransaction().begin();

        Alumno alumno = em.find(Alumno.class,
                 documento);

        em.remove(alumno);
        em.getTransaction().commit();

    }

    public List<Alumno> buscarAlumnosNombre(String nombre) {
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();

        List<Alumno> alumnos = em.createQuery("SELECT c FROM Alumno c WHERE c.nombre LIKE :nombre")
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();

        return alumnos;
    }

    public List<Alumno> buscarAlumnosEdad(Integer edad) {
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();

        List<Alumno> alumnos = em.createQuery("SELECT c FROM Alumno c WHERE c.edad LIKE :edad")
                .setParameter("edad", edad)
                .getResultList();

        return alumnos;
    }

    public void imprimirAlumnos(String nombre) {

        List<Alumno> alumnos = buscarAlumnosNombre(nombre);

        for (Alumno alumno : alumnos) {

            System.out.println(alumno);

        }

    }

    public void imprimirAlumnosEdad(Integer edad) {

        List<Alumno> alumnos = buscarAlumnosEdad(edad);

        for (Alumno alumno : alumnos) {

            System.out.println(alumno);

        }

    }
}
