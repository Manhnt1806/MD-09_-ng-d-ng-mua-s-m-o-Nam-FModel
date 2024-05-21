package poly.manhnt.md9_datn_fmodel.Account;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest {
    @SerializedName("password")
    public String oldPassword;

    @SerializedName("newPassword")
    public String newPassword;
}
