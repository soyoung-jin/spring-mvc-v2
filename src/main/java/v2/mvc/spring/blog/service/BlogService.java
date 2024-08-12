package v2.mvc.spring.blog.service;

import java.util.List;
import java.util.Map;

import v2.mvc.spring.blog.dto.BlogEditRequestDTO;
import v2.mvc.spring.blog.dto.BlogListRequestDTO;
import v2.mvc.spring.blog.dto.BlogListResponseDTO;

public interface BlogService {
	int create(Map<String, Object> map);

	Map<String, Object> read(int blogContSeq);

	boolean edit(BlogEditRequestDTO blogEditRequestDTO);

	boolean delete(int blogContSeq);

	List<BlogListResponseDTO> list(BlogListRequestDTO blogListRequestDTO);

}
