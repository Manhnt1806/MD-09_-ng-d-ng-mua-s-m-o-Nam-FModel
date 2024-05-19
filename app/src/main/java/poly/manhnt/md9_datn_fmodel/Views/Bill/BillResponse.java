package poly.manhnt.md9_datn_fmodel.Views.Bill;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillResponse {
    @SerializedName("data")
    public List<Bill> billList;
}
