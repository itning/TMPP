package top.sl.tmpp.discounts.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import top.sl.tmpp.discounts.service.DiscountsService;
import top.sl.tmpp.common.entity.Discounts;
import top.sl.tmpp.common.entity.DiscountsExample;
import top.sl.tmpp.discounts.exception.DiscountsNullException;
import top.sl.tmpp.discounts.exception.NoIdException;
import top.sl.tmpp.common.mapper.DiscountsMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ShuLu
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
        Discounts discounts = new Discounts(UUID.randomUUID().toString().replace("-", ""), discount,null,new Date());
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
        Discounts modifyDiscount = discountsMapper.selectByPrimaryKey(id);
        if (discount == null || modifyDiscount == null) {
            log.debug("修改折扣失败");
            throw new DiscountsNullException("discount is null add discount failure", HttpStatus.BAD_REQUEST);
        }
        log.debug("修改折扣");
        modifyDiscount.setDiscount(discount);
        modifyDiscount.setGmtModified(new Date());
        discountsMapper.updateByPrimaryKey(modifyDiscount);
    }
}
