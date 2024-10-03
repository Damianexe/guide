import java.util.ArrayList;
import java.util.Scanner;

public class Burbuja {

    //Arraylist que almacenará la lista en la clase
    ArrayList<Integer> lista = new ArrayList<>();

    public void menu() {

        System.out.println("\nSeleccione el metodo a utilizar");
        System.out.println("1. Selección");
        System.out.println("2. Inserción");
        System.out.println("3. Salir\n");

        //Variable para almacenar la opcion
        Scanner teclado = new Scanner(System.in);

        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1 ->
                ordenarSeleccion();
            case 2 ->
                ordenarInsercion();
            case 3 ->
                System.exit(0);
            default -> {
                System.out.println("Introduzca una opcion correcta");
                System.exit(0);
            }
        }

    }

    //Método para ingresar los elementos
    public void ingresarValores() {

        System.out.println("MENU ADE APLICACIÓN DE ORDENAMIENTO");
        System.out.println("Métodos de Selección e Inserción");
        System.out.println("--------------------------------");

        //Variable para almacenar los datos a introducir
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de valores a analizar");

        //Variable que almacena el tamaño de la lista
        int cantidad = teclado.nextInt();

        //Ciclo for para ingresar los numeros
        for (int i = 0; i < cantidad; i++) {

            System.out.print("Ingrese el valor a guardar en la lista: ");
            int num = teclado.nextInt();
            lista.add(num);
        }

    }

    //Método de ordenamiento: Selección
    public void ordenarSeleccion() {

        //Variables a utilizar para el método
        int iter = 0;
        int cambio = 0;
        int j;

        //Ciclo de iteraciones e intercambios    
        for (int i = 0; i < lista.size() - 1; i++) {

            //Variable para determinar la primera repeticion de cada pasada
            int repeticion = 0;

            //Variable que almacena el elemento actual a comparar
            int a = i;

            for (j = i + 1; j < lista.size(); j++) {

                ArrayList<String> list = setSize(lista);

                if (repeticion == 0) {

                    System.out.println(lista + " Menor = " + a + " J = " + j + " a= " + lista.get(a) + " b = " + lista.get(j));

                } else {

                    list.set(a, lista.get(a).toString());
                    list.set(j, lista.get(j).toString());

                    //      list.set(a, lista.get(iter))
                    System.out.println(list + " Menor = " + a + " J = " + j + " a= " + lista.get(a) + " b = " + lista.get(j));

                }

                //Si el elemento es menor
                if (lista.get(j) < lista.get(a)) {

                    a = j;

                }
                //Contador de iteraciones totales
                iter = iter + 1;

                repeticion++;
            }

            //Condicional para realizar el intercambio
            if (a != i) {

                //Reemplazar los numeros correspondientes
                int num = lista.get(i);
                lista.set(i, lista.get(a));
                lista.set(a, num);

                //Contador de cambios realizados en las iteraciones
                cambio++;

            }
            System.out.println("");

        }

        //Imprimir la lista ordenada
        System.out.println(lista);
        System.out.println("Iteraciones: " + iter);
        System.out.println("Cambios: " + cambio);

    }

    //Método de ordenamiento: Inserción
    public void ordenarInsercion() {

        //3,7,-1,-2,8,0}
        int iteraciones = 0;
        int pasadas = 0;
        int cambios = 0;

        for (int j = 1; j < lista.size(); j++) {

            int num = lista.get(j);
            int i = j - 1;

            int repeticion = 0;

            if (num > lista.get(i)) {

                System.out.println(lista + "i: " + i + " j: " + (i + 1) + " a: " + lista.get(i) + " b: " + num + "\n");
            }

            while (i >= 0 && num < lista.get(i)) {

                ArrayList<String> list = setSize(lista);

                list.set(i, lista.get(i).toString());

                list.set(i + 1, String.valueOf(num));
                ;

                int a = lista.get(i);
                int b = num;

                if (repeticion == 0) {

                    System.out.println(lista + "i: " + i + " j: " + (i + 1) + " a: " + a + " b: " + b + "\n");

                    iteraciones++;
                    repeticion++;
                } else {

                    System.out.println(list + "i: " + i + " j: " + (i + 1) + " a: " + a + " b: " + b + "\n");
                }

                lista.set(i + 1, a);
                cambios++;
                i--;
                iteraciones++;
            }
            lista.set(i + 1, num);

            repeticion++;
            pasadas++;
        }

        System.out.println(lista);
        System.out.println("Iteraciones: " + iteraciones);
        System.out.println("Cambios: " + (cambios - 1));
        System.out.println("Pasadas " + pasadas);

    }

    //Método para determinar el tamaño del arreglo de forma dinamica e introducir espacios en los elementos
    public ArrayList<String> setSize(ArrayList<Integer> listaOriginal) {

        ArrayList<String> listaNueva = new ArrayList<>();

        for (int i = 0; i < listaOriginal.size(); i++) {
            listaNueva.add(" ");

        }

        return listaNueva;
    }

}



