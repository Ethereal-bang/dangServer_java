package dangserver.service;

import dangserver.mapper.AdMapper;
import dangserver.pojo.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {
    private AdMapper adMapper;

    @Autowired
    public void setAdMapper(AdMapper adMapper) {
        this.adMapper = adMapper;
    }

    @Override
    public Ad[] getByPos(String pos) {
        return adMapper.getByPos(pos);
    }
}
