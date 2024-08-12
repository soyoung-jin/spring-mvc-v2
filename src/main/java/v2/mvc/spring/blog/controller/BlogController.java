package v2.mvc.spring.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import v2.mvc.spring.blog.dto.BlogEditRequestDTO;
import v2.mvc.spring.blog.dto.BlogListRequestDTO;
import v2.mvc.spring.blog.dto.BlogListResponseDTO;
import v2.mvc.spring.blog.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreate() {
		return "blog/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map) {
		int blogContSeq = this.blogService.create(map);
		return "redirect:/read/" + String.valueOf(blogContSeq);
	}

	@GetMapping(value = "/read/{blogContSeq}")
	public String getRead(@PathVariable("blogContSeq") int blogContSeq, Model model) {
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		model.addAttribute("blogCont", blogCont);

		return "blog/read";
	}

	@GetMapping(value = "/edit/{blogContSeq}")
	public ModelAndView getEdit(@PathVariable("blogContSeq") int blogContSeq) {
		ModelAndView mav = new ModelAndView("/blog/edit");
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);

		if (blogCont == null) {
			mav.setViewName("redirect:/list");
			return mav;
		}
		mav.addObject("blogCont", blogCont);

		return mav;
	}

	@PutMapping(value = "/edit/{blogContSeq}")
	public String putEdit(BlogEditRequestDTO blogEditRequestDTO) {
		boolean isSuccessEdit = this.blogService.edit(blogEditRequestDTO);

		if (isSuccessEdit) {
			return "redirect:/edit/" + String.valueOf(blogEditRequestDTO.getBlogContSeq());
		}
		return "redirect:/list";
	}

	@DeleteMapping(value = "/delete")
	public String delete(int blogContSeq) {
		this.blogService.delete(blogContSeq);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String list(BlogListRequestDTO blogListRequestDTO, Model model) {
		model.addAttribute("blogListRequestDTO", blogListRequestDTO);

		List<BlogListResponseDTO> blogListResponseDTOList = this.blogService.list(blogListRequestDTO);
		model.addAttribute("blogListResponseDTOList", blogListResponseDTOList);

		return "/blog/list";
	}

}
