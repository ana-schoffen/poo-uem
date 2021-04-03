package com.uem.clinica.dao;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
    ArrayList<T> getEntidades();
    void adicionarEntidade(T obj);
    T buscarEntidade(int id);
    boolean removerEntidade(int id);
}
