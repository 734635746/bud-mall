package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.config.AppConfig;
import net.scode.budmall.server.consts.BannerTypeEnum;
import net.scode.budmall.server.dao.BannerDao;
import net.scode.budmall.server.dto.banner.OuterChainBannerDto;
import net.scode.budmall.server.dto.banner.ProductBannerDto;
import net.scode.budmall.server.po.Banner;
import net.scode.budmall.server.service.BannerService;
import net.scode.budmall.server.vo.appVo.banner.BannerAppVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Banner对应service实现
 *
 * @author liuyoubin 2020年04月22日
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerDao, Banner> implements BannerService {

    @Autowired
    private AppConfig appConfig;

    @Override
    public List<BannerAppVo> listBannerVoByPosition(Integer position) {
        //查询
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("position", position);
        queryWrapper.select("title", "image", "content", "type");
        List<Banner> list = list(queryWrapper);

        List<BannerAppVo> bannerAppVos = list.stream().map(banner -> {
            BannerAppVo bannerAppVo = new BannerAppVo();
            BeanUtils.copyProperties(banner, bannerAppVo);
            return bannerAppVo;
        }).collect(Collectors.toList());

        return bannerAppVos;
    }

    @Override
    public List<Banner> listBannerByPosition(Integer position) {

        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("position", position);

        return list(queryWrapper);
    }

    @Override
    public boolean saveBanner(ProductBannerDto productBannerDto) {

        return updateBanner(0, productBannerDto);
    }

    @Override
    public boolean saveBanner(OuterChainBannerDto outerChainBannerDto) {

        return updateBanner(0, outerChainBannerDto);
    }

    @Override
    public boolean updateBanner(Integer id, ProductBannerDto productBannerDto) {

        Banner banner = new Banner();

        BeanUtils.copyProperties(productBannerDto, banner);
        //设置横幅类型
        banner.setType(BannerTypeEnum.Product.getType());
        //处理并设置横幅内容(商品地址)
        int productId = productBannerDto.getProductId();
        int skuId = productBannerDto.getSkuId();
        String productUrl = appConfig.getProductUrl() + "/" + productId + "?sku_id=" + skuId;
        banner.setContent(productUrl);

        if (id == 0) {//添加操作
            return save(banner);
        } else {//修改操作
            banner.setId(id);
            return updateById(banner);
        }

    }

    @Override
    public boolean updateBanner(Integer id, OuterChainBannerDto outerChainBannerDto) {

        Banner banner = new Banner();

        BeanUtils.copyProperties(outerChainBannerDto, banner);
        //设置横幅类型
        banner.setType(BannerTypeEnum.OuterChain.getType());
        //设置横幅内容（外链地址）
        banner.setContent(outerChainBannerDto.getOuterChain());

        if (id == 0) {//添加操作
            return save(banner);
        } else {//修改操作
            banner.setId(id);
            return updateById(banner);
        }

    }
}