package com.koscom.hackathon.web;


import com.koscom.hackathon.config.auth.dto.SessionUser;

import com.koscom.hackathon.domain.user.User;
import com.koscom.hackathon.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final UserRepository userRepository;


    @GetMapping("/main")
    public String index() {
        return "login";
    }

    @GetMapping("/index")
    public String index2(){

        return "index";
    }

    @GetMapping("/survey")
    public String survey() {
        return "survey";
    }

    @GetMapping("/charts")
    public String chart(){
        return "charts";
    }

    @GetMapping("/tables")
    public String table(Model model){
        SessionUser sessionUser = (SessionUser)httpSession.getAttribute("user");
        User user = userRepository.findByEmail(sessionUser.getEmail()).orElse(null);

        model.addAttribute("workingYear",user.getWorkingYear());
        model.addAttribute("currentAsset",user.getCurrentAsset());
        model.addAttribute("annualInvest",user.getAnnualInvest());


        return "tables";
    }


}
