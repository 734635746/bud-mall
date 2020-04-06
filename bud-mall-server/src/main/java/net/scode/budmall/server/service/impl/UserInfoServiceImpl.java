package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.UserInfoDao;
import net.scode.budmall.server.po.UserInfo;
import net.scode.budmall.server.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * UserInfo对应service实现
 * 
 * @author liuyoubin 2020年04月06日 
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao,UserInfo> implements UserInfoService {

}