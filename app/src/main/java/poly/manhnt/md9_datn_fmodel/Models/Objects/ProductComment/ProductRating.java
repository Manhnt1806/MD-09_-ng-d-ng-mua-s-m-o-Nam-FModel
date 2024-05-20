package poly.manhnt.md9_datn_fmodel.Models.Objects.ProductComment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductRating {
    @SerializedName("_id")
    public String id;
    @SerializedName("images")
    public List<String> images;
    @SerializedName("product_detail_id")
    public String sizeColorId;
    @SerializedName("product_id")
    public String productId;
    @SerializedName("user_id")
    public String userId;
    @SerializedName("comment")
    public String comment;
    @SerializedName("rating")
    public float rating;

}
