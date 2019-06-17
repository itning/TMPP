package top.sl.tmpp.common.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNull() {
            addCriterion("isbn is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("isbn is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("isbn =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("isbn <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("isbn >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("isbn >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("isbn <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("isbn <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("isbn like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("isbn not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("isbn in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("isbn not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("isbn between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("isbn not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andTextBookNameIsNull() {
            addCriterion("text_book_name is null");
            return (Criteria) this;
        }

        public Criteria andTextBookNameIsNotNull() {
            addCriterion("text_book_name is not null");
            return (Criteria) this;
        }

        public Criteria andTextBookNameEqualTo(String value) {
            addCriterion("text_book_name =", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameNotEqualTo(String value) {
            addCriterion("text_book_name <>", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameGreaterThan(String value) {
            addCriterion("text_book_name >", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("text_book_name >=", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameLessThan(String value) {
            addCriterion("text_book_name <", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameLessThanOrEqualTo(String value) {
            addCriterion("text_book_name <=", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameLike(String value) {
            addCriterion("text_book_name like", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameNotLike(String value) {
            addCriterion("text_book_name not like", value, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameIn(List<String> values) {
            addCriterion("text_book_name in", values, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameNotIn(List<String> values) {
            addCriterion("text_book_name not in", values, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameBetween(String value1, String value2) {
            addCriterion("text_book_name between", value1, value2, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookNameNotBetween(String value1, String value2) {
            addCriterion("text_book_name not between", value1, value2, "textBookName");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryIsNull() {
            addCriterion("text_book_category is null");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryIsNotNull() {
            addCriterion("text_book_category is not null");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryEqualTo(Integer value) {
            addCriterion("text_book_category =", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryNotEqualTo(Integer value) {
            addCriterion("text_book_category <>", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryGreaterThan(Integer value) {
            addCriterion("text_book_category >", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("text_book_category >=", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryLessThan(Integer value) {
            addCriterion("text_book_category <", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("text_book_category <=", value, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryIn(List<Integer> values) {
            addCriterion("text_book_category in", values, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryNotIn(List<Integer> values) {
            addCriterion("text_book_category not in", values, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryBetween(Integer value1, Integer value2) {
            addCriterion("text_book_category between", value1, value2, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andTextBookCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("text_book_category not between", value1, value2, "textBookCategory");
            return (Criteria) this;
        }

        public Criteria andPressIsNull() {
            addCriterion("press is null");
            return (Criteria) this;
        }

        public Criteria andPressIsNotNull() {
            addCriterion("press is not null");
            return (Criteria) this;
        }

        public Criteria andPressEqualTo(Integer value) {
            addCriterion("press =", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotEqualTo(Integer value) {
            addCriterion("press <>", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThan(Integer value) {
            addCriterion("press >", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThanOrEqualTo(Integer value) {
            addCriterion("press >=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThan(Integer value) {
            addCriterion("press <", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThanOrEqualTo(Integer value) {
            addCriterion("press <=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressIn(List<Integer> values) {
            addCriterion("press in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotIn(List<Integer> values) {
            addCriterion("press not in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressBetween(Integer value1, Integer value2) {
            addCriterion("press between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotBetween(Integer value1, Integer value2) {
            addCriterion("press not between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberIsNull() {
            addCriterion("teacher_book_number is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberIsNotNull() {
            addCriterion("teacher_book_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberEqualTo(Integer value) {
            addCriterion("teacher_book_number =", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberNotEqualTo(Integer value) {
            addCriterion("teacher_book_number <>", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberGreaterThan(Integer value) {
            addCriterion("teacher_book_number >", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_book_number >=", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberLessThan(Integer value) {
            addCriterion("teacher_book_number <", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_book_number <=", value, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberIn(List<Integer> values) {
            addCriterion("teacher_book_number in", values, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberNotIn(List<Integer> values) {
            addCriterion("teacher_book_number not in", values, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberBetween(Integer value1, Integer value2) {
            addCriterion("teacher_book_number between", value1, value2, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherBookNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_book_number not between", value1, value2, "teacherBookNumber");
            return (Criteria) this;
        }

        public Criteria andAwardInformationIsNull() {
            addCriterion("award_Information is null");
            return (Criteria) this;
        }

        public Criteria andAwardInformationIsNotNull() {
            addCriterion("award_Information is not null");
            return (Criteria) this;
        }

        public Criteria andAwardInformationEqualTo(String value) {
            addCriterion("award_Information =", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationNotEqualTo(String value) {
            addCriterion("award_Information <>", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationGreaterThan(String value) {
            addCriterion("award_Information >", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationGreaterThanOrEqualTo(String value) {
            addCriterion("award_Information >=", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationLessThan(String value) {
            addCriterion("award_Information <", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationLessThanOrEqualTo(String value) {
            addCriterion("award_Information <=", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationLike(String value) {
            addCriterion("award_Information like", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationNotLike(String value) {
            addCriterion("award_Information not like", value, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationIn(List<String> values) {
            addCriterion("award_Information in", values, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationNotIn(List<String> values) {
            addCriterion("award_Information not in", values, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationBetween(String value1, String value2) {
            addCriterion("award_Information between", value1, value2, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andAwardInformationNotBetween(String value1, String value2) {
            addCriterion("award_Information not between", value1, value2, "awardInformation");
            return (Criteria) this;
        }

        public Criteria andPublicationDateIsNull() {
            addCriterion("publication_date is null");
            return (Criteria) this;
        }

        public Criteria andPublicationDateIsNotNull() {
            addCriterion("publication_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublicationDateEqualTo(Date value) {
            addCriterion("publication_date =", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateNotEqualTo(Date value) {
            addCriterion("publication_date <>", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateGreaterThan(Date value) {
            addCriterion("publication_date >", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("publication_date >=", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateLessThan(Date value) {
            addCriterion("publication_date <", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateLessThanOrEqualTo(Date value) {
            addCriterion("publication_date <=", value, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateIn(List<Date> values) {
            addCriterion("publication_date in", values, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateNotIn(List<Date> values) {
            addCriterion("publication_date not in", values, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateBetween(Date value1, Date value2) {
            addCriterion("publication_date between", value1, value2, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andPublicationDateNotBetween(Date value1, Date value2) {
            addCriterion("publication_date not between", value1, value2, "publicationDate");
            return (Criteria) this;
        }

        public Criteria andSubscriberIsNull() {
            addCriterion("subscriber is null");
            return (Criteria) this;
        }

        public Criteria andSubscriberIsNotNull() {
            addCriterion("subscriber is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriberEqualTo(String value) {
            addCriterion("subscriber =", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberNotEqualTo(String value) {
            addCriterion("subscriber <>", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberGreaterThan(String value) {
            addCriterion("subscriber >", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberGreaterThanOrEqualTo(String value) {
            addCriterion("subscriber >=", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberLessThan(String value) {
            addCriterion("subscriber <", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberLessThanOrEqualTo(String value) {
            addCriterion("subscriber <=", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberLike(String value) {
            addCriterion("subscriber like", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberNotLike(String value) {
            addCriterion("subscriber not like", value, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberIn(List<String> values) {
            addCriterion("subscriber in", values, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberNotIn(List<String> values) {
            addCriterion("subscriber not in", values, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberBetween(String value1, String value2) {
            addCriterion("subscriber between", value1, value2, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberNotBetween(String value1, String value2) {
            addCriterion("subscriber not between", value1, value2, "subscriber");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelIsNull() {
            addCriterion("subscriber_tel is null");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelIsNotNull() {
            addCriterion("subscriber_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelEqualTo(Integer value) {
            addCriterion("subscriber_tel =", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelNotEqualTo(Integer value) {
            addCriterion("subscriber_tel <>", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelGreaterThan(Integer value) {
            addCriterion("subscriber_tel >", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelGreaterThanOrEqualTo(Integer value) {
            addCriterion("subscriber_tel >=", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelLessThan(Integer value) {
            addCriterion("subscriber_tel <", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelLessThanOrEqualTo(Integer value) {
            addCriterion("subscriber_tel <=", value, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelIn(List<Integer> values) {
            addCriterion("subscriber_tel in", values, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelNotIn(List<Integer> values) {
            addCriterion("subscriber_tel not in", values, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelBetween(Integer value1, Integer value2) {
            addCriterion("subscriber_tel between", value1, value2, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andSubscriberTelNotBetween(Integer value1, Integer value2) {
            addCriterion("subscriber_tel not between", value1, value2, "subscriberTel");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseIsNull() {
            addCriterion("is_book_purchase is null");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseIsNotNull() {
            addCriterion("is_book_purchase is not null");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseEqualTo(Integer value) {
            addCriterion("is_book_purchase =", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseNotEqualTo(Integer value) {
            addCriterion("is_book_purchase <>", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseGreaterThan(Integer value) {
            addCriterion("is_book_purchase >", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_book_purchase >=", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseLessThan(Integer value) {
            addCriterion("is_book_purchase <", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseLessThanOrEqualTo(Integer value) {
            addCriterion("is_book_purchase <=", value, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseIn(List<Integer> values) {
            addCriterion("is_book_purchase in", values, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseNotIn(List<Integer> values) {
            addCriterion("is_book_purchase not in", values, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseBetween(Integer value1, Integer value2) {
            addCriterion("is_book_purchase between", value1, value2, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andIsBookPurchaseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_book_purchase not between", value1, value2, "isBookPurchase");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNull() {
            addCriterion("discount_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNotNull() {
            addCriterion("discount_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdEqualTo(String value) {
            addCriterion("discount_id =", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotEqualTo(String value) {
            addCriterion("discount_id <>", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThan(String value) {
            addCriterion("discount_id >", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThanOrEqualTo(String value) {
            addCriterion("discount_id >=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThan(String value) {
            addCriterion("discount_id <", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThanOrEqualTo(String value) {
            addCriterion("discount_id <=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLike(String value) {
            addCriterion("discount_id like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotLike(String value) {
            addCriterion("discount_id not like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIn(List<String> values) {
            addCriterion("discount_id in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotIn(List<String> values) {
            addCriterion("discount_id not in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdBetween(String value1, String value2) {
            addCriterion("discount_id between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotBetween(String value1, String value2) {
            addCriterion("discount_id not between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberIsNull() {
            addCriterion("affairs_number is null");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberIsNotNull() {
            addCriterion("affairs_number is not null");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberEqualTo(Integer value) {
            addCriterion("affairs_number =", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberNotEqualTo(Integer value) {
            addCriterion("affairs_number <>", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberGreaterThan(Integer value) {
            addCriterion("affairs_number >", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("affairs_number >=", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberLessThan(Integer value) {
            addCriterion("affairs_number <", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("affairs_number <=", value, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberIn(List<Integer> values) {
            addCriterion("affairs_number in", values, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberNotIn(List<Integer> values) {
            addCriterion("affairs_number not in", values, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberBetween(Integer value1, Integer value2) {
            addCriterion("affairs_number between", value1, value2, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andAffairsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("affairs_number not between", value1, value2, "affairsNumber");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIsNull() {
            addCriterion("login_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIsNotNull() {
            addCriterion("login_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdEqualTo(String value) {
            addCriterion("login_user_id =", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotEqualTo(String value) {
            addCriterion("login_user_id <>", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdGreaterThan(String value) {
            addCriterion("login_user_id >", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("login_user_id >=", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLessThan(String value) {
            addCriterion("login_user_id <", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLessThanOrEqualTo(String value) {
            addCriterion("login_user_id <=", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLike(String value) {
            addCriterion("login_user_id like", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotLike(String value) {
            addCriterion("login_user_id not like", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIn(List<String> values) {
            addCriterion("login_user_id in", values, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotIn(List<String> values) {
            addCriterion("login_user_id not in", values, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdBetween(String value1, String value2) {
            addCriterion("login_user_id between", value1, value2, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotBetween(String value1, String value2) {
            addCriterion("login_user_id not between", value1, value2, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookIsNull() {
            addCriterion("is_buy_book is null");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookIsNotNull() {
            addCriterion("is_buy_book is not null");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookEqualTo(String value) {
            addCriterion("is_buy_book =", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookNotEqualTo(String value) {
            addCriterion("is_buy_book <>", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookGreaterThan(String value) {
            addCriterion("is_buy_book >", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookGreaterThanOrEqualTo(String value) {
            addCriterion("is_buy_book >=", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookLessThan(String value) {
            addCriterion("is_buy_book <", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookLessThanOrEqualTo(String value) {
            addCriterion("is_buy_book <=", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookLike(String value) {
            addCriterion("is_buy_book like", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookNotLike(String value) {
            addCriterion("is_buy_book not like", value, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookIn(List<String> values) {
            addCriterion("is_buy_book in", values, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookNotIn(List<String> values) {
            addCriterion("is_buy_book not in", values, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookBetween(String value1, String value2) {
            addCriterion("is_buy_book between", value1, value2, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andIsBuyBookNotBetween(String value1, String value2) {
            addCriterion("is_buy_book not between", value1, value2, "isBuyBook");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}