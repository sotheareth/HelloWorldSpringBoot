package hello.service;

import hello.dto.ArticleDTO;

public interface ArticlesService {

	public ArticleDTO getArticle(int id);
    public boolean updateArticle(ArticleDTO article);
    public boolean deleteArticle(int id);
    public ArticleDTO insertArticle(ArticleDTO article);

}