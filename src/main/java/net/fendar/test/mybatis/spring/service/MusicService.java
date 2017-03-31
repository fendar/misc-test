package net.fendar.test.mybatis.spring.service;

import net.fendar.test.mybatis.domain.Music;
import net.fendar.test.mybatis.spring.dao.MusicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhongchao on 16/4/12.
 */
@Service
public class MusicService {
    @Resource
    private MusicMapper musicMapper;

    public Music getMusicById(int id) {
        return musicMapper.getById(id);
    }
}
