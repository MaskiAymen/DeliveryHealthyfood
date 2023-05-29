package com.management.controllers;

import com.management.entities.Product;
import com.management.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(){
        return "Home";
    }
    @RequestMapping("/createProduct")
    public String createProduct(){
        return "CreateProduct";
    }
    @RequestMapping("/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult)  {
 if(bindingResult.hasErrors())    return "CreateProduct";
         productService.saveProduct(product);
         return "CreateProduct";


    }

    @RequestMapping("/productsList")
    public String productsList(ModelMap modelMap,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "2")  int size,
                               Model model){
        Page<Product> productsController = productService.getAllProductsByPage(page, size);
        modelMap.addAttribute("productsJsp", productsController);
        modelMap.addAttribute("pages", new int[productsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ProductsList";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id,ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2")  int size){
        productService.deleteProductById(id);
        Page<Product> productsController = productService.getAllProductsByPage(page, size);
        modelMap.addAttribute("productsJsp", productsController);
        modelMap.addAttribute("pages", new int[productsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "ProductsList";

    }
    @RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long id,ModelMap modelMap){
        Product productController = productService.getProduct(id);
        modelMap.addAttribute("productJsp",productController);
        return "EditProduct";

    }
    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product)  {

     productService.saveProduct(product);
        return "CreateProduct";


    }



    @GetMapping("/accessDenied")
 public String accessDenied(){
        return "accessDenied";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
