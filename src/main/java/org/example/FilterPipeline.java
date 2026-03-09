package org.example;

import java.util.ArrayList;
import java.util.List;

public class FilterPipeline {
    private final List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) { filters.add(filter); }

    public void process(UserContext context) {
        filters.forEach(f -> f.execute(context));
    }
}
