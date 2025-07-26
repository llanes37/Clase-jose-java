import java.util.*;
import java.time.LocalDate;

/******************************************************************************************
 *                           🎓 UT05: DESARROLLO AVANZADO DE CLASES – R.A. 7
 *             Curso 2024/2025 – Programación – 1º DAW (Herencia, Polimorfismo, 
 *                     Manejo de Excepciones y Métodos Default en Interfaces)
 *
 * TEORÍA:  
 * Este archivo integra varios ejercicios avanzados de POO:
 *   1. Clínica Veterinaria: Gestión de animales usando herencia y polimorfismo.
 *   2. Tienda de Productos: Productos perecederos y no perecederos con excepciones personalizadas.
 *   3. Gestión de Personal: Personal de centro (profesores, alumnos y conserjes) con métodos
 *      abstractos.
 *   4. Manejo de Excepciones: Ejercicios para capturar y gestionar errores.
 *   5. Métodos Default en Interfaces: Uso de métodos default y static.
 *
 * Cada sección contiene además TAREAS para que el alumno realice modificaciones o extienda
 * la funcionalidad.
 ******************************************************************************************/

public class UT3_POO_PracticaAvanzadaClases {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Bucle principal del menú
            System.out.println("\n========================================");
            System.out.println("   MENÚ DE EJERCICIOS - DESARROLLO AVANZADO");
            System.out.println("========================================");
            System.out.println("1. Clínica Veterinaria");
            System.out.println("2. Tienda de Productos");
            System.out.println("3. Gestión de Personal");
            System.out.println("4. Manejo de Excepciones");
            System.out.println("5. Métodos Default en Interfaces");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = readInt(scanner);
            System.out.println();
            switch (opcion) {
                case 1:
                    demoClinicaVeterinaria(scanner);
                    break;
                case 2:
                    demoTiendaProductos(scanner);
                    break;
                case 3:
                    demoGestionPersonal(scanner);
                    break;
                case 4:
                    demoManejoExcepciones(scanner);
                    break;
                case 5:
                    demoMetodosDefaultInterfaces(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
    
    // ---------------------------------------------------------------
    // Método auxiliar: readInt
    // ---------------------------------------------------------------
    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                // Intenta leer y retornar un entero ingresado por el usuario
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("❌ Entrada inválida, por favor ingrese un número entero.");
                scanner.next(); // Descarta la entrada incorrecta
            }
        }
    }
    
    // ?==============================================================
    // ? SECCIÓN 1: CLÍNICA VETERINARIA
    // ?==============================================================
    /*
     * En esta sección se gestionan animales de una clínica veterinaria.
     * Se utilizan clases abstractas y concretas (Perro, Gato, Pajaro, Reptil) para modelar
     * distintos tipos de animales, y la clase ClinicaVeterinaria para gestionar una lista de ellos.
     *
     * TAREAS:
     * - Agregar una nueva clase, por ejemplo, "Conejo" que herede de Animal.
     * - Añadir un método en ClinicaVeterinaria para eliminar un animal por nombre.
     * - Modificar el método toString de ClinicaVeterinaria para mostrar solo animales de un
     *   determinado tipo (por ejemplo, todos los perros).
     */
    public static void demoClinicaVeterinaria(Scanner scanner) {
        System.out.println("=== Clínica Veterinaria ===");
        // Se crea un objeto de la clínica que almacenará animales
        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
        
        // Crear animales de prueba con datos de ejemplo
        Perro perro = new Perro("Luna", RazaPerro.PASTOR_ALEMAN, LocalDate.of(2003, 2, 12), 12.4, "38479382749DF39");
        perro.setComentarios("Está pachucho.");
        Gato gato = new Gato("Michi", RazaGato.COMUN, LocalDate.of(2015, 5, 10), 4.5, "MICRO12345");
        gato.setComentarios("Muy juguetón.");
        Pajaro pajaro = new Pajaro("Piolín", EspeciePajaro.CANARIO, LocalDate.of(2018, 3, 20), 0.2, true);
        pajaro.setComentarios("Canta muy bien.");
        Reptil reptil = new Reptil("Rex", EspecieReptil.TORTUGA, LocalDate.of(2010, 7, 15), 3.0, false);
        reptil.setComentarios("Lento pero seguro.");
        
        // Insertar animales en la clínica
        clinica.insertaAnimal(perro);
        clinica.insertaAnimal(gato);
        clinica.insertaAnimal(pajaro);
        clinica.insertaAnimal(reptil);
        
        // Mostrar la lista de animales registrados
        System.out.println(clinica);
        
        // Buscar un animal por nombre
        System.out.print("Ingrese el nombre del animal a buscar: ");
        String nombreBusqueda = scanner.next();
        Animal encontrado = clinica.buscaAnimal(nombreBusqueda);
        if (encontrado != null) {
            System.out.println("Animal encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("❌ No se encontró un animal con ese nombre.");
        }
        
        // Modificar el comentario de un animal
        System.out.print("Ingrese el nombre del animal para modificar comentario: ");
        String nombreMod = scanner.next();
        System.out.print("Ingrese el nuevo comentario: ");
        String nuevoComentario = scanner.next();
        clinica.modificaComentarioAnimal(nombreMod, nuevoComentario);
        System.out.println("Lista actualizada de animales:");
        System.out.println(clinica);
    }
    
    // --- Clases y Enumerados para Clínica Veterinaria ---
    
    // Clase abstracta Animal (atributos comunes a todos los animales)
    public static abstract class Animal {
        private String nombre;
        private LocalDate fechaNacimiento;
        private double peso;
        private String comentarios;
        
        public Animal(String nombre, LocalDate fechaNacimiento, double peso) {
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
            this.peso = peso;
            this.comentarios = "";
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }
        
        public double getPeso() {
            return peso;
        }
        
        public void setPeso(double peso) {
            this.peso = peso;
        }
        
        public String getComentarios() {
            return comentarios;
        }
        
        public void setComentarios(String comentarios) {
            this.comentarios = comentarios;
        }
        
        @Override
        public String toString() {
            return "Nombre: " + nombre + "\nFecha de Nacimiento: " + fechaNacimiento +
                   "\nPeso: " + peso + " kg\nComentarios: " + comentarios;
        }
    }
    
    // Enum para razas de perro
    public enum RazaPerro {
        PASTOR_ALEMAN, HUSKY, FOX_TERRIER, DALMATA, SAN_BERNARDO
    }
    
    // Clase Perro (hereda de Animal)
    public static class Perro extends Animal {
        private RazaPerro raza;
        private String microchip;
        
        public Perro(String nombre, RazaPerro raza, LocalDate fechaNacimiento, double peso, String microchip) {
            super(nombre, fechaNacimiento, peso);
            this.raza = raza;
            this.microchip = microchip;
        }
        
        public RazaPerro getRaza() {
            return raza;
        }
        
        public String getMicrochip() {
            return microchip;
        }
        
        @Override
        public String toString() {
            return "Ficha de Perro:\n" + super.toString() + "\nRaza: " + raza +
                   "\nMicrochip: " + microchip;
        }
    }
    
    // Enum para razas de gato
    public enum RazaGato {
        COMUN, SIAMES, PERSA, ANGORA, SCOTTISH_FOLD
    }
    
    // Clase Gato (hereda de Animal)
    public static class Gato extends Animal {
        private RazaGato raza;
        private String microchip;
        
        public Gato(String nombre, RazaGato raza, LocalDate fechaNacimiento, double peso, String microchip) {
            super(nombre, fechaNacimiento, peso);
            this.raza = raza;
            this.microchip = microchip;
        }
        
        public RazaGato getRaza() {
            return raza;
        }
        
        public String getMicrochip() {
            return microchip;
        }
        
        @Override
        public String toString() {
            return "Ficha de Gato:\n" + super.toString() + "\nRaza: " + raza +
                   "\nMicrochip: " + microchip;
        }
    }
    
    // Enum para especies de pájaro
    public enum EspeciePajaro {
        CANARIO, PERIQUITO, AGAPORNIS
    }
    
    // Clase Pajaro (hereda de Animal)
    public static class Pajaro extends Animal {
        private EspeciePajaro especie;
        private boolean cantor;
        
        public Pajaro(String nombre, EspeciePajaro especie, LocalDate fechaNacimiento, double peso, boolean cantor) {
            super(nombre, fechaNacimiento, peso);
            this.especie = especie;
            this.cantor = cantor;
        }
        
        public EspeciePajaro getEspecie() {
            return especie;
        }
        
        public boolean isCantor() {
            return cantor;
        }
        
        @Override
        public String toString() {
            return "Ficha de Pájaro:\n" + super.toString() + "\nEspecie: " + especie +
                   "\nCantor: " + (cantor ? "Sí" : "No");
        }
    }
    
    // Enum para especies de reptil
    public enum EspecieReptil {
        TORTUGA, IGUANA, DRAGON_DE_COMODO
    }
    
    // Clase Reptil (hereda de Animal)
    public static class Reptil extends Animal {
        private EspecieReptil especie;
        private boolean venenoso;
        
        public Reptil(String nombre, EspecieReptil especie, LocalDate fechaNacimiento, double peso, boolean venenoso) {
            super(nombre, fechaNacimiento, peso);
            this.especie = especie;
            this.venenoso = venenoso;
        }
        
        public EspecieReptil getEspecie() {
            return especie;
        }
        
        public boolean isVenenoso() {
            return venenoso;
        }
        
        @Override
        public String toString() {
            return "Ficha de Reptil:\n" + super.toString() + "\nEspecie: " + especie +
                   "\nVenenoso: " + (venenoso ? "Sí" : "No");
        }
    }
    
    // Clase ClinicaVeterinaria (gestiona una lista de animales)
    public static class ClinicaVeterinaria {
        private ArrayList<Animal> listaAnimales;
        
        public ClinicaVeterinaria() {
            listaAnimales = new ArrayList<>();
        }
        
        public void insertaAnimal(Animal a) {
            listaAnimales.add(a);
        }
        
        public Animal buscaAnimal(String nombre) {
            for (Animal a : listaAnimales) {
                if (a.getNombre().equalsIgnoreCase(nombre)) {
                    return a;
                }
            }
            return null;
        }
        
        public void modificaComentarioAnimal(String nombre, String nuevoComentario) {
            Animal a = buscaAnimal(nombre);
            if (a != null) {
                a.setComentarios(nuevoComentario);
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Animal a : listaAnimales) {
                sb.append(a.toString()).append("\n--------------------\n");
            }
            return sb.toString();
        }
    }
    
    // ?==============================================================
    // ? SECCIÓN 2: TIENDA DE PRODUCTOS
    // ?==============================================================
    /*
     * En esta sección se gestionan productos de una tienda.
     * Se definen productos perecederos y no perecederos (heredan de Producto) y se agrupan en un Carrito.
     *
     * TAREAS:
     * - Implementar una nueva clase "ProductoDigital" que herede de Producto.
     * - Permitir que el método calcularImporte acepte cualquier cantidad (no fija).
     * - Añadir un método en Carrito para buscar productos por nombre.
     */
    public static void demoTiendaProductos(Scanner scanner) {
        System.out.println("=== Tienda de Productos ===");
        // Se crea un carrito para agregar productos
        Carrito carrito = new Carrito();
        
        // Crear productos perecederos de ejemplo
        ProductoPerecedero p1 = new ProductoPerecedero("Leche", 1.0, LocalDate.of(2024, 3, 1), 2);
        ProductoPerecedero p2 = new ProductoPerecedero("Pan", 0.5, LocalDate.of(2024, 3, 2), 1);
        ProductoPerecedero p3 = new ProductoPerecedero("Yogur", 0.8, LocalDate.of(2024, 3, 1), 3);
        
        // Crear productos no perecederos de ejemplo
        ProductoNoPerecedero np1 = new ProductoNoPerecedero("Jabón", 2.5, "Limpieza");
        ProductoNoPerecedero np2 = new ProductoNoPerecedero("Champú", 4.0, "Higiene");
        ProductoNoPerecedero np3 = new ProductoNoPerecedero("Perfume", 15.0, "Perfumería");
        
        // Insertar productos en el carrito
        carrito.insertaProducto(p1);
        carrito.insertaProducto(p2);
        carrito.insertaProducto(p3);
        carrito.insertaProducto(np1);
        carrito.insertaProducto(np2);
        carrito.insertaProducto(np3);
        
        // Mostrar la información de cada producto y calcular el importe total para 3 unidades de cada
        System.out.println(carrito);
    }
    
    // --- Clases y Excepción para Tienda de Productos ---
    
    // Clase Producto (superclase para productos)
    public static class Producto {
        protected String nombre;
        protected double precio;
        
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        
        // Calcula el importe (precio * cantidad); lanza excepción si la cantidad es 0 o negativa
        public double calcularImporte(int cantidad) throws CantidadInsuficienteException {
            if (cantidad <= 0) {
                throw new CantidadInsuficienteException("Cantidad insuficiente", cantidad);
            }
            return precio * cantidad;
        }
        
        @Override
        public String toString() {
            return "Producto: " + nombre + " - Precio: " + precio;
        }
    }
    
    // Clase ProductoPerecedero (con fecha de envasado y días para caducar)
    public static class ProductoPerecedero extends Producto {
        private LocalDate fechaEnvasado;
        private int diasCaducar;
        
        public ProductoPerecedero(String nombre, double precio, LocalDate fechaEnvasado, int diasCaducar) {
            super(nombre, precio);
            this.fechaEnvasado = fechaEnvasado;
            this.diasCaducar = diasCaducar;
        }
        
        @Override
        public double calcularImporte(int cantidad) throws CantidadInsuficienteException {
            double importe = super.calcularImporte(cantidad);
            // Ajuste de precio según días para caducar:
            // Si queda 1 día o menos, reduce 75%; 2 días, reduce 50%; 3 días, reduce 25%
            if (diasCaducar <= 1) {
                importe *= 0.25;
            } else if (diasCaducar == 2) {
                importe *= 0.5;
            } else if (diasCaducar == 3) {
                importe *= 0.75;
            }
            return importe;
        }
        
        @Override
        public String toString() {
            LocalDate fechaCaducidad = fechaEnvasado.plusDays(diasCaducar);
            return super.toString() + " (Perecedero) - Envasado: " + fechaEnvasado + " - Caduca: " + fechaCaducidad;
        }
    }
    
    // Clase ProductoNoPerecedero (con atributo tipo)
    public static class ProductoNoPerecedero extends Producto {
        private String tipo;
        
        public ProductoNoPerecedero(String nombre, double precio, String tipo) {
            super(nombre, precio);
            this.tipo = tipo;
        }
        
        @Override
        public String toString() {
            return super.toString() + " (No Perecedero) - Tipo: " + tipo;
        }
    }
    
    // Clase Carrito (gestiona una lista de productos)
    public static class Carrito {
        private ArrayList<Producto> productos;
        
        public Carrito() {
            productos = new ArrayList<>();
        }
        
        public void insertaProducto(Producto p) {
            productos.add(p);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            double total = 0;
            for (Producto p : productos) {
                sb.append(p.toString()).append("\n");
                try {
                    total += p.calcularImporte(3); // Se usa cantidad fija de 3 para cada producto
                } catch (CantidadInsuficienteException ex) {
                    sb.append("Error: ").append(ex.getMessage()).append("\n");
                }
            }
            sb.append("Importe total del carrito (3 unidades cada): ").append(total);
            return sb.toString();
        }
    }
    
    // Excepción personalizada para cantidad insuficiente
    public static class CantidadInsuficienteException extends Exception {
        private int cantidad;
        
        public CantidadInsuficienteException(String message, int cantidad) {
            super(message);
            this.cantidad = cantidad;
        }
        
        public int getCantidad() {
            return cantidad;
        }
    }
    
    // ?==============================================================
    // ? SECCIÓN 3: GESTIÓN DE PERSONAL
    // ?==============================================================
    /*
     * En esta sección se modela el personal de un centro educativo.
     * Se define una clase abstracta Personal y sus subclases: Profesor, Alumno y Conserje.
     *
     * TAREAS:
     * - Agregar una nueva subclase de Personal, por ejemplo, "Administrativo", con sus atributos.
     * - Implementar un método para actualizar el email y verificar su formato.
     * - Extender el método notificar para incluir nuevos medios (SMS, push, etc.).
     */
    public static void demoGestionPersonal(Scanner scanner) {
        System.out.println("=== Gestión de Personal ===");
        // Se crea una lista para almacenar distintos tipos de personal
        ArrayList<Personal> lista = new ArrayList<>();
        
        // Crear un profesor con datos de ejemplo
        Profesor profesor = new Profesor("Carlos", 40, "carlos@centro.edu", 2000.0, 0.15, "600111222", 3);
        // Crear un alumno asignándole al profesor como tutor
        Alumno alumno = new Alumno("Ana", 18, "ana@alumno.edu", "1º DAW", 8.5, profesor);
        // Crear un conserje con datos de ejemplo
        Conserje conserje = new Conserje("Luis", 55, "luis@centro.edu", 12, "Calle Falsa 123");
        
        lista.add(profesor);
        lista.add(alumno);
        lista.add(conserje);
        
        // Mostrar la ficha de cada personal y enviar una notificación
        for (Personal p : lista) {
            System.out.println(p.ficha());
            System.out.println(p.notificar("El último día de clase es el 20 de junio."));
            // Mostrar información adicional según el tipo de personal
            if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                System.out.println("Salario neto: " + prof.calcularSalario());
            } else if (p instanceof Alumno) {
                Alumno al = (Alumno) p;
                System.out.println("Nota media: " + al.getNotaMedia());
            } else if (p instanceof Conserje) {
                Conserje con = (Conserje) p;
                System.out.println("Días de vacaciones: " + con.vacaciones());
            }
            System.out.println("-----------------------------------");
        }
    }
    
    // --- Clases para Gestión de Personal ---
    
    // Clase abstracta Personal (atributos comunes: nombre, edad y email)
    public static abstract class Personal {
        protected String nombre;
        protected int edad;
        protected String email;
        
        public Personal(String nombre, int edad, String email) {
            this.nombre = nombre;
            this.edad = edad;
            this.email = email;
        }
        
        // Método abstracto para mostrar la ficha del personal
        public abstract String ficha();
        // Método abstracto para notificar un mensaje
        public abstract String notificar(String mensaje);
    }
    
    // Clase Profesor (extiende Personal) con atributos adicionales
    public static class Profesor extends Personal {
        private double salarioBase;
        private double retencion;
        private String telefono;
        private int trienios;
        
        public Profesor(String nombre, int edad, String email, double salarioBase, double retencion, String telefono, int trienios) {
            super(nombre, edad, email);
            this.salarioBase = salarioBase;
            this.retencion = retencion;
            this.telefono = telefono;
            this.trienios = trienios;
        }
        
        // Calcula el salario neto: suma complementos por trienios y aplica retención
        public double calcularSalario() {
            double complemento = trienios * 30.5;
            double salarioBruto = salarioBase + complemento;
            return salarioBruto * (1 - retencion);
        }
        
        @Override
        public String ficha() {
            return "Profesor: " + nombre + "\nEdad: " + edad + "\nEmail: " + email +
                   "\nTeléfono: " + telefono + "\nTrienios: " + trienios;
        }
        
        @Override
        public String notificar(String mensaje) {
            return "Notificar " + mensaje + " al número de teléfono " + telefono;
        }
    }
    
    // Clase Alumno (extiende Personal) con atributos adicionales
    public static class Alumno extends Personal {
        private String curso;
        private double notaMedia;
        private Profesor tutor;
        
        public Alumno(String nombre, int edad, String email, String curso, double notaMedia, Profesor tutor) {
            super(nombre, edad, email);
            this.curso = curso;
            this.notaMedia = notaMedia;
            this.tutor = tutor;
        }
        
        public double getNotaMedia() {
            return notaMedia;
        }
        
        @Override
        public String ficha() {
            return "Alumno: " + nombre + "\nEdad: " + edad + "\nEmail: " + email +
                   "\nCurso: " + curso + "\nTutor: " + tutor.nombre + "\nNota Media: " + notaMedia;
        }
        
        @Override
        public String notificar(String mensaje) {
            return "Notificar " + mensaje + " al número de email " + email;
        }
    }
    
    // Clase Conserje (extiende Personal) con atributos adicionales
    public static class Conserje extends Personal {
        private int antiguedad;
        private String direccion;
        
        public Conserje(String nombre, int edad, String email, int antiguedad, String direccion) {
            super(nombre, edad, email);
            this.antiguedad = antiguedad;
            this.direccion = direccion;
        }
        
        // Devuelve los días de vacaciones según la antigüedad:
        // - Menos de 3 años: 20 días
        // - Entre 4 y 10 años: 25 días
        // - Más de 10 años: 30 días
        public int vacaciones() {
            if (antiguedad < 3) {
                return 20;
            } else if (antiguedad <= 10) {
                return 25;
            } else {
                return 30;
            }
        }
        
        @Override
        public String ficha() {
            return "Conserje: " + nombre + "\nEdad: " + edad + "\nEmail: " + email +
                   "\nAntigüedad: " + antiguedad + " años\nDirección: " + direccion;
        }
        
        @Override
        public String notificar(String mensaje) {
            return "Notificar " + mensaje + " a la dirección " + direccion;
        }
    }
    
    // ?==============================================================
    // ? SECCIÓN 4: MANEJO DE EXCEPCIONES
    // ?==============================================================
    /*
     * En esta sección se practican conceptos de manejo de excepciones.
     * Se ejemplifica el uso de try-catch-finally y se muestra el funcionamiento de una excepción
     * personalizada (CantidadInsuficienteException) en el contexto de productos.
     *
     * TAREAS:
     * - Mejorar el juego "Adivina el número" para registrar además el tiempo transcurrido.
     * - Crear una nueva excepción personalizada para otro método y probarla.
     */
    public static void demoManejoExcepciones(Scanner scanner) {
        System.out.println("=== Manejo de Excepciones ===");
        // Ejercicio 1: Mostrar la salida del ejemplo de excepciones
        System.out.println("Salida de EjemploExcepciones: " + EjemploExcepciones.devuelveNumero(1));
        
        // Ejercicio 2: Generar un número aleatorio e indicar si es par o impar mediante excepción
        int num = new Random().nextInt(100);
        try {
            if (num % 2 == 0) {
                throw new Exception("El número " + num + " es par.");
            } else {
                throw new Exception("El número " + num + " es impar.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Ejercicio 3: Adivina el número (versión simplificada)
        int numeroSecreto = new Random().nextInt(500) + 1;
        int intentos = 0, guess = 0;
        System.out.println("Adivina el número (entre 1 y 500): ");
        while (guess != numeroSecreto) {
            try {
                guess = readInt(scanner);
                intentos++;
                if (guess < numeroSecreto) {
                    System.out.println("El número es mayor.");
                } else if (guess > numeroSecreto) {
                    System.out.println("El número es menor.");
                } else {
                    System.out.println("¡Correcto! Número de intentos: " + intentos);
                }
            } catch (Exception ex) {
                System.out.println("Error: ingrese un número válido.");
                scanner.next(); // Descarta la entrada errónea
                intentos++;
            }
        }
    }
    
    // --- Clase de Ejemplo para Manejo de Excepciones ---
    public static class EjemploExcepciones {
        public static int devuelveNumero(int num) {
            try {
                if (num % 2 == 0) {
                    throw new Exception("Lanzando excepción");
                }
                return 1;
            } catch (Exception ex) {
                return 2;
            } finally {
                // El bloque finally se ejecuta siempre, incluso si se retorna un valor
                return 3;
            }
        }
    }
    
    // ?==============================================================
    // ? SECCIÓN 5: MÉTODOS DEFAULT EN INTERFACES
    // ?==============================================================
    /*
     * En esta sección se demuestra el uso de métodos default y static en interfaces.
     * La interfaz Comercio define constantes y métodos abstractos, default y static. Se utiliza
     * en la clase Publicacion y su subclase Libro.
     *
     * TAREAS:
     * - Crear una nueva clase "Revista" que extienda Publicacion y modifique la descripción.
     * - Añadir un nuevo método default en Comercio, por ejemplo, para un mensaje promocional.
     */
    public static void demoMetodosDefaultInterfaces(Scanner scanner) {
        System.out.println("=== Métodos Default en Interfaces ===");
        // Crear un objeto Libro de ejemplo
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 20.0, 5.0);
        System.out.println("Precio final del libro: " + libro.precioFinal());
        System.out.println("Descripción: " + libro.descripcion());
        System.out.println("Oferta: " + libro.oferta("Descuento especial"));
        // Uso del método static de la interfaz Comercio
        System.out.println("Precio con IVA aplicado a 20.0: " + Comercio.precioConIva(20.0));
    }
    
    // --- Clases para Métodos Default en Interfaces ---
    
    // Interfaz Comercio: define constantes, métodos abstractos, default y static
    public interface Comercio {
        double IVA = 0.21;
        
        // Método abstracto que debe calcular el precio final
        double precioFinal();
        
        // Método default que devuelve una oferta con el texto proporcionado
        default String oferta(String textoOferta) {
            return "Oferta del día: " + textoOferta;
        }
        
        // Método default que devuelve una descripción básica
        default String descripcion() {
            return "Producto en tienda";
        }
        
        // Método static para calcular el precio con IVA
        static double precioConIva(double precioBase) {
            return precioBase + (precioBase * IVA);
        }
    }
    
    // Clase Publicacion (abstracta) que implementa Comercio
    public static abstract class Publicacion implements Comercio {
        protected String titulo;
        protected String autor;
        protected double precioBase;
        
        public Publicacion(String titulo, String autor, double precioBase) {
            this.titulo = titulo;
            this.autor = autor;
            this.precioBase = precioBase;
        }
        
        @Override
        public String toString() {
            return "Título: " + titulo + "\nAutor: " + autor + "\nPrecio base: " + precioBase;
        }
    }
    
    // Clase Libro, subtipo de Publicacion, con coste de envío
    public static class Libro extends Publicacion {
        private double costeEnvio;
        
        public Libro(String titulo, String autor, double precioBase, double costeEnvio) {
            super(titulo, autor, precioBase);
            this.costeEnvio = costeEnvio;
        }
        
        @Override
        public double precioFinal() {
            return precioBase + (precioBase * IVA) + costeEnvio;
        }
        
        @Override
        public String descripcion() {
            return "Libro " + titulo + " escrito por " + autor;
        }
    }
    
    // =================================================================
    // FIN DE LA PRÁCTICA AVANZADA
    // =================================================================
}
