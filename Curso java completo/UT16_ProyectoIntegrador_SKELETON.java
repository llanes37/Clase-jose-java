/******************************************************************************************
 *  📚 CURSO DE PROGRAMACIÓN EN JAVA
 *  📅 PROYECTO INTEGRADOR - SKELETON (ARREGLADO)
 *  🔐 EJERCICIO COMPLETO PARA HACER DESDE CERO
 ******************************************************************************************/

/*
 * ******************************************************************************************
 * 🧠 OBJETIVO:
 * ──────────────────────────────────────────────────────────────
 * El alumno debe crear un sistema de gestión de un CAMPUS UNIVERSITARIO.
 * Debe aplicar todo lo aprendido en POO:
 *   - Clases, constructores, getters/setters
 *   - Herencia, polimorfismo, interfaces
 *   - Manejo de excepciones
 *   - Uso de colecciones (ArrayList)
 *   - Modularidad y organización en varias clases
 *
 * 📌 Aquí solo tienes la estructura de las clases y el menú principal.
 * 📌 NO hay código implementado en la lógica, debes completarlo tú.
 * 📌 Cada parte está explicada con comentarios Better Comments.
 ******************************************************************************************
 */

import java.util.*;

/* =========================================================================================
   🟥 EXCEPCIONES PROPIAS
   ========================================================================================= */
class ValidationException extends Exception {
    // ! Lanza esta excepción cuando los datos no sean válidos (edad negativa, nota inválida…)
}

class NotFoundException extends Exception {
    // ! Lanza esta excepción cuando no se encuentre un objeto (ej: alumno inexistente)
}

class DuplicateException extends Exception {
    // ! Lanza esta excepción si se intenta registrar dos veces lo mismo
}

/* =========================================================================================
   🟧 INTERFACES
   ========================================================================================= */
interface Identificable {
    // ? Método para obtener un identificador único (ej: DNI, código alumno…)
    String getId();
}

interface Exportable {
    // ? Método para exportar datos del objeto a una cadena de texto (ej: CSV)
    String exportar();
}

/* =========================================================================================
   🟨 CLASE ABSTRACTA BASE: PERSONA
   ========================================================================================= */
abstract class Persona implements Identificable {
    // * Atributos comunes: nombre, edad, dni
    // TODO: Crear constructor, getters y setters
    // ✅ Método toString() sobrescrito
}

/* =========================================================================================
   🟩 CLASE ALUMNO (hereda de Persona)
   ========================================================================================= */
class Alumno extends Persona implements Exportable {
    // * Atributos: notaMedia, curso
    // TODO: Constructor vacío y completo
    // TODO: Implementar método exportar() → devuelve datos en formato CSV
}

/* =========================================================================================
   🟦 CLASE PROFESOR (hereda de Persona)
   ========================================================================================= */
class Profesor extends Persona implements Exportable {
    // * Atributos: departamento, especialidad
    // TODO: Constructor vacío y completo
    // TODO: Implementar método exportar()
}

/* =========================================================================================
   🟪 CLASE ASIGNATURA
   ========================================================================================= */
class Asignatura implements Identificable, Exportable {
    // * Atributos: código, nombre, créditos
    // TODO: Constructor, getters, setters
    // TODO: Implementar exportar()
}

/* =========================================================================================
   🟫 CLASE MATRICULA (relación Alumno-Asignatura)
   ========================================================================================= */
class Matricula {
    // * Atributos: Alumno, Asignatura, año académico
    // TODO: Constructor y getters
}

/* =========================================================================================
   ⬛ CLASE EVALUACION (nota de un alumno en una asignatura)
   ========================================================================================= */
class Evaluacion {
    // * Atributos: Alumno, Asignatura, nota
    // TODO: Constructor, getters y setters
}

/* =========================================================================================
   🟦 REPOSITORIO GENÉRICO (Memoria)
   ========================================================================================= */
class RepositorioMem<T extends Identificable> {
    // * Atributo: ArrayList<T>
    // TODO: Métodos CRUD → agregar, listar, buscarPorId, eliminar
    // ! Lanza DuplicateException si ya existe, NotFoundException si no encuentra
}

/* =========================================================================================
   🟧 SERVICIO PRINCIPAL: GESTOR DEL CAMPUS
   ========================================================================================= */
class GestorCampus {
    // * Atributos: repositorio de alumnos, profesores, asignaturas
    // TODO: Métodos de gestión (registrar alumno, asignar profesor, matricular alumno, evaluar alumno…)
    // TODO: Métodos de exportación de datos
}

/* =========================================================================================
   🟨 CLASE PRINCIPAL CON MENÚ
   ========================================================================================= */
public class UT16_ProyectoIntegrador_SKELETON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCampus gestor = new GestorCampus();

        int opcion;
        do {
            System.out.println("\n🎓 MENÚ PRINCIPAL - CAMPUS");
            System.out.println("1. Gestionar alumnos (💡 Aquí debes mostrar submenú para añadir, listar, buscar, eliminar)");
            System.out.println("2. Gestionar profesores (💡 Igual que con alumnos, CRUD completo)");
            System.out.println("3. Gestionar asignaturas (💡 Crear, listar y eliminar asignaturas)");
            System.out.println("4. Matricular alumno (💡 Relacionar Alumno con Asignatura)");
            System.out.println("5. Evaluar alumno (💡 Guardar nota de un alumno en una asignatura)");
            System.out.println("6. Exportar datos (💡 Mostrar todos los datos en formato CSV)");
            System.out.println("0. Salir");
            System.out.print("👉 Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
                switch (opcion) {
                    case 1:
                        // TODO: Llamar a métodos de gestión de alumnos
                        System.out.println("👉 [HUECO] Aquí implementarás la gestión de alumnos.");
                        break;
                    case 2:
                        // TODO: Gestión de profesores
                        System.out.println("👉 [HUECO] Aquí implementarás la gestión de profesores.");
                        break;
                    case 3:
                        // TODO: Gestión de asignaturas
                        System.out.println("👉 [HUECO] Aquí implementarás la gestión de asignaturas.");
                        break;
                    case 4:
                        // TODO: Matricular alumno en asignatura
                        System.out.println("👉 [HUECO] Aquí implementarás la matrícula de un alumno.");
                        break;
                    case 5:
                        // TODO: Evaluar alumno
                        System.out.println("👉 [HUECO] Aquí implementarás la evaluación de un alumno.");
                        break;
                    case 6:
                        // TODO: Exportar todos los datos
                        System.out.println("👉 [HUECO] Aquí implementarás la exportación de datos.");
                        break;
                    case 0:
                        System.out.println("👋 ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: debes escribir un número.");
                opcion = -1;
            }
        } while (opcion != 0);

        sc.close();
    }
}

/* =========================================================================================
   ✅ TAREAS PARA EL ALUMNO
   =========================================================================================
   1️⃣ Completar constructores, getters/setters y métodos pendientes.
   2️⃣ Implementar las interfaces (Identificable y Exportable).
   3️⃣ Implementar excepciones en los métodos CRUD.
   4️⃣ Completar el menú con todas las opciones funcionando.
   5️⃣ Probar con varios alumnos, profesores y asignaturas.
   6️⃣ Exportar datos a CSV y mostrar en consola.
   -----------------------------------------------------------------------------------------
   🔥 RETO EXTRA:
   - Añadir la clase "Curso" (ej: 1º DAM) que agrupe varias asignaturas y alumnos.
   - Permitir buscar alumnos por nota media.
   - Guardar/leer los datos de un archivo.
 ========================================================================================= */
