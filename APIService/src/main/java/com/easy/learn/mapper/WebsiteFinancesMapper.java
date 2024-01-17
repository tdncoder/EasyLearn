package com.easy.learn.mapper;

import com.easy.learn.dto.WebsiteFinancesDTO;
import com.easy.learn.entity.WebsiteFinances;
import org.springframework.stereotype.Service;

@Service
public class WebsiteFinancesMapper extends AbstractMapper<WebsiteFinances, WebsiteFinancesDTO>{
    public WebsiteFinancesMapper(){
        super(WebsiteFinances.class,WebsiteFinancesDTO.class);
    }
}
