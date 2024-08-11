package v2.mvc.spring.blog.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import v2.mvc.spring.blog.dto.BlogEditRequestDTO;

@Repository
public class BlogDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);
		if(result > 0 && map.containsKey("blg_cont_seq")) {
			return (Integer) map.get("blg_cont_seq");
		}
		return -1;
		
	}

	public Map<String, Object> selectOne(int blogContSeq) {
		
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne", blogContSeq);
	}
	
	public int update(BlogEditRequestDTO blogEditRequestDTO) {
		
		return this.sqlSessionTemplate.update("TB_BLG_CONT.update", blogEditRequestDTO);
	}

}
