package org.example.examen_di;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un elemento dentro de la colección "Item" en MongoDB.
 */
@Data
@Document(collection = "Item")
public class Item {

    /**
     * Identificador único del elemento en MongoDB.
     */
    @Id
    private String _id;

    /**
     * Identificador del elemento.
     */
    private String id;

    /**
     * Título o nombre del elemento.
     */
    private String title;

    /**
     * Precio del elemento.
     */
    private Double price;

    /**
     * Categoría a la que pertenece el elemento.
     */
    private String category;

    /**
     * Descripción detallada del elemento.
     */
    private String description;

    /**
     * Calificación del elemento basada en opiniones de usuarios.
     */
    private Double rate;

    /**
     * Cantidad disponible del elemento.
     */
    private Integer count;

    /**
     * URL de la imagen representativa del elemento.
     */
    private String image;
}