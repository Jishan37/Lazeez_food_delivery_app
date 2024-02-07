package com.hridoykrisna.Lazeez.controller.Rest;

import com.hridoykrisna.Lazeez.Utils.CommonUtils;
import com.hridoykrisna.Lazeez.model.CartItem;
import com.hridoykrisna.Lazeez.repository.CartRepo;
import com.hridoykrisna.Lazeez.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart/")
public class AddToCartRestController {
    private final CartService cartService;
    private final CartRepo cartRepo;

    @GetMapping("{id}")
    public List<CartItem> addCartItem(@Valid @PathVariable("id") int id, Model model) {
        return cartService.addToCart(id);
    }

    @GetMapping("list")
    public List<CartItem> ListSize() {
        int userId = 0;
        if (CommonUtils.isUserAuthenticate) {
            userId = CommonUtils.customer.getId();
        }
        return cartRepo.getCartListAndStatusOne(userId);

    }

    @GetMapping("remove/{id}")
    public List<CartItem> removeCartItem(@Valid @PathVariable("id") int id) {
        return cartService.removeFromCart(id);
    }

}
