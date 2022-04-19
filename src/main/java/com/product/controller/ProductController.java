package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import com.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.showAll();
        model.addAttribute("products",products);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create Success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success","Removed Success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name,Model model){
        Product product = productService.findByName(name);
        if (product != null){
            model.addAttribute("product",product);
            return "/search";
        } else
            model.addAttribute("message","Not found");
            return "/search";
    }
}
