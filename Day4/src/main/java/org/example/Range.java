package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Range {

    private int start;
    private int end;

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
