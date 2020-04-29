package net.scode.budmall.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.scode.budmall.server.dto.banner.OuterChainBannerDto;
import net.scode.budmall.server.dto.banner.ProductBannerDto;
import net.scode.budmall.server.po.Banner;
import net.scode.budmall.server.vo.appVo.banner.BannerAppVo;

import java.util.List;

/**
 * Banner对应Service
 *
 * @author liuyoubin 2020年04月22日
 */
public interface BannerService extends IService<Banner> {

    /**
     * 获取指定位置的横幅信息Vo列表
     *
     * @param position 位置
     * @return 横幅信息列表
     */
    List<BannerAppVo> listBannerVoByPosition(Integer position);

    /**
     * 获取指定位置的横幅信息列表
     *
     * @param position 位置
     * @return 横幅信息列表
     */
    List<Banner> listBannerByPosition(Integer position);

    /**
     * 添加商品横幅信息
     *
     * @param productBannerDto 商品横幅信息Dto
     * @return 是否添加成功
     */
    boolean saveBanner(ProductBannerDto productBannerDto);

    /**
     * 添加外链横幅信息
     *
     * @param outerChainBannerDto 外链横幅信息Dto
     * @return 是否添加成功
     */
    boolean saveBanner(OuterChainBannerDto outerChainBannerDto);

    /**
     * 修改商品横幅信息
     *
     * @param id               横幅id
     * @param productBannerDto 商品横幅信息Dto
     * @return 是否修改成功
     */
    boolean updateBanner(Integer id, ProductBannerDto productBannerDto);

    /**
     * 修改外链横幅信息
     *
     * @param id                  横幅id
     * @param outerChainBannerDto 外链横幅信息Dto
     * @return 是否修改成功
     */
    boolean updateBanner(Integer id, OuterChainBannerDto outerChainBannerDto);


}