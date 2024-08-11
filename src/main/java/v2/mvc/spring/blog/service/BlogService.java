package v2.mvc.spring.blog.service;

import java.util.Map;

import v2.mvc.spring.blog.dto.BlogEditRequestDTO;

public interface BlogService {
	int create(Map<String, Object> map);

	Map<String, Object> read(int blogContSeq);

	boolean edit(BlogEditRequestDTO blogEditRequestDTO);

}
