package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> items = new LinkedList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String query) {
        TreeMap<String, Searchable> sortedResults = new TreeMap<>();
        String lowerCaseQuery = query.toLowerCase();

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerCaseQuery)) {
                sortedResults.put(item.getName(), item);
            }
        }
        return sortedResults;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            int occurrences = countOccurrences(item.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestResult = item;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("По Вашему запросу \"" + search + "\" ничего не найдено");
        }
        return bestResult;
    }

    private int countOccurrences(String source, String target) {
        int count = 0;
        int index =0;
        while ((index = source.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count;
    }
}
