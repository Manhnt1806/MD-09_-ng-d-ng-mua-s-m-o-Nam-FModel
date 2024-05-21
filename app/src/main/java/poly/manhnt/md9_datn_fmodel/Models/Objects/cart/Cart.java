package poly.manhnt.md9_datn_fmodel.Models.Objects.cart;

import com.google.gson.annotations.SerializedName;

public class Cart {
    @SerializedName("_id")
    public String _id;
    @SerializedName("product_id")
    public ProductSizeColorCart sizeColor;
    @SerializedName("status")
    public String status;

    public int quantity = 1;

}
