package com.appsdeveloperblog.app.ws.userservice;

import com.appsdeveloperblog.app.ws.ui.model.UserRest;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
