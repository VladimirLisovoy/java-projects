package ua.lisovoy.data_stucture.list;

import ua.lisovoy.data_structure.list.ArrayList;
import ua.lisovoy.data_structure.list.List;

/**
 * Created by vladimir on 28.11.16.
 */
public class ArrayListTest extends AbstractListTest {

    @Override
    public List<Integer> getList() {
        return new ArrayList<Integer>();
    }
}