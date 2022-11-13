package br.edu.infnet.apppagamento.model.persistence;

import java.util.List;

public interface IDAO<T> {

	Boolean save(T obj);

	Boolean update(T obj);

	Boolean delete(Integer id);

	T getById(Integer id);

	List<T> listAll();

}