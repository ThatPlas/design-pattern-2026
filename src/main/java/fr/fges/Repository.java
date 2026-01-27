package fr.fges;

public interface Repository<T> {

    boolean save(T object, String file);
    T load(String file);

}
