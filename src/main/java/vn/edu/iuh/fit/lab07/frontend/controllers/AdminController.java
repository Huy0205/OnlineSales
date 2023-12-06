package vn.edu.iuh.fit.lab07.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.lab07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.lab07.backend.models.Product;
import vn.edu.iuh.fit.lab07.backend.services.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public String showProducts(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Product> productPage = productService.getAll(currentPage - 1, pageSize, "productId", "asc");
        model.addAttribute("productPage", productPage);
        int totalPage = productPage.getTotalPages();
        if(totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/product/products";
    }

    @GetMapping("/products/add")
    public String navigateAddPage(Model model){
        model.addAttribute("product", new Product());
        return "/admin/product/add-form";
    }

    @PostMapping("/products/add")
    public String add(@ModelAttribute("product") Product product, Model model, RedirectAttributes redirectAttributes){
        product.setStatus(ProductStatus.ACTIVE);
        if(productService.findProductExist(product.getName(), product.getManufacturer()) == null){
            productService.add(product);
            redirectAttributes.addFlashAttribute("messages", "Successful "+product.getName()+" products have been added");
            return "redirect:/admin/products";
        }
        model.addAttribute("messages", "This product is exist!");
        return "/admin/product/add-form";
    }

    @GetMapping("/products/update/{id}")
    public String navigateUpdatePage(Model model, @PathVariable("id") long id){
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("status", ProductStatus.values());
        return "/admin/product/update-form";
    }

    @PostMapping("/products/update")
    public String update(Model model, @ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        Product oldProduct = productService.findProductById(product.getProductId());
        // Trường hợp người dùng không sửa tên sản phẩm và nhà sản xuất
        if(oldProduct.getName().equals(product.getName()) && oldProduct.getManufacturer().equals(product.getManufacturer())){
            productService.update(product);
            redirectAttributes.addFlashAttribute("messages", "Successful "+product.getName()+" products have been updated");
            return "redirect:/admin/products";
        }else{
            // Trường hợp người dùng sửa 1 trong 2 filed tên sản phẩm hoặc nhà sản xuất, hoặc sửa cả 2
            // Thì sẽ kiểm tra xem tên sản phầm và nhà sản xuât sửa lại có trùng với tên sản phẩm và nhà sản xuất của 1 sản phẩm bất kỳ trong list ko
            // Nếu không trùng thì mới cho sửa
            if(productService.findProductExist(product.getName(), product.getManufacturer()) == null){
                productService.update(product);
                redirectAttributes.addFlashAttribute("messages", "Successful "+product.getName()+" products have been updated");
                return "redirect:/admin/products";
            }
        }
        model.addAttribute("messages", "Product update failed because the correction information is duplicated with the product in the list");
        model.addAttribute("status", ProductStatus.values());
        return "/admin/product/update-form";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(Model model, @PathVariable("id") long id, RedirectAttributes redirectAttributes){
        Product product = productService.findProductById(id);
        product.setStatus(ProductStatus.TERMINATED);
        productService.update(product);
        redirectAttributes.addFlashAttribute("messages", "Delete the product successfully");
        return "redirect:/admin/products";
    }
}
