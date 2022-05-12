package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private int _id, comments, ranking;

    private String name, img, type, genre, description, author, process;

    private float price_now, price_old;
//    private String[] img;
}
