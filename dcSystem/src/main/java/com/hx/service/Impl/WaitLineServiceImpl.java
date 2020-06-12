package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.WaitLine;
import com.hx.mapper.BaseMapper;
import com.hx.mapper.WaitLineMapper;
import com.hx.service.WaitLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/5/17.
 */
@Service
public class WaitLineServiceImpl extends YonlieServiceImpl<WaitLine> implements WaitLineService {
    @Override
    public int updateByPrimaryKeySelective(int id, String state) {
        WaitLine wait_line =new WaitLine();
        wait_line.setLineId(id);
        wait_line.setLineState(state);
        wait_line.setDealTime(getDatetoString());
        return wait_lineMapper.updateByPrimaryKeySelective(wait_line);
    }

    @Autowired
    private WaitLineMapper wait_lineMapper;

    @Override
    public BaseMapper<WaitLine> getMapper() {
        return wait_lineMapper;
    }

    @Override
    public WaitLine selectLast() {
        return wait_lineMapper.selectLast();
    }

    //重置排序号，修改排序字段为**|#形式，下次新增就会从1开始
    @Override
    public int ReloadPx() {
       WaitLine wait_line = wait_lineMapper.selectLast();
        String xh = wait_line.getLineXh().split("|")[0];
        wait_line.setLineXh(xh + "|#");
        System.out.println(wait_line);
        return wait_lineMapper.updateByPrimaryKeySelective(wait_line);
    }

    //新增排序记录
    @Override
    public int insertSelective(WaitLine wait_line) {
        int xh = 0;
        //判断序号是否从零开始
        if (selectLast() != null) {
            String state = selectLast().getLineXh();
            String tem[] = state.split("|");
            System.out.println(state);
            if (state.contains("@")) {
                System.out.println(tem);
                xh = Integer.parseInt(tem[0]) + 1;
            } else if (state.contains("#")) {
                xh = 1;
            } else {
                System.out.println("erro");
            }
        } else {
            xh = 1;
        }
        wait_line.setLineXh(xh + "|@");
        wait_line.setBeginTime(getDatetoString());
        wait_line.setLineState("0");//设置排队状态为排队中
        // System.out.println(wait_line);
        return getMapper().insertSelective(wait_line);
    }

    //整理序号显示问题
    @Override
    public PageInfo<WaitLine> selectPage(Integer pageIndex, Integer pageSize, WaitLine t) {
        PageHelper.startPage(pageIndex, pageSize);
        List<WaitLine> list = getMapper().selectPage(t);
        for (WaitLine w : list) {
            w.setLineXh(w.getLineXh().split("|")[0]);
        }
        PageInfo<WaitLine> pageInfo = new PageInfo<WaitLine>(list);
        return pageInfo;
    }
}
