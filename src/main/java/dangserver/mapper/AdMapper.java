package dangserver.mapper;

import dangserver.pojo.Ad;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdMapper {

    Ad[] getByPos(String pos);

}
