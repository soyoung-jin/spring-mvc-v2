package v2.mvc.spring.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import v2.mvc.spring.blog.dto.CommentInsertDTO;

@Mapper
public interface CommentMapper {
	int insert(CommentInsertDTO commentInsertDTO);

}
