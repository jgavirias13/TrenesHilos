package com.eafit.app;

public class Tren implements Runnable {
    private Alternador alternador;
    private boolean mostrarMensaje;
    private int id;
    private static int currId;
    
    public Tren(Alternador alternador, boolean mostrarMensaje) {
	this.alternador = alternador;
	this.mostrarMensaje = mostrarMensaje;
	this.id = Tren.currId++;
    }
    
    public void run() {
	while (true) {
	    imprimirEstado("Entrando a A");
	    alternador.entrarA();
	    Puente p = alternador.leerPuente();
	    alternador.salirA();
	    imprimirEstado("Saliendo de A");

	    switch (p) {
	    case B:
		imprimirEstado("Entrando a B");
		alternador.entrarB();
		alternador.salirB();
		imprimirEstado("Saliendo de B");
		break;
	    case C:
		imprimirEstado("Entrando a C");
		alternador.entrarC();
		alternador.salirC();
		imprimirEstado("Saliendo de C");
		break;
	    case D:
		imprimirEstado("Entrando a D");
		alternador.entrarD();
		alternador.salirD();
		imprimirEstado("Saliendo de D");
		break;
	    }
	}
    }

    private void imprimirEstado(String mensaje) {
	if (mostrarMensaje) {
	    System.out.println("ID: " + id + " " +
			       mensaje);
	}
    }
}

