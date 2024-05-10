package br.com.ufrn.imd.securityexample;

import br.com.ufrn.imd.securityexample.domain.UserRepository;
import br.com.ufrn.imd.securityexample.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signUp(@RequestParam String username, @RequestParam String password) {
        Users user = new Users();
        user.setUsername(username);
        String encodedPassword = securityConfig.passwordEncoder().encode(password);
        user.setPassword(encodedPassword);
        user.setActive(true);
        userRepository.save(user);
        return "/login";
    }



}
