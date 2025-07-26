import java.util.*;  // Importamos librerías necesarias

public class UT6_ColeccionesPractica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n📌 MENÚ PRINCIPAL");
            System.out.println("1️⃣ - Arrays Unidimensionales");
            System.out.println("2️⃣ - Arrays Bidimensionales");
            System.out.println("3️⃣ - ArrayList y Colecciones");
            System.out.println("0️⃣ - Salir");
            System.out.print("👉 Selecciona una opción: ");
            opcion = readInt(scanner);

            switch (opcion) {
                case 1 -> arraysUnidimensionales(scanner);
                case 2 -> arraysBidimensionales(scanner);
                case 3 -> demoArrayList(scanner);
                case 0 -> System.out.println("🚪 Saliendo del programa...");
                default -> System.out.println("⚠️ Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // 📌 SECCIÓN 1: ARRAYS UNIDIMENSIONALES (VECTORES)
    // =====================================================
    public static void arraysUnidimensionales(Scanner scanner) {
        System.out.println("\n🎨 **SECCIÓN 1: Arrays Unidimensionales (Vectores)**");
        System.out.println("------------------------------------------------------------");
        
        /*
         * 📖 TEORÍA:
         * - Un array unidimensional almacena múltiples valores del mismo tipo en posiciones consecutivas.
         * - Se accede a los elementos mediante un índice (inicia en 0).
         * - Se pueden recorrer con bucles `for` o `while`.
         */

        System.out.println("\n✅ EJEMPLO: Crear un array de 5 números, solicitarlos por teclado y mostrarlos.");
        
        int[] numeros = new int[5];
        System.out.println("🔹 Introduce 5 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("   Número " + (i + 1) + ": ");
            numeros[i] = readInt(scanner);
        }

        System.out.println("\n📊 Números ingresados: " + Arrays.toString(numeros));

        // Ejemplo adicional: Calcular suma total y determinar el mayor.
        int suma = 0, mayor = numeros[0];
        for (int num : numeros) {
            suma += num;
            if (num > mayor) mayor = num;
        }
        System.out.println("💡 Suma total: " + suma);
        System.out.println("💡 Número mayor: " + mayor);

        // 📝 **TAREA PARA EL ALUMNO**:
        // * Modifica el código para encontrar el número menor y calcular el promedio.
    }

    // =====================================================
    // 📌 SECCIÓN 2: ARRAYS BIDIMENSIONALES (MATRICES)
    // =====================================================
    public static void arraysBidimensionales(Scanner scanner) {
        System.out.println("\n🎨 **SECCIÓN 2: Arrays Bidimensionales (Matrices)**");
        System.out.println("------------------------------------------------------------");
        
        /*
         * 📖 TEORÍA:
         * - Una matriz organiza datos en filas y columnas.
         * - Se accede a cada elemento con dos índices: fila y columna.
         */

        System.out.println("\n✅ EJEMPLO: Crear una matriz 3x3, llenarla con números y mostrarla.");
        
        int[][] matriz = new int[3][3];

        System.out.println("🔹 Introduce valores para la matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("   Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = readInt(scanner);
            }
        }

        System.out.println("\n📊 Matriz ingresada:");
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }

        // Mostrar la diagonal principal
        System.out.print("💡 Diagonal principal: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(matriz[i][i] + " ");
        }

        // Calcular la suma total
        int sumaMatriz = Arrays.stream(matriz).flatMapToInt(Arrays::stream).sum();
        System.out.println("\n💡 Suma total: " + sumaMatriz);

        // 📝 **TAREA PARA EL ALUMNO**:
        // * Modifica el código para calcular la suma de cada fila y cada columna.
    }

    // =====================================================
    // 📌 SECCIÓN 3: DEMOSTRACIÓN DE ARRAYLIST (COLECCIONES)
    // =====================================================
    public static void demoArrayList(Scanner scanner) {
        System.out.println("\n🎨 **SECCIÓN 3: ArrayList y Colecciones**");
        System.out.println("------------------------------------------------------------");
        
        /*
         * 📖 TEORÍA:
         * - `ArrayList` permite almacenar datos dinámicos sin un tamaño fijo.
         * - Permite agregar y eliminar elementos de manera flexible.
         */

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        System.out.println("\n📊 Lista original: " + lista);

        // Eliminar un elemento
        lista.remove("C++");
        System.out.println("📌 Lista después de eliminar C++: " + lista);

        // Insertar en una posición específica
        lista.add(0, "JavaScript");
        System.out.println("📌 Lista después de agregar JavaScript al inicio: " + lista);

        // 📝 **TAREA PARA EL ALUMNO**:
        // * Crea un `ArrayList` de objetos "Alumno" (con nombre y nota).
        // * Muestra solo los alumnos con nota mayor o igual a 5.
    }

    // =====================================================
    // 📌 MÉTODO AUXILIAR PARA LEER ENTEROS
    // =====================================================
    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Ingresa un número válido.");
                scanner.next(); // Limpia la entrada inválida
            }
        }
    }
}
