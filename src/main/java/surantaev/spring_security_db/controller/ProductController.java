package surantaev.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import surantaev.spring_security_db.entity.Product;
import surantaev.spring_security_db.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @RequestMapping ("/")
    public String viewHomePage(Model model) {
        List<Product> products = service.getAllProduct();
        model.addAttribute("productList", products);
        return "/product-page";
    }

    @RequestMapping("/new")
    public String showNewPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id) {
        ModelAndView view = new ModelAndView("edit_product");
        Product product = service.getById(id);
        view.addObject("product", product);
        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
