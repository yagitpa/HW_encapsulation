package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public void addItem(Searchable item) {
        if (currentIndex < items.length) {
            items[currentIndex++] = item;
        } else {
            System.out.println("Больше нельзя добавить элементов");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query) && resultIndex <= 5) {
                results[resultIndex++] = item;
            }
            break;
        }
        return results;
    }
}
