package poly.manhnt.md9_datn_fmodel.Models.Objects.cart;

import java.util.ArrayList;

public class ProductCart {
    public String _id;
    public String name;
    public ArrayList<String> image;
    public int price;
    public Integer discount;

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getFinalPrice() {
        return discount == null ? price : discount;
    }
}
