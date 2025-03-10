package org.example.examen_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones CRUD en la entidad Item.
 */
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    ItemRepository itemRepository;

    /**
     * Obtiene todos los elementos disponibles en la base de datos.
     * @return una lista de todos los elementos.
     */
    @GetMapping("/")
    public List<Item> all() {
        return itemRepository.findAll();
    }

    /**
     * Busca un elemento por su ID.
     * @param _id el identificador del elemento.
     * @return el elemento correspondiente al ID proporcionado.
     */
    @GetMapping("/id/{_id}")
    public Item findById(@PathVariable String _id) {
        return itemRepository.findById(_id).get();
    }

    /**
     * Busca elementos por su categoría.
     * @param category la categoría de los elementos a buscar.
     * @return una lista de elementos que pertenecen a la categoría proporcionada.
     */
    @GetMapping("/category/{category}")
    public List<Item> findByCategory(@PathVariable String category) {
        return itemRepository.findByCategory(category);
    }

    /**
     * Crea un nuevo elemento y lo guarda en la base de datos.
     * @param item el elemento a crear.
     * @return el elemento guardado.
     */
    @PostMapping("/")
    public Item create(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    /**
     * Elimina un elemento de la base de datos por su ID.
     * @param _id el identificador del elemento a eliminar.
     */
    @DeleteMapping("/{_id}")
    public void delete(@PathVariable String _id) {
        itemRepository.deleteById(_id);
    }
}
