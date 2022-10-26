package cn.wolfcode.service.imp;

import cn.wolfcode.dao.LogDao;
import cn.wolfcode.entity.T_Log;
import cn.wolfcode.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logMapper;
    @Override
    public void addLog(T_Log t_log) {
        logMapper.insert(t_log);
    }
}
