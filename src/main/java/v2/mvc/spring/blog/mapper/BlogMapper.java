package v2.mvc.spring.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import v2.mvc.spring.blog.dto.BlogListRequestDTO;
import v2.mvc.spring.blog.dto.BlogListResponseDTO;

@Mapper
public interface BlogMapper {
	
	int delete(int blogContSeq);
	
	List<BlogListResponseDTO> selectList(BlogListRequestDTO bloglistRequestDTO);

}

