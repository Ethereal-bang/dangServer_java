package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private int id, comments, ranking;
    private String name, img, price_now, price_old,
            type, genre, description, author, process;
}
