package com.ty.toubiao.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.specification
 * @Description: 重写Specification的toPredicate方法
 * @date 2018/12/26 9:09
 */
public class SimpleSpecification<T> implements Specification<T> {

    /**
     * 查询的条件列表，是一组列表
     * */
    private List<SpecificationOperator> oprs;

    public SimpleSpecification(List<SpecificationOperator> oprs) {
        this.oprs = oprs;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        int index = 0;
        Predicate resultPre = null;
        for(SpecificationOperator op:oprs) {
            if(index++==0) {
                resultPre = generatePredicate(root,criteriaBuilder,op);
                continue;
            }
            Predicate pre = generatePredicate(root,criteriaBuilder,op);
            if(pre==null) continue;
            if(SpecifcationRelationEnum.AND.getCode().equals(op.getRelation().getCode())) {
                resultPre = criteriaBuilder.and(resultPre,pre);
            } else if(SpecifcationRelationEnum.OR.getCode().equals(op.getRelation().getCode())) {
                resultPre = criteriaBuilder.or(resultPre,pre);
            }
        }
        return resultPre;
    }

    /**
     * 根据不同的运算符拼接不同的关系
     * @param root
     * @param criteriaBuilder
     * @param op
     * @return
     */
    private Predicate generatePredicate(Root<T> root, CriteriaBuilder criteriaBuilder, SpecificationOperator op) {
        if(SpecifcationOprEnum.EQUAL.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.equal(root.get(op.getKey()).as(op.getClazz()),op.getValue());
        } else if(SpecifcationOprEnum.GREATERTHANOREQUALTO.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(op.getKey()).as(op.getClazz()), (Comparable)op.getValue());
        } else if(SpecifcationOprEnum.LESSTHANOREQUALTO.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(op.getKey()).as(op.getClazz()), (Comparable)op.getValue());
        } else if(SpecifcationOprEnum.GREATERTHAN.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.greaterThan(root.get(op.getKey()).as(op.getClazz()), (Comparable)op.getValue());
        } else if(SpecifcationOprEnum.LESSTHAN.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.lessThan(root.get(op.getKey()).as(op.getClazz()), (Comparable)op.getValue());
        } else if(SpecifcationOprEnum.LIKE.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.like(root.get(op.getKey()),String.valueOf(op.getValue()));
        } else if(SpecifcationOprEnum.NOTLIKE.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.notLike(root.get(op.getKey()),String.valueOf(op.getValue()));
        }else if(SpecifcationOprEnum.ISNULL.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.isNull(root.get(op.getKey()));
        } else if(SpecifcationOprEnum.NOTNULL.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.isNotNull(root.get(op.getKey()));
        } else if(SpecifcationOprEnum.NOTEQUAL.getCode().equals(op.getOpr().getCode())) {
            return criteriaBuilder.notEqual(root.get(op.getKey()),op.getValue());
        }

        return null;
    }

}
