package poly.manhnt.md9_datn_fmodel.Models.Objects.ProductSearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductSearchResponse {
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public List<ProductSearch> data;
}
