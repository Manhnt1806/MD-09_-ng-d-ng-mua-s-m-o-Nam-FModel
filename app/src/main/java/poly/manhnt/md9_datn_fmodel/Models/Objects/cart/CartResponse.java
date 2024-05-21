package poly.manhnt.md9_datn_fmodel.Models.Objects.cart;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartResponse {
    @SerializedName("message")
    public String message;
    @SerializedName("listCart")
    public List<Cart> cartList;
}
