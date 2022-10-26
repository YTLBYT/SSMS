package cn.wolfcode.service.imp;

import cn.wolfcode.dao.PicAuthorDao;
import cn.wolfcode.entity.PicAuthor;
import cn.wolfcode.service.PicAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PicAuthorServiceImpl implements PicAuthorService {

    @Autowired
    PicAuthorDao picAuthorMapper;


    @Override
    public Integer getPicUid(String name) {

        Integer picuid = picAuthorMapper.selectAuthor(name);

        return picuid;
    }

    @Override
    public void addAuthor(PicAuthor author) {

        picAuthorMapper.insertAuthor(author);
    }
}
