package cz.uhk.fim.ppro.service;

import cz.uhk.fim.ppro.model.News;

import java.util.List;

public interface INewsService extends IGeneralService<News, Integer> {

    /**
     * Method which finds all news
     * @return list of found Events
     */
    public List<News> findAllNews();

    /**
     * Method finds news by name
     * @param name partial or whole name
     * @return returns collection of {@link News}
     */
    public List<News> getNewsByName(String name);
}
