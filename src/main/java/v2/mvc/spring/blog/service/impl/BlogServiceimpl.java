package v2.mvc.spring.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.mvc.spring.blog.dao.BlogDAO;
import v2.mvc.spring.blog.dto.BlogEditRequestDTO;
import v2.mvc.spring.blog.dto.BlogListRequestDTO;
import v2.mvc.spring.blog.dto.BlogListResponseDTO;
import v2.mvc.spring.blog.mapper.BlogMapper;
import v2.mvc.spring.blog.service.BlogService;

@Service
public class BlogServiceimpl implements BlogService {

	private BlogDAO blogDAO;
	private BlogMapper blogMapper;

	@Autowired
	public BlogServiceimpl(BlogDAO blogDAO, BlogMapper blogMapper) {
		this.blogDAO = blogDAO;
		this.blogMapper = blogMapper;
	}

	@Override
	public int create(Map<String, Object> map) {
		int seq = this.blogDAO.insert(map);
		return seq;
	}

	@Override
	public Map<String, Object> read(int blogContSeq) {
		Map<String, Object> blogCont = this.blogDAO.selectOne(blogContSeq);

		return blogCont;
	}

	@Override
	public boolean edit(BlogEditRequestDTO blogEditRequestDTO) {
		int affectRowsCount = this.blogDAO.update(blogEditRequestDTO);

		return affectRowsCount > 0;
	}

	@Override
	public boolean delete(int blogContSeq) {
		return this.blogMapper.delete(blogContSeq) > 0;
	}

	@Override
	public List<BlogListResponseDTO> list(BlogListRequestDTO blogListRequestDTO) {
		List<BlogListResponseDTO> result = this.blogMapper.selectList(blogListRequestDTO);
		return result;
	}

}
