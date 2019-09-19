package DP23.Structure.Adapter;
/**
 * Created by litianye on 2019-07-10
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-10
 **/

public class ComposeAdapter implements JobNeedSkills {
    private Worker worker;

    public ComposeAdapter(Worker worker) {
        this.worker = worker;
    }

    public void speakChinese() {
        worker.speakChinese();
    }

    public void goodCoding() {
        worker.goodConding();
    }

    @Override
    public void speakEnglish() {

    }
}
