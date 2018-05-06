package me.xiao.leetcode.depth_first_search;

import java.util.*;

/**
 * 推荐电影
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/6 17:48
 */

public class Medium02_MovieRecommend {
    Set<Integer> visited = new HashSet<>();
    List<Movie> list = new ArrayList<>();

    private Set<Movie> getMovieRecommendations(Movie movie, int n) {
        dfs(movie);

        Set<Movie> results = new HashSet<>();

        list.sort(Comparator.comparingDouble(o -> o.rating));

        list.stream().limit(n).forEach(results::add);

        return results;
    }

    private void dfs(Movie movie) {
        visited.add(movie.id);
        for (Movie m : movie.similars) {
            if (!visited.contains(m.id)) {
                list.add(m);
                dfs(m);
            }
        }
    }

    class Movie {
        int id;
        float rating;
        ArrayList<Movie> similars;
    }
}
