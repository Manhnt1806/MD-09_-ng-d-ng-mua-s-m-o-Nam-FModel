package poly.manhnt.md9_datn_fmodel.Presenters.UserDiscount;

import java.util.List;

import poly.manhnt.datn_md09.Models.discount.UserDiscount;

public interface UserDiscountContract {
    interface View {
        void onGetUserDiscountSuccess(List<UserDiscount> discountList);
    }

    interface Presenter {
        void getUserDiscount(String uid);
    }
}
