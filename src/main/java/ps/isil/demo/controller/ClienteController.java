package ps.isil.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ps.isil.demo.model.Cliente;
import ps.isil.demo.repository.JdbcClienteRepository;


@Controller
public class ClienteController {

    @Autowired
    JdbcClienteRepository jdbcClienteRepository;



    @GetMapping("/clientes")
    public String getAll(Model model){
        model.addAttribute("clientes",jdbcClienteRepository.findAll());
        return "cliente";
    }
    @GetMapping("/clientes/add")
    public String create(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente-add";
    }

    @PostMapping("/clientes/save")
    public String update(Cliente cliente, Model model){

        jdbcClienteRepository.create(cliente);

        model.addAttribute("clientes", jdbcClienteRepository.findAll());

        return "cliente";
    }

    @GetMapping("/clientes/edit/{idCliente}")
    public String getProductoForEdit(@PathVariable Integer idCliente,
                                     Model model){
        model.addAttribute("cliente",
                jdbcClienteRepository.findById(idCliente));
        return "cliente-edit";
    }

    @PostMapping("/clientes/update/{idCliente}")
    public String update(@PathVariable Integer idCliente,
                         Cliente cliente,
                         Model model){
        jdbcClienteRepository.update(cliente);
        model.addAttribute("productos",
                jdbcClienteRepository.findAll());
        return "producto";
    }

    @GetMapping("/clientes/delete/{idCliente}")
    public String delete(@PathVariable Integer idCliente,
                         Model model){
        jdbcClienteRepository.delete(idCliente);
        model.addAttribute("clientes",
                jdbcClienteRepository.findAll());
        return "cliente";
    }
}
