package poly.manhnt.md9_datn_fmodel.Models.Objects.ProductSizeColor;

import com.google.gson.annotations.SerializedName;

public class ProductSizeColor {
    @SerializedName("_id")
    public String sizeColorId;
    @SerializedName("size_id")
    public ProductSize size;
    @SerializedName("color_id")
    public ProductColor color;

    @SerializedName("quantity")
    public int quantity;
}

