package org.perry.wechat.service.impl;

import java.util.List;
import java.util.UUID;

import org.perry.wechat.model.Goods;
import org.perry.wechat.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "goods";

    @Override
    public Goods addGoods(Goods goods) {
        if (!mongoTemplate.collectionExists(Goods.class)) {
            mongoTemplate.createCollection(Goods.class);
        }
        goods.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(goods, COLLECTION_NAME);
        return goods;
    }

    @Override
    public List<Goods> listPerson() {
        List<Goods> list = mongoTemplate.findAll(Goods.class, COLLECTION_NAME);
        return list;
    }

    @Override
    public void deleteGoods(Goods goods) {
        mongoTemplate.remove(goods, COLLECTION_NAME);
    }

    @Override
    public Goods updateGoods(Goods goods) {
        Update update = new Update();
        update.set("name", goods.getName());
        update.set("readOnly", goods.getReadOnly());
        mongoTemplate.upsert(new Query(Criteria.where("id").is(goods.getId())),
                update, Goods.class, COLLECTION_NAME);
        return goods;
    }
}
