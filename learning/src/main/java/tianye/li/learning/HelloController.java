package tianye.li.learning;
/**
 * Created by litianye on 2019-07-17
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: learning
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-17
 **/

@RestController
public class HelloController {

    @RequestMapping(value = "/Dio", method = RequestMethod.GET)
    public String world() {
        return "The World";
    }
}
