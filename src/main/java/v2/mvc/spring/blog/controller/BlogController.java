package v2.mvc.spring.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "blog/create";
	}

}
