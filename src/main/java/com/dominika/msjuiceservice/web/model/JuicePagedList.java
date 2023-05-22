package com.dominika.msjuiceservice.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class JuicePagedList extends PageImpl<JuiceDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public JuicePagedList(@JsonProperty("content") List<JuiceDto> content,
                          @JsonProperty("number") int number,
                          @JsonProperty("size") int size,
                          @JsonProperty("totalElements") long totalElements,
                          @JsonProperty("pageable") JsonNode pageable,
                          @JsonProperty("last") boolean last,
                          @JsonProperty("totalPages") int totalPages,
                          @JsonProperty("sort") JsonNode sort,
                          @JsonProperty("first") boolean first,
                          @JsonProperty("numberOfElements") int numberOfElements){
        super(content, PageRequest.of(number,size), totalElements);
    }

    public JuicePagedList(final List<JuiceDto> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }
    public JuicePagedList(final List<JuiceDto> content) {
        super(content);
    }
}
