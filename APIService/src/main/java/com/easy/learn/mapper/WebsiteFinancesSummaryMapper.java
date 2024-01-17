package com.easy.learn.mapper;

import com.easy.learn.dto.WebsiteFinancesSummaryDTO;
import com.easy.learn.entity.WebsiteFinancesSummary;
import org.springframework.stereotype.Service;

@Service
public class WebsiteFinancesSummaryMapper extends AbstractMapper<WebsiteFinancesSummary, WebsiteFinancesSummaryDTO>{
    public WebsiteFinancesSummaryMapper (){
        super(WebsiteFinancesSummary.class, WebsiteFinancesSummaryDTO.class);
    }
}
