package DP23.Structure.Composite;
/**
 * Created by litianye on 2019-07-10
 */


import java.util.LinkedList;
import java.util.List;

/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-10
 **/

public class Directory implements FileUnit {
    private List<FileUnit> childFileUnits = new LinkedList<>();

    private String name;

    private Directory(String name) {
        this.name = name;
    }

    //管理方法
    public void addFileUnit(FileUnit fileUnit) {
        childFileUnits.add(fileUnit);
    }

    public void removeFileUnit(FileUnit fileUnit) {
        childFileUnits.remove(fileUnit);
    }

    public List<FileUnit> getChild() {
        return childFileUnits;
    }

    @Override
    public void PrintStruct(String preStr) {

    }
}
