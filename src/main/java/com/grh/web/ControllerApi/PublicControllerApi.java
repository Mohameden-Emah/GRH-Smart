package com.grh.web.ControllerApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grh.dto.AuthRequest;
import com.grh.dto.RegisterModel;
import com.grh.utils.Constants;

@RequestMapping(Constants.AUTH)
public interface PublicControllerApi {

        @PostMapping(Constants.REGISTER)
        public ResponseEntity<?> register(@RequestBody RegisterModel registerModel);

        @PostMapping(Constants.LOGIN)
        public ResponseEntity<?> login(@RequestBody AuthRequest authRequest);
}