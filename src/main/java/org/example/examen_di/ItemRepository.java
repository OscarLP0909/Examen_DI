package org.example.examen_di;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repositorio para la entidad Item, proporcionando métodos de acceso a la base de datos MongoDB.
 */
public interface ItemRepository extends MongoRepository<Item, String> {

    /**
     * Busca un elemento por su título.
     * @param title el título del elemento.
     * @return el elemento que coincide con el título proporcionado.
     */
    Item findItemByTitle(String title);

    /**
     * Busca un elemento por su ID.
     * @param _id el identificador del elemento.
     * @return el elemento que coincide con el ID proporcionado.
     */
    Item findItemById(String _id);

    /**
     * Busca elementos por su categoría.
     * @param category la categoría de los elementos.
     * @return una lista de elementos que pertenecen a la categoría proporcionada.
     */
    List<Item> findItemByCategory(String category);

    /**
     * Busca un elemento por su precio.
     * @param price el precio del elemento.
     * @return el elemento que coincide con el precio proporcionado.
     */
    Item findItemByPrice(Double price);

    /**
     * Busca un elemento por su calificación.
     * @param rate la calificación del elemento.
     * @return el elemento que coincide con la calificación proporcionada.
     */
    Item findItemByRate(Double rate);

    /**
     * Busca un elemento por su cantidad disponible.
     * @param count la cantidad de elementos.
     * @return el elemento que coincide con la cantidad proporcionada.
     */
    Item findItemByCount(Integer count);

    /**
     * Busca un elemento por su URL de imagen.
     * @param image la URL de la imagen del elemento.
     * @return el elemento que coincide con la URL de imagen proporcionada.
     */
    Item findItemByImage(String image);

    /**
     * Busca elementos por su categoría.
     * @param category la categoría de los elementos.
     * @return una lista de elementos que pertenecen a la categoría proporcionada.
     */
    List<Item> findByCategory(String category);

    /**
     * Busca un elemento por su precio usando una consulta personalizada.
     * @param price el precio del elemento.
     * @return el elemento que coincide con el precio proporcionado.
     */
    @Query("{ 'price' : ?0 }")
    Item itemByPrice(Double price);
}