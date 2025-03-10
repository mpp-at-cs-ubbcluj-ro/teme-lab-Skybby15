package repository;

import model.Entity;

import java.util.List;
import java.util.Optional;

public interface IRepository<E extends Entity<ID>,ID>  {
    /**
     * Ia lista intreaga de entitati
     * @return lista entitatilor
     */
    public List<E> getEntityList();

    /**
     * Ia o lista customizata de entitati
     * @param filter un string ce contine datele corespunzatoarea filtrarii
     * @return lista customizata de entitati
     */
    public List<E> getEntityList(String filter);

    /**
     * Gaseste o entitate dupa id
     * @param id elementul dupa care se cauta entitatea
     * @return un Optional ce contine entitatea cautata , sau Optional.empty() daca entitatea cu acel id nu exista
     */
    public Optional<E> getEntity(ID id);

    /**
     * Adauga o entitate
     * @param entity entitatea ce se doreste a fi adaugate
     * @return Optional.empty() daca adaugarea a fost realizata cu succes, altfel se returneaza Optional cu entitatea data ca parametru
     */
    public Optional<E> addEntity(E entity);

    /**
     * Modifica atributele unei entitati
     * @param entity entitatea ce se va scrie peste entitatea existenta cu acelasi id
     * @return Optional cu entitatea veche daca update-ul a fost realizat cu succes ,
     *      Optional cu entitatea data ca parametru altfel
     */
    public Optional<E> updateEntity(E entity);

    /**
     * Sterge o entitate
     * @param id id-ul entitatii ce se va sterge
     * @return un Optional cu entitatea stearsa daca operatia a fost realizata cu succes, Optional.empty() altfel
     */
    public Optional<E> deleteEntity(ID id);
}
