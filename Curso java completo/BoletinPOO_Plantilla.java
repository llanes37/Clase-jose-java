/*
 * 🎒 BOLETÍN POO (1º DAM) — PLANTILLA PARA PRACTICAR
 * ---------------------------------------------------
 * Objetivo: Dar al alumno una estructura ejecutable con menú y tres ejercicios
 * para que IMPLEMENTE el código por su cuenta.
 *
 * 🔧 ¿Cómo usar esta plantilla?
 *   1) Compila y ejecuta este .java: verás un menú con 3 ejercicios.
 *   2) Entra en cada ejercicio y lee el ENUNCIADO.
 *   3) Completa las clases y métodos marcados con // TODO siguiendo las pistas.
 *   4) Vuelve a ejecutar y usa los mini-demos para probar tu código.
 *
 * Estilo “Better Comments” (VS Code):
 *   // ! importante/alerta   // ? pista/duda   // TODO tarea   // * idea/nota   // ✅ logrado
 */

import java.util.*;

public class BoletinPOO_Plantilla {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n===============================================");
      System.out.println("   🧭 MENÚ · Boletín POO — PLANTILLA");
      System.out.println("===============================================");
      System.out.println(" 1) E1 · Geometría Lite (Rectángulo / Cuadrado opcional)");
      System.out.println(" 2) E2 · Empresa Lite (Empleado / Directivo con herencia)");
      System.out.println(" 3) E3 · CuentaBancaria Lite (ejercicio más sencillo)");
      System.out.println(" 0) Salir");
      System.out.print("Elige opción: ");
      String op = sc.nextLine().trim();
      switch (op) {
        case "1": E1_GeometriaLite.demo(sc); break;
        case "2": E2_EmpresaLite.demo(sc); break;
        case "3": E3_CuentaBancariaLite.demo(sc); break;
        case "0": System.out.println("¡Hasta luego!"); return;
        default: System.out.println("Opción no válida.");
      }
    }
  }

  // =====================================================================================
  // 🔹 E1 · Geometría Lite — Rectángulo (+ Cuadrado opcional mediante herencia)
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Implementa una clase Rectangulo con:
  //     • base y altura (double) → deben ser > 0 (si no, corrige a 0.1).
  //     • constructores: () y (base, altura).
  //     • get/set con validación, area(), perimetro(), diagonal(), toString().
  //   OPCIONAL (herencia):
  //     • Clase Cuadrado que HEREDA de Rectangulo y asegura base==altura (lado).
  //       - constructor (lado)
  //       - si el alumno cambia base o altura, debe mantenerse la invariantes (opcional).
  //
  // ✅ Objetivos didácticos: encapsulación, validación, métodos de cálculo, herencia.
  // =====================================================================================
  static class E1_GeometriaLite {

    // TODO: Implementa la clase Rectangulo
    // ? Pistas:
    //   - Campos privados: double base, altura;
    //   - Validación en setters (si <=0 → 0.1 y avisa con System.out.println)
    //   - area = base*altura; perimetro = 2*(base+altura); diagonal = Math.hypot(base, altura)
    //   - toString(): devuelve algo legible con todos los datos
    static class Rectangulo {
      // private double base;
      // private double altura;

      // public Rectangulo() { /* TODO: valores por defecto (1,1) */ }
      // public Rectangulo(double base, double altura) { /* TODO: usa setters */ }

      // public double getBase() { /* TODO */ return 0; }
      // public void setBase(double base) { /* TODO validación */ }

      // public double getAltura() { /* TODO */ return 0; }
      // public void setAltura(double altura) { /* TODO validación */ }

      // public double area() { /* TODO */ return 0; }
      // public double perimetro() { /* TODO */ return 0; }
      // public double diagonal() { /* TODO */ return 0; }

      // @Override public String toString() { /* TODO */ return "[Rectangulo]"; }

      // * Puedes añadir un método privado double positivoSeguro(double v, String nombreCampo)
      //   para centralizar la validación en los setters.
    }

    // TODO (OPCIONAL): Implementa Cuadrado heredando de Rectangulo
    // ? Pistas:
    //   - Constructor Cuadrado(double lado) llama al super(lado, lado)
    //   - (Opcional) Sobrescribe setBase/setAltura para mantener siempre base==altura
    static class Cuadrado /* extends Rectangulo */ {
      // public Cuadrado(double lado) { /* TODO: super(lado, lado); */ }
      // @Override public String toString() { /* TODO (opcional) */ return "[Cuadrado]"; }
    }

    // Mini demo guiada para que el alumno pruebe su implementación
    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E1: GEOMETRÍA LITE —\u001B[0m");
      System.out.println("Enunciado y pistas dentro del código. Completa Rectangulo (y Cuadrado opcional).\n");

      System.out.println("\n--- Ejemplo de uso esperado (comentado): ---");
      System.out.println("// Rectangulo r = new Rectangulo(5, 3);\n// System.out.println(r);\n// System.out.printf(\"Área: %.2f | Perímetro: %.2f | Diagonal: %.2f\\n\", r.area(), r.perimetro(), r.diagonal());\n");

      System.out.println("Pulsa Enter para volver al menú...");
      sc.nextLine();
    }
  }

  // =====================================================================================
  // 🔹 E2 · Empresa Lite — Empleado y Directivo (HERENCIA)
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Clase Empleado:
  //     • nombre, apellidos, edad, dni, salarioAnual (privados) + IRPF (solo lectura, calculado).
  //     • Reglas IRPF (orientativas): <6000 → 7.5%; 6000..30000 → 15%; >30000 → 20%.
  //     • Constructores () y (nombre, apellidos, edad, dni, salarioAnual). Setters con validación.
  //     • dineroHacienda() = salarioAnual * irpf/100. toString().
  //   Clase Directivo (HEREDA de Empleado):
  //     • porcentajeBeneficio [0..100].
  //     • gananciaDirectivo(beneficioEmpresa) → 0 si ≤0; si >0 → beneficio*(%/100).
  //
  // ✅ Objetivos: encapsulación, reglas de negocio, HERENCIA, cálculo dependiente de parámetro.
  // =====================================================================================
  static class E2_EmpresaLite {

    // TODO: Implementa Empleado (clase base)
    static class Empleado {
      // private String nombre, apellidos, dni;
      // private int edad;
      // private double salarioAnual;
      // private double irpf; // calculado automáticamente

      // public Empleado() { /* TODO: valores por defecto */ }
      // public Empleado(String nombre, String apellidos, int edad, String dni, double salarioAnual) {
      //   /* TODO: usar setters; recalcular IRPF cuando cambie salario */
      // }

      // public String getNombre() { /* TODO */ return ""; }
      // public void setNombre(String nombre) { /* TODO: trim/evitar null */ }
      // public String getApellidos() { /* TODO */ return ""; }
      // public void setApellidos(String apellidos) { /* TODO */ }
      // public int getEdad() { /* TODO */ return 0; }
      // public void setEdad(int edad) { /* ! validar >=0 */ }
      // public String getDni() { /* TODO */ return ""; }
      // public void setDni(String dni) { /* TODO */ }
      // public double getSalarioAnual() { /* TODO */ return 0; }
      // public void setSalarioAnual(double salarioAnual) { /* ! validar >=0; recalcularIRPF() */ }
      // public double getIrpf() { /* TODO */ return 0; }

      // private void recalcularIRPF() { /* TODO franjas 7.5 / 15 / 20 */ }
      // public double dineroHacienda() { /* TODO */ return 0; }
      // @Override public String toString() { /* TODO */ return "[Empleado]"; }
    }

    // TODO: Implementa Directivo HEREDANDO de Empleado
    static class Directivo /* extends Empleado */ {
      // private double porcentajeBeneficio; // [0..100]
      // public Directivo() { /* TODO */ }
      // public Directivo(String nombre, String apellidos, int edad, String dni, double salarioAnual, double porcentajeBeneficio) {
      //   /* TODO: llamar a super(...); setPorcentajeBeneficio(...) */
      // }
      // public double getPorcentajeBeneficio() { /* TODO */ return 0; }
      // public void setPorcentajeBeneficio(double v) { /* ! si <0 o >100 → ajustar a 0 o lanzar excepción */ }
      // public double gananciaDirectivo(double beneficioEmpresa) { /* TODO */ return 0; }
      // @Override public String toString() { /* TODO */ return "[Directivo]"; }
    }

    // Mini demo guiada
    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E2: EMPRESA LITE —\u001B[0m");
      System.out.println("Completa Empleado (base) y Directivo (hereda). Usa las franjas de IRPF y el % de beneficio.\n");

      System.out.println("\n--- Ejemplo de uso esperado (comentado): ---");
      System.out.println("// Empleado e = new Empleado(\"Luis\", \"Pérez\", 30, \"12345678A\", 20000);\n// System.out.println(e);\n// Directivo d = new Directivo(\"Ana\", \"López\", 45, \"87654321B\", 40000, 5);\n// System.out.printf(\"Ganancia directivo (beneficio 100k): %.2f€\\n\", d.gananciaDirectivo(100000));\n");

      System.out.println("Pulsa Enter para volver al menú...");
      sc.nextLine();
    }
  }

  // =====================================================================================
  // 🔹 E3 · CuentaBancaria Lite — ejercicio más sencillo (sin herencia)
  // -------------------------------------------------------------------------------------
  // ENUNCIADO (resumen):
  //   Implementa una CuentaBancaria con:
  //     • titular (String), saldo (double ≥ 0), limiteRetiradaDiaria (double ≥ 0, opcional).
  //     • constructores: () y (titular, saldoInicial).
  //     • métodos: ingresar(cant), retirar(cant) con validación (cant>0 y saldo suficiente).
  //     • toString() legible.
  //   EXTRA (opcional): llevar un registro simple (List<String> movimientos) con apuntes de texto.
  //
  // ✅ Objetivos: validación básica, estados coherentes, diseño de API simple.
  // =====================================================================================
  static class E3_CuentaBancariaLite {

    // TODO: Implementa la clase CuentaBancaria
    static class CuentaBancaria {
      // private String titular;
      // private double saldo;
      // private double limiteRetiradaDiaria; // * opcional: si no quieres usarlo, ignóralo
      // private List<String> movimientos;    // * opcional

      // public CuentaBancaria() { /* TODO: valores por defecto (\"\", 0) */ }
      // public CuentaBancaria(String titular, double saldoInicial) { /* TODO */ }

      // public String getTitular() { /* TODO */ return ""; }
      // public void setTitular(String titular) { /* TODO: trim/null-safe */ }
      // public double getSaldo() { /* TODO */ return 0; }

      // public void ingresar(double cantidad) { /* ! validar >0; actualizar saldo; registrar movimiento (opcional) */ }
      // public boolean retirar(double cantidad) { /* ! validar >0 y saldo suficiente; aplicar; devolver true/false */ return false; }

      // @Override public String toString() { /* TODO */ return "[CuentaBancaria]"; }

      // * Idea (opcional): String apuntes() → une movimientos con \n
    }

    // Mini demo guiada
    public static void demo(Scanner sc) {
      System.out.println("\n\u001B[1;36m— E3: CUENTA BANCARIA LITE —\u001B[0m");
      System.out.println("Implementa CuentaBancaria con ingresar/retirar y validaciones básicas.\n");

      System.out.println("\n--- Ejemplo de uso esperado (comentado): ---");
      System.out.println("// CuentaBancaria c = new CuentaBancaria(\"Alumno\", 100);\n// c.ingresar(50);\n// boolean ok = c.retirar(120); // debería fallar si no hay saldo suficiente\n// System.out.println(c);\n");

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