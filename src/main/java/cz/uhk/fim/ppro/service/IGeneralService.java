package cz.uhk.fim.ppro.service;

import java.io.Serializable;
import java.util.List;

public interface IGeneralService<T, PK extends Serializable> {

    public PK create(T t);
    public T read(PK id);
    public void update(T t);
    public void delete(T t);
    public void createOrUpdate(T t) ;
    public List<T> getAll();
}
