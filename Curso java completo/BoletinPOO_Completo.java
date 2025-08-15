/******************************************************************************************
 * 📚 BOLETÍN POO COMPLETO (1º DAM)
 * ----------------------------------------------------------------------------------------
 * Basado en el documento "PRG_Boletín 4.1 - POO" (autor: Francisco Bellas Aláez, Curro).
 * Este archivo integra **enunciados resumidos**, **soluciones ejemplo** y **extras**
 * para practicar. Incluye un menú en consola para ejecutar cada ejercicio.
 *
 * ESTRUCTURA Y ESTILO (inspirado en tu GestorAlumnos.java):
 *  - Secciones claras con separadores y emojis.
 *  - En cada ejercicio: 
 *      1) Enunciado (resumen).
 *      2) Diseño / API de clases (comentado).
 *      3) Implementación ejemplo.
 *      4) Método demo() para probar desde el menú.
 *
 * 💡 Sugerencia didáctica: pide al alumno que lea el enunciado de la sección, 
 *    intente implementarlo en otra clase/fichero y, si lo necesita, compare con 
 *    la solución aquí incluida.
 *
 * © Uso educativo.
 ******************************************************************************************/

import java.util.*;

// =========================================================================================
// 🧭 MENÚ PRINCIPAL
// =========================================================================================
public class BoletinPOO_Completo {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n==========================================================");
      System.out.println("      🧭 MENÚ · BOLETÍN POO (1º DAM)");
      System.out.println("==========================================================");
      System.out.println(" 1) Ejercicio 1 · Geometría");
      System.out.println(" 2) Ejercicio 2 · Fecha");
      System.out.println(" 3) Ejercicio 3 · Proyecto Empresa I (Empleado / IUEmpleado)");
      System.out.println(" 4) Ejercicio 4 · Proyecto Empresa II (Directivo / IUDirectivo)");
      System.out.println(" 5) Ejercicio 5 · Proyecto Empresa III (Empresa + menú)");
      System.out.println(" 6) (Opcional) Juego conversacional · Esqueleto");
      System.out.println(" 7) (Opcional) Juego por turnos · Esqueleto");
      System.out.println(" 0) Salir");
      System.out.print("\nElige opción: ");

      String opt = sc.nextLine().trim();
      switch (opt) {
        case "1": E1_Geometria.demo(sc); break;
        case "2": E2_Fecha.demo(sc); break;
        case "3": E3_Empleado_IU.demo(sc); break;
        case "4": E4_Directivo_IU.demo(sc); break;
        case "5": E5_Empresa_Menu.demo(sc); break;
        case "6": E6_JuegoConversacional_Skel.demo(sc); break;
        case "7": E7_JuegoTurnos_Skel.demo(sc); break;
        case "0": System.out.println("¡Hasta luego!"); return;
        default:  System.out.println("Opción no válida.");
      }
    }
  }

    // =======================================================================================
  // 🟩 EJERCICIO 1 · GEOMETRÍA (MEJORADO · DIDÁCTICO + BETTER COMMENTS)
  // ---------------------------------------------------------------------------------------
  // ENUNCIADO (resumen mejorado):
  //   Implementa una clase Geometria con:
  //     • figura: boolean (true = rectángulo, false = triángulo)  ➜ SOLO LECTURA (se fija en constructor).
  //     • base, altura: double con validación (> 0).
  //   Constructores:
  //     • sin parámetros → triángulo base=2, altura=2.
  //     • (base, altura) → triángulo con esos valores.
  //     • (figura, base, altura) → crea rectángulo/triángulo según figura.
  //   Métodos:
  //     • area(): rectángulo = base*altura · triángulo = base*altura/2
  //     • perimetro(): rectángulo = 2*(base+altura) · triángulo rectángulo = base + altura + diagonal
  //     • diagonal(): hipotenusa (Math.hypot(base, altura)) — válida para ambos casos
  //     • tipo(): "rectángulo" o "triángulo"
  //
  // DEMO:
  //   • Crea un rectángulo por parámetros.
  //   • Crea un triángulo con constructor vacío y pide base/altura por teclado.
  //
  // OBJETIVOS DIDÁCTICOS:
  //   1) Constructores sobrecargados + encapsulación (get/set) con validación.
  //   2) Métodos de cálculo + uso de Math.hypot.
  //   3) Diseño: propiedad inmutable (figura) y toString informativo.
  //
  // EXTRA (tras entender el ejercicio):
  //   A) Añadir método "esCuadrado()" (solo sentido para rectángulo).
  //   B) Añadir "setPositivoSeguro(double v)" para centralizar validaciones (reutilízalo en setBase/setAltura).
  //   C) Añadir "static Geometria crearCuadrado(double lado)" (factoría).
  //   D) Añadir "clonarEscalado(double k)" → devuelve un nuevo objeto escalado SIN modificar el actual.
  //
  // RETO NUEVO (más fácil, para hacerlo desde cero):
  //   • Implementa "RectanguloLite" (ver al final del bloque) con base/altura, area(), perimetro() y validación.
  //   • Sin diagonal, sin figura booleana, sin triángulo. Simplicidad máxima.
  //   • Incluye un pequeño "demoLite()" para probarlo.
  //
  // NOTA Better Comments:
  //   Usa estas etiquetas en VS Code para colorear:
  //     // ! importante/alerta    // ? duda/pista    // TODO tarea pendiente
  //     // * idea/nota útil       // ✅ paso validado // 🔎 explicación
  // =======================================================================================
  static class E1_Geometria {

    // =====================================================================================
    // 🔧 CLASE · Geometria
    // -------------------------------------------------------------------------------------
    // ! Importante: 'figura' es inmutable ➜ solo lectura → define el tipo (rectángulo/triángulo).
    // * Validaciones: base y altura deben ser > 0. Si no, se corrigen a 0.1 con aviso.
    // * Sólido: toString() resume toda la información útil para depurar/ver resultados.
    // =====================================================================================
    static class Geometria {
      private final boolean figura;   // true = rectángulo, false = triángulo
      private double base;
      private double altura;

      // -----------------------------------------------------------------------------------
      // 🏗️ Constructores
      // -----------------------------------------------------------------------------------
      public Geometria() {             // * Triángulo 2x2 por defecto
        this.figura = false;
        this.base = 2;
        this.altura = 2;
      }

      public Geometria(double base, double altura) { // * Triángulo con parámetros
        this.figura = false;
        setBase(base);
        setAltura(altura);
      }

      public Geometria(boolean figura, double base, double altura) { // * General
        this.figura = figura;
        setBase(base);
        setAltura(altura);
      }

      // -----------------------------------------------------------------------------------
      // 🔐 Getters/Setters (encapsulación)
      // -----------------------------------------------------------------------------------
      public boolean getFigura() { return figura; }
      public double getBase()    { return base; }
      public double getAltura()  { return altura; }

      public void setBase(double base) {
        // ! Validación: aseguramos valor positivo mínimo
        this.base = setPositivoSeguro(base, "Base");
      }

      public void setAltura(double altura) {
        // ! Validación: aseguramos valor positivo mínimo
        this.altura = setPositivoSeguro(altura, "Altura");
      }

      // * Centralizamos validación (así no repetimos lógica en cada set)
      private double setPositivoSeguro(double v, String nombreCampo) {
        if (v <= 0) {
          System.out.println("⚠️ " + nombreCampo + " inválida; se ajusta a 0.1");
          return 0.1;
        }
        return v;
      }

      // -----------------------------------------------------------------------------------
      // 🧮 Métodos de cálculo
      // -----------------------------------------------------------------------------------
      public double area() {
        // 🔎 Fórmula según tipo de figura
        if (figura) return base * altura;     // rectángulo
        return (base * altura) / 2.0;         // triángulo rectángulo
      }

      public double diagonal() {
        // 🔎 Hipotenusa/diagonal (misma operación)
        return Math.hypot(base, altura);
      }

      public double perimetro() {
        if (figura) {
          return 2 * (base + altura);         // rectángulo
        } else {
          // triángulo rectángulo: suma catetos + hipotenusa
          return base + altura + diagonal();
        }
      }

      public String tipo() {
        return figura ? "rectángulo" : "triángulo";
      }

      // -----------------------------------------------------------------------------------
      // ➕ Utilidades (para ampliar)
      // -----------------------------------------------------------------------------------
      public void escalar(double k) {
        // ! Modifica el objeto actual escalando base/altura
        setBase(base * k);
        setAltura(altura * k);
      }

      // TODO EXTRA A: Implementa después de entender todo
      // * Devuelve true si (y solo si) es rectángulo y además base == altura
      public boolean esCuadrado() {
        if (!figura) return false; // en triángulo no tiene sentido
        // * Se considera “cuadrado” con tolerancia por decimales
        final double EPS = 1e-9;
        return Math.abs(base - altura) < EPS;
      }

      // TODO EXTRA B: Factoría para crear cuadrados fácilmente
      public static Geometria crearCuadrado(double lado) {
        return new Geometria(true, lado, lado);
      }

      // TODO EXTRA C: Clonar escalado (NO modifica el actual)
      public Geometria clonarEscalado(double k) {
        return new Geometria(figura, base * k, altura * k);
      }

      @Override
      public String toString() {
        return String.format(
          "Figura: %s | base=%.2f, altura=%.2f, área=%.2f, perímetro=%.2f, diag=%.2f",
          tipo(), base, altura, area(), perimetro(), diagonal()
        );
      }
    }

    // =====================================================================================
    // 🧪 DEMO INTERACTIVA (EJECUTABLE)
    // -------------------------------------------------------------------------------------
    // * 1) Muestra rectángulo por parámetros
    // * 2) Pide base/altura para triángulo
    // * 3) Enseña extras (cuadrado / clonar escalado)
    // =====================================================================================
    public static void demo(Scanner sc) {
      System.out.println("\n\033[1;36m--- EJERCICIO 1: GEOMETRÍA (MEJORADO) ---\033[0m");

      // 1) Rectángulo con parámetros
      Geometria rect = new Geometria(true, 5, 3);
      System.out.println("\033[1;32mRectángulo por parámetros →\033[0m " + rect);

      // 2) Triángulo por teclado
      Geometria tri = new Geometria();
      System.out.print("Introduce base para TRIÁNGULO: ");
      tri.setBase(leerDouble(sc));
      System.out.print("Introduce altura para TRIÁNGULO: ");
      tri.setAltura(leerDouble(sc));
      System.out.println("\033[1;32mTriángulo configurado →\033[0m " + tri);

      // 3) Demostración de extras
      Geometria cuadr = Geometria.crearCuadrado(4);
      System.out.println("¿Es cuadrado 4x4? " + cuadr.esCuadrado() + " → " + cuadr);

      Geometria rectEscalado = rect.clonarEscalado(1.5);
      System.out.println("Rectángulo escalado x1.5 (clonado): " + rectEscalado);
    }

    // =====================================================================================
    // 🧩 PRÁCTICA EXTRA (para el alumno, tras entenderlo todo)
    // -------------------------------------------------------------------------------------
    // * A) Añadir validación para evitar degradar la figura con escalados negativos o 0:
    //      - escalar(k): si k <= 0, NO modificar y avisar.
    // * B) Añadir equals(Object) y hashCode(): considera figura, base y altura (con tolerancia).
    // * C) Añadir fromString(String s): parsea "R;5;3" → rectángulo 5x3  |  "T;2;2" → triángulo 2x2.
    //
    // ? Pistas:
    //   - Usa split(";") para separar partes.
    //   - 'R' = true, 'T' = false.
    //   - Valida nº de partes y tipos (double).
    //
    // ✅ Con esto refuerzas:
    //   - Inmutabilidad parcial (figura).
    //   - Buenas prácticas de parseo/equals/hashCode.
    // =====================================================================================


    // =====================================================================================
    // 🎯 RETO NUEVO · RectanguloLite (más fácil, para hacer desde cero)
    // -------------------------------------------------------------------------------------
    // Objetivo: reproducir la idea base del rectángulo con lo mínimo imprescindible.
    //
    // REQUISITOS:
    //   • Atributos privados: base (double), altura (double).
    //   • Constructor (base, altura) + constructor vacío (base=1, altura=1).
    //   • set/get con validación (> 0) — reusa una ayudita "positivoSeguro".
    //   • Métodos:
    //       - area() = base*altura
    //       - perimetro() = 2*(base+altura)
    //   • toString() legible.
    //
    // DEMO LITE:
    //   • Pide base y altura y muestra área/perímetro.
    //
    // * Sugerencia:
    //   Empieza por los atributos y constructores → luego set/get → luego los métodos.
    // =====================================================================================
    static class RectanguloLite {
      private double base;
      private double altura;

      public RectanguloLite() {
        // TODO: inicializa a 1 y 1
        this.base = 1;
        this.altura = 1;
      }

      public RectanguloLite(double base, double altura) {
        // TODO: usa setBase/setAltura para aprovechar la validación
        setBase(base);
        setAltura(altura);
      }

      public double getBase()   { return base; }
      public double getAltura() { return altura; }

      public void setBase(double base)   { this.base   = positivoSeguro(base, "Base"); }
      public void setAltura(double altura){ this.altura = positivoSeguro(altura, "Altura"); }

      private double positivoSeguro(double v, String nombreCampo) {
        // ! Si v <= 0, corrige a 0.1 y avisa
        if (v <= 0) {
          System.out.println("⚠️ " + nombreCampo + " inválida; se ajusta a 0.1 (RectanguloLite)");
          return 0.1;
        }
        return v;
      }

      public double area()      { return base * altura; }
      public double perimetro() { return 2 * (base + altura); }

      @Override public String toString() {
        return String.format("[RectanguloLite] base=%.2f, altura=%.2f, área=%.2f, perímetro=%.2f",
          base, altura, area(), perimetro());
      }
    }

    // ✳️ Mini demo para RectanguloLite (el alumno puede llamarla desde el menú principal si quiere)
    public static void demoLite(Scanner sc) {
      System.out.println("\n\033[1;35m--- RETO NUEVO: RectanguloLite ---\033[0m");
      RectanguloLite r = new RectanguloLite();
      System.out.print("Base: ");
      r.setBase(leerDouble(sc));
      System.out.print("Altura: ");
      r.setAltura(leerDouble(sc));
      System.out.println(r);
    }

    /*
     * 🧪 PRÁCTICA EXTRA: Validar que el nuevo nombre no exista ya (EJEMPLO GENÉRICO)
     * -----------------------------------------------------------
     * Si más adelante manejas colecciones (por ejemplo, una lista de figuras con un "nombre"),
     * podrías evitar duplicados al modificar:
     *
     * for (Figura f : listaFiguras) {
     *   if (f.getNombre().equalsIgnoreCase(nuevoNombre)) {
     *     System.out.println("❌ Ya existe una figura con ese nombre.");
     *     return; // o lanza excepción
     *   }
     * }
     *
     * ✅ Refuerza:
     * - Validación previa
     * - Búsqueda y comparación dentro de estructuras
     */
  }


    // =======================================================================================
  // 🟦 EJERCICIO 2 · FECHA (MEJORADO · DIDÁCTICO + BETTER COMMENTS)
  // ---------------------------------------------------------------------------------------
  // ENUNCIADO (resumen mejorado):
  //   Clase Fecha con atributos privados int: dia, mes, anio. Encapsulación con set/get.
  //   Reglas mínimas de validación:
  //     • Si día ∉ [1..31] => 1  |  Si mes ∉ [1..12] => 1  |  anio sin restricción.
  //   Constructores:
  //     • () → inicializa a 01/01/2000 (coherente).
  //     • (d,m,a) → usa setters (aplican validación).
  //   Métodos:
  //     • fechaFormateada(boolean numerica): "dd/mm/aaaa" (true) o "1 de enero de 2000" (false).
  //     • static diferenciaFechas(Fecha f1, Fecha f2) → años (valor absoluto).
  //     • (extra) static diferenciaDiasAprox(Fecha f1, Fecha f2) → días aproximados (28/29/30/31).
  //
  // OBJETIVOS DIDÁCTICOS:
  //   1) Encapsulación con validación simple.
  //   2) Sobrecarga de constructores.
  //   3) Métodos estáticos de utilidad que operan con objetos del mismo tipo.
  //
  // EXTRA (después de entender todo):
  //   A) fromString("dd/mm/aaaa" | "dd-mm-aaaa")  → Fecha   (implementado).
  //   B) compareTo(Fecha) y equals/hashCode       → ordenar/comparar (implementado).
  //   C) toISO() → "aaaa-mm-dd"                   (implementado).
  //   D) suma/dif de fechas con java.time.LocalDate (PROPUESTO para que lo intente el alumno).
  //
  // RETO NUEVO (más fácil, desde cero):
  //   • Implementa FechaLite (ver abajo): solo dia, mes, anio; formato corto, validación básica
  //     y un pequeño demoLite(). Sin extras complejos.
  //
  // Better Comments (VS Code):
  //   // ! importante/alerta   // ? duda/pista   // TODO tarea pendiente   // * idea/nota   // ✅ logrado
  // =======================================================================================
  static class E2_Fecha {

    // =====================================================================================
    // 🔧 CLASE · Fecha
    // -------------------------------------------------------------------------------------
    // * Encapsulación + validación mínima en setDia/setMes
    // * equals/hashCode/compareTo para poder comparar/ordenar fechas
    // =====================================================================================
    static class Fecha {
      private int dia, mes, anio;

      // -----------------------------------------------------------------------------------
      // 🏗️ Constructores
      // -----------------------------------------------------------------------------------
      public Fecha() {              // * Valores coherentes por defecto
        this(1, 1, 2000);
      }
      public Fecha(int dia, int mes, int anio) {
        setDia(dia);
        setMes(mes);
        setAnio(anio);
      }

      // -----------------------------------------------------------------------------------
      // 🔐 Getters/Setters
      // -----------------------------------------------------------------------------------
      public int getDia()  { return dia; }
      public int getMes()  { return mes; }
      public int getAnio() { return anio; }

      public void setDia(int dia) {
        this.dia = (dia >= 1 && dia <= 31) ? dia : 1;
      }
      public void setMes(int mes) {
        this.mes = (mes >= 1 && mes <= 12) ? mes : 1;
      }
      public void setAnio(int anio) {
        this.anio = anio; // enunciado: sin restricciones
      }

      // -----------------------------------------------------------------------------------
      // 🧮 Formato y utilidades
      // -----------------------------------------------------------------------------------
      public String fechaFormateada(boolean numerica) {
        if (numerica) {
          return String.format("%02d/%02d/%04d", dia, mes, anio);
        } else {
          String[] meses = {
            "enero","febrero","marzo","abril","mayo","junio",
            "julio","agosto","septiembre","octubre","noviembre","diciembre"
          };
          return String.format("%d de %s de %d", dia, meses[mes - 1], anio);
        }
      }

      public String toISO() { // extra: formato normalizado
        return String.format("%04d-%02d-%02d", anio, mes, dia);
      }

      public static int diferenciaFechas(Fecha f1, Fecha f2) {
        return Math.abs(f1.anio - f2.anio);
      }

      // Extra opcional: diferencia aproximada de días (cuenta bisiestos 29)
      public static int diferenciaDiasAprox(Fecha f1, Fecha f2) {
        int dias1 = toDiasAprox(f1);
        int dias2 = toDiasAprox(f2);
        return Math.abs(dias1 - dias2);
      }

      private static int toDiasAprox(Fecha f) {
        int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (esBisiesto(f.anio)) diasMes[1] = 29;
        int total = f.dia;
        for (int i = 0; i < f.mes - 1; i++) total += diasMes[i];
        // * aproximación a “días desde 0”:
        total += f.anio * 365 + cuentaBisiestosHasta(f.anio - 1);
        return total;
      }
      private static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
      }
      private static int cuentaBisiestosHasta(int year) {
        // número de años bisiestos desde el año 0 hasta 'year' inclusive
        return year / 4 - year / 100 + year / 400;
      }

      // -----------------------------------------------------------------------------------
      // 🔁 Comparación/ordenación (útil en colecciones)
      // -----------------------------------------------------------------------------------
      public int compareTo(Fecha o) {
        if (anio != o.anio) return Integer.compare(anio, o.anio);
        if (mes  != o.mes)  return Integer.compare(mes,  o.mes);
        return Integer.compare(dia,  o.dia);
      }
      @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fecha)) return false;
        Fecha o = (Fecha) obj;
        return dia == o.dia && mes == o.mes && anio == o.anio;
      }
      @Override public int hashCode() { return Objects.hash(dia, mes, anio); }
      @Override public String toString() { return fechaFormateada(true); }

      // -----------------------------------------------------------------------------------
      // 🧰 Extra: parseo desde texto
      // -----------------------------------------------------------------------------------
      public static Fecha fromString(String s) {
        if (s == null) throw new IllegalArgumentException("Cadena nula");
        String[] p = s.trim().split("[/\\-\\s]+");
        if (p.length != 3) throw new IllegalArgumentException("Formato esperado dd/mm/aaaa");
        int d = Integer.parseInt(p[0]);
        int m = Integer.parseInt(p[1]);
        int a = Integer.parseInt(p[2]);
        return new Fecha(d, m, a); // setters aplican validación de rango
      }
    }

    // =====================================================================================
    // 🧪 DEMO INTERACTIVA (EJECUTABLE)
    // -------------------------------------------------------------------------------------
    // * Soluciona el fallo: ahora existe pedirFecha(Scanner) robusto:
    //   - Acepta "dd/mm/aaaa", "dd-mm-aaaa" o introduce por pasos (día, mes, año).
    // * Se muestran formato corto y largo, y diferencias en años y días (extra).
    // =====================================================================================
    public static void demo(Scanner sc) {
      System.out.println("\n\033[1;36m--- EJERCICIO 2: FECHA (MEJORADO) ---\033[0m");

      System.out.println("Introduce primera fecha:");
      Fecha f1 = pedirFecha(sc);

      System.out.println("Introduce segunda fecha:");
      Fecha f2 = pedirFecha(sc);

      System.out.println("Formato corto: " + f1.fechaFormateada(true)  + " | " + f2.fechaFormateada(true));
      System.out.println("Formato largo: " + f1.fechaFormateada(false) + " | " + f2.fechaFormateada(false));

      System.out.println("Diferencia de años (abs): " + Fecha.diferenciaFechas(f1, f2));
      System.out.println("Diferencia aprox de días: " + Fecha.diferenciaDiasAprox(f1, f2) + " (extra)");
    }

    // =====================================================================================
    // 🧰 pedirFecha() — entrada de datos amigable y tolerante a formatos
    // -------------------------------------------------------------------------------------
    // ! Arregla el fallo que tenías: antes no existía este método; ahora se integra y valida.
    // ? Tips: acepta "dd/mm/aaaa" o "dd-mm-aaaa". Si dejas en blanco, lo pide por pasos.
    // =====================================================================================
    private static Fecha pedirFecha(Scanner sc) {
      while (true) {
        System.out.print("Fecha (dd/mm/aaaa ó Enter para introducir por pasos): ");
        String s = sc.nextLine().trim();

        // A) Cadena con separadores
        if (!s.isEmpty()) {
          try {
            return Fecha.fromString(s);
          } catch (Exception e) {
            System.out.println("⚠️ Formato no válido. Ejemplos: 01/12/1999, 1-1-2000");
            continue;
          }
        }

        // B) Introducción por pasos
        try {
          System.out.print("  Día (1..31): ");
          int d = BoletinPOO_Completo.leerEntero(sc);

          System.out.print("  Mes (1..12): ");
          int m = BoletinPOO_Completo.leerEntero(sc);

          System.out.print("  Año: ");
          int a = BoletinPOO_Completo.leerEntero(sc);

          return new Fecha(d, m, a); // setters corrigen fuera de rango a 1
        } catch (Exception ex) {
          System.out.println("⚠️ Entrada inválida; inténtalo de nuevo.");
        }
      }
    }

    // =====================================================================================
    // 🎯 RETO NUEVO · FechaLite (más fácil, para hacer desde cero)
    // -------------------------------------------------------------------------------------
    // REQUISITOS:
    //   • Atributos privados: dia, mes, anio.
    //   • Constructores: () → 1/1/2000,  (d,m,a).
    //   • set/get con misma validación básica del enunciado.
    //   • Métodos: formatoCorto() "dd/mm/aaaa".
    //   • toString() → formato corto.
    //   • demoLite(): pedir por pasos y mostrar formato.
    // =====================================================================================
    static class FechaLite {
      private int dia, mes, anio;
      public FechaLite() { this(1,1,2000); }
      public FechaLite(int d, int m, int a) { setDia(d); setMes(m); setAnio(a); }

      public int getDia(){ return dia; }
      public int getMes(){ return mes; }
      public int getAnio(){ return anio; }

      public void setDia(int d){ this.dia = (d>=1 && d<=31)? d : 1; }
      public void setMes(int m){ this.mes = (m>=1 && m<=12)? m : 1; }
      public void setAnio(int a){ this.anio = a; }

      public String formatoCorto(){ return String.format("%02d/%02d/%04d", dia, mes, anio); }
      @Override public String toString(){ return formatoCorto(); }
    }

    // ✳️ Mini demo para FechaLite (el alumno puede llamarla desde menú si lo añades)
    public static void demoLite(Scanner sc) {
      System.out.println("\n\033[1;35m--- RETO NUEVO: FechaLite ---\033[0m");
      FechaLite f = new FechaLite();
      System.out.print("  Día: ");  f.setDia(BoletinPOO_Completo.leerEntero(sc));
      System.out.print("  Mes: ");  f.setMes(BoletinPOO_Completo.leerEntero(sc));
      System.out.print("  Año: ");  f.setAnio(BoletinPOO_Completo.leerEntero(sc));
      System.out.println("FechaLite → " + f);
    }

    /* 
     * TODO PROPUESTA PARA EL ALUMNO (ampliación con java.time):
     * - Implementa:
     *     public long diferenciaDiasJavaTime(Fecha otra)
     *     public Fecha sumarDiasJavaTime(int dias)
     *   con LocalDate.of(anio, mes, dia) y Period/ChronoUnit.DAYS.
     * ✅ Así refuerza: uso de librería estándar moderna para fechas y robustez real.
     */
  }

    // =======================================================================================
  // 🟨 EJERCICIO 3 · PROYECTO EMPRESA I (MEJORADO · DIDÁCTICO + BETTER COMMENTS)
  // ---------------------------------------------------------------------------------------
  // ENUNCIADO (resumen mejorado):
  //   • Clase Empleado con: nombre, apellidos, edad, dni, salarioAnual y %irpf (solo get).
  //   • Al cambiar salario → recalcula IRPF:
  //       salario <  6000  → 7.5
  //       6000..30000      → 15
  //       > 30000          → 20
  //   • Constructores: vacío (""/0) y con parámetros (usar setters).
  //   • Método dineroHacienda(): salario * irpf/100.
  //   • Clase IUEmpleado (vista): mostrar(), pedir(), mostrar(int campo) → (1..5).
  //
  // OBJETIVOS DIDÁCTICOS:
  //   1) Encapsulación + reglas de negocio (recalcular IRPF).
  //   2) Diseño de “Vista” separada (IU) y clase de dominio (Empleado).
  //   3) Formateo y validación de entrada (edad >= 0, salario >= 0).
  //
  // EXTRA (cuando el alumno ya lo entienda):
  //   A) netoAnual(): salario - dineroHacienda()
  //   B) salarioMensualBruto()/Neto(): dividir entre 12 (2 decimales).
  //   C) subirSueldo(double porcentaje): aplica incremento y recalcula IRPF.
  //   D) fromString("Nombre;Apellidos;Edad;DNI;Salario"): factoría con validación.
  //   E) (opcional) Validar DNI/NIF simple (formato) y/o equals/hashCode por DNI.
  //
  // RETO NUEVO (más fácil, desde cero):
  //   • Implementa EmpleadoLite (ver al final): solo nombre, salario, IRPF auto y dineroHacienda().
  //     Incluye demoLite() para probarlo de forma rápida con el alumno.
  //
  // Better Comments (VS Code):
  //   // ! importante/alerta   // ? pista   // TODO tarea   // * idea/nota   // ✅ logrado
  // =======================================================================================
  static class E3_Empleado_IU {

    // =====================================================================================
    // 🔧 CLASE · Empleado
    // -------------------------------------------------------------------------------------
    // * Encapsula datos + lógica de IRPF. Evita estados inválidos (edad < 0, salario < 0).
    // * Añadimos utilidades didácticas (neto, mensual, subida), marcadas como EXTRA.
    // =====================================================================================
    static class Empleado {
      private String nombre;
      private String apellidos;
      private int    edad;
      private String dni;
      private double salarioAnual;
      private double irpf; // % calculado automáticamente

      // -----------------------------------------------------------------------------------
      // 🏗️ Constructores
      // -----------------------------------------------------------------------------------
      public Empleado() {
        this("", "", 0, "", 0);
      }
      public Empleado(String nombre, String apellidos, int edad, String dni, double salarioAnual) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDni(dni);
        setSalarioAnual(salarioAnual); // recalcula IRPF
      }

      // -----------------------------------------------------------------------------------
      // 🔐 Getters/Setters (validación mínima)
      // -----------------------------------------------------------------------------------
      public String getNombre() { return nombre; }
      public void setNombre(String nombre) { this.nombre = (nombre != null) ? nombre.trim() : ""; }

      public String getApellidos() { return apellidos; }
      public void setApellidos(String apellidos) { this.apellidos = (apellidos != null) ? apellidos.trim() : ""; }

      public int getEdad() { return edad; }
      public void setEdad(int edad) { this.edad = Math.max(0, edad); } // ! no negativos

      public String getDni() { return dni; }
      public void setDni(String dni) { this.dni = (dni != null) ? dni.trim() : ""; } // ? (extra) validar formato

      public double getSalarioAnual() { return salarioAnual; }
      public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = Math.max(0, salarioAnual); // ! no negativos
        recalcularIRPF();
      }

      public double getIrpf() { return irpf; }

      // -----------------------------------------------------------------------------------
      // 🧮 Reglas de negocio
      // -----------------------------------------------------------------------------------
      private void recalcularIRPF() {
        if (salarioAnual < 6000) irpf = 7.5;
        else if (salarioAnual <= 30000) irpf = 15.0;
        else irpf = 20.0;
      }

      public double dineroHacienda() { // ✅ pedido en enunciado
        return salarioAnual * (irpf / 100.0);
      }

      // -----------------------------------------------------------------------------------
      // ➕ EXTRA (para después de entender lo básico)
      // -----------------------------------------------------------------------------------
      public double netoAnual() {                 // A
        return salarioAnual - dineroHacienda();
      }
      public double salarioMensualBruto() {       // B
        return round2(salarioAnual / 12.0);
      }
      public double salarioMensualNeto() {        // B
        return round2(netoAnual() / 12.0);
      }
      public void subirSueldo(double porcentaje) { // C
        // ! si % <= -100 → evitar dejar el salario en <= 0
        double factor = 1.0 + (porcentaje / 100.0);
        if (factor <= 0) {
          System.out.println("⚠️ Incremento inválido; no se aplica.");
          return;
        }
        setSalarioAnual(salarioAnual * factor); // set → recalcula IRPF
      }

      public static Empleado fromString(String linea) { // D
        // Espera: "Nombre;Apellidos;Edad;DNI;Salario"
        if (linea == null) throw new IllegalArgumentException("Cadena nula");
        String[] p = linea.split(";");
        if (p.length != 5) throw new IllegalArgumentException("Formato esperado: Nombre;Apellidos;Edad;DNI;Salario");
        String nombre = p[0].trim();
        String apell  = p[1].trim();
        int edad      = Integer.parseInt(p[2].trim());
        String dni    = p[3].trim();
        double sal    = Double.parseDouble(p[4].trim().replace(",", "."));
        return new Empleado(nombre, apell, edad, dni, sal);
      }

      private static double round2(double v) { return Math.round(v * 100.0) / 100.0; }

      @Override public String toString() {
        return String.format("👤 %s %s | %d años | DNI: %s | 💶 Bruto: %.2f€ | IRPF: %.1f%% | 🏛️ Hacienda: %.2f€",
          nombre, apellidos, edad, dni, salarioAnual, irpf, dineroHacienda());
      }

      // (opcional) equals/hashCode por DNI
      // @Override public boolean equals(Object o){...}
      // @Override public int hashCode(){...}
    }

    // =====================================================================================
    // 🪟 VISTA · IUEmpleado
    // -------------------------------------------------------------------------------------
    // * Única responsabilidad: interacción por consola.
    // * Formatea salida y reutiliza BoletinPOO_Completo.leerEntero/leerDouble.
    // =====================================================================================
    static class IUEmpleado {
      public Empleado empleado; // público según enunciado

      public IUEmpleado(Empleado e) { this.empleado = e; }

      public void mostrar() {
        System.out.println(empleado.toString());
        System.out.printf("📉 Neto anual: %.2f€ | 📅 Bruto/mes: %.2f€ | Neto/mes: %.2f€%n",
          empleado.netoAnual(), empleado.salarioMensualBruto(), empleado.salarioMensualNeto());
      }

      public void pedir(Scanner sc) {
        System.out.print("Nombre: ");        empleado.setNombre(sc.nextLine());
        System.out.print("Apellidos: ");     empleado.setApellidos(sc.nextLine());
        System.out.print("Edad: ");          empleado.setEdad(leerEntero(sc));
        System.out.print("DNI: ");           empleado.setDni(sc.nextLine());
        System.out.print("Salario anual: "); empleado.setSalarioAnual(leerDouble(sc));
      }

      public void mostrar(int campo) {
        switch (campo) {
          case 1:
            System.out.println("👤 " + empleado.getNombre() + " " + empleado.getApellidos());
            break;
          case 2:
            System.out.println("🎂 Edad: " + empleado.getEdad());
            break;
          case 3:
            System.out.println("🪪 DNI: " + empleado.getDni());
            break;
          case 4:
            System.out.printf("💶 Salario: %.2f € | IRPF: %.1f%%%n", empleado.getSalarioAnual(), empleado.getIrpf());
            break;
          case 5:
            System.out.printf("🏛️ Hacienda: %.2f €%n", empleado.dineroHacienda());
            break;
          default:
            System.out.println("Campo no válido [1..5].");
        }
      }

      // ✚ Mini menú opcional para clase (modificar salario / subir sueldo)
      public void miniMenuSalario(Scanner sc) {
        while (true) {
          System.out.println("\n-- Salario --");
          System.out.println("1) Cambiar salario anual");
          System.out.println("2) Subir sueldo (%)");
          System.out.println("0) Volver");
          System.out.print("Opción: ");
          String op = sc.nextLine().trim();
          if ("1".equals(op)) {
            System.out.print("Nuevo salario anual: ");
            empleado.setSalarioAnual(leerDouble(sc));
            System.out.println("Actualizado → " + empleado);
          } else if ("2".equals(op)) {
            System.out.print("Porcentaje (+/-): ");
            double p = leerDouble(sc);
            empleado.subirSueldo(p);
            System.out.println("Actualizado → " + empleado);
          } else if ("0".equals(op)) {
            return;
          } else System.out.println("Opción no válida.");
        }
      }
    }

    // =====================================================================================
    // 🧪 DEMO (EJECUTABLE)
    // -------------------------------------------------------------------------------------
    // * Pide datos, muestra ficha completa y permite ver un campo individual.
    // * Incluye un mini-menú de salario para jugar en clase con IRPF y netos.
    // =====================================================================================
    public static void demo(Scanner sc) {
      System.out.println("\n\033[1;36m--- EJERCICIO 3: EMPRESA I (MEJORADO) ---\033[0m");

      Empleado emp = new Empleado();
      IUEmpleado iu = new IUEmpleado(emp);

      System.out.println("Introduce los datos del empleado:");
      iu.pedir(sc);

      System.out.println("\n📋 Ficha completa:");
      iu.mostrar();

      System.out.print("\n¿Ver campo individual? (1..5, 0 para omitir): ");
      int c = leerEntero(sc);
      if (c != 0) iu.mostrar(c);

      // ? Probar reglas de negocio con un menú corto
      System.out.print("\n¿Abrir mini-menú de salario? (s/n): ");
      String s = sc.nextLine().trim().toLowerCase();
      if (s.startsWith("s")) iu.miniMenuSalario(sc);

      // * Demostración fromString (útil como práctica guiada)
      System.out.print("\n¿Crear otro empleado desde cadena 'Nombre;Apellidos;Edad;DNI;Salario'? (s/n): ");
      String s2 = sc.nextLine().trim().toLowerCase();
      if (s2.startsWith("s")) {
        System.out.print("Cadena: ");
        String linea = sc.nextLine();
        try {
          Empleado e2 = Empleado.fromString(linea);
          System.out.println("✅ Creado: " + e2);
        } catch (Exception ex) {
          System.out.println("⚠️ Formato inválido: " + ex.getMessage());
        }
      }
    }

    // =====================================================================================
    // 🎯 RETO NUEVO · EmpleadoLite (más fácil, para que lo haga el alumno desde cero)
    // -------------------------------------------------------------------------------------
    // REQUISITOS:
    //   • Atributos: nombre (String), salario (double).
    //   • IRPF auto con las mismas franjas (método privado recalcularIRPF()).
    //   • Constructores: vacío ("", 0) y con parámetros.
    //   • Métodos: dineroHacienda(), toString().
    //   • demoLite(): pedir datos y mostrar resultado.
    // =====================================================================================
    static class EmpleadoLite {
      private String nombre;
      private double salario;
      private double irpf;

      public EmpleadoLite() { this("", 0); }
      public EmpleadoLite(String nombre, double salario) {
        setNombre(nombre);
        setSalario(salario);
      }

      public String getNombre() { return nombre; }
      public void setNombre(String nombre) { this.nombre = (nombre != null) ? nombre.trim() : ""; }

      public double getSalario() { return salario; }
      public void setSalario(double salario) {
        this.salario = Math.max(0, salario);
        recalcularIRPF();
      }

      public double getIrpf() { return irpf; }
      private void recalcularIRPF() {
        if (salario < 6000) irpf = 7.5;
        else if (salario <= 30000) irpf = 15.0;
        else irpf = 20.0;
      }

      public double dineroHacienda() { return salario * (irpf/100.0); }

      @Override public String toString() {
        return String.format("[EmpleadoLite] %s | Salario: %.2f€ | IRPF: %.1f%% | Hacienda: %.2f€",
          nombre, salario, irpf, dineroHacienda());
      }
    }

    // ✳️ Mini demo para EmpleadoLite (puedes añadir opción en el menú principal si quieres)
    public static void demoLite(Scanner sc) {
      System.out.println("\n\033[1;35m--- RETO NUEVO: EmpleadoLite ---\033[0m");
      EmpleadoLite e = new EmpleadoLite();
      System.out.print("Nombre: ");
      e.setNombre(sc.nextLine());
      System.out.print("Salario anual: ");
      e.setSalario(leerDouble(sc));
      System.out.println(e);
    }

    /*
     * 🧪 PRÁCTICA EXTRA: Evitar duplicados por DNI en una lista
     * ---------------------------------------------------------
     * Supón que gestionas una List<Empleado> y quieres modificar el DNI de uno.
     * Antes de guardar, valida que no exista ya ese DNI:
     *
     * for (Empleado otro : empleados) {
     *   if (otro != actual && otro.getDni().equalsIgnoreCase(nuevoDni)) {
     *     System.out.println("❌ Ya existe un empleado con ese DNI.");
     *     return; // o lanza excepción
     *   }
     * }
     *
     * ✅ Refuerza:
     * - Validación previa a cambios
     * - Búsqueda y comparación en colecciones
     */
  }

  // =======================================================================================
// 🟧 EJERCICIO 4 · PROYECTO EMPRESA II (VERSIÓN DIDÁCTICA COMPLETA + BETTER COMMENTS)
// ---------------------------------------------------------------------------------------
// 🎯 OBJETIVOS DE APRENDIZAJE
//   1) Encapsular datos con validación y normalización (departamento en MAYÚSCULAS).
//   2) Separar responsabilidades: lógica de negocio (Directivo) vs IU (IUDirectivo).
//   3) Diseñar API con contratos claros (precondiciones/postcondiciones).
//   4) Practicar métodos que dependen de parámetros externos (beneficioEmpresa).
//
// 🧩 ENUNCIADO (ampliado y aclarado)
//   • Clase Directivo con atributos privados: nombre, apellidos, edad, dni, departamento, porcentajeBeneficio.
//   • Guardar departamento SIEMPRE en MAYÚSCULAS (al “leer” se devuelve entre comillas → “VENTAS”).
//   • porcentajeBeneficio ∈ [0,100]. Si llega fuera de rango → ajustar a 0 (o podrías lanzar excepción).
//   • Constructores: vacío y completo (usar setters).
//   • Método gananciaDirectivo(double beneficioEmpresa):
//       - Si beneficioEmpresa ≤ 0 → 0
//       - Si > 0 → beneficioEmpresa * (porcentajeBeneficio/100)
//
// 📌 DECISIONES DE DISEÑO (por qué así)
//   • Inmutabilidad parcial NO necesaria: el negocio quiere que IU pueda editar todos los campos.
//   • Normalizamos “departamento” en setDepartamento() → evitamos inconsistencias en toda la app.
//   • getDepartamento() devuelve texto ya “listo para mostrar” → UX cómoda en consola.
//
// 🧪 CÓMO PROBAR EN CLASE (sugerencia)
//   1) Crear directivo, introducir datos de teclado (incluye % fuera de rango para ver corrección).
//   2) Probar con beneficios negativos (debe dar 0).
//   3) Probar 3 escenarios de %: 0%, 25% y 100% con diferentes beneficios.
//   4) Abrir el mini-menú y modificar el % para ver el efecto rápido.
//
// 🟦 Better Comments guía rápida:
//   // ! importante/alerta   // ? pista/duda   // TODO tarea   // * nota/idea   // ✅ validado/ok
// =======================================================================================
static class E4_Directivo_IU {

  // =====================================================================================
  // 🧑‍💼 CLASE · Directivo (Dominio / Lógica de negocio)
  // -------------------------------------------------------------------------------------
  // * Reglas/invariantes:
  //   - edad ≥ 0
  //   - 0 ≤ porcentajeBeneficio ≤ 100  (si no, se ajusta a 0)  // ! decisión simple para principiantes
  //   - departamento se guarda SIEMPRE en mayúsculas
  // * Contratos:
  //   - setPorcentajeBeneficio(v): PRE v∈ℝ | POST this.porcentajeBeneficio ∈ [0,100] (o 0 si v inválido)
  //   - gananciaDirectivo(b): PRE b∈ℝ | POST retorna 0 si b ≤ 0; si b>0 retorna b*(%/100)
  // =====================================================================================
  static class Directivo {
    private String nombre, apellidos, dni;
    private int    edad;
    private String departamento;         // guardado en MAYÚSCULAS (invariante)
    private double porcentajeBeneficio;  // 0..100

    // -------------------------------------- //
    // 🏗️ Constructores (usan setters)
    // -------------------------------------- //
    public Directivo() {
      this("", "", 0, "", "", 0);
    }
    public Directivo(String nombre, String apellidos, int edad, String dni,
                     String departamento, double porcentajeBeneficio) {
      setNombre(nombre);
      setApellidos(apellidos);
      setEdad(edad);
      setDni(dni);
      setDepartamento(departamento);
      setPorcentajeBeneficio(porcentajeBeneficio);
    }

    // -------------------------------------- //
    // 🔐 Encapsulación + validaciones
    // -------------------------------------- //
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = (nombre!=null) ? nombre.trim() : ""; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = (apellidos!=null) ? apellidos.trim() : ""; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = Math.max(0, edad); }  // ! evitamos negativos

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = (dni!=null) ? dni.trim() : ""; } // ? extra: validar patrón

    // * UX: al “leer” departamento, pedían comillas -> las añadimos aquí
    public String getDepartamento() { return "\"" + departamento + "\""; }
    public void setDepartamento(String departamento) {
      if (departamento == null) departamento = "";
      // * Normalización en un único punto → coherencia en toda la app
      this.departamento = departamento.toUpperCase(Locale.ROOT);
    }

    public double getPorcentajeBeneficio() { return porcentajeBeneficio; }
    public void setPorcentajeBeneficio(double v) {
      if (v < 0 || v > 100) {
        System.out.println("⚠️ Porcentaje fuera de rango [0..100]. Se ajusta a 0.");
        v = 0;
      }
      this.porcentajeBeneficio = v;
    }

    // -------------------------------------- //
    // 🧮 Lógica de cálculo (negocio)
    // -------------------------------------- //
    /**
     * Calcula la ganancia del directivo en función del beneficio de la empresa.
     * PRE: beneficioEmpresa ∈ ℝ
     * POST: si beneficioEmpresa ≤ 0 → 0; si > 0 → beneficioEmpresa * (%/100)
     */
    public double gananciaDirectivo(double beneficioEmpresa) {
      if (beneficioEmpresa <= 0) return 0;
      return beneficioEmpresa * (porcentajeBeneficio / 100.0);
    }

    @Override
    public String toString() {
      return String.format("🧑‍💼 %s %s | %d años | DNI: %s | Dpto: %s | %,.2f %% beneficio",
        nombre, apellidos, edad, dni, getDepartamento(), porcentajeBeneficio);
    }

    // -----------------------------------------------------------------------------------
    // ➕ EXTRAS GUIADOS (para cuando ya entiende lo anterior)
    // -----------------------------------------------------------------------------------
    // TODO A) Añade salarioBase (double) y:
    //        - get/set con validación (≥0)
    //        - gananciaTotal(beneficioEmpresa) = salarioBase + gananciaDirectivo(beneficioEmpresa)
    // TODO B) Añade bonusFijo(double) y combínalo en gananciaTotal (si beneficio > 0).
    // TODO C) Implementa toCSV() → "nombre;apellidos;edad;dni;departamento;porcentaje"
    //         e implementa fromCSV(String) que cree el objeto validando cada campo.
    // TODO D) equals/hashCode por DNI (si la organización lo considera identificador único).
  }

  // =====================================================================================
  // 🖥️ CLASE · IUDirectivo (Interfaz de Usuario por Consola)
  // -------------------------------------------------------------------------------------
  // * Única responsabilidad: pedir datos por teclado y mostrarlos formateados.
  // * Reutiliza leerEntero/leerDouble del main (ya robustos con reintentos).
  // =====================================================================================
  static class IUDirectivo {
    public Directivo directivo; // (según enunciado) acceso público para la IU

    public IUDirectivo(Directivo d) { this.directivo = d; }

    public void mostrar() {
      System.out.println(directivo.toString());
    }

    public void pedir(Scanner sc) {
      // ? Pista: puedes dejar campos vacíos y luego editarlos en el mini-menú
      System.out.print("Nombre: ");              directivo.setNombre(sc.nextLine());
      System.out.print("Apellidos: ");           directivo.setApellidos(sc.nextLine());
      System.out.print("Edad: ");                directivo.setEdad(leerEntero(sc));
      System.out.print("DNI: ");                 directivo.setDni(sc.nextLine());
      System.out.print("Departamento: ");        directivo.setDepartamento(sc.nextLine());
      System.out.print("Porcentaje beneficio [0..100]: ");
      directivo.setPorcentajeBeneficio(leerDouble(sc));
    }

    // Mini-menú de práctica: editar % y recalcular con diferentes beneficios
    public void miniMenuBeneficio(Scanner sc) {
      while (true) {
        System.out.println("\n-- % Beneficio Directivo --");
        System.out.println("1) Cambiar porcentaje");
        System.out.println("2) Calcular ganancia con un beneficio dado");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        switch (op) {
          case "1":
            System.out.print("Nuevo % beneficio [0..100]: ");
            directivo.setPorcentajeBeneficio(leerDouble(sc));
            System.out.println("✅ Actualizado → " + directivo);
            break;
          case "2":
            System.out.print("Beneficio empresa: ");
            double ben = leerDouble(sc);
            System.out.printf("💼 Ganancia directivo: %.2f €%n", directivo.gananciaDirectivo(ben));
            break;
          case "0":
            return;
          default:
            System.out.println("Opción no válida.");
        }
      }
    }
  }

  // =====================================================================================
  // 🧪 DEMO (ejecutable desde el menú principal)
  // -------------------------------------------------------------------------------------
  // * Flujo sugerido en clase:
  //   1) Pedir datos
  //   2) Mostrar ficha
  //   3) Probar ganancia con un beneficio
  //   4) Abrir mini-menú para experimentar cambios
  // =====================================================================================
  public static void demo(Scanner sc) {
    System.out.println("\n\033[1;33m--- EJERCICIO 4: EMPRESA II (MEJORADO) ---\033[0m");
    Directivo d = new Directivo();
    IUDirectivo iu = new IUDirectivo(d);

    System.out.println("Introduce los datos del directivo:");
    iu.pedir(sc);

    System.out.print("Introduce el beneficio global de la empresa: ");
    double ben = leerDouble(sc);

    System.out.println("\n📋 Ficha del directivo:");
    iu.mostrar();
    System.out.printf("💼 Ganancia del directivo: %.2f €%n", d.gananciaDirectivo(ben));

    System.out.print("\n¿Abrir mini-menú de % beneficio? (s/n): ");
    if (sc.nextLine().trim().toLowerCase().startsWith("s")) {
      iu.miniMenuBeneficio(sc);
    }
  }

  // =====================================================================================
  // 🎯 RETO NUEVO (más fácil) · DirectivoLite — para hacer desde cero tras entenderlo
  // -------------------------------------------------------------------------------------
  // Requisitos:
  //   • Atributos: nombre (String), porcentajeBeneficio (double 0..100)
  //   • Constructores: vacío y con parámetros
  //   • Validación del porcentaje (mismo criterio que arriba)
  //   • Método gananciaDirectivo(beneficioEmpresa)
  //   • toString() sencillo + demoLite() para pedir/mostrar
  //   • Objetivo: simplificar al máximo para practicar la esencia
  // =====================================================================================
  static class DirectivoLite {
    private String nombre;
    private double porcentajeBeneficio;

    public DirectivoLite() { this("", 0); }
    public DirectivoLite(String nombre, double porcentajeBeneficio) {
      setNombre(nombre);
      setPorcentajeBeneficio(porcentajeBeneficio);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = (nombre!=null)? nombre.trim() : ""; }

    public double getPorcentajeBeneficio() { return porcentajeBeneficio; }
    public void setPorcentajeBeneficio(double v) {
      if (v < 0 || v > 100) {
        System.out.println("⚠️ % fuera de rango. Se ajusta a 0.");
        v = 0;
      }
      this.porcentajeBeneficio = v;
    }

    public double gananciaDirectivo(double beneficioEmpresa) {
      return (beneficioEmpresa > 0) ? beneficioEmpresa * (porcentajeBeneficio/100.0) : 0;
    }

    @Override public String toString() {
      return String.format("[DirectivoLite] %s | %,.2f %% beneficio", nombre, porcentajeBeneficio);
    }
  }

  // ✳️ Mini-demo del reto lite
  public static void demoLite(Scanner sc) {
    System.out.println("\n\033[1;35m--- RETO NUEVO: DirectivoLite ---\033[0m");
    DirectivoLite d = new DirectivoLite();
    System.out.print("Nombre: "); d.setNombre(sc.nextLine());
    System.out.print("% beneficio [0..100]: "); d.setPorcentajeBeneficio(leerDouble(sc));
    System.out.print("Beneficio empresa: "); double ben = leerDouble(sc);
    System.out.println(d);
    System.out.printf("💼 Ganancia: %.2f €%n", d.gananciaDirectivo(ben));
  }

  /* ==========================================================================
   * 📚 CHECKLIST PARA EL ALUMNO (repaso rápido)
   * --------------------------------------------------------------------------
   * [ ] He entendido por qué normalizamos el departamento en mayúsculas.
   * [ ] Puedo explicar el contrato de gananciaDirectivo(b).
   * [ ] Sé por qué validamos y corregimos el % fuera de rango.
   * [ ] He probado valores límite: % = 0, % = 100, beneficio = 0/negativo/positivo.
   * [ ] He implementado al menos un EXTRA (A, B, C o D) y lo he probado.
   * [ ] He completado DirectivoLite y lo he ejecutado con demoLite().
   *
   * 🧠 Pistas de ampliación:
   *  - Sustituye el “ajustar a 0” por lanzar IllegalArgumentException (manejar en IU).
   *  - Añade logs detallados (System.out.printf) para cada validación.
   *  - Internacionalización: devuelve el departamento sin comillas y deja el “estilo” a la IU.
   * ========================================================================== */
}

    // =======================================================================================
  // 🟥 EJERCICIO 5 · PROYECTO EMPRESA III (VERSIÓN DIDÁCTICA COMPLETA + BETTER COMMENTS)
  // ---------------------------------------------------------------------------------------
  // 🎯 OBJETIVOS
  //   1) Componer objetos: Empresa contiene un Directivo + 2 Empleados.
  //   2) Diseñar menús por consola con submenús (ver / modificar / pagar / cobrar).
  //   3) Aplicar reglas de negocio reutilizando API de ejercicios previos (IRPF, ganancias).
  //
  // 🧩 ENUNCIADO (ampliado)
  //   • Clase Empresa:
  //       - Atributos: ganancias (double), directivo (Directivo), emp1, emp2 (Empleado).
  //       - Constructores:
  //           (Directivo, Empleado, Empleado)   y
  //           (Directivo, Empleado, Empleado, ganancias)
  //       - Crear también IU de directivo/empleados en el constructor (para mostrar/pedir).
  //       - Menú principal:
  //           1) Ver datos empleados (submenú todos o un dato)
  //           2) Ver datos directivo (incluye la ganancia € del directivo)
  //           3) Modificar datos (directivo o uno de los empleados)
  //           4) Pagar (disminuye ganancias según sueldos)
  //           5) Cobrar (aumenta ganancias)
  //           6) Salir
  //
  // 📌 DECISIONES DE DISEÑO
  //   • “Ver directivo” usa las ganancias actuales de Empresa para calcular su ganancia.
  //   • “Pagar” por defecto descuenta los sueldos BRUTOS (enunciado simple). → Ofrecemos
  //     también “pagar NETO” en un submenú (EXTRA), aprovechando netoAnual() de Empleado.
  //   • Validamos “cobrar”: si cantidad ≤ 0 → avisar y no aplicar (didáctico).
  //
  // 🟦 Better Comments:
  //   // ! importante   // ? pista   // TODO tarea   // * nota   // ✅ ok
  // =======================================================================================
  static class E5_Empresa_Menu {

    // =====================================================================================
    // 🏢 CLASE · Empresa (Dominio)
    // -------------------------------------------------------------------------------------
    // * Invariantes:
    //   - directivo, emp1, emp2 ≠ null
    //   - ganancias ∈ ℝ (puede ser negativa → deuda)
    // * Contratos:
    //   - pagarSueldosBrutos(): POST ganancias -= (salarioAnual emp1 + emp2)
    //   - pagarSueldosNetos():  POST ganancias -= (netoAnual emp1 + emp2)   // ✅ extra
    //   - cobrar(c): PRE c>0 | POST ganancias += c
    // =====================================================================================
    static class Empresa {
      private double ganancias;
      private final E4_Directivo_IU.Directivo directivo;
      private final E3_Empleado_IU.Empleado emp1;
      private final E3_Empleado_IU.Empleado emp2;

      // IU asociadas (vista)
      private final E4_Directivo_IU.IUDirectivo iuDirectivo;
      private final E3_Empleado_IU.IUEmpleado iuEmp1;
      private final E3_Empleado_IU.IUEmpleado iuEmp2;

      // -------------------------------------- //
      // 🏗️ Constructores
      // -------------------------------------- //
      public Empresa(E4_Directivo_IU.Directivo d, E3_Empleado_IU.Empleado e1, E3_Empleado_IU.Empleado e2) {
        this(d, e1, e2, 0);
      }
      public Empresa(E4_Directivo_IU.Directivo d, E3_Empleado_IU.Empleado e1, E3_Empleado_IU.Empleado e2, double ganancias) {
        // ! precondición: objetos no nulos (omisión de null-check para simplificar)
        this.directivo = d;
        this.emp1 = e1;
        this.emp2 = e2;
        this.ganancias = ganancias;

        // IU vinculadas
        this.iuDirectivo = new E4_Directivo_IU.IUDirectivo(d);
        this.iuEmp1      = new E3_Empleado_IU.IUEmpleado(e1);
        this.iuEmp2      = new E3_Empleado_IU.IUEmpleado(e2);
      }

      // -------------------------------------- //
      // 🔐 Get/Set mínimos
      // -------------------------------------- //
      public double getGanancias() { return ganancias; }
      public void setGanancias(double g) { this.ganancias = g; }

      // -------------------------------------- //
      // 👁️ Mostrar datos (reutiliza IU)
      // -------------------------------------- //
      public void verDatosEmpleadosTodos() {
        System.out.println("\n\033[1;36m— EMPLEADO 1 —\033[0m");
        iuEmp1.mostrar();
        System.out.println("\n\033[1;36m— EMPLEADO 2 —\033[0m");
        iuEmp2.mostrar();
      }

      public void verDatosEmpleadosCampo(int campo) {
        System.out.println("\n\033[1;36m— EMPLEADO 1 —\033[0m");
        iuEmp1.mostrar(campo);
        System.out.println("\n\033[1;36m— EMPLEADO 2 —\033[0m");
        iuEmp2.mostrar(campo);
      }

      public void verDatosDirectivoConBeneficiosActuales() {
        iuDirectivo.mostrar();
        System.out.printf("💼 Ganancia del directivo con beneficios actuales (%.2f €): %.2f €%n",
          ganancias, directivo.gananciaDirectivo(ganancias));
      }

      // -------------------------------------- //
      // 🔧 Modificar (reutiliza IU)
      // -------------------------------------- //
      public void modificarDatos(Scanner sc, int quien) {
        if (quien == 1) {
          System.out.println("🔧 Modificando DIRECTIVO...");
          iuDirectivo.pedir(sc);
        } else if (quien == 2) {
          System.out.println("🔧 Modificando EMPLEADO 1...");
          iuEmp1.pedir(sc);
        } else if (quien == 3) {
          System.out.println("🔧 Modificando EMPLEADO 2...");
          iuEmp2.pedir(sc);
        } else {
          System.out.println("⚠️ Opción no válida.");
        }
      }

      // -------------------------------------- //
      // 💸 Operaciones económicas
      // -------------------------------------- //
      private double totalSueldosBrutos() {
        return emp1.getSalarioAnual() + emp2.getSalarioAnual();
      }
      private double totalSueldosNetos() { // ✅ extra (requiere netoAnual() del Ej.3 mejorado)
        return emp1.netoAnual() + emp2.netoAnual();
      }

      public void pagarSueldosBrutos() {
        double antes = ganancias;
        double total = totalSueldosBrutos();
        setGanancias(ganancias - total);
        System.out.printf("💸 Pagando SUELDOS BRUTOS… Antes: %.2f € | Total: %.2f € | Después: %.2f €%n",
          antes, total, ganancias);
      }

      public void pagarSueldosNetos() { // ✅ extra formativo
        double antes = ganancias;
        double total = totalSueldosNetos();
        setGanancias(ganancias - total);
        System.out.printf("💸 Pagando SUELDOS NETOS…  Antes: %.2f € | Total: %.2f € | Después: %.2f €%n",
          antes, total, ganancias);
      }

      public void cobrar(double cantidad) {
        if (cantidad <= 0) {
          System.out.println("⚠️ Cantidad a cobrar debe ser > 0 (ignorado).");
          return;
        }
        double antes = ganancias;
        setGanancias(ganancias + cantidad);
        System.out.printf("🧾 Cobro registrado. Antes: %.2f € | +%.2f € | Después: %.2f €%n",
          antes, cantidad, ganancias);
      }

      // -------------------------------------- //
      // 🧾 Resumen rápido (para informes)
      // -------------------------------------- //
      @Override public String toString() {
        return String.format("🏦 Empresa → Ganancias: %.2f € | Emp1: %.2f € | Emp2: %.2f € | Dir %%: %.1f%%",
          ganancias, emp1.getSalarioAnual(), emp2.getSalarioAnual(), directivo.getPorcentajeBeneficio());
      }
    }

    // =====================================================================================
    // 🧪 DEMO con MENÚ (ejecutable)
    // -------------------------------------------------------------------------------------
    // * Incluye submenú “Ver Empleados” (todos o un campo) y “Pagar” (brutos / netos).
    // * “Ver directivo” usa las ganancias actuales de la empresa para su cálculo.
    // =====================================================================================
    public static void demo(Scanner sc) {
      System.out.println("\n\033[1;31m--- EJERCICIO 5: EMPRESA III (MEJORADO) ---\033[0m");
      // Datos de partida (editables luego por menú)
      var d  = new E4_Directivo_IU.Directivo("Ana",   "López",   45, "12345678A", "Ventas", 5.0);
      var e1 = new E3_Empleado_IU.Empleado("Luis",   "Pérez",   30, "11111111B", 20000);
      var e2 = new E3_Empleado_IU.Empleado("Marta",  "García",  28, "22222222C", 24000);
      Empresa empresa = new Empresa(d, e1, e2, 100000);

      while (true) {
        System.out.println("\n========= MENÚ EMPRESA =========");
        System.out.println("1) Ver datos EMPLEADOS");
        System.out.println("2) Ver datos DIRECTIVO (con ganancia)");
        System.out.println("3) Modificar datos (1=Directivo, 2=Emp1, 3=Emp2)");
        System.out.println("4) Pagar sueldos");
        System.out.println("5) Cobrar (añadir ingresos)");
        System.out.println("6) Mostrar ganancias / resumen");
        System.out.println("0) Salir al menú principal");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        switch (op) {
          case "1": subMenuEmpleados(sc, empresa); break;
          case "2": empresa.verDatosDirectivoConBeneficiosActuales(); break;
          case "3":
            System.out.print("¿A quién modificar? (1=Directivo, 2=Emp1, 3=Emp2): ");
            int quien = leerEntero(sc);
            empresa.modificarDatos(sc, quien);
            break;
          case "4": subMenuPagar(sc, empresa); break;
          case "5":
            System.out.print("Cantidad a cobrar: ");
            double cant = leerDouble(sc);
            empresa.cobrar(cant);
            break;
          case "6":
            System.out.printf("🏦 Ganancias actuales: %.2f €%n", empresa.getGanancias());
            System.out.println(empresa);
            break;
          case "0": return;
          default: System.out.println("Opción inválida.");
        }
      }
    }

    // -------------------------------------- //
    // 📑 Submenú: ver empleados
    // -------------------------------------- //
    private static void subMenuEmpleados(Scanner sc, Empresa empresa) {
      while (true) {
        System.out.println("\n--- Ver datos empleados ---");
        System.out.println("1) Ver TODOS los datos de ambos");
        System.out.println("2) Ver un SOLO campo de ambos (1..5)");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
          empresa.verDatosEmpleadosTodos();
        } else if (op.equals("2")) {
          System.out.print("Campo (1=Nom+Ap, 2=Edad, 3=DNI, 4=Salario+IRPF, 5=Hacienda): ");
          int campo = leerEntero(sc);
          empresa.verDatosEmpleadosCampo(campo);
        } else if (op.equals("0")) {
          return;
        } else {
          System.out.println("Opción inválida.");
        }
      }
    }

    // -------------------------------------- //
    // 💳 Submenú: pagar sueldos (Bruto/ Neto)
    // -------------------------------------- //
    private static void subMenuPagar(Scanner sc, Empresa empresa) {
      while (true) {
        System.out.println("\n--- Pagar sueldos ---");
        System.out.println("1) Pagar BRUTOS");
        System.out.println("2) Pagar NETOS (extra formativo)");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
          empresa.pagarSueldosBrutos();
        } else if (op.equals("2")) {
          empresa.pagarSueldosNetos(); // ✅ usa netoAnual() del Ej.3 mejorado
        } else if (op.equals("0")) {
          return;
        } else {
          System.out.println("Opción inválida.");
        }
      }
    }

    // =====================================================================================
    // 🎯 RETO NUEVO (más fácil) · EmpresaLite — para que el alumno lo haga desde cero
    // -------------------------------------------------------------------------------------
    // Requisitos:
    //   • Atributos: ganancias (double), solo 1 Empleado.
    //   • Menú: ver empleado, modificar empleado, pagar (bruto), cobrar, mostrar ganancias, salir.
    //   • Sin directivo. Simplicidad máxima para practicar composición + menú.
    // =====================================================================================
    static class EmpresaLite {
      private double ganancias;
      private final E3_Empleado_IU.Empleado emp;
      private final E3_Empleado_IU.IUEmpleado iuEmp;

      public EmpresaLite(E3_Empleado_IU.Empleado emp, double ganancias) {
        this.emp = emp;
        this.ganancias = ganancias;
        this.iuEmp = new E3_Empleado_IU.IUEmpleado(emp);
      }

      public void verEmpleado() { iuEmp.mostrar(); }
      public void modificarEmpleado(Scanner sc) { iuEmp.pedir(sc); }
      public void pagarBruto() {
        double antes = ganancias;
        ganancias -= emp.getSalarioAnual();
        System.out.printf("💸 Pagar bruto: Antes %.2f | Después %.2f%n", antes, ganancias);
      }
      public void cobrar(double c) {
        if (c <= 0) { System.out.println("⚠️ Cantidad debe ser > 0"); return; }
        double antes = ganancias;
        ganancias += c;
        System.out.printf("🧾 Cobrar: Antes %.2f | Después %.2f%n", antes, ganancias);
      }
      public double getGanancias(){ return ganancias; }
    }

    public static void demoLite(Scanner sc) {
      System.out.println("\n\033[1;35m--- RETO NUEVO: EmpresaLite ---\033[0m");
      EmpresaLite el = new EmpresaLite(
        new E3_Empleado_IU.Empleado("Alumno", "Demo", 20, "X0000000", 12000),
        5000
      );
      while (true) {
        System.out.println("\n— EmpresaLite —");
        System.out.println("1) Ver empleado");
        System.out.println("2) Modificar empleado");
        System.out.println("3) Pagar bruto");
        System.out.println("4) Cobrar");
        System.out.println("5) Ver ganancias");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        switch (op) {
          case "1": el.verEmpleado(); break;
          case "2": el.modificarEmpleado(sc); break;
          case "3": el.pagarBruto(); break;
          case "4":
            System.out.print("Cantidad a cobrar: ");
            double c = leerDouble(sc);
            el.cobrar(c);
            break;
          case "5": System.out.printf("🏦 Ganancias: %.2f €%n", el.getGanancias()); break;
          case "0": return;
          default: System.out.println("Opción inválida.");
        }
      }
    }

    /* ==========================================================================
     * 📚 CHECKLIST PARA EL ALUMNO
     * --------------------------------------------------------------------------
     * [ ] Entiendo que “ver directivo” usa ganancias actuales para su ganancia.
     * [ ] Sé la diferencia entre pagar BRUTO y pagar NETO (extra).
     * [ ] He probado “cobrar” con valores límite (≤0 y >0).
     * [ ] He modificado datos y he visto recalcular IRPF en empleados.
     * [ ] He implementado al menos un EXTRA propuesto (por ejemplo, paga neta).
     * [ ] He completado EmpresaLite y la he probado con demoLite().
     * ========================================================================== */
  }

  // =======================================================================================
  // 🟪 EJERCICIO 6 (Opcional) · JUEGO CONVERSACIONAL (ESQUELETO)
  // ---------------------------------------------------------------------------------------
  // El objetivo es practicar diseño OO con un pequeño mapa de habitaciones enlazadas y
  // un protagonista con inventario simple. Aquí se ofrece un esqueleto mínimo para partir.
  // =======================================================================================
  static class E6_JuegoConversacional_Skel {
    // Clases mínimas
    static class Habitacion {
      String nombre;
      String descripcion;
      Habitacion norte, sur, este, oeste; // 4 salidas básicas
      List<String> objetos = new ArrayList<>();
      boolean puertaNorteCerrada, puertaSurCerrada, puertaEsteCerrada, puertaOesteCerrada;

      Habitacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
      }

      // 💡 Puedes añadir métodos: addObjeto, quitarObjeto, abrir/cerrar puertas, etc.
    }

    static class Protagonista {
      String nombre;
      int vidas = 3;
      List<String> inventario = new ArrayList<>();
      Habitacion actual;
      Protagonista(String nombre, Habitacion inicio) { this.nombre = nombre; this.actual = inicio; }
    }

    // 🔎 Pequeña demo guiada (1-2 acciones para mostrar la idea)
    public static void demo(Scanner sc) {
      System.out.println("\n--- OPCIONAL: JUEGO CONVERSACIONAL (ESQUELETO) ---");
      Habitacion sala = new Habitacion("Sala", "Una sala sencilla con una mesa.");
      Habitacion pasillo = new Habitacion("Pasillo", "Un pasillo angosto.");
      sala.este = pasillo; pasillo.oeste = sala;
      sala.objetos.add("llave");

      Protagonista p = new Protagonista("Héroe", sala);
      System.out.println("Estás en: " + p.actual.nombre + " · " + p.actual.descripcion);
      System.out.println("Ves: " + p.actual.objetos);

      System.out.print("Acción (coger llave / ir este): ");
      String acc = sc.nextLine().trim().toLowerCase();
      if (acc.contains("coger")) { p.inventario.add("llave"); sala.objetos.remove("llave"); System.out.println("Has cogido la llave."); }
      if (acc.contains("este")) { p.actual = p.actual.este; System.out.println("Ahora estás en: " + p.actual.nombre); }

      System.out.println("Inventario: " + p.inventario);
    }
  }

  // =======================================================================================
  // 🟫 EJERCICIO 7 (Opcional) · JUEGO POR TURNOS (ESQUELETO)
  // ---------------------------------------------------------------------------------------
  // Se propone practicar modelado de posición, distancias y combate sencillo entre
  // Guerrero (jugador) y Orco (CPU). Aquí va un esqueleto mínimo que respeta el espíritu.
  // =======================================================================================
  static class E7_JuegoTurnos_Skel {
    static class Posicion {
      int x, y; // origen (1,1) arriba-izquierda
      Posicion(int x, int y){ this.x=x; this.y=y; }
      void moverA(int x, int y){ this.x=x; this.y=y; }
      void desplazar(int dx, int dy){ this.x+=dx; this.y+=dy; }
      int distanciaManhattan(Posicion otra){ return Math.abs(x-otra.x)+Math.abs(y-otra.y); }
      double distanciaEuclid(Posicion otra){ return Math.hypot(x-otra.x, y-otra.y); }
    }

    static class Guerrero {
      int energia; boolean escudo; char arma; Posicion pos;
      Guerrero(int energia, boolean escudo, char arma, Posicion pos){
        this.energia=energia; this.escudo=escudo; this.arma=Character.toUpperCase(arma); this.pos=pos;
      }
      void recuperarse(int cant){ energia = Math.min(1000, energia + cant); }
      void atacar(Orco orco) {
        int d = (int)Math.round(pos.distanciaEuclid(orco.pos));
        int delta = 0, daño = 0;
        if (arma=='E') { // espada: 1-2 casillas
          if (d==1){ daño=100; delta=20; }
          else if (d==2){ daño=50; delta=10; }
        } else if (arma=='A') { // arco: 1..5
          if (d>=1 && d<=5){
            int[] base = {0,50,40,30,20,10};
            int[] deltas = {0,5,5,5,5,5};
            daño = base[d]; delta = deltas[d];
          }
        }
        if (daño>0){
          int rnd = new Random().nextInt(delta*2+1)-delta; // [-delta..+delta]
          int real = Math.max(0, daño + rnd);
          orco.recibirDanio(real);
          System.out.printf("🗡️ Guerrero ataca (d=%d) e inflige %d%n", d, real);
        } else {
          System.out.println("El ataque no alcanza al orco.");
        }
      }
    }

    static class Orco {
      int energia; int nivel; Posicion pos;
      Orco(int energia, int nivel, Posicion pos){ this.energia=energia; this.nivel=nivel; this.pos=pos; }
      void recuperarse(int cant){ energia = Math.min(1000, energia + cant + 10*nivel); }
      void recibirDanio(int dmg){ energia = Math.max(0, energia - dmg); }
      void atacar(Guerrero g){
        int d = (int)Math.round(pos.distanciaEuclid(g.pos));
        int alcance = 2 + (nivel/5); // cada 5 niveles +1 alcance
        if (d<1 || d>alcance){ System.out.println("El orco no alcanza al guerrero."); return; }
        int base = (d==1)?100:50;
        base += 10*nivel; // cada nivel +10
        if (d>1) base -= 50; // si ganó alcance extra, 50 menos en distancia mayor
        int delta = (d==1)?20:10;
        int rnd = new Random().nextInt(delta*2+1)-delta;
        int real = Math.max(0, base + rnd);
        if (g.escudo) real = (int)Math.round(real*0.7); // escudo reduce daño
        g.energia = Math.max(0, g.energia - real);
        System.out.printf("🪓 Orco (nivel %d) ataca (d=%d) e inflige %d%n", nivel, d, real);
      }
    }

    // 🔎 Versión simple: 1 turno de combate
    public static void demo(Scanner sc) {
      System.out.println("\n--- OPCIONAL: JUEGO POR TURNOS (ESQUELETO) ---");
      Guerrero player = new Guerrero(800, true, 'E', new Posicion(3,3));
      Orco cpu = new Orco(700, 2, new Posicion(4,3));
      System.out.printf("Estado inicial -> Guerrero:%d | Orco:%d%n", player.energia, cpu.energia);
      player.atacar(cpu);
      if (cpu.energia>0) cpu.atacar(player);
      System.out.printf("Estado final -> Guerrero:%d | Orco:%d%n", player.energia, cpu.energia);
    }
  }

  // =======================================================================================
  // 🧩 UTILIDADES COMUNES
  // =======================================================================================
  private static int leerEntero(Scanner sc){
    while (true){
      try { return Integer.parseInt(sc.nextLine().trim()); }
      catch(Exception e){ System.out.print("Introduce un entero válido: "); }
    }
  }
  private static double leerDouble(Scanner sc){
    while (true){
      try { return Double.parseDouble(sc.nextLine().trim().replace(",", ".")); }
      catch(Exception e){ System.out.print("Introduce un número válido: "); }
    }
  }
}
