package top.sl.tmpp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import top.sl.tmpp.mapper.DiscountsMapper;
import top.sl.tmpp.entity.Discounts;
import top.sl.tmpp.exception.DiscountsNullException;
import top.sl.tmpp.service.DiscountsService;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 11578
 */
@Service
public class DiscountsServiceImpl implements DiscountsService {
    private final DiscountsMapper discountsMapper;
    private Logger log = LoggerFactory.getLogger(DiscountsServiceImpl.class);
    public DiscountsServiceImpl(DiscountsMapper discountsMapper) {
        this.discountsMapper = discountsMapper;
    }

    @Override
    public void save(BigDecimal discount) {
        if (discount==null){
            log.debug("添加折扣失败");
            throw new DiscountsNullException("discount is null add discount failure", HttpStatus.BAD_REQUEST);
        }
        log.debug("添加折扣");
        Discounts discounts = new Discounts(UUID.randomUUID().toString().replace("-", ""), discount);
        discountsMapper.insert(discounts);
    }
}
