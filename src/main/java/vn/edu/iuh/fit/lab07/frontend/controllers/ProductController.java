package vn.edu.iuh.fit.lab07.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.lab07.backend.models.Product;
import vn.edu.iuh.fit.lab07.backend.services.ProductService;

import java.util.ArrayList;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
//    public String showProductListPaging(Module module, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(10);
//
////        Page<Product> productPage =
//        return "";
//    }

    @GetMapping("/home")
    public String home(Model model){
        Page<Product> products = productService.showPaging();
        model.addAttribute("products", products);
        return "/client/index";
    }
}
