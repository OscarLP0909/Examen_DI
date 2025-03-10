package org.example.examen_di;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador web para la gestión de vistas relacionadas con los hoteles.
 * <p>
 * Proporciona endpoints basados en vistas (Thymeleaf u otro motor de plantillas)
 * para mostrar, crear, editar y actualizar hoteles.
 * <p>
 * Todas las rutas de este controlador están prefijadas con <strong>/web</strong>.
 *
 * @author [Oscar]
 * @version 1.0
 */
@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * Repositorio para acceder a los datos de los productos.
     */
    @Autowired
    ItemRepository itemRepository;

    /**
     * Muestra la página de inicio con un listado de todos los productos.
     * <p>
     * Endpoint: <strong>GET /web/</strong>
     *
     * @param session la sesión HTTP actual.
     * @param model   el modelo para pasar datos a la vista.
     * @return la vista "index" con la lista de productos.
     */
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var items = itemRepository.findAll();
        model.addAttribute("titulo", "Listado de productos");
        model.addAttribute("productos", items);
        return "index";
    }

    /**
     * Muestra los detalles de un producto específico por su ID.
     * <p>
     * Endpoint: <strong>GET /web/{id}</strong>
     *
     * @param model el modelo para pasar datos a la vista.
     * @param id    el ID del producto.
     * @return la vista "single" si el hotel existe, o "404" si no se encuentra.
     */
    @GetMapping("/{id}")
    public String single(Model model, @PathVariable String id) {
        var producto = itemRepository.findById(id);
        if (producto.isEmpty()) return "404";
        else {
            model.addAttribute("producto", producto.get());
            return "single";
        }
    }
}
