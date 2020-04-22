package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.po.Banner;
import net.scode.budmall.server.vo.banner.BannerVo;

import java.util.List;

/**
 * Banner对应Service
 *
 * @author liuyoubin 2020年04月22日
 */
public interface BannerService extends IService<Banner> {

    /**
     * 获取指定位置的横幅信息列表
     *
     * @param position 位置
     * @return 横幅信息列表
     */
    List<BannerVo> listBannerByPosition(Integer position);
}