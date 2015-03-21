package org.perry.wechat.controller;

import java.util.List;

import org.perry.wechat.model.Goods;
import org.perry.wechat.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/kfc/brands")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/goods", method = RequestMethod.GET)
	public @ResponseBody List<Goods> getPersonList(ModelMap model) {  
        return goodsService.listPerson();  
    }
    @RequestMapping(value = "/goods", method = RequestMethod.POST)  
    public @ResponseBody Goods createGoods(@RequestBody Goods goods) {
        if(StringUtils.hasText(goods.getId())) {
            goods = goodsService.updateGoods(goods);
        } else {
            goods = goodsService.addGoods(goods);
        }
        return goods;  
    }
    @RequestMapping(value="/goods/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeGoods(@PathVariable String id) {
        Goods goods = new Goods();
        goods.setId(id);
        goodsService.deleteGoods(goods);
    }
}
