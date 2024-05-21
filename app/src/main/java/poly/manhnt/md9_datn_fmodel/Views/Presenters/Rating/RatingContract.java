package poly.manhnt.md9_datn_fmodel.Views.Presenters.Rating;

import java.util.List;

import poly.manhnt.datn_md09.Models.Bill.Bill;
import poly.manhnt.datn_md09.Models.ProductComment.ProductComment;

public interface RatingContract {
    interface View {
        void onGetRatingSuccess(List<ProductComment> productComments);
        void onGetBillListSuccess(List<Bill> billList);

        void onGetBillListError(Exception e);
    }

    interface Presenter {
        void getRating(String productId);
        void getBillList(String uid);
    }
}
