package top.sl.tmpp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import top.sl.tmpp.entity.Discounts;
import top.sl.tmpp.entity.DiscountsExample;
import top.sl.tmpp.exception.DiscountsNullException;
import top.sl.tmpp.exception.NoIdException;
import top.sl.tmpp.mapper.DiscountsMapper;
import top.sl.tmpp.service.DiscountsService;

import java.math.BigDecimal;
import java.util.List;
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
        if (discount == null) {
            log.debug("添加折扣失败");
            throw new DiscountsNullException("discount is null add discount failure", HttpStatus.BAD_REQUEST);
        }
        log.debug("添加折扣");
        Discounts discounts = new Discounts(UUID.randomUUID().toString().replace("-", ""), discount);
        discountsMapper.insert(discounts);
    }

    @Override
    public List<Discounts> getAllDiscount() {
        DiscountsExample discountsExample = new DiscountsExample();
        discountsExample.createCriteria().andIdIsNotNull();
        List<Discounts> discounts = discountsMapper.selectByExample(discountsExample);
        log.debug("查找全部折扣");
        return discounts;
    }

    @Override
    public void remove(String id) {
        if (StringUtils.isEmpty(id) || discountsMapper.selectByPrimaryKey(id) == null) {
            log.debug("删除失败");
            throw new NoIdException("没有折扣id，无法删除", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.debug("删除折扣");
        discountsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modify(String id, BigDecimal discount) {
        if (discount == null || discountsMapper.selectByPrimaryKey(id) == null) {
            log.debug("修改折扣失败");
            throw new DiscountsNullException("discount is null add discount failure", HttpStatus.BAD_REQUEST);
        }
        log.debug("修改折扣");
        discountsMapper.updateByPrimaryKey(new Discounts(id, discount));
    }
}
