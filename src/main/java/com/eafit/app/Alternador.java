package com.eafit.app;

public interface Alternador {
    public void entrarA();
    public void salirA();
    public void entrarB();
    public void salirB();
    public void entrarC();
    public void salirC();
    public void entrarD();
    public void salirD();
    public Puente leerPuente();
    public void establecerPuente(Puente puente);
}
