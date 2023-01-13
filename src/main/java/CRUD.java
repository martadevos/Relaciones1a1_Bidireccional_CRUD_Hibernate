import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class CRUD {

    private static SessionFactory sessionFactory;
    private static Session session;

    protected static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void open() {
        setUp();
        session = sessionFactory.openSession();
    }

    public static void close() {
        sessionFactory.close();
    }

    public static void create(int idAlumno1, int idAlumno2, String[] datos1, String[] datos2, int numCalle1, int numCalle2) {
        AlumnadoEntity alumno1 = new AlumnadoEntity(idAlumno1, datos1[0], datos1[1], datos1[2]);
        DireccionEntity direccion1 = new DireccionEntity(idAlumno1, datos1[3], numCalle1, datos1[4], datos1[5]);

        alumno1.setDireccion(direccion1);
        direccion1.setAlumnado(alumno1);
        Transaction transaction1 = session.beginTransaction();
        session.save(alumno1);
        transaction1.commit();

        AlumnadoEntity alumno2 = new AlumnadoEntity(idAlumno2, datos2[0], datos2[1], datos2[2]);
        DireccionEntity direccion2 = new DireccionEntity(idAlumno2, datos2[3], numCalle2, datos2[4], datos2[5]);

        alumno2.setDireccion(direccion2);
        direccion2.setAlumnado(alumno2);
        Transaction transaction2 = session.beginTransaction();
        session.save(direccion2);
        transaction2.commit();
    }

    /*public static void read(int id) {
        Transaction transaction = session.beginTransaction();
        AgendaEntity contacto = session.get(AgendaEntity.class, id);
        transaction.commit();
        System.out.println("Nombre: " + contacto.getNombre() + "    Telf: " + contacto.getTelf());
    }

    public static void update(int id, String nombre, String telf) {
        Transaction transaction = session.beginTransaction();
        AgendaEntity contacto = session.get(AgendaEntity.class, id);
        contacto.setNombre(nombre);
        contacto.setTelf(telf);
        AgendaEntity contactoActualizado = session.merge(contacto);
        transaction.commit();
        System.out.println("Nombre: " + contactoActualizado.getNombre() + "    Telf: " + contactoActualizado.getTelf());
    }

    public static void delete(int id) {
        Transaction transaction = session.beginTransaction();
        AgendaEntity contacto = session.get(AgendaEntity.class, id);
        session.remove(contacto);
        transaction.commit();
    }*/

    public static boolean menu(int resp) {
        Scanner s = new Scanner(System.in);
        boolean salir = false;
        switch (resp) {
            case 1 -> {
                String[] datos1 = new String[]{"nombreAlumno1", "apellido1Alumno1", "apellido2Alumno1", "calleAlumno1", "poblacionAlumno1", "provinciaAlumno1"};
                String[] datos2 = new String[]{"nombreAlumno2", "apellido1Alumno2", "apellido2Alumno2", "calleAlumno2", "poblacionAlumno2", "provinciaAlumno2"};
                int id1 = 1, id2 = 2, numCalle1 = 1, numCalle2 = 2;
                CRUD.create(id1, id2, datos1, datos2, numCalle1, numCalle2);
            }
            /*case 2 -> {
                int id;
                System.out.println("Introduce el id del contacto a buscar");
                id = s.nextInt();
                CRUD.read(id);
            }
            case 3 -> {
                int id;
                String nombre, telf;
                System.out.println("Introduce el id del contacto a cambiar");
                id = s.nextInt();
                System.out.println("Introduce el nombre nuevo para el contacto a cambiar");
                nombre = s.next();
                System.out.println("Introduce el telefono nuevo para el contacto a cambiar");
                telf = s.next();
                CRUD.update(id, nombre, telf);
            }
            case 4 -> {
                int id;
                System.out.println("Introduce el id del contacto a borrar");
                id = s.nextInt();
                CRUD.delete(id);
            }*/
            default -> salir = true;
        }
        return salir;
    }

}
