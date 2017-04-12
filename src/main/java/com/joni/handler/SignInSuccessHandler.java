package com.joni.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shenjj on 2017/4/12.
 */
public class SignInSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public SignInSuccessHandler() {
        super();
        setRedirectStrategy(new NoRedirectStrategy());
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
//        response.write("my JSON response");
    }


    protected class NoRedirectStrategy implements RedirectStrategy {

        @Override
        public void sendRedirect(HttpServletRequest request,
                                 HttpServletResponse response, String url) throws IOException {
            // no redirect

        }

    }
}
