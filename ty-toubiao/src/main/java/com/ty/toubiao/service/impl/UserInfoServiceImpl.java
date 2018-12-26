package com.ty.toubiao.service.impl;

import com.ty.toubiao.base.NativeFinder;
import com.ty.toubiao.base.NativeQuery;
import com.ty.toubiao.bean.UserInfo;
import com.ty.toubiao.dao.UserInfoRepository;
import com.ty.toubiao.service.UserInfoService;
import com.ty.toubiao.specification.SimpleSpecificationBuilder;
import com.ty.toubiao.specification.SpecifcationOprEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.service.impl
 * @Description: TODO
 * @date 2018/12/25 15:03
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserInfo getOne(Integer id) {
        UserInfo one = userInfoRepository.getOne(id);
        return one;
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Override
    public UserInfo test1(Integer id) {

        NativeQuery init = NativeQuery.init(entityManager);
        //sql查询
        String sql1 = "select * from t_user_info u where u.phone =:phone and u.nick_name = :nickname";
        init.setParameter("phone","18320758880");
        init.setParameter("nickname","mofan");
        List list2 = init.queryBySql(sql1);

        //hql查询
        String hql1 = "select u from com.ty.toubiao.bean.UserInfo u where u.userId != :userid";
        init.clearParameter();
        init.setParameter("userid",100000);
        List list3 = init.queryByHql(hql1);

        //sql update
        String sql2 = "update t_user_info u set u.email = :email where u.phone =:phone and u.nick_name = :nickname";
        init.clearParameter();
        init.setParameter("phone","18320758880");
        init.setParameter("nickname","mofan");
        init.setParameter("email","mofancoder@163.com");
        init.modifyBySql(sql2);

        //hql update
        String hql2 = "update com.ty.toubiao.bean.UserInfo u set u.iconUrl =:iconUrl where u.userId != :userid";
        init.clearParameter();
        init.setParameter("userid",100000);
        init.setParameter("iconUrl","hhhhh");
        init.modifyByHql(hql2);

        //sql 插入
        String sql3 = "insert into t_user_info (`user_id`) VALUES ('889');";
        init.clearParameter();
        init.modifyBySql(sql3);
        return null;
    }

    /**
     * 原生sql及hql测试,占位符？
     * @param id
     * @return
     */
    @Override
    public UserInfo test2(Integer id) {

        NativeFinder init = NativeFinder.init(entityManager);

        //sql 占位符从1开始
        String sql1 = "select * from t_user_info u where u.phone = ? and u.nick_name = ?";
        Query query = entityManager.createNativeQuery(sql1);
        init.setParameter("18320758880");
        init.setParameter("mofan");
        List list2 = init.queryBySql(sql1);

        //hql 占位符从0开始
        String hql1 = "select u from com.ty.toubiao.bean.UserInfo u where u.userId != ?";
        init.clearParameter();
        init.setParameter(100000);
        List list3 = init.queryByHql(hql1);
        return null;
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Override
    public UserInfo test3(Integer id) {
        NativeQuery init = NativeQuery.init(entityManager);
        //sql delete
        String sql2 = "delete from t_user_info where phone =:phone and nick_name =:nickname";
        init.clearParameter();
        init.setParameter("phone","18320758880");
        init.setParameter("nickname","mofan");
        init.modifyBySql(sql2);

        //hql delete
        String hql2 = "delete from com.ty.toubiao.bean.UserInfo where userId =:userid";
        init.clearParameter();
        init.setParameter("userid",100000);
        init.modifyByHql(hql2);
        return null;
    }

    @Override
    public UserInfo test4(Integer id) {
        UserInfo userInfo = UserInfo.builder().userId(889).nickName("mofan").account("songliang").phone("18888888888").build();

        SimpleSpecificationBuilder<UserInfo> init = SimpleSpecificationBuilder.init();
        init.addAnd("userId",userInfo.getUserId(), SpecifcationOprEnum.EQUAL,Integer.class);
        init.addOr("nickName",userInfo.getNickName(),SpecifcationOprEnum.EQUAL,String.class);
        init.addOr("account",userInfo.getAccount(),SpecifcationOprEnum.EQUAL,String.class);
        init.addOr("phone",userInfo.getPhone(),SpecifcationOprEnum.EQUAL,String.class);
        Specification specification = init.generateSpecification();
        Page page = userInfoRepository.findAll(specification, PageRequest.of(0, 10, Sort.Direction.ASC, "loginPwd"));
        return null;
    }

}
