package v2.mvc.spring.blog.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLModElement;

import v2.mvc.spring.blog.dto.CommentAddRequestDTO;
import v2.mvc.spring.blog.dto.CommentInsertDTO;
import v2.mvc.spring.blog.dto.CommentResponseDTO;
import v2.mvc.spring.blog.mapper.CommentMapper;
import v2.mvc.spring.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	private CommentMapper commentMapper;
	
	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	@Override
	public CommentResponseDTO add(CommentAddRequestDTO commentAddRequestDTO) {
		ModelMapper modeelMapper = new ModelMapper();
		CommentInsertDTO commentInsertDTO = modeelMapper.map(commentAddRequestDTO, CommentInsertDTO.class);
		if(commentInsertDTO.getTmpPw() != null) {
			String sha236hex = DigestUtils.sha256Hex(commentInsertDTO.getTmpPw());
			commentInsertDTO.setTmpPw(sha236hex);
		}
		
		int affetRowCount = this.commentMapper.insert(commentInsertDTO);
		
		if(affetRowCount ==0) {
			return null;
		}
		
		ModelMapper modelMapperInsertToResponse = new ModelMapper();
		CommentResponseDTO commentResponseDTO = modelMapperInsertToResponse.map(commentInsertDTO, CommentResponseDTO.class);
		
		return commentResponseDTO;
	}

}
