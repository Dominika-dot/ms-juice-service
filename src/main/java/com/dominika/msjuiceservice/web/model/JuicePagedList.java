package com.dominika.msjuiceservice.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class JuicePagedList extends PageImpl<JuiceDto> {
    public JuicePagedList(final List<JuiceDto> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }
    public JuicePagedList(final List<JuiceDto> content) {
        super(content);
    }
}
