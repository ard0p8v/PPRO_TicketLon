package cz.uhk.fim.ppro.dao;

import cz.uhk.fim.ppro.model.News;

import java.util.List;

public interface INewsDao extends IGeneralDao<News, Integer> {

    /**
     * Method finds all news in DB
     * @return return collection of found {@link News}
     */
    public List<News> findAllNews();

    /**
     * Method finds all corresponding names of news
     * @param name whole or partial news name
     * @return returns collection of string
     */
    public List<String> findNewsName(String name);

    /**
     * Method finds all news with corresponding name
     * @param name whole or partial news name
     * @return returns collection of found {@link News}
     */
    public List<News> findNewsByName(String name);

}
