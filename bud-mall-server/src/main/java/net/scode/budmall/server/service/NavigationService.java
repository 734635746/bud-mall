package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.navigation.CategoryNavigationDto;
import net.scode.budmall.server.po.Navigation;
import net.scode.budmall.server.vo.navigation.NavigationVo;

import java.util.List;

/**
 * Navigation对应Service
 *
 * @author liuyoubin 2020年04月23日
 */
public interface NavigationService extends IService<Navigation> {

    /**
     * 获取NavigationVo列表
     *
     * @return NavigationVo列表
     */
    List<NavigationVo> listNavigations();

    /**
     * 添加商品导航
     *
     * @param categoryNavigationDto 商品导航Dto
     * @return 是否添加成功
     */
    boolean saveNavigation(CategoryNavigationDto categoryNavigationDto);

    /**
     * 修改商品导航
     *
     * @param id                    导航信息id
     * @param categoryNavigationDto 商品导航Dto
     * @return 是否修改成功
     */
    boolean updateNavigation(Integer id, CategoryNavigationDto categoryNavigationDto);
}