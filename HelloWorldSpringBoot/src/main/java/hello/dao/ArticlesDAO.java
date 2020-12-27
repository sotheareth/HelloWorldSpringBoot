package hello.dao;

//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

import hello.dto.ArticleDTO;

@Mapper
public interface ArticlesDAO {
	
//	@Select("select * from articles where id = #{id}")
    public ArticleDTO getArticle(int id);
	
//	@Update("update articles\r\n" + 
//			"		set title = #{title}, author = #{author}\r\n" + 
//			"		where id = #{id}")
    public boolean updateArticle(ArticleDTO article);
    
//    @Delete("DELETE FROM articles WHERE id = #{id}")
    public boolean deleteArticle(int id);
    
//    @Insert("INSERT INTO articles\r\n" + 
//    		"		(id, title, author)\r\n" + 
//    		"		values(#{id}, #{title}, #{author})	")
    public int insertArticle(ArticleDTO article);
}
