/*
============================================================
 Proyecto didáctico de POO: "Restaurante Java"
 Nivel: iniciación (1º / 2º programación)
 Autor: (tú)
 Licencia: CC BY 4.0
------------------------------------------------------------
 ▶ Objetivo
 Crear un pequeño sistema de restaurante usando Programación
 Orientada a Objetos (clases, atributos, métodos, herencia,
 encapsulación, colecciones, enum, y una interfaz).
------------------------------------------------------------
 ▶ Cómo usar esta PLANTILLA
 - Busca las etiquetas TODO, FIXME y ??? para completar.
 - Los huecos marcados con ____ deben reemplazarse por código.
 - Lee los comentarios // TIP para pistas.
 - Ejecuta el main al final para ir probando paso a paso.
------------------------------------------------------------
 Estructura que construiremos:
   Persona (abstracta)
    ├── Cliente
    └── Empleado
   Plato
   Mesa
   Pedido  (usa enum EstadoPedido y la interfaz Descuento)
   Restaurante (agrega y coordina todo)
============================================================
*/

import java.util.*;

//region ====== MODELO BÁSICO ======

/**
 * Clase base abstracta para personas del sistema (Cliente y Empleado).
 *
 * Objetivos didácticos:
 * - Practicar encapsulación (atributos privados + getters).
 * - Definir una clase abstracta para reutilizar comportamiento común.
 * - Preparar herencia para Cliente y Empleado.
 *
 * NOTA: Mantén esta clase sin implementar para resolverla paso a paso en clase.
 */
// TODO-1: Clase abstracta Persona con encapsulación
abstract class Persona {

    // Atributos privados
    @SuppressWarnings("unused")
    private String nombre;
    @SuppressWarnings("unused")
    private String id;

    /**
     * Constructor de Persona.
     *
     * TODO-1.1: inicializar nombre e id.
     * TIP: usa this.nombre = nombre; this.id = id;
     */
    public Persona(/* ____ nombre, ____ id */) {
        // this.nombre = ____ ;
        // this.id = ____ ;
        throw new UnsupportedOperationException("TODO: constructor Persona");
    }

    // Getters (solo lectura pública)
    /**
     * TODO-1.2: devolver el nombre.
     */
    public String getNombre() { throw new UnsupportedOperationException("TODO: getter nombre"); }

    /**
     * TODO-1.3: devolver el id.
     */
    public String getId() { throw new UnsupportedOperationException("TODO: getter id"); }

    /**
     * Método común de ejemplo para todas las personas.
     *
     * TODO-1.4: devolver una cadena tipo: "Hola, soy NOMBRE (ID)".
     */
    public String presentarse() {
        // return "Hola, soy " + getNombre() + " (" + getId() + ")";
        throw new UnsupportedOperationException("TODO: método presentarse");
    }
}

// TODO-2: Cliente hereda de Persona
/**
 * Representa a un cliente del restaurante.
 *
 * Objetivos didácticos:
 * - Heredar de Persona (super(nombre, id)).
 * - Añadir estado propio (saldo) y operaciones (añadir saldo, pagar).
 * - Validación de argumentos (no admitir cantidades negativas).
 */
class Cliente extends Persona {

    // TIP: saldo permite pagar pedidos
    @SuppressWarnings("unused")
    private double saldo;

    /**
     * TODO-2.1: constructor con nombre, id e importeInicial (saldo inicial).
     * TIP: llama a super(nombre, id) y asigna this.saldo = importeInicial.
     */
    public Cliente(/* ____ nombre, ____ id, ____ importeInicial */) {
        super(/* ____ , ____ */);
        // this.saldo = ____ ;
        throw new UnsupportedOperationException("TODO: constructor Cliente");
    }

    /**
     * TODO-2.2: devolver el saldo actual del cliente.
     */
    public double getSaldo() { throw new UnsupportedOperationException("TODO: getter saldo"); }

    /**
     * Añade saldo a la cuenta del cliente.
     *
     * TODO-2.3: validar cantidad positiva y sumar al saldo.
     * FIXME-2.A: decidir qué hacer si cantidad <= 0 (ignorar, lanzar excepción, etc.).
     */
    public void anadirSaldo(double cantidad) {
        // FIXME: validar cantidad positiva
        // saldo += ____ ;
        throw new UnsupportedOperationException("TODO: anadirSaldo");
    }

    /**
     * Intenta pagar una cantidad desde el saldo.
     *
     * Contrato:
     * - Entrada: cantidad > 0.
     * - Éxito: si saldo >= cantidad, descontar y devolver true.
     * - Fracaso: no modificar saldo y devolver false.
     *
     * TODO-2.4: implementar la lógica anterior.
     */
    public boolean pagar(double cantidad) {
        // TIP: si saldo >= cantidad, descuéntalo y devuelve true
        // if ( ____ ) { ____ ; return true; } else { return false; }
        throw new UnsupportedOperationException("TODO: pagar");
    }
}

// TODO-3: Empleado hereda de Persona
/**
 * Representa a un empleado del restaurante (camarero, cocinero, etc.).
 *
 * Objetivos didácticos:
 * - Heredar de Persona.
 * - Añadir atributos rol y salarioBaseMensual con getters.
 */
class Empleado extends Persona {
    @SuppressWarnings("unused")
    private String rol;
    @SuppressWarnings("unused")
    private double salarioBaseMensual;

    /**
     * TODO-3.1: constructor con nombre, id, rol y salarioBaseMensual.
     */
    public Empleado(/* ____ nombre, ____ id, ____ rol, ____ salarioBaseMensual */) {
        super(/* ____ , ____ */);
        // this.rol = ____ ;
        // this.salarioBaseMensual = ____ ;
        throw new UnsupportedOperationException("TODO: constructor Empleado");
    }

    /** TODO-3.2: devolver el rol. */
    public String getRol() { throw new UnsupportedOperationException("TODO: getter rol"); }
    /** TODO-3.3: devolver el salario base mensual. */
    public double getSalarioBaseMensual() { throw new UnsupportedOperationException("TODO: getter salario"); }

    // Método de ejemplo
    public String descripcionPuesto() {
        // return "Empleado: " + getNombre() + " - Rol: " + getRol();
        throw new UnsupportedOperationException("TODO: descripcionPuesto");
    }
}

// Clase simple: Plato
/**
 * Elemento de la carta del restaurante.
 *
 * Objetivos didácticos:
 * - Inmutabilidad básica (atributos final).
 * - Getters y toString.
 */
class Plato {
    @SuppressWarnings("unused")
    private final String nombre;
    @SuppressWarnings("unused")
    private final double precio;
    @SuppressWarnings("unused")
    private final boolean esVegetariano;

    // TODO-4: completa el constructor y getters
    public Plato(/* ____ nombre, ____ precio, ____ esVegetariano */) {
        // this.nombre = ____ ;
        // this.precio = ____ ;
        // this.esVegetariano = ____ ;
        throw new UnsupportedOperationException("TODO: constructor Plato");
    }

    /** TODO-4.1: devolver nombre del plato. */
    public String getNombre() { throw new UnsupportedOperationException("TODO: getter nombre plato"); }
    /** TODO-4.2: devolver precio del plato. */
    public double getPrecio() { throw new UnsupportedOperationException("TODO: getter precio"); }
    /** TODO-4.3: devolver si es vegetariano. */
    public boolean isVegetariano() { throw new UnsupportedOperationException("TODO: getter vegetariano"); }

    @Override
    public String toString() {
        // return nombre + " (" + (esVegetariano ? "veg" : "no veg") + ") - " + precio + "€";
        throw new UnsupportedOperationException("TODO: toString Plato");
    }
}

// Clase simple: Mesa
/**
 * Mesa del restaurante con número y capacidad.
 *
 * Objetivos didácticos:
 * - Atributos de solo lectura (final) + estado (ocupada) mutable.
 * - Métodos ocupar/liberar y representación textual.
 */
class Mesa {
    @SuppressWarnings("unused")
    private final int numero;
    @SuppressWarnings("unused")
    private final int capacidad;
    private boolean ocupada = false;

    // TODO-5: constructor y getters
    public Mesa(/* ____ numero, ____ capacidad */) {
        // this.numero = ____ ;
        // this.capacidad = ____ ;
        throw new UnsupportedOperationException("TODO: constructor Mesa");
    }

    /** TODO-5.1: devolver número de mesa. */
    public int getNumero() { throw new UnsupportedOperationException("TODO: getter numero"); }
    /** TODO-5.2: devolver capacidad de la mesa. */
    public int getCapacidad() { throw new UnsupportedOperationException("TODO: getter capacidad"); }
    public boolean isOcupada() { return ocupada; }

    public void ocupar() { ocupada = true; }
    public void liberar() { ocupada = false; }

    @Override public String toString() {
        // return "Mesa " + getNumero() + " (" + getCapacidad() + " pax) - " + (ocupada ? "Ocupada" : "Libre");
        throw new UnsupportedOperationException("TODO: toString Mesa");
    }
}

//endregion

//region ====== ENUM + INTERFAZ ======

enum EstadoPedido { CREADO, EN_PREPARACION, SERVIDO, PAGADO }

// Interfaz de descuento (polimorfismo)
interface Descuento {
    double aplicar(double total);
}

// Implementación concreta de descuento
class DescuentoEstudiante implements Descuento {
    @SuppressWarnings("unused")
    private final double porcentaje; // ej. 0.1 = 10 %

    public DescuentoEstudiante(double porcentaje) { this.porcentaje = porcentaje; }

    @Override
    public double aplicar(double total) {
        // TODO-6: devuelve total con el descuento aplicado
        // return ____ ;
        throw new UnsupportedOperationException("TODO: descuento estudiante");
    }
}

//endregion

//region ====== AGREGACIÓN: Pedido y Restaurante ======

class Pedido {
    private final int numero;
    private final Cliente cliente;
    private final Mesa mesa;
    private final List<Plato> platos = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.CREADO;
    @SuppressWarnings("unused")
    private Descuento descuentoOpcional; // puede ser null

    public Pedido(int numero, Cliente cliente, Mesa mesa) {
        this.numero = numero;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public void anadirPlato(Plato p) { platos.add(p); }
    public List<Plato> getPlatos() { return Collections.unmodifiableList(platos); }
    public EstadoPedido getEstado() { return estado; }
    public void setDescuento(Descuento d) { this.descuentoOpcional = d; }

    // TODO-7: calcular total sumando precios
    public double totalSinDescuento() {
        // double suma = 0;
        // for (Plato p : platos) { ____ ; }
        // return suma;
        throw new UnsupportedOperationException("TODO: total sin descuento");
    }

    // TODO-8: aplicar descuento si existe
    public double totalFinal() {
        // double t = totalSinDescuento();
        // if (descuentoOpcional != null) { t = descuentoOpcional.aplicar( ____ ); }
        // return t;
        throw new UnsupportedOperationException("TODO: total final");
    }

    public void avanzarEstado() {
        // Orden: CREADO -> EN_PREPARACION -> SERVIDO -> PAGADO
        switch (estado) {
            case CREADO: estado = EstadoPedido.EN_PREPARACION; break;
            case EN_PREPARACION: estado = EstadoPedido.SERVIDO; break;
            case SERVIDO: estado = EstadoPedido.PAGADO; break;
            default: /* ya pagado */ ;
        }
    }

    // Cobrar al cliente (usa Cliente.pagar)
    public boolean cobrar() {
        // double importe = totalFinal(); // TODO-8.1: calcular importe final
        // TIP: si se cobra, liberar la mesa
        // if (cliente.pagar(importe)) { mesa.liberar(); estado = EstadoPedido.PAGADO; return true; }
        // return false;
        throw new UnsupportedOperationException("TODO: cobrar pedido");
    }

    @Override public String toString() {
        return "Pedido #" + numero + " (" + estado + ") - Mesa " + mesa.getNumero() + " - Cliente " + cliente.getNombre();
    }
}

class Restaurante {
    private final String nombre;
    private final List<Plato> carta = new ArrayList<>();
    private final List<Mesa> mesas = new ArrayList<>();
    private final List<Empleado> empleados = new ArrayList<>();
    private int contadorPedidos = 1;

    public Restaurante(String nombre) { this.nombre = nombre; }

    // Añadir elementos
    public void agregarPlato(Plato p) { carta.add(p); }
    public void agregarMesa(Mesa m) { mesas.add(m); }
    public void contratar(Empleado e) { empleados.add(e); }

    public List<Plato> getCarta() { return Collections.unmodifiableList(carta); }
    public List<Mesa> getMesas() { return Collections.unmodifiableList(mesas); }
    public String getNombre() { return nombre; }

    // Buscar primera mesa libre con capacidad >= pax
    public Mesa asignarMesa(int pax) {
        for (Mesa m : mesas) {
            if (!m.isOcupada() && /* ____ */ m.getCapacidad() >= pax) {
                m.ocupar();
                return m;
            }
        }
        return null; // no hay mesa
    }

    // Crear pedido para un cliente y n comensales
    public Pedido crearPedido(Cliente c, int pax) {
        Mesa mesa = asignarMesa(pax);
        if (mesa == null) return null;
        return new Pedido(contadorPedidos++, c, mesa);
    }
}

//endregion

//region ====== PROGRAMA PRINCIPAL (main) ======

public class Restaurante_POO_Plantilla {

    public static void main(String[] args) {
        // TIP: ve descomentando poco a poco conforme completes los TODOs

        // 1) Crear restaurante, mesas y carta
        // Restaurante r = new Restaurante("La Buena Onda");
        // r.agregarMesa(new Mesa(1, 2));
        // r.agregarMesa(new Mesa(2, 4));
        // r.agregarMesa(new Mesa(3, 4));

        // r.agregarPlato(new Plato("Ensalada", 6.0, true));
        // r.agregarPlato(new Plato("Hamburguesa", 9.5, false));
        // r.agregarPlato(new Plato("Pasta", 8.0, true));

        // 2) Registrar personal (herencia Empleado <- Persona)
        // Empleado e1 = new Empleado("Marta", "E-01", "Camarera", 1200);
        // r.contratar(e1);

        // 3) Crear cliente con saldo
        // Cliente c1 = new Cliente("Ana", "C-100", 25.0);

        // 4) Crear un pedido para 2 comensales
        // Pedido p = r.crearPedido(c1, 2);
        // System.out.println(p);

        // 5) Añadir platos al pedido
        // p.anadirPlato(r.getCarta().get(0));
        // p.anadirPlato(r.getCarta().get(1));

        // 6) Aplicar descuento estudiante del 10%
        // p.setDescuento(new DescuentoEstudiante(0.10));

        // 7) Mostrar totales y cobrar
        // System.out.println("Total sin descuento: " + p.totalSinDescuento());
        // System.out.println("Total final: " + p.totalFinal());
        // boolean cobrado = p.cobrar();
        // System.out.println("Cobrado: " + cobrado + " | Estado: " + p.getEstado());

        // 8) Comprueba saldo restante del cliente
        // System.out.println("Saldo de " + c1.getNombre() + ": " + c1.getSaldo() + "€");
    }
}

//endregion
