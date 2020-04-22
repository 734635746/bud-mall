package net.scode.budmall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.scode.budmall.server.dao.BannerDao;
import net.scode.budmall.server.po.Banner;
import net.scode.budmall.server.service.BannerService;
import net.scode.budmall.server.vo.banner.BannerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Banner对应service实现
 *
 * @author liuyoubin 2020年04月22日
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerDao, Banner> implements BannerService {

    @Override
    public List<BannerVo> listBannerByPosition(Integer position) {


        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("position", position);
        queryWrapper.select("title", "image", "content");
        List<Banner> list = list(queryWrapper);

        //BannerVo列表
        List<BannerVo> bannerVos = new ArrayList<>();
        for (Banner banner : list) {
            BannerVo bannerVo = new BannerVo();
            BeanUtils.copyProperties(banner, bannerVo);
            bannerVos.add(bannerVo);
        }

        return bannerVos;
    }
}