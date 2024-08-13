package v2.mvc.spring.blog.service;

import v2.mvc.spring.blog.dto.CommentAddRequestDTO;
import v2.mvc.spring.blog.dto.CommentResponseDTO;

public interface CommentService {

	CommentResponseDTO add(CommentAddRequestDTO commentAddRequestDTO);

}
