package piiv.senac.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home_Controller {
    
    @GetMapping("/TelaInicial/Home")
    public ModelAndView showView() {
		
	ModelAndView mv = new ModelAndView("home");
	return mv;
    }
    
    @GetMapping("/")
    public ModelAndView exibirHome() {
		
	return showView();
    }
    
}