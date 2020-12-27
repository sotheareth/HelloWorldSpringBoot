package hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.dao.ArticlesDAO;
import hello.dto.ArticleDTO;
import hello.service.ArticlesService;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService {
	
	@Autowired
	private ArticlesDAO articlesDAO;

	@Override
	public ArticleDTO getArticle(int id) {
		return articlesDAO.getArticle(id);
	}

	@Override
	public boolean updateArticle(ArticleDTO article) {
		return articlesDAO.updateArticle(article);
	}

	@Override
	public boolean deleteArticle(int id) {
		return articlesDAO.deleteArticle(id);
	}

	@Override
	public ArticleDTO insertArticle(ArticleDTO article) {
		
		ArticleDTO result;
		articlesDAO.insertArticle(article);
		int id = article.getId();
		result = getArticle(id);
		
		return result;
	}

}
