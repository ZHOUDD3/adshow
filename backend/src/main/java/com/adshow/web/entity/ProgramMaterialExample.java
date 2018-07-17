package com.adshow.web.entity;

import java.util.ArrayList;
import java.util.List;

public class ProgramMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ProgramMaterialExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProgramIdIsNull() {
            addCriterion("program_id is null");
            return (Criteria) this;
        }

        public Criteria andProgramIdIsNotNull() {
            addCriterion("program_id is not null");
            return (Criteria) this;
        }

        public Criteria andProgramIdEqualTo(String value) {
            addCriterion("program_id =", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotEqualTo(String value) {
            addCriterion("program_id <>", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThan(String value) {
            addCriterion("program_id >", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThanOrEqualTo(String value) {
            addCriterion("program_id >=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThan(String value) {
            addCriterion("program_id <", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThanOrEqualTo(String value) {
            addCriterion("program_id <=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLike(String value) {
            addCriterion("program_id like", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotLike(String value) {
            addCriterion("program_id not like", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdIn(List<String> values) {
            addCriterion("program_id in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotIn(List<String> values) {
            addCriterion("program_id not in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdBetween(String value1, String value2) {
            addCriterion("program_id between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotBetween(String value1, String value2) {
            addCriterion("program_id not between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionIsNull() {
            addCriterion("material_position is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionIsNotNull() {
            addCriterion("material_position is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionEqualTo(String value) {
            addCriterion("material_position =", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionNotEqualTo(String value) {
            addCriterion("material_position <>", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionGreaterThan(String value) {
            addCriterion("material_position >", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionGreaterThanOrEqualTo(String value) {
            addCriterion("material_position >=", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionLessThan(String value) {
            addCriterion("material_position <", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionLessThanOrEqualTo(String value) {
            addCriterion("material_position <=", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionLike(String value) {
            addCriterion("material_position like", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionNotLike(String value) {
            addCriterion("material_position not like", value, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionIn(List<String> values) {
            addCriterion("material_position in", values, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionNotIn(List<String> values) {
            addCriterion("material_position not in", values, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionBetween(String value1, String value2) {
            addCriterion("material_position between", value1, value2, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialPositionNotBetween(String value1, String value2) {
            addCriterion("material_position not between", value1, value2, "materialPosition");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeIsNull() {
            addCriterion("material_size is null");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeIsNotNull() {
            addCriterion("material_size is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeEqualTo(String value) {
            addCriterion("material_size =", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeNotEqualTo(String value) {
            addCriterion("material_size <>", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeGreaterThan(String value) {
            addCriterion("material_size >", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeGreaterThanOrEqualTo(String value) {
            addCriterion("material_size >=", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeLessThan(String value) {
            addCriterion("material_size <", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeLessThanOrEqualTo(String value) {
            addCriterion("material_size <=", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeLike(String value) {
            addCriterion("material_size like", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeNotLike(String value) {
            addCriterion("material_size not like", value, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeIn(List<String> values) {
            addCriterion("material_size in", values, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeNotIn(List<String> values) {
            addCriterion("material_size not in", values, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeBetween(String value1, String value2) {
            addCriterion("material_size between", value1, value2, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialSizeNotBetween(String value1, String value2) {
            addCriterion("material_size not between", value1, value2, "materialSize");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalIsNull() {
            addCriterion("material_interval is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalIsNotNull() {
            addCriterion("material_interval is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalEqualTo(String value) {
            addCriterion("material_interval =", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalNotEqualTo(String value) {
            addCriterion("material_interval <>", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalGreaterThan(String value) {
            addCriterion("material_interval >", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("material_interval >=", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalLessThan(String value) {
            addCriterion("material_interval <", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalLessThanOrEqualTo(String value) {
            addCriterion("material_interval <=", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalLike(String value) {
            addCriterion("material_interval like", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalNotLike(String value) {
            addCriterion("material_interval not like", value, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalIn(List<String> values) {
            addCriterion("material_interval in", values, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalNotIn(List<String> values) {
            addCriterion("material_interval not in", values, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalBetween(String value1, String value2) {
            addCriterion("material_interval between", value1, value2, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialIntervalNotBetween(String value1, String value2) {
            addCriterion("material_interval not between", value1, value2, "materialInterval");
            return (Criteria) this;
        }

        public Criteria andMaterialOderIsNull() {
            addCriterion("material_oder is null");
            return (Criteria) this;
        }

        public Criteria andMaterialOderIsNotNull() {
            addCriterion("material_oder is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialOderEqualTo(String value) {
            addCriterion("material_oder =", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderNotEqualTo(String value) {
            addCriterion("material_oder <>", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderGreaterThan(String value) {
            addCriterion("material_oder >", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderGreaterThanOrEqualTo(String value) {
            addCriterion("material_oder >=", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderLessThan(String value) {
            addCriterion("material_oder <", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderLessThanOrEqualTo(String value) {
            addCriterion("material_oder <=", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderLike(String value) {
            addCriterion("material_oder like", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderNotLike(String value) {
            addCriterion("material_oder not like", value, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderIn(List<String> values) {
            addCriterion("material_oder in", values, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderNotIn(List<String> values) {
            addCriterion("material_oder not in", values, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderBetween(String value1, String value2) {
            addCriterion("material_oder between", value1, value2, "materialOder");
            return (Criteria) this;
        }

        public Criteria andMaterialOderNotBetween(String value1, String value2) {
            addCriterion("material_oder not between", value1, value2, "materialOder");
            return (Criteria) this;
        }
    }

    /**
     */
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