package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.config.AppConfig;
import net.scode.budmall.server.consts.NavigationTypeEnum;
import net.scode.budmall.server.dao.NavigationDao;
import net.scode.budmall.server.dto.navigation.CategoryNavigationDto;
import net.scode.budmall.server.po.Navigation;
import net.scode.budmall.server.service.NavigationService;
import net.scode.budmall.server.vo.navigation.NavigationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Navigation对应service实现
 *
 * @author liuyoubin 2020年04月23日
 */
@Service
public class NavigationServiceImpl extends ServiceImpl<NavigationDao, Navigation> implements NavigationService {

    @Autowired
    private AppConfig appConfig;

    @Override
    public List<NavigationVo> listNavigations() {

        //构造查询参数
        QueryWrapper<Navigation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("title", "image", "content");
        List<Navigation> list = list(queryWrapper);

        List<NavigationVo> navigationVoList = list.stream().map(navigation -> {
            NavigationVo navigationVo = new NavigationVo();
            BeanUtils.copyProperties(navigation, navigationVo);
            return navigationVo;
        }).collect(Collectors.toList());

        return navigationVoList;
    }


    @Override
    public boolean saveNavigation(CategoryNavigationDto categoryNavigationDto) {

        return updateNavigation(0, categoryNavigationDto);
    }

    @Override
    public boolean updateNavigation(Integer id, CategoryNavigationDto categoryNavigationDto) {

        Navigation navigation = new Navigation();
        BeanUtils.copyProperties(categoryNavigationDto, navigation);

        //设置导航类型
        navigation.setType(NavigationTypeEnum.Category.getType());
        //设置导航内容（分类跳转地址）
        String url = appConfig.getProductUrl() + "/list?category=" + categoryNavigationDto.getCategoryId();
        navigation.setContent(url);

        if (id == 0) {//添加导航
            return save(navigation);
        } else {//修改导航
            navigation.setId(id);
            return updateById(navigation);
        }
    }
}