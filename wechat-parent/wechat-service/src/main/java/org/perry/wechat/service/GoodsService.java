package org.perry.wechat.service;

import java.util.List;

import org.perry.wechat.model.Goods;

public interface GoodsService {

	List<Goods> listPerson();

	Goods addGoods(Goods goods);

    void deleteGoods(Goods goods);

    Goods updateGoods(Goods goods);

}
