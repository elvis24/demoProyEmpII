package ps.isil.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ps.isil.demo.model.Producto;
import ps.isil.demo.repository.JdbcProductoRepository;

@Controller
public class ProductoController {

    @Autowired
    JdbcProductoRepository jdbcProductoRepository;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/productos")
    public String getAll(Model model){
        model.addAttribute("productos",jdbcProductoRepository.findAll());
        return "producto";
    }
    @GetMapping("/productos/add")
    public String create(Model model){
        model.addAttribute("producto", new Producto());
        return "producto-add";
    }

    @PostMapping("/productos/save")
    public String update(Producto producto, Model model){

        jdbcProductoRepository.create(producto);

        model.addAttribute("productos", jdbcProductoRepository.findAll());

        return "producto";
    }

    @GetMapping("/productos/edit/{idProducto}")
    public String getProductForEdit(@PathVariable Integer idProducto,
                                    Model model){
        model.addAttribute("producto",
                jdbcProductoRepository.findById(idProducto));
        return "producto-edit";
    }

    @PostMapping("/productos/update/{idProducto}")
    public String update(@PathVariable String idProducto,
                         Producto producto,
                         Model model){
        jdbcProductoRepository.update(producto);
        model.addAttribute("productos",
                jdbcProductoRepository.findAll());
        return "producto";
    }

    @GetMapping("/productos/delete/{idProducto}")
    public String delete(@PathVariable Integer idProducto,
                         Model model){
        jdbcProductoRepository.delete(idProducto);
        model.addAttribute("productos",
                jdbcProductoRepository.findAll());
        return "producto";
    }
}
