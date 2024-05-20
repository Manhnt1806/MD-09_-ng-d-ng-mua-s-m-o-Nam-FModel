package poly.manhnt.md9_datn_fmodel.Models.Objects.ProductSizeColor;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductSizeColorResponse {
    @SerializedName("productListSize")
    public ArrayList<ProductSizeColor> productSizeColors;
}
