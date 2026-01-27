package fr.fges;

public interface Repository<T> {

    void save(T object, String file);
    T load(String file);

}
