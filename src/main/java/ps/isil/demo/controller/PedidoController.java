package ps.isil.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ps.isil.demo.model.Pedido;
import ps.isil.demo.repository.JdbcPedidoRepository;

@Controller
public class PedidoController {

    @Autowired
    JdbcPedidoRepository jdbcPedidoRepository;

    @GetMapping("/pedidos")
    public String getAll(Model model){
        model.addAttribute("pedidos", jdbcPedidoRepository.findAll());
        return "pedido";
    }

    @GetMapping("/pedidos/add")
    public String create(Model model){
        model.addAttribute("pedido", new Pedido());
        return "pedido-add";
    }

    @PostMapping("/pedidos/save")
    public String update(Pedido pedido, Model model){

        jdbcPedidoRepository.create(pedido);

        model.addAttribute("pedidos", jdbcPedidoRepository.findAll());

        return "pedido";
    }

    @GetMapping("/pedidos/edit/{codigoPedido}")
    public String getProductForEdit(@PathVariable String  codigoPedido,
                                    Model model){
        model.addAttribute("pedido",
                jdbcPedidoRepository.findById(codigoPedido));
        return "pedido-edit";
    }

    @PostMapping("/pedidos/update/{codigoPedido}")
    public String update(@PathVariable String codigoPedido,
                         Pedido pedido,
                         Model model){
        jdbcPedidoRepository.update(pedido);
        model.addAttribute("pedidos",
                jdbcPedidoRepository.findAll());
        return "pedido";
    }

    @GetMapping("/pedidos/delete/{codigoPedido}")
    public String delete(@PathVariable String codigoPedido,
                         Model model){
        jdbcPedidoRepository.delete(codigoPedido);
        model.addAttribute("pedidos",
                jdbcPedidoRepository.findAll());
        return "pedido";
    }

}
