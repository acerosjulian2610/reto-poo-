package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDE lista = new ListaDE();
        Scanner sc = new Scanner(System.in);
        lista.primero = null;
        int opcion,lugar;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n" +
                    "1) Insertar dato\n" +
                    "2) Insertar nodo\n" +
                    "3) Eliminar Enésimo\n" +
                    "4) Imprimir lista de izquerda a derecha\n"+
                    "5) Imprimir lista de derecha a izquierda\n"+
                    "6) Sumar primer par con el ultimo par\n"+
                    "7) Concatenar\n"+
                    "8) Intercalar\n"+
                    "0) salir\n");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    lista.InsertarNodo(new nodo().info = sc.nextInt());
                    break;
                case 2:
                    System.out.println("Valor del nodo");
                    lista.InsertarNodo(sc.nextInt());
                    break;
                case 3:
                    lista.EliminarEnesimo(2);
                    break;
                case 4:
                    lista.ImprimirListaIzq_Der();
                    break;
                case 5:
                    lista.ImprimirListaDer_Izq();
                    break;
                case 6:
                    lista.sumarPrimerParUltimoPar();
                    break;
                case 7:
                    ListaDE lista2 = new ListaDE();
                    lista2.InsertarNodo(sc.nextInt());
                    lista2.InsertarNodo(sc.nextInt());
                    lista2.InsertarNodo(sc.nextInt());
                    lista.Concatenar(lista2);
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Digita un un número válido");
                    break;
            }
        }while(opcion !=0);
    }
    public static class ListaDE {
        nodo primero;
        nodo ultimo;

        public ListaDE() {}

        public void InsertarNodo(int valor){
            nodo temporal = new nodo();
            temporal.info = valor;
            if(vacio()){
                primero = temporal;
                ultimo = temporal;
            }
            else{
                nodo current = primero;
                while (current.siguiente != null){
                    current = current.siguiente;
                }
                current.siguiente = temporal;
                temporal.anterior = current;
                ultimo = temporal;
            }
        }

        public void InsertarNodo(nodo temporal){
            if(vacio()){
                primero = temporal;
                ultimo = temporal;
            }else{
                nodo current = primero;
                while (current.siguiente != null){
                    current = current.siguiente;
                }
                current.siguiente = temporal;
                temporal.anterior = current;
                ultimo = temporal;
            }
        }

        public void EliminarEnesimo(int lugar){
            nodo tamanoNodo = new nodo();
            int tamano=1;
            tamanoNodo = primero;
            while (tamanoNodo!=null || tamano <= lugar) {
                if(tamano == lugar){
                    tamanoNodo.anterior.siguiente = tamanoNodo.siguiente;
                    tamanoNodo.siguiente.anterior = tamanoNodo.anterior;
                }
                tamanoNodo = tamanoNodo.siguiente;
                tamano++;
            }
        }

        public void ImprimirListaDer_Izq(){
            nodo tamanoNodo = new nodo();
            tamanoNodo = ultimo;
            while (tamanoNodo!=null) {
                System.out.println("> "+tamanoNodo.info);
                tamanoNodo = tamanoNodo.anterior;
            }
        }

        public void ImprimirListaIzq_Der(){
            nodo tamanoNodo = new nodo();
            tamanoNodo = primero;
            while (tamanoNodo!=null) {
                System.out.println("> "+tamanoNodo.info);
                tamanoNodo = tamanoNodo.siguiente;
            }
        }

        public void sumarPrimerParUltimoPar(){
            int primerPar=0, ban2=0, ultimoPrimo=0;
            nodo temporal = new nodo();
            temporal=primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else {
                while (temporal != null) {
                    if (temporal.EsImpar() && ban2 == 0) {
                        primerPar = temporal.info;
                        ban2 = 1;
                    }
                    if (!temporal.EsImpar() && ultimoPrimo != temporal.info)
                        ultimoPrimo = temporal.info;
                    temporal = temporal.siguiente;
                }
                System.out.println("La suma de primer par y el ultimo par es : " + (primerPar + ultimoPrimo));
            }
        }

        public void Concatenar(ListaDE lista){
            nodo lista_1 = ultimo;
            nodo lista_2 = lista.primero;
            lista_1.siguiente = lista_2;
        }

        public Boolean vacio(){
            return (primero==null);
        }
    }
    private static class nodo{
        int info;
        nodo siguiente;
        nodo anterior;

        public nodo() {
        }

        public Boolean EsImpar(){
            return !(info % 2 == 0);
        }

        public Boolean EsPrimo(){
            return (info % 2 == 0 && info % 3 == 0 && info % 5 == 0 && info % 7 ==0 || (info == 1 || info ==2 || info == 3 || info ==5 || info ==7));
        }
    }
}