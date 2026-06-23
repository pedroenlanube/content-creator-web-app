package dev.pedroenlanube.domain.model.generic;

import java.util.List;

public record PaginationResult<T>(List<T> items, Integer total) {
    public PaginationResult {
        if(items == null)
            items = List.of();
        if(total == null || total < 0)
            total = 0;
    }
}
