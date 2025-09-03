/*
 * 🎒 BOLETÍN POO (1º DAM) — PLANTILLA #2 (Enunciados NUEVOS)
 * -----------------------------------------------------------
 * Objetivo: otro set de 3 ejercicios COMPLETOS para practicar POO con la
 * misma estructura, ejecutable y con huecos // TODO para que el alumno
 * implemente. Incluye herencia, colecciones y validación.
 *
 * Estilo “Better Comments” (VS Code):
 *   // ! importante/alerta   // ? pista/duda   // TODO tarea   // * idea/nota   // ✅ logrado
 */

import java.util.*;

public class BoletinPOO_Plantilla_2 {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n===============================================");
      System.out.println("   🧭 MENÚ · Boletín POO — PLANTILLA #2");
      System.out.println("===============================================");
      System.out.println(" 1) E1 · Personas (Persona / Alumno / Profesor)");
      System.out.println(" 2) E2 · Geometría 2D (Punto / Segmento / Vector2D)");
      System.out.println(" 3) E3 · Agenda de Tareas (colecciones + filtros)");
      System.out.println(" 0) Salir");
      System.out.print("Elige opción: ");
      String op = sc.nextLine().trim();
      switch (op) {
        case "1": E1_Personas.demo(sc); break;
        case "2": E2_Geometria2D.demo(sc); break;
        case "3": E3_AgendaTareas.demo(sc); break;
        case "0": System.out.println("¡Hasta luego!"); return;
        default: System.out.println("Opción no válida.");
      }
    }
  }

  // =====================================================================================
  // 🔹 E1 · Personas — Herencia + validación + toString/equals (opcional)
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Implementa un pequeño modelo de personas para un centro educativo.
  //   Clases:
  //     • Persona  (base): nombre, apellidos, dni, edad (≥0). Métodos comunes.
  //     • Alumno   (subclase): curso (String), notaMedia (0..10).
  //     • Profesor (subclase): departamento (String), salarioAnual (≥0).
  //   Requisitos mínimos:
  //     • Constructores () y completos en cada clase (usa setters para validar).
  //     • Encapsulación con getters/setters (trim/null-safe). Edad ≥ 0, nota 0..10, salario ≥ 0.
  //     • toString() legible en cada clase (usa super.toString() cuando toque).
  //   Extras opcionales:
  //     • equals/hashCode por DNI en Persona.
  //     • Profesor: subirSueldo(%) con validación.
  //     • Alumno: subirNota(puntos) sin superar 10.
  // =====================================================================================
  static class E1_Personas {

    // TODO: Implementa Persona (clase base)
    static class Persona {
      // private String nombre, apellidos, dni;
      // private int edad; // ! validar >= 0

      // public Persona() { /* TODO: valores por defecto */ }
      // public Persona(String nombre, String apellidos, String dni, int edad) { /* TODO */ }

      // public String getNombre() { /* TODO */ return ""; }
      // public void setNombre(String nombre) { /* TODO: trim/null-safe */ }
      // public String getApellidos() { /* TODO */ return ""; }
      // public void setApellidos(String apellidos) { /* TODO */ }
      // public String getDni() { /* TODO */ return ""; }
      // public void setDni(String dni) { /* TODO */ }
      // public int getEdad() { /* TODO */ return 0; }
      // public void setEdad(int edad) { /* ! validar >=0 */ }

      // @Override public String toString() { /* TODO */ return "[Persona]"; }
      // @Override public boolean equals(Object o) { /* TODO (opcional, por DNI) */ return super.equals(o); }
      // @Override public int hashCode() { /* TODO (opcional) */ return super.hashCode(); }
    }

    // TODO: Implementa Alumno (hereda de Persona)
    static class Alumno /* extends Persona */ {
      // private String curso;
      // private double notaMedia; // 0..10

      // public Alumno() { /* TODO */ }
      // public Alumno(String nombre, String apellidos, String dni, int edad, String curso, double notaMedia) { /* TODO */ }

      // public String getCurso() { /* TODO */ return ""; }
      // public void setCurso(String curso) { /* TODO */ }
      // public double getNotaMedia() { /* TODO */ return 0; }
      // public void setNotaMedia(double n) { /* ! validar [0..10] */ }

      // public void subirNota(double puntos) { /* * opcional: Math.min(10, nota+puntos) */ }
      // @Override public String toString() { /* TODO */ return "[Alumno]"; }
    }

    // TODO: Implementa Profesor (hereda de Persona)
    static class Profesor /* extends Persona */ {
      // private String departamento;
      // private double salarioAnual; // >= 0

      // public Profesor() { /* TODO */ }
      // public Profesor(String nombre, String apellidos, String dni, int edad, String departamento, double salarioAnual) { /* TODO */ }

      // public String getDepartamento() { /* TODO */ return ""; }
      // public void setDepartamento(String d) { /* TODO */ }
      // public double getSalarioAnual() { /* TODO */ return 0; }
      // public void setSalarioAnual(double s) { /* ! validar >=0 */ }

      // public void subirSueldo(double porcentaje) { /* * opcional */ }
      // @Override public String toString() { /* TODO */ return "[Profesor]"; }
    }

    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E1: PERSONAS —\u001B[0m");
      System.out.println("Implementa Persona, Alumno y Profesor (herencia). Añade validaciones y toString().\n");

      System.out.println("--- Ejemplo de uso esperado (comentado) ---");
      System.out.println("// Alumno a = new Alumno(\"Ana\", \"López\", \"12345678A\", 19, \"1ºDAM\", 8.2);\n// Profesor p = new Profesor(\"Luis\", \"Pérez\", \"87654321B\", 40, \"INFORMÁTICA\", 32000);\n// System.out.println(a);\n// System.out.println(p);\n");

      System.out.println("Pulsa Enter para volver al menú...");
      sc.nextLine();
    }
  }

  // =====================================================================================
  // 🔹 E2 · Geometría 2D — Composición + métodos utilitarios
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Modela elementos geométricos simples:
  //     • Punto(x,y)           → mover, distancia a otro punto, toString().
  //     • Segmento(a,b)        → longitud, puntoMedio(), desplazar(dx,dy).
  //     • Vector2D(dx,dy)      → módulo, normalizar(), suma/resta de vectores.
  //   Requisitos mínimos:
  //     • Encapsulación básica (get/set) y constructores completos.
  //     • Usa Math.hypot para distancias/módulos.
  //     • toString() en cada clase.
  //   Extras opcionales:
  //     • Segmento: pendiente() (tener en cuenta divisiones por 0).
  //     • Punto: equals con tolerancia EPS.
  // =====================================================================================
  static class E2_Geometria2D {

    // TODO: Implementa Punto
    static class Punto {
      // private double x, y;
      // public Punto() { /* TODO: (0,0) */ }
      // public Punto(double x, double y) { /* TODO */ }
      // public double getX() { /* TODO */ return 0; }
      // public void setX(double x) { /* TODO */ }
      // public double getY() { /* TODO */ return 0; }
      // public void setY(double y) { /* TODO */ }
      // public void moverA(double x, double y) { /* TODO */ }
      // public void desplazar(double dx, double dy) { /* TODO */ }
      // public double distancia(Punto otro) { /* TODO: Math.hypot(...) */ return 0; }
      // @Override public String toString() { /* TODO */ return "(x,y)"; }
      // @Override public boolean equals(Object o) { /* * opcional con EPS */ return super.equals(o); }
    }

    // TODO: Implementa Segmento (compone dos Puntos)
    static class Segmento {
      // private Punto a, b; // ! no null
      // public Segmento(Punto a, Punto b) { /* TODO: copia/defensiva opcional */ }
      // public Punto getA() { /* TODO */ return null; }
      // public Punto getB() { /* TODO */ return null; }
      // public double longitud() { /* TODO: a.distancia(b) */ return 0; }
      // public Punto puntoMedio() { /* TODO */ return null; }
      // public void desplazar(double dx, double dy) { /* TODO: mover ambos */ }
      // public Double pendiente() { /* * opcional: null si vertical */ return null; }
      // @Override public String toString() { /* TODO */ return "[Segmento]"; }
    }

    // TODO: Implementa Vector2D
    static class Vector2D {
      // private double dx, dy;
      // public Vector2D() { /* TODO: (0,0) */ }
      // public Vector2D(double dx, double dy) { /* TODO */ }
      // public double getDx() { /* TODO */ return 0; }
      // public void setDx(double dx) { /* TODO */ }
      // public double getDy() { /* TODO */ return 0; }
      // public void setDy(double dy) { /* TODO */ }
      // public double modulo() { /* TODO: Math.hypot(dx, dy) */ return 0; }
      // public void normalizar() { /* TODO: hacer módulo 1 si módulo>0 */ }
      // public Vector2D sumar(Vector2D v) { /* TODO */ return null; }
      // public Vector2D restar(Vector2D v) { /* TODO */ return null; }
      // @Override public String toString() { /* TODO */ return "<dx,dy>"; }
    }

    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E2: GEOMETRÍA 2D —\u001B[0m");
      System.out.println("Implementa Punto, Segmento y Vector2D. Practica composición y utilidades matemáticas.\n");

      System.out.println("--- Ejemplo de uso esperado (comentado) ---");
      System.out.println("// Punto a = new Punto(0,0); Punto b = new Punto(3,4);\n// Segmento s = new Segmento(a,b);\n// System.out.printf(\"Longitud: %.2f\\n\", s.longitud()); // 5.00\n// Vector2D v = new Vector2D(3,4); v.normalizar(); System.out.println(v);\n");

      System.out.println("Pulsa Enter para volver al menú...");
      sc.nextLine();
    }
  }

  // =====================================================================================
  // 🔹 E3 · Agenda de Tareas — Colecciones (List), filtros y ordenación (opcional)
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Crea una pequeña Agenda con tareas.
  //   Clases:
  //     • Tarea: titulo, prioridad (enum BAJA/MEDIA/ALTA), hecha(boolean).
  //     • Agenda: List<Tarea> con operaciones CRUD básicas.
  //   Requisitos mínimos:
  //     • Tarea: constructores, getters/setters, toString().
  //     • Agenda: añadir, listar, marcarHecha(indice), eliminar(indice), filtrarPorPrioridad(...).
  //   Extras opcionales:
  //     • Ordenar por prioridad (y por título) usando Comparator.
  //     • Buscar por texto en el título (contains, case-insensitive).
  // =====================================================================================
  static class E3_AgendaTareas {

    // TODO: Implementa enum Prioridad { BAJA, MEDIA, ALTA }
    // enum Prioridad { /* TODO */ }

    // TODO: Implementa Tarea
    static class Tarea {
      // private String titulo;
      // private Prioridad prioridad;
      // private boolean hecha;

      // public Tarea() { /* TODO: por defecto */ }
      // public Tarea(String titulo, Prioridad prioridad) { /* TODO */ }

      // public String getTitulo() { /* TODO */ return ""; }
      // public void setTitulo(String titulo) { /* TODO: trim/null-safe */ }
      // public Prioridad getPrioridad() { /* TODO */ return null; }
      // public void setPrioridad(Prioridad p) { /* TODO */ }
      // public boolean isHecha() { /* TODO */ return false; }
      // public void setHecha(boolean h) { /* TODO */ }

      // @Override public String toString() { /* TODO */ return "[Tarea]"; }
    }

    // TODO: Implementa Agenda (gestionará una lista de Tarea)
    static class Agenda {
      // private final List<Tarea> tareas = new ArrayList<>();

      // public void anadir(Tarea t) { /* TODO: evitar null */ }
      // public List<Tarea> listar() { /* TODO: devolver copia inmutable opcional */ return null; }
      // public boolean marcarHecha(int idx) { /* TODO: rango válido */ return false; }
      // public boolean eliminar(int idx) { /* TODO */ return false; }
      // public List<Tarea> filtrarPorPrioridad(Prioridad p) { /* TODO */ return null; }

      // * Opcional: ordenarPorPrioridad(), buscarPorTexto(String s), etc.
    }

    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E3: AGENDA DE TAREAS —\u001B[0m");
      System.out.println("Implementa Tarea (con enum Prioridad) y Agenda (List<Tarea> + CRUD y filtros).\n");

      System.out.println("--- Ejemplo de uso esperado (comentado) ---");
      System.out.println("// Agenda ag = new Agenda();\n// ag.anadir(new Tarea(\"Estudiar POO\", Prioridad.ALTA));\n// ag.anadir(new Tarea(\"Hacer ejercicio\", Prioridad.MEDIA));\n// System.out.println(ag.listar());\n// ag.marcarHecha(0);\n// System.out.println(ag.filtrarPorPrioridad(Prioridad.ALTA));\n");

      System.out.println("Pulsa Enter para volver al menú...");
      sc.nextLine();
    }
  }

  // =====================================================================================
  // 🧩 UTILIDADES COMUNES (entrada segura)
  // =====================================================================================
  private static int leerEntero(Scanner sc) {
    while (true) {
      try { return Integer.parseInt(sc.nextLine().trim()); }
      catch (Exception e) { System.out.print("Introduce un entero válido: "); }
    }
  }
  private static double leerDouble(Scanner sc) {
    while (true) {
      try { return Double.parseDouble(sc.nextLine().trim().replace(",", ".")); }
      catch (Exception e) { System.out.print("Introduce un número válido: "); }
    }
  }
}
