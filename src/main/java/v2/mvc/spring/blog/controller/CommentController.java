package v2.mvc.spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import v2.mvc.spring.blog.dto.CommentAddRequestDTO;
import v2.mvc.spring.blog.dto.CommentResponseDTO;
import v2.mvc.spring.blog.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping
	@ResponseBody
	public CommentResponseDTO add(CommentAddRequestDTO commentAddRequestDTO) {
		return this.commentService.add(commentAddRequestDTO);
	}
}
